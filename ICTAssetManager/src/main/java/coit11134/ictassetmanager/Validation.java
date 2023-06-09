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
    
    


    //method that validates input as a double
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
    
    //checks input is a valid string
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
  
    //checks input is a valid int
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
    
    //validaiton method to check input is a boolean
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
    
    //validaiton method to check phone number format
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
    
    // validation method to check email format
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
