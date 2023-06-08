/*
*COIT11134 Assessment 3 Part B
*
*Authors: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/

package coit11134.ictassetmanager;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StaffInformationPageController {
   
    
    @FXML
    private Button btnBack;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnRead;

    @FXML
    private Button btnUpdate;

    @FXML
    private ListView<?> listViewAssets;

    @FXML
    private TextField txtFieldSearch;
    
    @FXML
    void handleButtonExitAction(ActionEvent event) {
        try {
            App.setRoot("Menu");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }

    @FXML
    void handleButtonCreateAction(ActionEvent event) {
        try {
            App.setRoot("CreateStaffInformation");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }
    
    private void clearAllField()
    {
    
        txtFieldSearch.clear();
        
    }

}
