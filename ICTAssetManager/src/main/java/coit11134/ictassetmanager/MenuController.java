/*
*COIT11134 Assessment 3 Part B
*
*Authers: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/
package coit11134.ictassetmanager;

    
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
    private void switchToAssets() throws IOException {
        App.setRoot("assetInformationPage");
    }
    
    @FXML
    private void switchToLoanRecords() throws IOException {
        App.setRoot("loanRecordsPage");
    }
    
    @FXML
    private void switchToLocationInformationPage() throws IOException {
        App.setRoot("locationInformationPage");
    }
    
    @FXML
    private void switchToStaffInformationPage() throws IOException {
        App.setRoot("staffInformationPage");
    }
    
    @FXML
    private void switchToStaffAccountPage() throws IOException {
        App.setRoot("staffAccountPage");
    }
    
    @FXML
    private void switchToLoadRecords() throws IOException {
        App.setRoot("loanRecords");
    }
}
