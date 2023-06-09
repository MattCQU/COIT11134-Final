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


public class PageAssetItemsController implements Initializable{
    

    @FXML
    private Button btnBack;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnGenerateReport;

    @FXML
    private Button btnRead;

    @FXML
    private Button btnUpdate;

    @FXML
    private ListView<String> listViewAssets;
    
    private Asset[] asset;

    @FXML
    private TextField txtFieldSearch;
    
    private DataManager dataManager;

    //Event handler for the exit button
    @FXML
    void handleButtonExitAction(ActionEvent event) {
        try {
            App.setRoot("Menu");
        } catch (Exception e){
           App.customAlert(e.getMessage()); 
        }
    }
    
//Event handler for the update button
    @FXML
    void handleButtonEditAction(ActionEvent event) {
        Asset selectedAsset = getSelectedAsset();
        try 
        {
            if(selectedAsset == null)
            {
                App.customAlert("Please Select an Asset");
                return;
            }
            
            CreateAssetItemController.setEditAsset((Asset)selectedAsset);
            
            App.setRoot("CreateAssetItem");
        } catch (IOException e){
           App.customAlert(e.getMessage()); 
        }
    }
            

    
    //Event handler for the generate report button
    @FXML
    private void handleReportButtonAction (ActionEvent event) throws Exception
    {
        try
        {
            App.setRoot("Report");
        } catch (Exception e)
        {
            App.customAlert(e.getMessage());
        }
    }
    
    //Event handler for the create button
    @FXML
    private void handleCreateButton (ActionEvent event ) throws Exception
    {
        try
        {
            App.setRoot("CreateAssetItem");
            
        }catch (Exception e)
        {
            App.customAlert(e.getMessage());
        }
    }

    //Method that initializes datamanager 
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
      dataManager = App.getDataManager();
      displayAsset();
    }
    
    private Asset getSelectedAsset()
    {
        int index = listViewAssets.getSelectionModel().getSelectedIndex();
        
        if(index < 0)
            return null;
        
        return asset[index];
    }
    
    //Method that displays the list of assets in a ListView
    private void displayAsset()
    {
       try{ 
           //Retrieve all assets from the data manager
           asset = dataManager.getAllAssets();
       
            ObservableList<String> elements = FXCollections.observableArrayList();
            
            for(Asset asset : asset)
            {
                elements.add(asset.getAssetID() +",  " + asset.getItemType());
            }
            listViewAssets.setItems(elements);
       }catch(Exception e)
       {
           App.customAlert(e.getMessage()); //Error message
       }
    }

}
