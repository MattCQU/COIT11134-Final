/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class LocanRecordsController {
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
    
    @FXML
    private void handleButtonExitAction (ActionEvent event) throws Exception  {
        System.out.println("You have pressed the Cancel button!");
        
        clearAll();
        try {
            App.setRoot("menu");
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
    
    @FXML
    private void handleAddLoanRecordsButton(ActionEvent Event){
        LoanRecord loanRecord = new LoanRecord();
        
        try{
            String assetID = this.txtAssetID.getText();
            if (assetID.isEmpty() || assetID.equals("")){
                throw new Exception ("Asset ID cannot be blank");
            }
            if (dataManager.searchAsset(assetID) == null){
                throw new Exception ("The entered asset ID does not exists");
            }
            
            String staffID = this.txtStaffID.getText();
            if (staffID.isEmpty() || assetID.equals("")){
                throw new Exception ("Staff ID cannot be blank");
            }
            if (dataManager.searchStaff(staffID)==null){
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
