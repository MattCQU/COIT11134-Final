/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coit11134.ictassetmanager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
/**
 *
 * @author Wesley
 */
public class LoginMenuController implements Initializable {
 
    private DataManager dataManager;
    
    @FXML
    private TextField txtUsername;
  
    @FXML
    private TextField txtPassword;
    


 //Method that initializes datamanager 
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        dataManager = App.getDataManager();
    } 
}
