/*
*COIT11134 Assessment 3 Part B
*
*Authers: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/
package coit11134.ictassetmanager;

    
import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class MenuController {

    @FXML
    private Button btnAssetItems;

    @FXML
    private Button btnExt;

    @FXML
    private Button btnLoadRecords;

    @FXML
    private Button btnLocationInformation;

    @FXML
    private Button btnStaffAccount;

    @FXML
    private Button btnStaffInformation;
    
    @FXML
    void exit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Exit? Are you sure?"); 
        alert.showAndWait().ifPresent(response -> { 
            if (response == ButtonType.OK) { 
            Platform.exit(); 
        } 
        }); 
    }
    
    @FXML
    private void switchToAssets() throws IOException {
        App.setRoot("PageAssetInformation");
    }
    
    @FXML
    private void switchToLoanRecords() throws IOException {
        App.setRoot("PageLoanRecord");
    }
    
    @FXML
    private void switchToLocationInformationPage() throws IOException {
        App.setRoot("PageLocationInformation");
    }
    
    @FXML
    private void switchToStaffInformationPage() throws IOException {
        App.setRoot("PageStaffInformation");
    }
    
    @FXML
    private void switchToStaffAccountPage() throws IOException {
        App.setRoot("PageAssetManager");
    }
    
    @FXML
    private void switchToLoadRecords() throws IOException {
        App.setRoot("PageLoanRecord");
    }
}
