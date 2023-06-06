/*
*COIT11134 Assessment 3 Part B
*
*Authers: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/


package coit11134.ictassetmanager;

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
    private TextField txtfieldSearch;
    
    @FXML
    private void handleButtonExitAction (ActionEvent event) throws Exception  {
        System.out.println("You have pressed the Cancel button!");
        
        try {
            App.setRoot("menu");
        } catch (IOException e){
           System.out.println(e); 
        }
    }

}
