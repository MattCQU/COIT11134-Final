package coit11134.ictassetmanager;

import coit11134.ictassetmanager.App;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ReportController {

    @FXML
    private Button btnBack;

    @FXML
    private ListView<?> listViewReport;
    
    @FXML
    private void switchToAssets() throws IOException {
        App.setRoot("assetInformationPage");
    }

}
