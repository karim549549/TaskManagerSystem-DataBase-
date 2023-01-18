
package CollageProject;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

public class DataBaseFunctions {
        java.sql.Connection con;
        Statement Stmt;
        PreparedStatement Pre;
  
        //Print Functions
      public void printAdminTable()
      {
            try {
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                Stmt = con.createStatement();
                ResultSet rs=Stmt.executeQuery("select * from admin");
                while(rs.next()){
                    String name=rs.getString("name");
                    int age=rs.getInt("age");
                    double salary=rs.getDouble("salary");
                    System.out.println(name+" "+age+" "+salary);
                }
                Stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(RunApp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
       } 
           public void printEmployeeTable()
      {
            try {
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
            
                Stmt = con.createStatement();
                ResultSet rs=Stmt.executeQuery("select * from employee");
                while(rs.next()){
                    int ID=rs.getInt("id");
                    String name=rs.getString("name");
                    int age=rs.getInt("age");
                    double salary=rs.getDouble("salary");
                    String starttime=rs.getString("starttime");
                    String endtime=rs.getString("endtime");
                    System.out.println("ID:"+ID+" NAME:"+name+" AGE:"+age+" SALARY:"+salary+" STARTTIME: "+starttime+" ENDTIME: "+endtime);
                }
                Stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(RunApp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
          public void printTasksTable()
      {
            try {
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                Stmt = con.createStatement();
                ResultSet rs=Stmt.executeQuery("select * from tasks");
                while(rs.next()){
                    String code=rs.getString("taskcode");
                    int assignedemployee=rs.getInt("assignedemployee");
                    int creater=rs.getInt("creater");
                    String priorty=rs.getString("priorty");
                    String Phase=rs.getString("phase");
                    if(Phase.isEmpty())
                        Phase="NULL";
                    if(priorty.isEmpty())
                        priorty="NULL";
                    System.out.println("CODE:"+code+" "+"ASSIGNED EMPLOYEE:"+assignedemployee+" "+"CREATER:"+creater+" "+"PRIORTY:"+priorty+" "+"PHASE:"+Phase);
                }
                Stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(RunApp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
          public void PrintEmployeeTasks(int id){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                     Stmt = con.createStatement();
                ResultSet rs=Stmt.executeQuery("select * from tasks");
                while(rs.next()){
                    String code=rs.getString("taskcode");
                    int assignedemployee=rs.getInt("assignedemployee");
                    int creater=rs.getInt("creater");
                    String priorty=rs.getString("priorty");
                    String Phase=rs.getString("phase");
                    if(id  == assignedemployee){
                        System.out.println("CODE:"+code+" "+"ASSIGNED EMPLOYEE:"+assignedemployee+" "+"CREATER:"+creater+" "+"PRIORTY:"+priorty+" "+"PHASE:"+Phase);
                    }
                    
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
          public void printEmployeeData(int EMployeeID){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                ResultSet rs=Stmt.executeQuery("select * from employee");
                while(rs.next()){
                    if(EMployeeID == rs.getInt("id")){
                    int ID=rs.getInt("id");
                    String name=rs.getString("name");
                    int age=rs.getInt("age");
                    double salary=rs.getDouble("salary");
                    String starttime=rs.getString("starttime");
                    String endtime=rs.getString("endtime");
                    System.out.println("ID:"+ID+" NAME:"+name+" AGE:"+age+" SALARY:"+salary+" STARTTIME: "+starttime+" ENDTIME: "+endtime);
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
             
          }
      //Prints Functions
      //insertion functions
      public void InsertIntoAdmin(String name,int age,double salary){
            try {
              try {
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                  Pre=con.prepareStatement("insert into admin(name,age,salary) values(?,?,?)");
                  Pre.setString(1, name);
                  Pre.setInt(2, age);
                  Pre.setDouble(3, salary);
                  Pre.execute();
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
              }
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
            public void InsertIntoEmployee(String name,int age,double salary,String startTime){
            try {
              try {
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                  Pre=con.prepareStatement("insert into employee(name,age,salary,starttime) values(?,?,?,?)");
                  Pre.setString(1, name);
                  Pre.setInt(2, age);
                  Pre.setDouble(3, salary);
                  Pre.setString(4,startTime);
                  Pre.execute();
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
              }
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
        public void InsertIntoTasks(String code,int assignedEmployee, int creater,String priorty,String Phase){
            try {
              try {
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                  Pre=con.prepareStatement("insert into tasks(taskcode,assignedemployee,creater,priorty,phase) values(?,?,?,?,?)");
                  Pre.setString(1, code);
                  Pre.setInt(2, assignedEmployee);
                  Pre.setDouble(3, creater);
                  Pre.setString(4, priorty);
                  Pre.setString(5,Phase);
                  Pre.execute();
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
              }
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
        //InboxFunctions
     public void SendToAdmin(String message){
            try {
              try {
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                  Pre=con.prepareStatement("insert into admin_messages(message,decision) value(?,0)");
                  Pre.setString(1, message);
                  Pre.execute();
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
              }
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
        public void takeDecision(int decision,int messageID){
            try {
              try {
                  Class.forName("com.mysql.cj.jdbc.Driver");
                  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                  Pre=con.prepareStatement("update  admin_messages set decision=? where id=?");
                  Pre.setInt(1, decision);
                  Pre.setInt(2,messageID);
                  Pre.execute();
              } catch (ClassNotFoundException ex) {
                  Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
              }
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
     
      public void printInbox()
      {
            try {
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");  
                Stmt = con.createStatement();
                ResultSet rs=Stmt.executeQuery("select * from admin_messages");
                while(rs.next()){
                    String message=rs.getString("message");
                    int decision=rs.getInt("decision");
                    int MessageID=rs.getInt("id");
                    if(decision==1)
                    System.out.println("MESSAGE ID:"+MessageID+"  "+"MESSAGE:"+message+"  "+"DECISION:Accepted");
                    else if(decision==2)
                         System.out.println("MESSAGE ID:"+MessageID+"  "+"MESSAGE:"+message+"  "+"DECISION:DENIED");
                    else
                         System.out.println("MESSAGE ID:"+MessageID+"  "+"MESSAGE:"+message+"  "+"DECISION:NOT ANSWERD");
                }
                Stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(RunApp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
          public void clearInbox(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                Pre=con.prepareStatement("delete from admin_messages  where decision>0");
                Pre.executeUpdate();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
          public boolean searchMessage(int ID){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                Stmt = con.createStatement();
                ResultSet rs=Stmt.executeQuery("select * from admin_messages");
                while(rs.next()){
                   if(ID==rs.getInt("id"))
                       return true;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
          }
       //InboxFunctions
      //Delete Functions
      public void DeleteEmployee(int id){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                Pre=con.prepareStatement("delete from  employee where id=?");
                Pre.setInt(1,id);
                Pre.executeUpdate();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
             catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
          public void DeleteTask(String code){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                Pre=con.prepareStatement("delete from  tasks where taskcode=?");
                Pre.setString(1,code);
                Pre.executeUpdate();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
             catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      //Delete Functions
      //UpdateFunctions
      public void UpdateEmployee(int id,String name,int age,double salary){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                Pre=con.prepareStatement("update employee set name=?, age=?, salary=? where id=?");
                Pre.setString(1,name);
                Pre.setInt(2,age);
                Pre.setDouble(3,salary);
                Pre.setInt(4,id);
                Pre.executeUpdate();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
            public void Updatetask(String code,int assignedEmployee,int creater,String priorty,String Phase){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                Pre=con.prepareStatement("update tasks set assignedemployee=?, creater=?, priorty=?,phase=? where taskcode=?");    
                Pre.setInt(1,assignedEmployee);
                Pre.setInt(2,creater);
                Pre.setString(3,priorty);
                Pre.setString(4, Phase);
                Pre.setString(5,code);
                Pre.executeUpdate();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
        public void setEmployeeStartTime(int ID,String time){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                Pre=con.prepareStatement("update employee set starttime=? where id=?");
                Pre.setString(1,time);
                Pre.setInt(2, ID);
                Pre.executeUpdate();  
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
               
        }
        public void setEmployeeEndTime(int ID,String time){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                Pre=con.prepareStatement("update employee set endtime=? where id=?");
                Pre.setString(1,time);
                Pre.setInt(2, ID);
                Pre.executeUpdate();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
               
        }        
      //UpdateFunctions
      //searchFunctions
            public boolean searchAdmin(int id){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                Stmt = con.createStatement();
                ResultSet rs=Stmt.executeQuery("select * from admin");
                while(rs.next()){
                   int AdminID=rs.getInt("id");
                   if(AdminID == id)
                       return true;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
            }
           public boolean searchEmployee(int id){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                Stmt = con.createStatement();
                ResultSet rs=Stmt.executeQuery("select * from employee");
                while(rs.next()){
                   int EmployeeID=rs.getInt("id");
                   if(EmployeeID == id)
                       return true;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
            }
           public boolean searchTask(String code){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                Stmt = con.createStatement();
                ResultSet rs=Stmt.executeQuery("select * from tasks");
                while(rs.next()){
                   String TaskCode=rs.getString("taskcode");
                   if(TaskCode.equals(code))
                       return true;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
            }
        //searchFunctions     
        //GetAdmin
           public AdminModule getAdmin(int id){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                Stmt = con.createStatement();
                ResultSet rs=Stmt.executeQuery("select * from admin");
                while(rs.next()){
                   int AdminID=rs.getInt("id");
                   if(AdminID == id){
                   AdminModule admin=new AdminModule(rs.getString("name"),rs.getInt("age"),rs.getDouble("salary"));
                   return admin;
                   }
                     
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
           }
           public EmployeeModule getEmployee(int id){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage","root","root");
                Stmt = con.createStatement();
                ResultSet rs=Stmt.executeQuery("select * from employee");
                while(rs.next()){
                   int EmployeeID=rs.getInt("id");
                   if(EmployeeID == id){
                   EmployeeModule Employee=new EmployeeModule(rs.getString("name"),rs.getInt("age"),rs.getDouble("salary"));
                   return Employee;
                   }
                     
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
           }
}
