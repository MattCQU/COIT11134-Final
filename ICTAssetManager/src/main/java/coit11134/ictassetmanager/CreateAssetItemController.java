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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class CreateAssetItemController
{
    @FXML
    private TextField txtAssetID;

    @FXML
    private TextField txtMake;

    @FXML
    private TextField txtSerialNumber;

    @FXML
    private DatePicker datePickerDueTestDate;

    @FXML
    private DatePicker datePickerPurchaseDate;

    @FXML
    private TextField txtItemType;

    @FXML
    private TextField txtModel;

    @FXML
    private DatePicker datePickerWarrantyEndDate;

    @FXML
    private TextField txtPurchasePrice;

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

    private DataManager dataManager;
    private static Asset editAsset;
    private LocalDate dueTestDate;
    private LocalDate warrantyEndDate;
    private LocalDate purchaseDate;
    


    @FXML
    private void handleButtonExitAction (ActionEvent event) throws Exception  {
        System.out.println("You have pressed the Cancel button!");
        
        
        try {
            App.setRoot("PageStaffInformation");
        } catch (IOException e){
           System.out.println(e); 
        }
    }

    private void clearAllField()
    {
    
        txtAssetID.clear();
        txtMake.clear();
        txtSerialNumber.clear();
        datePickerDueTestDate.setValue(null);
        datePickerPurchaseDate.setValue(null);
        txtItemType.clear();
        txtModel.clear();
        datePickerWarrantyEndDate.setValue(null);
        txtPurchasePrice.clear();
    }
    
    
    public static void setEditAsset(Asset asset){
        editAsset = asset;
    }


    //Method that initializes datamanager 
    //@Override
    public void initialize(URL url, ResourceBundle rb)
    {
        dataManager = App.getDataManager();
        String menuButtonOption = "";
        
        if(editAsset != null)
        {
            if(editAsset.getArchived() == true)
            {
                menuButtonOption = "Archived";
            }else
            {
                menuButtonOption = "Active";
            }
            
            txtAssetID.setText(String.valueOf(editAsset.getAssetID()));
            txtMake.setText(editAsset.getMake());
            txtSerialNumber.setText(editAsset.getSerialNumber());
            datePickerDueTestDate.setValue(editAsset.getDueTestDate());
            datePickerPurchaseDate.setValue(editAsset.getPurchaseDate());         
            txtItemType.setText(String.valueOf(editAsset.getItemType()));
            txtModel.setText(editAsset.getModel());
            datePickerWarrantyEndDate.setValue(editAsset.getWarrantyEndDate());
            txtPurchasePrice.setText(String.valueOf(editAsset.getPurchasePrice()));    
            MnuStatus.setText(menuButtonOption);
            
        }
        else
        {
            txtAssetID.setText(String.valueOf(dataManager.getNextAssetID()));
        }
    }
    



    
    @FXML
    private void handleAddAssetItemsButton (ActionEvent Event){
        Asset newAsset = new Asset();
        boolean isArchived = false;
        
        try{
            String assetID = this.txtAssetID.getText();
            if (assetID.length() == 0  || !assetID.matches("\\d+")){
                throw new Exception ("Please enter a valid asset ID");
            }            
            
            String serialNumber = this.txtSerialNumber.getText();
            if (serialNumber.isEmpty() || serialNumber.equals("")){
                throw new Exception ("Serial Number cannot be blank");
            }
            
            LocalDate testDueDate = datePickerDueTestDate.getValue();
            if (testDueDate.isBefore(LocalDate.now())){
                throw new Exception ("Invalid Date - Next test due date cannot be before today");
            }
            
            LocalDate purchaseDate = datePickerPurchaseDate.getValue();
            if (purchaseDate.isAfter(LocalDate.now())){
                throw new Exception ("Invalid Date - Purchase date cannot be after today");
            }

            LocalDate warrantyEndDate = datePickerWarrantyEndDate.getValue();
            if (warrantyEndDate.isBefore(LocalDate.now())){
                throw new Exception ("Invalid Date - Warranty date cannot be before today");
            }
            
            String itemType = this.txtItemType.getText();
            if (itemType.isEmpty() || itemType.equals("")){
                throw new Exception ("Item type field cannot be blank");
            }
            
            String make = this.txtMake.getText();
            if (make.isEmpty() || make.equals("")){
                throw new Exception ("Make field cannot be blank");
            }            
            
            String model = this.txtModel.getText();
            if (model.isEmpty() || model.equals("")){
                throw new Exception ("Model field cannot be blank");
            }
                       
            double purchasePrice = Double.parseDouble(this.txtPurchasePrice.getText());
            if(this.txtPurchasePrice.getText() == null || this.txtPurchasePrice.getText().equalsIgnoreCase(""))
            {
                throw new Exception("Please Enter A Number For The Sale Price.");
            }
            if(purchasePrice <= 0)
            {
                throw new Exception("Please Enter A Positive Value For Price");
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
            

            if(editAsset != null)
            {
                editAsset.setMake(make);
                editAsset.setSerialNumber(serialNumber);
                editAsset.setDueTestDate(dueTestDate);
                editAsset.setPurchaseDate(purchaseDate);
                editAsset.setItemType(itemType);
                editAsset.setModel(model);
                editAsset.setWarrantyEndDate(warrantyEndDate);
                editAsset.setPurchasePrice(purchasePrice);
                editAsset.setArchived(isArchived);      
                
                dataManager.saveAssetToFile();
                handleButtonExitAction(null);   
            }
            else
            {
                newAsset.setAssetID(Integer.parseInt(assetID));
                newAsset.setMake(this.txtMake.getText().trim());
                newAsset.setSerialNumber(this.txtSerialNumber.getText().trim());
                newAsset.setDueTestDate(dueTestDate);
                newAsset.setPurchaseDate(purchaseDate);
                newAsset.setItemType(this.txtItemType.getText().trim());
                newAsset.setModel(this.txtModel.getText().trim());
                newAsset.setWarrantyEndDate(warrantyEndDate);
                newAsset.setPurchasePrice(Double.parseDouble(this.txtPurchasePrice.getText()));
                newAsset.setArchived(isArchived);      
                
                dataManager.addAsset(newAsset);
                dataManager.saveAssetToFile();
            }
            
            clearAllField();
                 

            
        }catch(Exception e)
        {
            App.customAlert(e.getMessage());
        }
        
        txtAssetID.setText(String.valueOf(dataManager.getNextAssetID()));
    }
    
    @FXML
    private void handleMenuItemSelection(ActionEvent event) 
    {
        MenuItem selectedItem = (MenuItem) event.getSource();
        String selectedText = selectedItem.getText();
        MnuStatus.setText(selectedText);
    }
}
