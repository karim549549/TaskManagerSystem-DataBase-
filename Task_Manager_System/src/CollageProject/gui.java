package CollageProject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class gui extends JFrame implements ActionListener{
  DataBaseFunctions data=new  DataBaseFunctions(); 
    java.sql.Connection con;
            Statement Stmt;
            PreparedStatement Pre;
    JPanel n=new JPanel();
    JButton b1=new JButton("Insert");
    JButton b2=new JButton("Update");
    JButton b3=new JButton("Delete");
    JTextField t1,t2,t3,t4,t5;
    JLabel l1,l2,l3,l4,l5;
    public gui()
    {
        showframe();
    }
    public void showframe()
    {
       
       this.setTitle("ADD TASK");
       this.setSize(500, 700);
       this.setVisible(true);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setResizable(false);
       this.setLocation(700,200 );
 
      this.setLayout(null);//absoulute layout
      b1.setBounds(30, 600, 120, 30);//(x,y,w,h)
      b1.setBackground(Color.DARK_GRAY);
      b1.setForeground(Color.white);
      this.add(b1);
       b2.setBounds(185, 600, 120, 30);
       b2.setBackground(Color.DARK_GRAY);
       b2.setForeground(Color.white);
      this.add(b2);
       b3.setBounds(335, 600, 120, 30);
       b3.setBackground(Color.DARK_GRAY);
       b3.setForeground(Color.white);//font color
      this.add(b3);
       t1=new JTextField();
       t2=new JTextField();
       t3=new JTextField();
       t4=new JTextField();
       t5=new JTextField();
      t1.setBounds(160, 32, 250, 25);
      t1.setBackground(Color.LIGHT_GRAY);
       t2.setBounds(200, 72, 210, 25);
      t2.setBackground(Color.LIGHT_GRAY);
       t3.setBounds(160, 115, 250, 25);
      t3.setBackground(Color.LIGHT_GRAY);
       t4.setBounds(160, 155, 250, 25);
      t4.setBackground(Color.LIGHT_GRAY);
        t5.setBounds(160, 200, 250, 25);
      t5.setBackground(Color.LIGHT_GRAY);
    
      n.setBounds(0, 0, 500, 700);
      //labels
      l1=new JLabel("Code");
      l2=new JLabel("AssignedEmployees");
      l3=new JLabel("Creator");
      l4=new JLabel("Priority");
      l5=new JLabel("Phase");
      l1.setLayout(null);
      l1.setBounds(70, 20, 450,50);
      l1.setForeground(Color.white);
      l2.setLayout(null);
      l2.setBounds(70, 60, 450, 50);
      l2.setForeground(Color.white);
      l3.setLayout(null);
      l3.setBounds(70, 100, 450, 50);
      l3.setForeground(Color.white);
      l4.setLayout(null);
      l4.setBounds(70, 140, 450, 50);
      l4.setForeground(Color.white);
      l5.setLayout(null);
      l5.setBounds(70, 185, 450, 50);
      l5.setForeground(Color.white);
      this.add(l1);
       this.add(t1);
      this.add(l2);
       this.add(t2);
      this.add(l3);
      this.add(t3);
      this.add(l4);
       this.add(t4);
        this.add(l5);
       this.add(t5);
      n.setBackground(Color.BLACK);
      this.add(n);
      b1.addActionListener(this);
        b2.addActionListener(this);
         b3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     String code,pri,phase;
     int assigned,creater;
        if(e.getSource()==b1)
        {
           try{ 
        code=t1.getText().toString();
         assigned=Integer.parseInt(t2.getText().trim());
         creater=Integer.parseInt(t3.getText().trim());
        pri=t4.getText().toString();
        phase=t5.getText().toString();
         data.InsertIntoTasks(code, assigned, creater, pri, phase);
               t1.setText(" ");
                t2.setText(" ");
                 t3.setText(" ");
                  t4.setText(" ");
                   t5.setText(" ");
           }catch(Exception xcp)
           {
               JOptionPane.showMessageDialog(null,xcp.getMessage());
           }
        }else if(e.getSource()==b3)
        {
            code=t1.getText().toString();
            data.DeleteTask(code);
             t1.setText(" ");
        }else if(e.getSource()==b2)
        {
                try{ 
                    code=t1.getText().toString();
                    assigned=Integer.parseInt(t2.getText().trim());
                    creater=Integer.parseInt(t3.getText().trim());
                   pri=t4.getText().toString();
                   phase=t5.getText().toString();
                    data.Updatetask(code, assigned, creater, pri, phase);
                          t1.setText(" ");
                            t2.setText(" ");
                             t3.setText(" " );
                              t4.setText(" ");
                               t5.setText(" ");
           }catch(Exception xcp)
           {
               JOptionPane.showMessageDialog(null,xcp.getMessage());
           }
        }
    }

}