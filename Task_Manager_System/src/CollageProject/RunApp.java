package CollageProject;

import java.util.Scanner;


public class RunApp {
    Scanner in=new Scanner(System.in);
    public void StartAPP(){
    System.out.println( "                                                Task Manager System\n=========================================================================================================================================== "); 
    System.out.println( "1.Admin\n2.Employee\n3.Exit\n");

     int Choice=in.nextInt();
     if(Choice == 1){
        AdminLogin(); 
     }
     else if ( Choice== 2){
         EmployeeLogin();
     }
     else if(Choice ==3){
         return;
     }
     else{
         StartAPP();
     }
    }
    public void EmployeeLogin(){
                  System.out.println( "1.Login\n2.SignUp");
          int Choice=in.nextInt();
          if( Choice == 1){
              //if he choose to login
                 System.out.println( "ENTER YOUR ID");
                       int EmployeeID=in.nextInt();
                 DataBaseFunctions data= new DataBaseFunctions();
               if(  data.searchEmployee(EmployeeID)){
                   EmployeeModule employee= data.getEmployee(EmployeeID);
                   data.setEmployeeStartTime(EmployeeID, employee.AttendanceRegistration());
                   data.setEmployeeEndTime(EmployeeID,"0");
                   employee.EmployeeMenu();
                   employee.EmployeeChoice(employee.getID());
               }
               else{
                   System.out.print("ID NOT FOUND\n");
                   EmployeeLogin();
               }    
          }
          else if(Choice == 2){
              //if he choose  to signup  
               System.out.print("ENTER YOUR NAME"+"\n");
               in.nextLine();
               String name=in.nextLine();
               System.out.print("ENTER YOUR AGE\n");
               int age=in.nextInt();
               System.out.print("ENTER YOUR SALARY\n");    
               double salary=in.nextDouble();
               EmployeeModule Employee=new EmployeeModule(name,age,salary);
               Employee.AddEmployeeIntoDataBase();
               EmployeeLogin();
          }
          else{
              EmployeeLogin();
          }
    }
    public void AdminLogin(){
          System.out.println( "1.Login\n2.SignUp");
          int Choice=in.nextInt();
          if( Choice == 1){
              //if he choose to login
                 System.out.println( "ENTER YOUR ID");
                       int AdminID=in.nextInt();
                 DataBaseFunctions data= new DataBaseFunctions();
               if(  data.searchAdmin(AdminID)){
                   AdminModule admin= data.getAdmin(AdminID);
                   admin.AdminMenu();
                   admin.AdminChoice();
               }
               else{
                   System.out.print("ID NOT FOUND\n");
                   AdminLogin();
               }
               
          }
          else if(Choice == 2){
              //if he choose  to signup
               System.out.print("ENTER YOUR NAME"+"\n");
               in.nextLine();
               String name=in.nextLine();
               System.out.print("ENTER YOUR AGE\n");
               int age=in.nextInt();
               System.out.print("ENTER YOUR SALARY\n");    
               double salary=in.nextDouble();
               AdminModule admin= new AdminModule(name,age,salary);
               admin.InsertAdminIntoDataBase();
               admin.AdminMenu();
               admin.AdminChoice();
          }
          else{
              AdminLogin();
          }
    }
}
