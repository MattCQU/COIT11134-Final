/*
*COIT11134 Assessment 3 Part B
*
*Authors: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/


package coit11134.ictassetmanager;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;


public class CreateLocationInformationController implements Initializable{
    @FXML
    private TextField txtLocationID;
    
    @FXML
    private TextField txtLocationName;
    
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
    
    @FXML
    private Label pageTitle;
    
    private DataManager dataManager;
    private static Location editLocation;
    
    //Event handler for the exit button
    @FXML
    private void handleButtonExitAction (ActionEvent event) throws Exception  {
        System.out.println("You have pressed the Cancel button!");
        
        clearAllField();
        editLocation = null;
        
        try {
            App.setRoot("PageLocationInformation");
        } catch (IOException e){
           System.out.println(e); 
        }
    }
    
    private void clearAllField()
    {
    
        txtLocationID.clear();
        txtLocationName.clear();
        
    }
    
    public static void setEditLocation(Location location)
    {
        editLocation = location;
    }
    
    //Method that initializes datamanager 
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        dataManager = App.getDataManager();
        String menuButtonOption = "";
        
        if(editLocation != null)
        {
            if(editLocation.getArchived() == true)
            {
                menuButtonOption = "Archived";
            }else
            {
                menuButtonOption = "Active";
            }
            
            txtLocationID.setText(String.valueOf(editLocation.getLocationID()));
            txtLocationName.setText(editLocation.getLocationName());
            MnuStatus.setText(menuButtonOption);
            
            pageTitle.setText("Edit Location Information");
            
        }
        else
        {
            txtLocationID.setText(String.valueOf(dataManager.getNextLocationID()));
            pageTitle.setText("Create Location Information");
        }
    }
    
    //Event handler for the create button
    @FXML
    private void handleAddLocationButton (ActionEvent event) throws Exception {
        Location newLocation = new Location();
        boolean isArchived = false;
        
        try{
            //Validates if the location ID is blank or is not numeric
            String locationID = this.txtLocationID.getText();
            if (locationID.length() == 0  || !locationID.matches("\\d+")){
                throw new Exception ("Please enter a valid location ID");
            }
            
            //Validates if location name is blank
            String locationName = this.txtLocationName.getText();
            if (locationName.equals("")){
                throw new Exception ("Please enter a valid location name");
            }
            
            //Validates if the user does not select the menu item
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
            
            if(editLocation != null)
            {
                //Update location
                editLocation.setLocationName(locationName);
                editLocation.setArchived(isArchived);
                
                dataManager.saveLocationsToFile();
                handleButtonExitAction(null);   
            }
            else
            {
                //create new location
                newLocation.setLocationID(Integer.parseInt(locationID));
                newLocation.setLocationName(this.txtLocationName.getText().trim());
                newLocation.setArchived(isArchived);
            
                dataManager.addLocation(newLocation);
                dataManager.saveLocationsToFile();
            }
            
            clearAllField();
            
        }catch(Exception e)
        {
            App.customAlert(e.getMessage());
        }
        
        txtLocationID.setText(String.valueOf(dataManager.getNextLocationID()));
    }
    
    //Method to display the text of the selected option on the menu button
    @FXML
    private void handleMenuItemSelection(ActionEvent event) {
        MenuItem selectedItem = (MenuItem) event.getSource();
        String selectedText = selectedItem.getText();
        MnuStatus.setText(selectedText);
    }
}
