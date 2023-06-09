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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PageLoanRecordController {

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
    LoanRecord loanRecord = new LoanRecord();
    LoanRecord [] loanRecordList;

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
    void handleCreateButton(ActionEvent event) {
        try {
            App.setRoot("CreateLoanRecord");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }
    
    private LoanRecord getSelectedLoanRecord()
    {
        int index = listViewAssets.getSelectionModel().getSelectedIndex();
        
        if(index < 0)
            return null;
        
        return loanRecordList[index];
    }
    
    @FXML
    void handleButtonEditAction(ActionEvent event) {
        
        LoanRecord selectedLoanRecord = getSelectedLoanRecord();
        try 
        {
            if(selectedLoanRecord == null)
            {
                App.customAlert("Please Select a loan record");
                return;
            }
            
            CreateLoanRecordsController.setEditLoanRecords((LoanRecord)loanRecord);
            App.setRoot("CreateLoanRecordsInformation");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }
    
    private void displayLoanRecords()
    {
        loanRecordList = dataManager.getAllLoanRecords();
        ObservableList<String> elements = FXCollections.observableArrayList();
    }

}
