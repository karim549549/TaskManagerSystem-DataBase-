
package CollageProject;

import java.time.LocalTime;
import java.util.Scanner;








public class EmployeeModule  {
    //ID is Auto Incremented In database
    protected String name;
    protected int age,EmployeeID;
    protected LocalTime StartTime,EndTime;
    double salary;
    //Global varaibles
    Scanner in=new Scanner(System.in);
    LocalTime now = LocalTime. now();
    RunApp run=new  RunApp();
    DataBaseFunctions data=new DataBaseFunctions();
    //Global varaibles
    public EmployeeModule(String name, int age,double salary) {
        this.name = name;
        this.age = age;
        this.salary=salary;
    }

    public EmployeeModule() {
    } 
//setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTask(String Task) {
       //Only Admin Can set a Task to an Employee
    }
    
  //Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public int getID(){
        return EmployeeID;
    }
//AddEmployeeintoDatabase
public void AddEmployeeIntoDataBase(){
       DataBaseFunctions Data = new DataBaseFunctions();
       Data.InsertIntoEmployee(name,age,salary,AttendanceRegistration());
}  
//AddEmployeeintoDatabase
//public void EmployeeMenu
public void EmployeeMenu(){
    System.out.println("1.see inbox\n2.send a request\n3.see your task\n4.permission request\n5.logout\n6.My Data");
}
public void EmployeeChoice(int EmployeeID){
    System.out.print("Enter your choice\n");
        int Choice=in.nextInt();
         if(Choice==1)
             PrintInboxes();
         if(Choice==2)
             LeaveRequest();
         if(Choice==3)
             MyTasks();
         if(Choice==5){
            data.setEmployeeEndTime(EmployeeID, leaveRegistration());
             run.StartAPP();
         }
         if(Choice==6)
             PrintEmployeeData();
         if(Choice !=5){
       System.out.println("===============================================");
       System.out.println("Press AnyKey To Return menu");
       in.nextLine();
       String space=in.nextLine();
       EmployeeMenu();
       EmployeeChoice(EmployeeID);
         }
}
//public void EmployeeMenu
    public void PerrmissionRequest(){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Your Request");
        String request=in.nextLine();
        DataBaseFunctions data=new DataBaseFunctions();
        data.SendToAdmin(request);
    }
    public void Approvals(Boolean Decision){
        //Store a decison in table Requests
    }
    public String AttendanceRegistration(){
       System.out.println("LOGED IN SUCCESSFUL AT:  "+now.minusMinutes(0));
       StartTime=now.minusMinutes(0);
        return StartTime.toString();
    }
    public String leaveRegistration(){
        System.out.println("LOGED OUT SUCCESSFUL AT:  "+now.minusMinutes(0));
        EndTime=now.minusMinutes(0);  
        return EndTime.toString();
    }
    public void LeaveRequest(){
        System.out.println("Enter Your Request");
        String request=in.nextLine();
        data.SendToAdmin(request);
    }
    public void PrintInboxes(){
        data.printInbox();
    }
    public void MyTasks(){
        System.out.println("Enter Your ID to see Your Task Details");
        int EmployeeID=in.nextInt();     
        data.PrintEmployeeTasks(EmployeeID);
    }
    public void PrintEmployeeData(){
        System.out.println("Enter Your ID");
        int EmployeeID=in.nextInt();
        if(data.searchEmployee(EmployeeID))
        data.printEmployeeData(EmployeeID);
        else
            System.out.println("ID NOT FOUND");
    }
}
