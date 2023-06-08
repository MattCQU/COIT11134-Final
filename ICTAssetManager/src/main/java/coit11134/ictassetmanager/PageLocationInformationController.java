/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.ictassetmanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PageLocationInformationController implements Initializable{

    @FXML
    private Button btnBack;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnRead;

    @FXML
    private Button btnUpdate;

    @FXML
    private ListView<?> listViewLocations;
    private Location[] location;

    @FXML
    private TextField txtfieldSearch;
    
    private DataManager dataManager;

    @FXML
    void handleButtonExitAction(ActionEvent event) {
        try {
            App.setRoot("Menu");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }
    
    @FXML
    void handleButtonEditAction(ActionEvent event) {
        Location selectedLocation = getSelectedLocation();
        try 
        {
            if(selectedLocation == null)
            {
                App.customAlert("Please Select A Location");
                return;
            }
            
            CreateLocationInformationController.setEditLocation((Location)selectedLocation);
            App.setRoot("CreateLocationInformation");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }
    
    @FXML
    void handleButtonCreateAction(ActionEvent event) {
        try {
            App.setRoot("CreateLocationInformation");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }
    
    //Method that initializes datamanager 
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
      dataManager = App.getDataManager();
    }
    
    private Location getSelectedLocation()
    {
        int index = listViewLocations.getSelectionModel().getSelectedIndex();
        
        if(index < 0)
            return null;
        
        return location[index];
    }

}
