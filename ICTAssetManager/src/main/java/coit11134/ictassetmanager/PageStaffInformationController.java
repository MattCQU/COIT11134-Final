/*
*COIT11134 Assessment 3 Part B
*
*Authors: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/

package coit11134.ictassetmanager;

import java.io.IOException;
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

public class PageStaffInformationController implements Initializable{
   
    //Controller Variables
    @FXML
    private Button btnBack;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnRead;

    @FXML
    private Button btnUpdate;

    @FXML
    private ListView<String> listViewStaffRecords;
    private StaffRecords[] staffRecords;

    @FXML
    private TextField txtFieldSearch;
    
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
        StaffRecords selectedStaffRecord = getSelectedStaffRecord();
        try 
        {
            if(selectedStaffRecord == null)
            {
                App.customAlert("Please Select a Staff");
                return;
            }
            
            CreateStaffInformationController.setEditStaff((StaffRecords)selectedStaffRecord);
            App.setRoot("CreateStaffInformation");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }
        
    
    //Event handler for the create button
    @FXML
    void handleButtonCreateAction(ActionEvent event) {
        try {
            App.setRoot("CreateStaffInformation");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }
    
    
    //Method that initializes datamanager 
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
      dataManager = App.getDataManager();
      displayStaffRecords();
    }
    
    private StaffRecords getSelectedStaffRecord()
    {
        int index = listViewStaffRecords.getSelectionModel().getSelectedIndex();
        
        if(index < 0)
            return null;
        
        return staffRecords[index];
    }
    
    //Method that displays the list of staffRecords in a ListView
    private void displayStaffRecords()
    {
       try{ 
           //Retrieve all staffRecords from the data manager
           staffRecords = dataManager.getAllStaffRecords();
       
            ObservableList<String> elements = FXCollections.observableArrayList();
            for(StaffRecords staffRecord : staffRecords)
            {
                elements.add(staffRecord.getStaffName());
            }
            listViewStaffRecords.setItems(elements);
       }catch(Exception e)
       {
           App.customAlert(e.getMessage()); //Error Message
       }
    }

}
    

