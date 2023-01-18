package CollageProject;

import static CollageProject.TasksModule.setTask;
import java.util.Scanner;
import static CollageProject.TasksModule.UpdateTasks;






public class AdminModule  {
   protected String name;
   protected int age;
   protected double salary;
   //id is auto increminted in database
   //Global objects
    Scanner input = new Scanner(System.in);
    DataBaseFunctions Data = new DataBaseFunctions(); 
   //Global objects
    public AdminModule(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    public AdminModule() {
    }
   //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    //getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
    //
    //setAdminIntoDataBase
    public void InsertAdminIntoDataBase(){
       Data.InsertIntoAdmin(name,age,salary);
    }
    //setAdminIntoDataBase
    //AdminMenu FOR RUNAPP
    public void AdminMenu(){
           System.out.print("1.Add Task\n2.Delete Task\n3.Update Task\n4.AddEmployee\n5.Delete Employee\n6.Update Employee\n7.Logout\n");  
            System.out.println("8.see all Employees\n9.see all tasks\n10.see inbox\n11.take Decisions\n12.Clear Inbox");
    }     
    public void AdminChoice(){
         System.out.println(" Choice Your Operation");
         int Choice=input.nextInt();
         if(Choice==1)
            AddTasks();
         if(Choice==2)
             deleteTasks();
         if(Choice==3)
             UpdateTask();
         if(Choice==4)
             AddEmployee();
         if(Choice==5)
             DeleteEmployee();
         if(Choice==6)
             UpdateEmployee();    
         if(Choice==7) {           
             RunApp run=new  RunApp();
             run.StartAPP();
         }
         if(Choice==8)
             printEmployeeTable();
         if(Choice==9)
             PrintTasksTable();
         if(Choice==10)
             printInboxes();
         if(Choice == 11)
             takeDecisions();
         if(Choice ==12)
             ClearInbox();
         if(Choice != 7){
       System.out.println("===============================================");
       System.out.println("Press AnyKey To Return menu\n");
       input.nextLine();
       String space=input.nextLine();
         AdminMenu();
       AdminChoice();
         }
    }
    //AdminMenu FOR RUNAPP
    public void UpdateTask(){   
                 System.out.println("Enter Your ID");
           int ID=input.nextInt();
           if(  Data.searchAdmin(ID))
              UpdateTasks(ID);
           else{
              System.out.println("ID NOT FOUND");
              UpdateTask();
           }
    }
    public void AddTasks(){
           System.out.println("Enter Your ID");
           int ID=input.nextInt();
           if(  Data.searchAdmin(ID))
            setTask(ID);
           else{
              System.out.println("ID NOT FOUND");
              AddTasks();
           }
    }
    public void deleteTasks(){
         System.out.println("Enter Your ID");
        int ID= input.nextInt();
        if(Data.searchAdmin(ID)){
        System.out.println("Enter TaskCode");
        input.nextLine();
        String code=input.nextLine(); 
        if(Data.searchTask(code)){
        Data.DeleteTask(code);
        Data.printTasksTable();
        }
        else
            System.out.println("CODE NOT FOUND");
        }   
        else
            System.out.println("ID NOT FOUND");
    }
    public void PrintTasksTable(){
         Data.printTasksTable();
    }
    //==================
    //Employee Functions
    //==================
    public void AddEmployee(){
        System.out.println("Enter Name");
        input.nextLine();
        String name=input.nextLine();
        System.out.println("Enter Age");
        int age=input.nextInt();
        System.out.println("Enter Salary");
        double salary=input.nextDouble();
        EmployeeModule newEmployee=new EmployeeModule(name,age,salary);
        newEmployee.AddEmployeeIntoDataBase();
        Data.printEmployeeTable();
    }
    public void DeleteEmployee(){
        System.out.println("Enter The ID");
        int id=input.nextInt();
        Data.DeleteEmployee(id);
        Data.printEmployeeTable();
    }
    public void UpdateEmployee(){
        System.out.println("Enter ID");  
        int id=input.nextInt();
        System.out.println("Enter Name");
        input.nextLine();
        String name= input.nextLine();
        System.out.println("Enter Age"); 
        int age=input.nextInt();
        System.out.println("Enter Salary"); 
        double salary=input.nextDouble();
        Data.UpdateEmployee(id, name, age, salary);
        Data.printEmployeeTable();
    }
    public void printEmployeeTable(){
        Data.printEmployeeTable();
    }
    //==================
    //Employee Functions
    //==================
    public void printInboxes(){
        Data.printInbox();
    }
    public void takeDecisions(){ 
        System.out.println("Enter MessageID");
        int MessageID=input.nextInt();
        if(    Data.searchMessage(MessageID)){
        
        System.out.println("Enter Your Decision(YES,NO)");
        input.nextLine();
        String Choice=input.nextLine();
        Choice.toLowerCase();
        int Decision=0;
        if(Choice.equalsIgnoreCase("yes"))
            Decision=1;
         if(Choice.equalsIgnoreCase("no"))
            Decision=2;
        Data.takeDecision(Decision, MessageID);
        takeDecisions();
        }
        else
            System.out.println("MessageID NOT FOUND");
    }
    public void ClearInbox(){
        Data.clearInbox();
        Data.printInbox();
    }
}










