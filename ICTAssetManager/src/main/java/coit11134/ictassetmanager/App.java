package coit11134.ictassetmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.Alert;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    private static DataManager dataManager;

    @Override
    public void start(Stage stage) throws IOException {
        
        dataManager = new DataManager("staff.txt", "assets.txt", "locations.txt","loans.txt");
        
        scene = new Scene(loadFXML("Menu"),600, 400);  
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("ICT Asset Manager");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
    // method to pass dataManger
    public static DataManager getDataManager()
    {
        return dataManager;
    }
    
    public static void customAlert(String message)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR, message); 
        alert.showAndWait();
    }

}