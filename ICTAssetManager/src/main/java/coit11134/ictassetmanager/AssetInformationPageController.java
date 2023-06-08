/*
*COIT11134 Assessment 3 Part B
*
*Authers: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/


package coit11134.ictassetmanager;

import java.io.IOException;
import java.util.HashSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class AssetInformationPageController {
    

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
    private ListView<?> listViewAssets;

    @FXML
    private TextField txtFieldSearch;
    
    @FXML
    private void handleButtonExitAction (ActionEvent event) throws Exception  {
        System.out.println("You have pressed the Cancel button!");
        
        clearAllField();
        
        try {
            App.setRoot("Menu");
        } catch (IOException e){
           System.out.println(e); 
        }
    }
    
    private void clearAllField()
    {
    
        txtFieldSearch.clear();
        
    }
    
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
    
    @FXML
    private void handleCreatebutton (ActionEvent event ) throws Exception
    {
        try
        {
            App.setRoot("CreateAssetItem");
            
        }catch (Exception e)
        {
            App.customAlert(e.getMessage());
        }
    }

}
