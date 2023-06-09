/*
*COIT11134 Assessment 3 Part B
*
*Authors: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/

package coit11134.ictassetmanager;

import java.io.IOException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
/**
 *
 * @author Lenovo
 */
public class CreateLoanRecordsController {
    @FXML
    private TextField txtLoanReordsID;
    
    @FXML
    private TextField txtAssetID;
    
    @FXML
    private TextField txtStaffID;
    
    @FXML
    private DatePicker datePickerStartDate;
    
    @FXML
    private DatePicker datePickerDueDate;
    
    @FXML
    private Button btnBack;
    
    @FXML
    private Button btnCreate;
    
    private DataManager dataManager;
    private static LoanRecord editLoanRecord;
    
    @FXML
    private void handleButtonExitAction (ActionEvent event) throws Exception  {
        System.out.println("You have pressed the Cancel button!");
        
        clearAll();
        try {
            App.setRoot("PageLoanRecord");
        } catch (IOException e){
           System.out.println(e); 
        }
    }
    
    private void clearAll()
    {
        txtLoanReordsID.clear();
        txtAssetID.clear();
        txtStaffID.clear();
        datePickerStartDate.setValue(null);
        datePickerDueDate.setValue(null);
    }
    
    public static void setEditLoanRecords(LoanRecord loanRecords)
    {
        editLoanRecord = loanRecords;
    }
    
    @FXML
    private void handleAddLoanRecordsButton(ActionEvent Event){
        LoanRecord loanRecord = new LoanRecord();
        
        try{
            String assetID = this.txtAssetID.getText();
            if (assetID.isEmpty() || assetID.equals("")){
                throw new Exception ("Asset ID cannot be blank");
            }
            if (dataManager.searchAssetByID(assetID) == null){
                throw new Exception ("The entered asset ID does not exists");
            }
            
            String staffID = this.txtStaffID.getText();
            if (staffID.isEmpty() || assetID.equals("")){
                throw new Exception ("Staff ID cannot be blank");
            }
            if (dataManager.searchStaffByID(staffID) == null){
                throw new Exception ("The entered staff ID does not exists");
            }
            
            if (assetID.equals(staffID)){
                throw new Exception ("Asset ID and staff ID cannot be the same");
            }
            
            LocalDate startDate = datePickerStartDate.getValue();
            if(startDate.isAfter(LocalDate.now()))
            {
                throw new Exception("Cannot Forward Date Sale");
            }
            
            LocalDate dueDate = datePickerDueDate.getValue();
            if(dueDate.isBefore(startDate))
            {
                throw new Exception("Cannot Forward Date Sale");
            }
            
            
            
        }catch(Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage() ); 
            alert.showAndWait();
        }
    
    }
}
