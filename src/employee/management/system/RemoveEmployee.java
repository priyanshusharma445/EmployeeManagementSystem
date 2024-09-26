package employee.management.system;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice cempid;
    JButton delete, back;
    
    RemoveEmployee(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel labelempID= new JLabel("Employee ID :");
        labelempID.setBounds(50,50,200,30);
        labelempID.setFont(new Font("serif",Font.PLAIN, 18));
        add(labelempID);
        
        cempid= new Choice();
        cempid.setBounds(250,50,200,30);
        add(cempid);
        
         
         try{
            Conn c=new Conn();
            String query ="select * from Employee1";
            ResultSet rs;
            rs = c.s.executeQuery(query);
            while(rs.next()){
                cempid.add(rs.getString("empID"));
            }
        
        }catch (Exception e) {
        e.printStackTrace();//exception k liye print karna for database
        
   }
        
          JLabel labelname= new JLabel("Name :");
        labelname.setBounds(50,100,100,30);
        labelname.setFont(new Font("serif",Font.PLAIN, 18));
        add(labelname);
       
          JLabel lblname= new JLabel();
        lblname.setBounds(200,100,200,30);
        lblname.setFont(new Font("serif",Font.PLAIN, 18));
        add(lblname);
        
           
          JLabel labelphone= new JLabel("Phone :");
        labelphone.setBounds(50,150,100,30);
        labelphone.setFont(new Font("serif",Font.PLAIN, 18));
        add(labelphone);
       
          JLabel lblphone= new JLabel();
        lblphone.setBounds(200,150,200,30);
        lblphone.setFont(new Font("serif",Font.PLAIN, 18));
        add(lblphone);
        
           
          JLabel labelemail= new JLabel("Email :");
        labelemail.setBounds(50,200,100,30);
        labelemail.setFont(new Font("serif",Font.PLAIN, 18));
        add(labelemail);
       
          JLabel lblemail= new JLabel();
        lblemail.setBounds(200,200,200,30);
        lblemail.setFont(new Font("serif",Font.PLAIN, 18));
        add(lblemail);
        
           
         try{
            Conn c=new Conn();
            String query ="select * from Employee1 where empID ='"+cempid.getSelectedItem()+"'";
            ResultSet rs;
            rs = c.s.executeQuery(query);
            while(rs.next()){
               lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
               lblemail.setText(rs.getString("email"));
            }
        
        }catch (Exception e) {
        e.printStackTrace();//exception k liye print karna for database
        
   }
         
             
        cempid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from Employee1 where empID = '"+cempid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220, 300, 100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
         /* ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("C:/Users/User/Desktop/Employee123/pexels-chevanon-325044.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);*/
         
         ImageIcon i1 = new ImageIcon("C:/Users/User/Desktop/Employee123/pexels-chevanon-325044.jpg");
Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
ImageIcon i3 = new ImageIcon(i2);
JLabel image = new JLabel(i3);
image.setBounds(350, 0, 600, 400);
add(image);

        
        
       setSize(1000,400);
       setLocation(300,150);
       setVisible(true);
        
            }
    
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                String query = "delete from Employee1 where empID = '"+cempid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Sucessfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    
    public static void main(String args[])
    {
        new RemoveEmployee();
    }
}
