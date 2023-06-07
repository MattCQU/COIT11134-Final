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
    
    public double doubleValidator(String numberString) throws NumberFormatException
    {
        try
        {
            return Double.parseDouble(numberString);
        }
        catch(NumberFormatException e)
        {
            throw new NumberFormatException("Invalid Input.\nPlease enter a valid number.");
        }
    }
    
    
    public String stringValidator(String input ) throws IllegalArgumentException
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
  
}
