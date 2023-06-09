/*
*COIT11134 Assessment 3 Part B
*
*Authors: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/

package coit11134.ictassetmanager;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;


public class CreateStaffInformationController implements Initializable{


    
    @FXML
    private TextField txtStaffID;
    
    @FXML
    private TextField txtStaffName;
    
    @FXML
    private TextField txtStaffEmail;
    
    @FXML
    private TextField txtStaffPhoneNumber;  
    
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
    private Label pageTitle;
    
    DataManager dataManager;
    private static StaffRecords editStaffRecord;
    
    @FXML
    private void handleButtonExitAction (ActionEvent event) throws Exception  {
        System.out.println("You have pressed the Cancel button!");
        clearAllField();
        editStaffRecord = null;
        
        try {
            App.setRoot("PageStaffInformation");
        } catch (IOException e){
           System.out.println(e); 
        }
    }
    
    private void clearAllField()
    {
    
        txtStaffID.clear();
        txtStaffName.clear();
        txtStaffEmail.clear();
        txtStaffPhoneNumber.clear();
        
    }
    
    public static void setEditStaff(StaffRecords staff) {
        editStaffRecord = staff;
    }   
    
    //Method that initializes datamanager 
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        dataManager = App.getDataManager();
        String menuButtonOption = "";
        
        if(editStaffRecord != null)
        {
            if(editStaffRecord.getArchived() == true)
            {
                menuButtonOption = "Archived";
            }else
            {
                menuButtonOption = "Active";
            }
            
            txtStaffID.setText(String.valueOf(editStaffRecord.getStaffID()));
            txtStaffName.setText(editStaffRecord.getStaffName());
            txtStaffEmail.setText(editStaffRecord.getStaffEmail());
            txtStaffPhoneNumber.setText(editStaffRecord.getStaffPhoneNumber());
            MnuStatus.setText(menuButtonOption);
            
            pageTitle.setText("Edit Staff Information");
        }
        else
        {
            txtStaffID.setText(String.valueOf(dataManager.getNextStaffID()));
            pageTitle.setText("Create Staff Information");
        }
    }
    
    
    
    
    
    @FXML
    private void handleAddStaffButton (ActionEvent event) throws Exception {
        
        boolean isArchived = false;
        
        try{
            String staffID = this.txtStaffID.getText().trim();
            if (staffID.length() == 0  || !staffID.matches("\\d+")){
                throw new Exception ("Please enter a valid staff ID");
            }
            
            String staffName = this.txtStaffName.getText().trim();
            if (staffName.equals("")){
                throw new Exception ("Please enter a valid staff name");
            }
            
            String staffEmail = this.txtStaffEmail.getText().trim();
            if (staffEmail.equals("")){
                throw new Exception ("Please enter a valid staff email address");
            }
            
            String staffPhoneNumber = this.txtStaffPhoneNumber.getText().trim();
            if (staffPhoneNumber.equals("")){
                throw new Exception ("Please enter a valid staff phone number");
            }
            
            if(!Validation.phoneNumberValidator(staffPhoneNumber.trim()))
            {
                throw new Exception("Invalid Phone number, please enter a valid 10 digit number");
            }
            
            String selectedOption = this.MnuStatus.getText();
            if (selectedOption.equals("Active/Archived")) {
                throw new Exception("Please select a valid option from the menu");
            }
        
            if(selectedOption.equals("Active"))
            {
                isArchived = false;
            }else if(selectedOption.equals("Archived"))
            {
                isArchived = true;
            }
            
            if(editStaffRecord != null)
            {
                editStaffRecord.setStaffName(staffName);
                editStaffRecord.setStaffEmail(staffEmail);
                editStaffRecord.setStaffPhoneNumber(staffPhoneNumber);
                editStaffRecord.setArchived(isArchived);
                
                dataManager.saveStaffToFile();

                
                handleButtonExitAction(null);    

            }
            else
            {
                StaffRecords newStaffRecord = new StaffRecords();
                
                newStaffRecord.setStaffID(Integer.parseInt(staffID));
                newStaffRecord.setStaffName(this.txtStaffName.getText().trim());
                newStaffRecord.setStaffEmail(staffEmail);
                newStaffRecord.setStaffPhoneNumber(this.txtStaffPhoneNumber.getText().trim());
                newStaffRecord.setArchived(isArchived);
            
                dataManager.addStaffRecord(newStaffRecord);
                dataManager.saveStaffToFile();
            }
            
            clearAllField();
                    
        }catch(Exception e)
        {
            App.customAlert(e.getMessage());
        }
        
        txtStaffID.setText(String.valueOf(dataManager.getNextStaffID()));
    }
    
    @FXML
    private void handleMenuItemSelection(ActionEvent event) 
    {
        MenuItem selectedItem = (MenuItem) event.getSource();
        String selectedText = selectedItem.getText();
        MnuStatus.setText(selectedText);
    }
}
