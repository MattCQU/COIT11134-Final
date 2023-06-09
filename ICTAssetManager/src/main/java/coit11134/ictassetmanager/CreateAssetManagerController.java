/*
*COIT11134 Assessment 3 Part B
*
*Authors: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/

package coit11134.ictassetmanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;


public class CreateAssetManagerController implements Initializable{
    
    
    @FXML
    private TextField txtStaffID;
    
    @FXML
    private TextField txtStaffName;
    
    @FXML
    private TextField txtStaffEmail;
    
    @FXML
    private TextField txtPassword;   
    
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
    private static AssetManager editAssetManager;
    
    //Event handler for the exit button
    @FXML
    private void handleButtonExitAction (ActionEvent event) throws Exception  {
        System.out.println("You have pressed the Cancel button!");
        
        clearAllField();
        editAssetManager = null;
        try {
            App.setRoot("PageAssetManager");
        } catch (IOException e){
           System.out.println(e); 
        }
    }
    
    private void clearAllField()
    {
    
        txtStaffID.clear();
        txtStaffName.clear();
        txtStaffEmail.clear();
        txtPassword.clear();
        txtStaffPhoneNumber.clear();
        
    }
    
    public static void setEditAssetManager(AssetManager staff) 
    {
        editAssetManager = staff;
    }   
    
    //Method that initializes datamanager 
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        dataManager = App.getDataManager();
        String menuButtonOption = "";
        
        if(editAssetManager != null)
        {
            if(editAssetManager.getArchived() == true)
            {
                menuButtonOption = "Archived";
            }else
            {
                menuButtonOption = "Active";
            }
            
            txtStaffID.setText(String.valueOf(editAssetManager.getStaffID()));
            txtStaffName.setText(editAssetManager.getStaffName());
            txtStaffEmail.setText(editAssetManager.getStaffEmail());
            txtStaffPhoneNumber.setText(editAssetManager.getStaffPhoneNumber());
            txtPassword.setText(editAssetManager.getPassword());
            MnuStatus.setText(menuButtonOption);
            
            pageTitle.setText("Edit Asset Manager Information");
        }
        else
        {
            txtStaffID.setText(String.valueOf(dataManager.getNextStaffID()));
            pageTitle.setText("Create Staff Information");
        }
    }
     
        
        
        
    //Event handler for the create button
    @FXML
    private void handleAddAssetManagerButton (ActionEvent event) {
        AssetManager assetManager = new AssetManager();
        boolean isArchived = false;
        
        
        try{
            //Validates staff ID if it is blank or not numeric 
            String staffID = this.txtStaffID.getText();
            if (staffID.length() == 0  || !staffID.matches("\\d+")){
                throw new Exception ("Please enter a valid staff ID");
            }
            
            //Validates staff name if it is blank
            String staffName = this.txtStaffName.getText();
            if (staffName.equals("")){
                throw new Exception ("Please enter a valid staff name");
            }
            
            //Validates staff email if it is blank or does not contain the "@" or "."
            String staffEmail = this.txtStaffEmail.getText();
            if (staffEmail.equals("") || !staffEmail.contains("@") || !staffEmail.contains(".")){
                throw new Exception ("Please enter a valid staff email address");
            }
            
            //Validates password if it is blank
            String password = this.txtPassword.getText();
            if (password.equals("")){
                throw new Exception ("Please enter a valid password");
            }
            
            //Validates staff phone number if it is blank or not numeric 
            String staffPhoneNumber = this.txtStaffPhoneNumber.getText();
            if (staffPhoneNumber.equals("") || !staffPhoneNumber.matches("\\d+")){
                throw new Exception ("Please enter a valid staff phone number");
            }
            if(!Validation.phoneNumberValidator(staffPhoneNumber.trim()))
            {
                throw new Exception("Invalid Phone number, please enter a valid 10 digit number");
            }
            
            //Validates if the user does not select the menu item
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
            
            if(editAssetManager != null)
            {
                editAssetManager.setArchived(isArchived);
                
                dataManager.saveStaffToFile();
                handleButtonExitAction(null);   
            }
            else
            {
                assetManager.setStaffID(Integer.parseInt(staffID));
                assetManager.setStaffName(this.txtStaffName.getText().trim());
                assetManager.setArchived(isArchived);
            
                dataManager.addStaffRecord(assetManager);
                dataManager.saveStaffToFile();
            }
            
            if(editAssetManager != null)
            {
                editAssetManager.setStaffName(staffName);
                editAssetManager.setStaffEmail(staffEmail);
                editAssetManager.setStaffPhoneNumber(staffPhoneNumber);
                editAssetManager.setPassword(password);
                editAssetManager.setArchived(isArchived);
                
                dataManager.saveStaffToFile();

                
                handleButtonExitAction(null);    

            }
            else
            {
                AssetManager newAssetManager = new AssetManager();
                
                newAssetManager.setStaffID(Integer.parseInt(staffID));
                newAssetManager.setStaffName(this.txtStaffName.getText().trim());
                newAssetManager.setStaffEmail(this.txtStaffEmail.getText().trim());
                newAssetManager.setStaffPhoneNumber(this.txtStaffPhoneNumber.getText().trim());
                newAssetManager.setPassword(this.txtPassword.getText().trim());
                newAssetManager.setArchived(isArchived);
            
                dataManager.addStaffRecord(newAssetManager);
                dataManager.saveStaffToFile();
            }
            
            clearAllField();
                    
        }catch(Exception e)
        {
            App.customAlert(e.getMessage());
        }
        
        txtStaffID.setText(String.valueOf(dataManager.getNextStaffID()));
    }     
    
    //Method to display the text of the selected option on the menu button
    @FXML
    private void handleMenuItemSelection(ActionEvent event) 
    {
        MenuItem selectedItem = (MenuItem) event.getSource();
        String selectedText = selectedItem.getText();
        MnuStatus.setText(selectedText);
    }
}
