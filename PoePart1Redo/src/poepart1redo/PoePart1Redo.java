/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepart1redo;

/**
 *
 * @author Caleb Ragaven 
 */
import javax.swing.JOptionPane;
public class PoePart1Redo {

  
    public static void main(String[] args) 
    {
        String Name = JOptionPane.showInputDialog(null, "Please enter your name: ");
        String Surname = JOptionPane.showInputDialog("Please enter your name: ");
        
        String assignUsername = JOptionPane.showInputDialog(null, "Please Enter a username: \n" + "-Must not be longer thaan 5 characters \n" + "-Must include an underscore (_)" );
        
        String assignPassword = JOptionPane.showInputDialog(null, "Please enter a password: \n" + "-Must be at least 8 character\n" + "-Must have an upperscore letter\n" + "-Must have a special character");
        
        login Login = new login(assignUsername,assignPassword,Name,Surname);
        
        JOptionPane.showMessageDialog(null, Login.registerUser());
        
        JOptionPane.showMessageDialog(null, Login.returnLoginStatus());
    }
    
    
    
}
