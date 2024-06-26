/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepart1redo;

/**
 *
 * @author Roland
 */
import javax.swing.JOptionPane;
class login 
{
     //declaring variables
    private String username;
    private String password;
    private String name;
    private String surname;
    private String userLogin;
    private String userPassword;
    
    public login(String username,String password,String name,String surname)
            {
                this.password = password;
                this.username = username;
                this.name = name;
                this.surname = surname;
            }
    
    //creating a username
    public static boolean checkUsername(String username)
    {
        return username.length() >= 5 && username.contains("_");        
    }
    
    //creating  a password
    public static boolean checkPasswordComplexity (String password)
    {
        return password.length() > 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*") && password.matches(".*[!@#$%^&*_-].*");
    }
    
    public String registerUser()
    {
       if(checkUsername(username) && checkPasswordComplexity(password))
       {
           userLogin = JOptionPane.showInputDialog(null, "Login Account\n" + "Please enter your username");
           userPassword = JOptionPane.showInputDialog(null, "Login Account\n" + "Please enter your password");
           return "Username succefully captured and password succefully captured";
       }
       else
       {
           if(!checkUsername(username))
           {
               return """
                      Username is not 
                      correctly formatted
                      please ensure that 
                      your username 
                      contains an 
                      underscore and is no 
                      more than 5 
                      character in length 
                      """;
           }
       }
       if(!checkPasswordComplexity(password))
       {
           return """
                  Password is not 
                  please ensure that 
                  the password 
                  characters, a captial 
                  letter, a number and 
                  a special character""";
       }
       return null;
    }
    
    public boolean loginUser()
    {
        if(userLogin.equals(username) && userPassword.equals(password))
        {
            return true;
        }
        else
        {
            return false;
        }
            
    }
    public String returnLoginStatus()
    {
        if(loginUser())
        {
            return "Welcome " + name + " " + surname + " ." + "It is great to see you again";
        }
        else
        {
            return "Username or Pasword incorrect. Please try again.";
        }
    }
    
    
    
}
