/*
*COIT11134 Assessment 3 Part B
*
*Authors: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/
package coit11134.ictassetmanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class CreateAssetItemController
{
  @FXML
  private TextField txtAssetID;
  
  @FXML
  private TextField txtMake;
  
  @FXML
  private TextField txtSerialNumber;
  
  @FXML
  private TextField txtNextTestDueDate;
  
  @FXML
  private TextField txtPurchaseDate;
  
  @FXML
  private TextField txtItemType;
  
  @FXML
  private TextField txtModel;
  
  @FXML
  private TextField txtWarranteeEndDate;
  
  @FXML
  private TextField txtPurchasePrice;
  
  @FXML
  private MenuButton mnuStatus;
  
  @FXML
  private MenuItem itemActive;
  
  @FXML
  private MenuItem itemArchived;
  
  @FXML
  private Button btnBack;
  
  @FXML
  private Button btnCreate;
}
