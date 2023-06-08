/*
*COIT11134 Assessment 3 Part B
*
*Authors: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/

package coit11134.ictassetmanager;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;


public class CreateStaffInformationController {
    
    @FXML
    private TextField txtStaffID;
    
    @FXML
    private TextField txtStaffName;
    
    @FXML
    private TextField txtStaffEmail;
    
    @FXML
    private TextField txtStaffPhone;  
    
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
    
    DataManager dataManager;
    
    @FXML
    private void handleButtonExitAction (ActionEvent event) throws Exception  {
        System.out.println("You have pressed the Cancel button!");
        
        clearAllField();
        
        try {
            App.setRoot("menu");
        } catch (IOException e){
           System.out.println(e); 
        }
    }
    
    private void clearAllField()
    {
    
        txtStaffID.clear();
        txtStaffName.clear();
        txtStaffEmail.clear();
        txtStaffPhone.clear();
        
    }
    
    @FXML
    private void handleAddStaffButton (ActionEvent event) throws Exception {
        Staff staff = new Staff();
        
        try{
            String staffID = this.txtStaffID.getText();
            if (staffID.length() == 0  || !staffID.matches("\\d+")){
                throw new Exception ("Please enter a valid staff ID");
            }
            
            String staffName = this.txtStaffName.getText();
            if (staffName.equals("")){
                throw new Exception ("Please enter a valid staff name");
            }
            
            String staffEmail = this.txtStaffEmail.getText();
            if (staffEmail.equals("")){
                throw new Exception ("Please enter a valid staff email address");
            }
            
            String staffPhone = this.txtStaffPhone.getText();
            if (staffPhone.equals("")){
                throw new Exception ("Please enter a valid staff phone number");
            }
            
            String selectedOption = this.MnuStatus.getText();
            if (selectedOption.equals("Active/Archived")) {
                throw new Exception("Please select a valid option from the menu");
            }
            
            
        }catch(Exception e)
        {
            App.customAlert(e.getMessage());
        }
    }
    
    @FXML
    private void handleMenuItemSelection(ActionEvent event) {
        MenuItem selectedItem = (MenuItem) event.getSource();
        String selectedText = selectedItem.getText();
        MnuStatus.setText(selectedText);
}
}
