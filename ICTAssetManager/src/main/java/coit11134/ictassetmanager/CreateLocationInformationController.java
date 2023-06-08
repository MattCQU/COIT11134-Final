/*
*COIT11134 Assessment 3 Part B
*
*Authers: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/


package coit11134.ictassetmanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;


public class CreateLocationInformationController implements Initializable{
    @FXML
    private TextField txtLocationID;
    
    @FXML
    private TextField txtLocationName;
    
    @FXML
    private TextField txtAssetID;
    
    @FXML
    private MenuButton MnuStatus;
    
    @FXML
    private MenuItem itemActive;
    
    @FXML 
    private MenuItem itemArchived;
    
    @FXML
    private Button btnBack;
    
    @FXML
    private Button btnCreate;
    
    private DataManager dataManager;
    
    @FXML
    private void handleButtonExitAction (ActionEvent event) throws Exception  {
        System.out.println("You have pressed the Cancel button!");
        
        clearAllField();
        
        try {
            App.setRoot("Menu");
        } catch (IOException e){
           System.out.println(e); 
        }
    }
    
    private void clearAllField()
    {
    
        txtLocationID.clear();
        txtLocationName.clear();
        
    }
    
    //Method that initializes datamanager 
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
      dataManager = App.getDataManager();
      
      
      txtLocationID.setText(String.valueOf(dataManager.getNextLocationID()));
      
    }
    
    
    @FXML
    private void handleAddLocationButton (ActionEvent event) throws Exception {
        Location newLocation = new Location();
        boolean isArchived = false;
        
        try{
            String locationID = this.txtLocationID.getText();
            if (locationID.length() == 0  || !locationID.matches("\\d+")){
                throw new Exception ("Please enter a valid location ID");
            }
            
            String locationName = this.txtLocationName.getText();
            if (locationName.equals("")){
                throw new Exception ("Please enter a valid location name");
            }

            String selectedOption = this.MnuStatus.getText();
            if (selectedOption.equals("Active/Archived")) {
                throw new Exception("Please select a valid option from the menu");
            }
        
            if(selectedOption.equals("Active"))
            {
                isArchived = false;
            }else if(selectedOption.equals("Archived"))
            {
                isArchived = true;
            }
        
            newLocation.setLocationID(Integer.parseInt(locationID));
            newLocation.setLocationName(this.txtLocationName.getText().trim());
            newLocation.setArchived(isArchived);
            
            dataManager.addLocation(newLocation);
            dataManager.saveLocationsToFile();
            
            clearAllField();
            
        }catch(Exception e)
        {
            App.customAlert(e.getMessage());
        }
        
        txtLocationID.setText(String.valueOf(dataManager.getNextLocationID()));
    }
    
    @FXML
    private void handleMenuItemSelection(ActionEvent event) {
        MenuItem selectedItem = (MenuItem) event.getSource();
        String selectedText = selectedItem.getText();
        MnuStatus.setText(selectedText);
}
}
