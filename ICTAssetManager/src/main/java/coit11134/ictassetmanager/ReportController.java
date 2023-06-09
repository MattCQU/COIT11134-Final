package coit11134.ictassetmanager;

import coit11134.ictassetmanager.App;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;


public class ReportController implements Initializable {
    
    //Controller variables

    @FXML
    private Button btnBack;

    @FXML
    private ListView<Asset> listViewReport;
    
    @FXML 
    private DatePicker datePicker;
    
    private DataManager dataManager;
    private LocalDate reportDate;
    private ArrayList<Asset> overDueAssets;
    
    //method to handle the 
    @FXML
    private void switchToAssets() throws IOException {
        App.setRoot("PageAssetInformation");
    }

    
    //Method that initializes datamanager 
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
      dataManager = App.getDataManager();
    }
    
    
    /*Method which uses inputed date to search assets that are overdue for testing on that date
    * method confirms date entered before generating report
    * then returns the resutls to the List view, creates a file on the desktop and saves list to file
    */
    @FXML
    private void selectDate(ActionEvent event) throws IOException {
   
        reportDate = datePicker.getValue();
        String desktopPath = System.getProperty("user.home")+ "/Desktop";
        String fileName = "Overdue Test & Tag Report - " + reportDate.toString() +".txt";
        
        try{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Generate Report for overdue times as of " + reportDate.toString());

            ButtonType buttonTypeOK = new ButtonType("OK");
            ButtonType buttonTypeCancel = new ButtonType("Cancel");

            alert.getButtonTypes().setAll(buttonTypeOK, buttonTypeCancel);

            alert.showAndWait().ifPresent(response -> {
                if (response == buttonTypeOK) {
                    
                    // User clicked OK
                    System.out.println("Confirmed!"); 
                    overDueAssets = dataManager.taggingReport(reportDate);
                    ObservableList<Asset> elements = FXCollections.observableArrayList();
                    for(Asset asset : overDueAssets)
                    {
                        elements.add(asset);
                    }
                    listViewReport.setItems(elements);
                    
                    File desktopFile = new File(desktopPath, fileName);
                    
                    try
                    {
                        boolean created = desktopFile.createNewFile();
                        
                        if (created)
                        {
                            
                            BufferedWriter writer = new BufferedWriter( new FileWriter(desktopFile));
                            
                            writer.write(fileName + "\n");
                            
                            for(Asset asset : overDueAssets)
                            {
                                String assetString = asset.saveString();
                                writer.write(assetString);
                                writer.newLine();
                            }
                            writer.close();
                            Alert notice = new Alert(Alert.AlertType.INFORMATION);
                            notice.setContentText("File savesd to Desktop: " + fileName);
                            notice.showAndWait();
                        }
                        else
                        {
                            App.customAlert("File already exists.");
                        }
                    }catch(IOException e)
                    {
                        App.customAlert(e.getMessage());
                    }
                    
                } else {
                    // User clicked Cancel 
                    System.out.println("Cancelled.");
                }
            });
        } catch (Exception e)
        {
            App.customAlert(e.getMessage());
        }    
    }

}
