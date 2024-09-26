package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

class ViewEmployee extends JFrame implements ActionListener{
    
    JTable table;
    Choice cempId;
    JButton search,back,print,update;
    
    ViewEmployee(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel searchb=new JLabel("Search by Employee ID :");
        searchb.setBounds(20,20,150,20);
        add(searchb);
        
        cempId=new Choice();
        cempId.setBounds(180,20,150,20);
        add(cempId);
        
         try{
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("select * from Employee1");
            while(rs.next()) {
                cempId.add(rs.getString("empID"));
            }
            
        }catch (Exception e) {
        e.printStackTrace();//exception k liye print karna for database
        
   }
        
        table =new JTable();
        
        try{
            Conn c=new Conn();
            ResultSet rs =c.s.executeQuery("select * from Employee1");
            table.setModel(DbUtils.resultSetToTableModel(rs));//insert data into rs
        
        }catch (Exception e) {
        e.printStackTrace();//exception k liye print karna for database
        
   }
        JScrollPane jsp= new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search=new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
         print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
         update=new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);
        
        back=new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);   
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==search){
             String query ="select * from Employee1 where empID='"+cempId.getSelectedItem()+"'";
                  try{
                      Conn c=new Conn();
                  ResultSet rs=c.s.executeQuery(query);
                  table.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch (Exception e) {
        e.printStackTrace();
        
   }
                     
        }else if(ae.getSource()==print){
              try{
                  table.print();
        }catch (Exception e) {
        e.printStackTrace();
        
   }
        }else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee(cempId.getSelectedItem());
        }else{
            setVisible(false);
            new Home();
        }
    }
 
    public static void main(String args[]){
        new ViewEmployee();
        
   }
    
}
