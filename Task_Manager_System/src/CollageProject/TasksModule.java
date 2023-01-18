
package CollageProject;

import java.util.Scanner;


public class TasksModule {
    private String Code,Priority,Phase;
    private int AssigedEmoloyee,CreaterName;

    private TasksModule(String Code, int AssigedEmoloyee, int Creater, String Priority,String Phase) {
        this.Code = Code;
        this.AssigedEmoloyee = AssigedEmoloyee;
        this.CreaterName = CreaterName;
        this.Priority = Priority;
        this.Phase=Phase;
        //Store The task in Tasks table in database
         DataBaseFunctions Data = new DataBaseFunctions();
         Data.InsertIntoTasks(Code, AssigedEmoloyee, Creater, Priority,Phase);
    }

    private void setCode(String Code) {
        this.Code = Code;
          //Sets it in database
    }

    private void setAssigedEmoloyee(int AssigedEmoloyee) {
        this.AssigedEmoloyee = AssigedEmoloyee;
        //Sets it in database
    }

    private void setCreaterName(int CreaterName) {
        this.CreaterName = CreaterName;
        //Sets in in database
    }
    private void setPhase(String Phase){
        this.Phase=Phase;
    }
//Setters
    public static void setTask(int ID){
        DataBaseFunctions Data = new DataBaseFunctions();
        Scanner input=new Scanner(System.in);
        System.out.println("Enter code");
        String code=input.nextLine();
        System.out.println("Enter Priorty");
        String priorty=input.nextLine();
        System.out.println("Enter AssigedempleyeeID");
        int Assigedempleyee= input.nextInt(); 
        System.out.println("Enter Phase");
        input.nextLine();
        String Phase=input.nextLine(); 
        if(Data.searchEmployee(Assigedempleyee)){
        TasksModule task=new TasksModule(code,Assigedempleyee,ID,priorty,Phase);
        Data.printTasksTable();
        }
        else
            System.out.println("Assigned EmployeeId NOT FOUND");
    }
    public static void UpdateTasks(int ID){
        Scanner input=new Scanner(System.in);
        DataBaseFunctions Data = new DataBaseFunctions();
        System.out.println("Enter Task code");
        String code=input.nextLine();
        if(Data.searchTask(code)){
        System.out.println("Enter AssignedEmployeeID");
        int AssignedEmployee=input.nextInt();
        if(Data.searchEmployee(AssignedEmployee)){
        System.out.println("Enter Priorty");
        input.nextLine();
        String Priorty=input.nextLine();
        System.out.println("Enter taskPhase");
        String Phase =input.nextLine();
            Data.Updatetask( code , AssignedEmployee, ID, Priorty , Phase);
            Data.printTasksTable();
        }
          else
            System.out.println("Assigned EmployeeId NOT FOUND");
        }
        else
            System.out.println("CODE NOT FOUND");
    }
//Getters
    public void setPriority(String Priority) {
        this.Priority = Priority;
    }

    public String getCode() {
        return Code;
    }

    public int getAssigedEmoloyee() {
        return AssigedEmoloyee;
    }

    public int getCreaterName() {
        return CreaterName;
    }

    public String getPriority() {
        return Priority;
    }
    //======================================================
    //Every Empolyee only can see his tasks Using database 
    //======================================================
}


















