/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Roland
 */ 
import javax.swing.JOptionPane;
public class Task 
{
     private String taskName;
  private int taskNum;
  private String taskDescription;
  private String developerDetails;
  private int taskDuration;
  private String taskID;
  private String taskStatus;
  private  int sum = 0;
  
  public void addTask(String taskName, int taskNum, String taskDescription, String developerDetails, int taskDuration, String taskID, String taskStatus)
  {
      this.taskName = taskName;
      this.taskNum = taskNum;
      CheckTaskDescription(taskDescription);
      this.developerDetails = developerDetails;
      this.taskDuration = taskDuration;
      CheckTaskID(taskName, taskNum, developerDetails);
      this.taskStatus = taskStatus;
      
  }
  
  private boolean CheckTaskDescription(String taskDescription)
  {
      if(taskDescription.length() <= 100)
      {
          return true; 
      }
      else return false;
  }       
  
          
   private String CheckTaskID(String taskName, int taskNum, String detailDetails)
  {
      String output;
      
      if(developerDetails.contains(" ") && taskName.length() > 2)
      {
          int space = developerDetails.indexOf(" ");
          
          
          String developerID = developerDetails.substring(space-2, space).toUpperCase();
          String taskID = taskName.substring(0, 2).toUpperCase();
          
          
          output = taskID + "#" + taskNum + "#" + developerID;
          taskID = output;
      }
      else
      {
          JOptionPane.showMessageDialog(null, "An Error has occured.");
      }
      return taskID;
  }
   public String PrintTaskDetails()
   {
       StringBuilder output = new StringBuilder();
       //append, toString...
       output.append("\nStatus: ").append(taskStatus);
       output.append("\nTask Developer: ").append(developerDetails);
       output.append("\nTask Number: ").append(taskNum);
       output.append("\nTask Name: ").append(taskName);
       output.append("\nTask Description: ").append(taskDescription);
       output.append("\nTask ID: ").append(taskID);
       output.append("\nTask Duration: ").append(taskDuration);
       
      return output.toString();
   }
   public int ReturnTotalHour(int duration)
   {
       sum += duration;
       taskDuration = sum;
       return sum;
   }
   
   public String CalculateStatus(int taskStat)
   {
       while(true)
       {
           switch (taskStat)
           {
               case 1:
                   taskStatus = "TO DO";
                   break;
                   
               case 2:
                   taskStatus = "DONE";
                   break;
                   
               case 3:
                   taskStatus = "DOING";
                   break;
               
               default:
                   
                   taskStat = Integer.parseInt(JOptionPane.showInputDialog("Please enter task status: \n1. TO DO \n2. DONE \n3. DOING "));
               
           }
       }
   }
   
   public void TaskMenu()
   {
       int option = Integer.parseInt(JOptionPane.showInputDialog("Please enter an option: \n1. Add task \n2. Show Reprt \n3. Quit"));
       while(!(option == 3))
       {
           try
           {
               switch(option)
               {
                   case 1:
                       int numtask = Integer.parseInt(JOptionPane.showInputDialog("Enter number of task?"));
                       
                       for(int x=0; x< numtask; x++)
                       {
                           //prompt user to enter name of task
                           String taskName = JOptionPane.showInputDialog("Please enter name of task: ");
                           
                           //prompt user to enter task number
                           String taskNum = JOptionPane.showInputDialog("please enter task number of " + taskName);
                           
                           //prompt user to enter first and last name
                           String developerDetails = JOptionPane.showInputDialog("Please enter the developer of" + taskName);
                           
                           //prompt user to enter task duration
                           int duration = Integer.parseInt(JOptionPane.showInputDialog("Please enter estimated task duration of " + taskName +" (hours)"));
                           
                           //prompt user to enter status of task 
                           String taskStatus = JOptionPane.showInputDialog("Please enter the status of the task: \n1. TO DO \n2. DONE \n3.DOING");
                           
                           //Prompt user to enter brief description of the book
                           String description = JOptionPane.showInputDialog("Please enter a brief description of " + taskName);
                           
                           if(CheckTaskDescription(description))
                           {
                               JOptionPane.showMessageDialog(null, "Task succefully captured");
                           }
                           else
                           {
                               JOptionPane.showMessageDialog(null, "Please enter a brief description of " + taskName + "(please ensure it is less than 100 characters)");
                           }   
                           addTask(taskName,taskNum, description, developerDetails, duration, taskID, taskStatus);
                           JOptionPane.showMessageDialog(null, PrintTaskDetails());
                       }
                       break;
                       
                   case 2:
                       JOptionPane.showMessageDialog(null, "COMING SOON!");
                       break;
                       
                   case 3:
                       System.exit(0);
                       break;
                       
                   default:
                       System.exit(0);
               }
           }
           catch(NumberFormatException n)
           {
               JOptionPane.showInputDialog(null, "Error: " + n + "Invalid value please enter a number");
           }
           
           option = Integer.parseInt(JOptionPane.showInputDialog("Please select an option: \n1. Add task \n2. Show Report \n3. Quit"));
       }
   }
}
