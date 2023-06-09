/*
*COIT11134 Assessment 3 Part B
*
*Authers: Sera Jeong 12211242, Aye Chan Ko KO LWIN12206477, Matthew Meintjes S0270867
*/

package coit11134.ictassetmanager;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class Validation {
    
    

/*    
    public static ButtonType createAndShowAlert (String title, String discription, Alert.AlertType alertType)
    {
      Alert alert = new Alert (AlertType);
      alert.setTitle(title);
      alert.setContentText (discription);
      alert.showAndWait();
      
      return alert.getResult();
    }
  */
/*    
    public static boolean isEmpty(TextField textField) {
        String text = textField.getText();
        if (text.isEmpty() || text.isBlank())
            return true;

        return false;
    }
  
    public static boolean isEmptyOrNotNumeric(TextField textField) {
        String text = textField.getText();
        if (!isNumeric(text) || isEmpty(textField))
            return true;

        return false;
    }
  
    public static boolean isNotInRange(TextField textField, int min, int max) {
        if (isEmptyOrNotNumeric(textField))
            return true;

        //Get int, and check it's range
        int num = Integer.parseInt(textField.getText());
        if (num > max)
            return true;

        if (num < min)
            return true;

        return false;
    }
  
  public static boolean isNegative(TextField textField, int min) {
        if (isEmpty(textField))
            return true;

        int num = Integer.parseInt(textField.getText());
        if (num < min)
            return true;

        return false;
    }
  
   public static boolean isNumeric(String param) {
        for (int i = 0; i < param.length(); i++) {
            if (!Character.isDigit(param.charAt(i)))
                return false;
        }

        return true;
    }
  
  public static boolean hasComma(TextField textField) {
        String text = textField.getText();
        if (text.contains(","))
            return true;

        return false;
    }
  */
    
    public static double doubleValidator(String input) throws NumberFormatException
    {
        try
        {
            return Double.parseDouble(input);
        }
        catch(NumberFormatException e)
        {
            throw new NumberFormatException("Invalid Input.\nPlease enter a valid number.");
        }
    }
    
    
    public static String stringValidator(String input ) throws IllegalArgumentException
    {
        if(input == null || input.isEmpty())
        {
            throw new IllegalArgumentException("Field is empty. Please enter valid text.");
        }
        
        if(input.contains(","))
        {
            throw new IllegalArgumentException("Please remove commas.");
        }
        
        String trimmedString = input.trim();
        
        if (trimmedString.isEmpty())
        {
            throw new IllegalArgumentException("Input contains only white space, please enter a valid input");
        }
        
        return trimmedString;
    }
  
    
    public static int intValidator(String input) throws NumberFormatException
    {
        try
        {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e)
        {
            throw new NumberFormatException("Invalid input. Please enter a valid number");
        }
    }
    
    
    public static boolean booleanValidator(String input)
    {
        try{
            
            boolean validator = Boolean.parseBoolean(input.trim());
            
            return true;
            
        }catch(Exception e)
        {
            App.customAlert(e.getMessage());
            return false;
        }
    }
    
    public static boolean phoneNumberValidator(String input) throws IllegalArgumentException
    {
        String strPattern = "^[0-9]{10}$";
         
        if(input.contains(","))
        {
            throw new IllegalArgumentException("Please remove commas.");
        }
        
        if (input.matches(strPattern))
        {
            return true;
            
        }
        
        else
        {
            return false;
        }
        
    }
    
    public static boolean emailValidator(String input) throws IllegalArgumentException
    {
        String emailFormat = "^[A-Za-z0-9_.-]+@[A-Za-z0-9_.-]+$";
        
        if(input.matches(emailFormat))
        {
            return true;
        }else{
            throw new IllegalArgumentException("Invalid Email, please enter a valid Email.");
        }
    }
 
/*    
    public boolean staffIDValidator(String input)
    {
        try
        {
            if(input.isEmpty() || input.matches(""))
            {
                App.customAlert("StaffID Empty. Please enter a valid ID");
            }
            if(!input.matches("[^0-9]+$"))
            {
                App.customAlert("");
            }
        }
        catch(Exception e)
        {
            App.customAlert(e.getMessage());
        }
    }
    
*/  
    
}
