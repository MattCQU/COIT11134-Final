/*
*COIT11134 Assessment 3 Part B
*
*Authers: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/

package coit11134.ictassetmanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController implements Initializable {

    @FXML
    private Button btnSignIn;

    
    private DataManager dataManager;
    
  
    
    @FXML
    private void handleButtonLogInAction (ActionEvent event) throws Exception  {
           
            App.setRoot("Menu");
    }
   
    //Method that initializes datamanager 
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
         App.getDataManager();
    }

}

