/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;

/**
 *
 * @author w
 */
public class Validating {
    private static final String USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9_]{2,19}$";
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    
    private static final Pattern USERNAME_PATTERN_REGEX = Pattern.compile(USERNAME_PATTERN);
    private static final Pattern EMAIL_PATTERN_REGEX = Pattern.compile(EMAIL_PATTERN);
    private static final Pattern PASSWORD_PATTERN_REGEX = Pattern.compile(PASSWORD_PATTERN);
    
    public static boolean validateRegister(String username, String email, String password, String confirmPassword) {
        
        if(!validateUsername(username)) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "UserName", "Enter Valid UserName");
            return false;
        }
        
        if (!validateEmail(email)) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "Email", "Enter Valid Email");
            return false;
        }
        
        if (!validateConfirmPassword(password, confirmPassword)) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "Invalid Confirm Password", 
                    "The password confirmation does not match the original password.");
            return false;
        }
        
        if (!validatePassword(password)) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "Invalid Password", 
                    "The password does not meet the required criteria.\nPlease use a stronger password.");
            return false;
        }
        
        return true;
    }
    
    public static boolean validateLogin(String email, String password) {
        
        if (!validateEmail(email)) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "Email", "Enter Valid Email");
            return false;
        }
        
        if (!validatePassword(password)) {
            Util.showAlertDialog(Alert.AlertType.ERROR, "Invalid Password", 
                    "The password does not meet the required criteria.\nPlease use a stronger password.");
            return false;
        }
        
        return true;
    }
    
    private static boolean validateUsername(String username) {
        Matcher matcher = USERNAME_PATTERN_REGEX.matcher(username);
        return matcher.matches();
    }
    
    private static boolean validateEmail(String email) {
        Matcher matcher = EMAIL_PATTERN_REGEX.matcher(email);
        return matcher.matches();
    }
    
    private static boolean validateConfirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }
    
    private static boolean validatePassword(String password) {
        Matcher matcher = PASSWORD_PATTERN_REGEX.matcher(password);
        return matcher.matches();
    }
}