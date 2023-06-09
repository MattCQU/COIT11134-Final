/*
*COIT11134 Assessment 3 Part B
*
*Authors: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/

package coit11134.ictassetmanager;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
/**
 *
 * @author Lenovo
 */
public class CreateLoanRecordsController implements Initializable{
    @FXML
    private TextField txtLoanReordsID;
    
    @FXML
    private TextField txtAssetID;
    
    @FXML
    private TextField txtStaffID;
    
    @FXML
    private TextField txtLocationID;
    
    @FXML
    private DatePicker datePickerStartDate;
    
    @FXML
    private DatePicker datePickerDueDate;
    
    @FXML
    private Label pageTitle;
    
    @FXML
    private Button btnBack;
    
    @FXML
    private Button btnCreate;
    
    private DataManager dataManager;
    private static LoanRecord editLoanRecord;
    
    //Event handler for the exit button
    @FXML
    private void handleButtonExitAction (ActionEvent event) throws Exception  {
        System.out.println("You have pressed the Cancel button!");
        
        editLoanRecord =null;
        clearAll();
        try {
            App.setRoot("PageLoanRecord");
        } catch (IOException e){
           System.out.println(e); 
        }
    }
    
    public static void setEditLoan(LoanRecord loan)
    {
        editLoanRecord = loan;
    }
    
    private void clearAll()
    {
        txtLoanReordsID.clear();
        txtAssetID.clear();
        txtStaffID.clear();
        txtLocationID.clear();
        datePickerStartDate.setValue(null);
        datePickerDueDate.setValue(null);
    }
    
    //Method that initializes datamanager 
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        dataManager = App.getDataManager();
        String menuButtonOption = "";
        
        if(editLoanRecord != null)
        {
            txtLoanReordsID.setText(String.valueOf(editLoanRecord.getLoanID()));
            txtAssetID.setText(String.valueOf(editLoanRecord.getAsset().getAssetID()));    
            txtStaffID.setText(String.valueOf(editLoanRecord.getStaffMember().getStaffID()));
            txtLocationID.setText(String.valueOf(editLoanRecord.getLocation().getLocationID()));
            datePickerStartDate.setValue(editLoanRecord.getLoanDate());
            datePickerDueDate.setValue(editLoanRecord.getReturnDate());
            
            pageTitle.setText("Edit Loan Record");
        }
        else
        {
            txtLoanReordsID.setText(String.valueOf(dataManager.getNextLoanID()));
            pageTitle.setText("Create Loan Record");
        }
    }
    
    public static void setEditLoanRecords(LoanRecord loanRecords)
    {
        editLoanRecord = loanRecords;
    }
    
    //Event handler for the create button
    @FXML
    private void handleAddLoanRecordsButton(ActionEvent Event){
        LoanRecord newLoanRecord = new LoanRecord();
        
        try{
            String assetID = this.txtAssetID.getText();
            String staffID = this.txtStaffID.getText();
            LocalDate startDate = datePickerStartDate.getValue();
            String locationID = this.txtLocationID.getText();
            LocalDate dueDate = datePickerDueDate.getValue();
            LocalDate returnDateOfSearchAsset = LocalDate.now();
            LocalDate loanDateOfSearchAsset = LocalDate.now();
            
            //Validates if asset ID is blank
            if (assetID.isEmpty() || assetID.equals("")){
                throw new Exception ("Asset ID cannot be blank");
            }
            
            //Validates if the invalid asset ID is entered
            if (dataManager.searchAssetByID(assetID) == null){
                throw new Exception ("The entered asset ID does not exists");
            }
            
            if (dataManager.searchAssetByID(assetID).getArchived() == true)
            {
                throw new Exception ("The asset entered is not in service");
            }
           
            //Validates if staffID is blank
            if (staffID.isEmpty() || staffID.equals("")){
                throw new Exception ("Staff ID cannot be blank");
            }
            
            //Validates if the entered staff ID is invalid
            if (dataManager.searchStaffByID(staffID) == null){
                throw new Exception ("The entered staff ID does not exists");
            }
            
            //Validates if location ID is blank
            if(locationID.isEmpty() || locationID.equals(""))
            {
                throw new Exception ("LocationID is blank, please enter a locationID");
            }
            
            //Validates if the entered location ID is invalid
            if(dataManager.searchLocationByID(locationID) == null)
            {
                throw new Exception ("The entered locationID does not exist.");
            }
            if(dataManager.searchLocationByID(locationID).getArchived() == true)
            {
                throw new Exception ("The entered location is not in service");
            }
            
            //Validates if the start date is not selected
            if(startDate == null)
            {
                throw new Exception ("Loan Start Date Cannot Be Empty, Select a Date.");
            }
            
            //Validates if start date is after the present day
            if(startDate.isAfter(LocalDate.now()))
            {
                throw new Exception("Cannot Forward Date Loan");
            }
            
            //Validates if due date is not selected
            if(dueDate == null)
            {
                throw new Exception ("Return Date Cannot Be Empty, Select a Date.");
            }
            
            //Validates if due date is before start date
            if(dueDate.isBefore(startDate))
            {
                throw new Exception("Cannot retrun item before item loaned.");
            }
            
            /*
            returnDateOfSearchAsset = dataManager.searchLoanByAsset(assetID).getReturnDate();  
            loanDateOfSearchAsset = dataManager.searchLoanByAsset(assetID).getReturnDate();
                
            if(returnDateOfSearchAsset != null && loanDateOfSearchAsset != null)
            {
            
                if(loanDateOfSearchAsset.isBefore(startDate) || returnDateOfSearchAsset.isBefore(dueDate) )
                {
                    throw new Exception ("This asset is currently on loan.\nLoaned to "+ dataManager.searchLoanByAsset(assetID).getStaffMember().getStaffName());
                }
            }
            */
            
            if(editLoanRecord != null)
            {
                //Update loan record
                editLoanRecord.setAsset(dataManager.searchAssetByID(assetID));
                editLoanRecord.setStaffMember(dataManager.searchStaffByID(staffID));
                editLoanRecord.setLocation(dataManager.searchLocationByID(locationID));
                editLoanRecord.setLoanDate(startDate);
                editLoanRecord.setReturnDate(dueDate);
                
                dataManager.saveLoansToFile();
                handleButtonExitAction(null);
            }
            else
            {
                //create new asset
                newLoanRecord.setLoanID(Integer.parseInt(txtLoanReordsID.getText()));
                newLoanRecord.setAsset(dataManager.searchAssetByID(assetID));
                newLoanRecord.setStaffMember(dataManager.searchStaffByID(staffID));
                newLoanRecord.setLocation(dataManager.searchLocationByID(locationID));
                newLoanRecord.setLoanDate(startDate);
                newLoanRecord.setReturnDate(dueDate);
                
                dataManager.addLoan(newLoanRecord);
                dataManager.saveLoansToFile();
            }
            
            clearAll();
        }catch(Exception e)
        {
            App.customAlert(e.getMessage());
        }
        
        txtLoanReordsID.setText(String.valueOf(dataManager.getNextLoanID()));
    
    }
    
    
}
