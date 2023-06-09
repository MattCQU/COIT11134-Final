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

public class PageLoanRecordController implements Initializable{

    @FXML
    private Button btnBack;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnRead;

    @FXML
    private Button btnUpdate;

    @FXML
    private ListView<String> listViewLoans;
    
    private LoanRecord[] loanRecord;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
      dataManager = App.getDataManager();
      displayLoanRecords();
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
        int index = listViewLoans.getSelectionModel().getSelectedIndex();
        
        if(index < 0)
            return null;
        
        return loanRecord[index];
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
            
            CreateLoanRecordsController.setEditLoanRecords((LoanRecord)selectedLoanRecord);
            App.setRoot("CreateLoanRecord");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }
    
    private void displayLoanRecords()
    {
        try{ 
           loanRecord = dataManager.getAllLoanRecords();
       
            ObservableList<String> elements = FXCollections.observableArrayList();
            for(LoanRecord loan : loanRecord)
            {
                elements.add(loan.getLoanID() +",  " + loan.getAsset().getItemType() + ", " + loan.getStaffMember().getStaffName());
            }
            listViewLoans.setItems(elements);
       }catch(Exception e)
       {
           App.customAlert(e.getMessage());
       }
    }

}
