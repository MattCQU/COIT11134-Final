package com.mycompany.mavenproject4;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 *
 * @author 12206477
 */
public class CreateLocationInformationController {
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
    
    @FXML
    private void handleButtonExitAction (ActionEvent event) throws Exception  {
        System.out.println("You have pressed the Cancel button!");
        
        try {
            App.setRoot("menu");
        } catch (IOException e){
           System.out.println(e); 
        }
    }
    
    private void clearAllField()
    {
    
        txtLocationID.clear();
        txtLocationName.clear();
        txtAssetID.clear();
        
    }
    
    @FXML
    private void handleAddLocationButton (ActionEvent event) throws Exception {
        //Location location = new Location();
        
        try{
            String locationID = this.txtLocationID.getText();
            if (locationID.equals("") || locationID.length() != 4){
                throw new Exception ("Please enter a valid location ID");
            }
            
            String locationName = this.txtLocationName.getText();
            if (locationName.equals("")){
                throw new Exception ("Please enter a valid location name");
            }
            
            String assetID = this.txtAssetID.getText();
            if (assetID.length() == 0 || assetID.length() != 6){
                throw new Exception ("Please enter a valid asset ID");
            }
            
            
        }
    }
    
    
    
    @FXML
    private void handleMenuItemSelection(ActionEvent event) {
        MenuItem selectedItem = (MenuItem) event.getSource();
        String selectedText = selectedItem.getText();
        MnuStatus.setText(selectedText);
}
}
