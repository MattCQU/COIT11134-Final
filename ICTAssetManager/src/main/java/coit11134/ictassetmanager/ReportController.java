package coit11134.ictassetmanager;

import coit11134.ictassetmanager.App;
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

    @FXML
    private Button btnBack;

    @FXML
    private ListView<Asset> listViewReport;
    
    @FXML 
    private DatePicker datePicker;
    
    private DataManager dataManager;
    private LocalDate reportDate;
    private ArrayList<Asset> overDueAssets;
    
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
    
    @FXML
    private void selectDate(ActionEvent event) throws IOException {
   
        reportDate = datePicker.getValue();
        
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
