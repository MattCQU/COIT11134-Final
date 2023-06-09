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


public class PageAssetManagerController implements Initializable{
    
    //controller 
    @FXML
    private Button btnBack;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnRead;

    @FXML
    private Button btnUpdate;

    @FXML
    private ListView<String> listViewAssetManagers;
    private AssetManager[] assetManager;

    @FXML
    private TextField txtFieldSearch;
    
    private DataManager dataManager;
    
    //mehtod to handle back button, swaps to create menu
    @FXML
    void handleButtonExitAction(ActionEvent event) {
        try {
            App.setRoot("Menu");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }
    
    //mehtod to handle edit button, swaps to edit scene
    @FXML
    void handleButtonEditAction(ActionEvent event) {
        AssetManager selectedAssetManager = getSelectedAssetManager();
        try 
        {
            if(selectedAssetManager == null)
            {
                App.customAlert("Please Select an Asset Manager");
                return;
            }
            
            CreateAssetManagerController.setEditAssetManager((AssetManager)selectedAssetManager);
            App.setRoot("CreateAssetManager");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }
            
    
    // mehtod to handle creat button, swaps to create scene 
    @FXML
    void handleButtonCreateAction(ActionEvent event) {
        try {
            App.setRoot("CreateAssetManager");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }
    
    
    //Method that initializes datamanager 
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
      dataManager = App.getDataManager();
      //displayAssetManager();
    }
    
    private AssetManager getSelectedAssetManager()
    {
        int index = listViewAssetManagers.getSelectionModel().getSelectedIndex();
        
        if(index < 0)
            return null;
        
        return assetManager[index];
    }
    
    
    //Method to display List of AssetManagers to listview
    /*
    private void displayAssetManager()
    {
       try{ 
           assetManager = dataManager.getAllStaffRecords();
       
            ObservableList<String> elements = FXCollections.observableArrayList();
            for(AssetManager assetManager : assetManager)
            {
                elements.add(assetManager.getStaffName());
            }
            listViewAssetManagers.setItems(elements);
       }catch(Exception e)
       {
           App.customAlert(e.getMessage());
       }
    }
*/

}