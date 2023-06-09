/*
*COIT11134 Assessment 3 Part B
*
*Authors: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/

package coit11134.ictassetmanager;

import javafx.scene.input.KeyEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

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
    private ListView<String> listViewLocations;
    private Location[] location;

    @FXML
    private TextField txtfieldSearch;
    
    private DataManager dataManager;

    //Event handler for the exit button
    @FXML
    void handleButtonExitAction(ActionEvent event) {
        try {
            App.setRoot("Menu");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }
    
    //Event handler for the update button
    @FXML
    void handleButtonEditAction(ActionEvent event) {
        Location selectedLocation = getSelectedLocation();
        try 
        {
            if(selectedLocation == null)
            {
                App.customAlert("Please Select a Location");
                return;
            }
            
            CreateLocationInformationController.setEditLocation((Location)selectedLocation);
            App.setRoot("CreateLocationInformation");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }
    
    //Event handler for the create button
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
      displayLocations();
    }
    
    private Location getSelectedLocation()
    {
        int index = listViewLocations.getSelectionModel().getSelectedIndex();
        
        if(index < 0)
            return null;
        
        return location[index];
    }
    
    //Method that displays the list of locations in a ListView
    private void displayLocations()
    {
        //Retrieve all locations from the data manager
        location = dataManager.getAllLocations();
        ObservableList<String> elements = FXCollections.observableArrayList();
        for(Location location : location)
        {
            elements.add(location.getLocationName());
        }
        listViewLocations.setItems(elements);
    }
    
    
    public void handleSearch(KeyEvent event) throws Exception
    {
        if(event.getCode().equals(KeyCode.ENTER))
        {
            
        }
    }

}
