package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
    
    JButton view,add,update,remove;//globale call
    
    Home(){
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon("C://Users//User//Desktop//Employee123//pexels-souvenirpixels-417074.jpg");
	Image i2 = i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);//convert into icon new obj ...i2 ko jlbel mei pass karna thai..
	JLabel image = new JLabel(i3);//direct add nhi kar sakte
	image.setBounds(0,0,1120,630);
	add(image);
        
        add=new JButton ("Add Employee");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        add.setForeground(Color.white);
        image.add(add);
         add.setBackground(Color.blue);
        add.setOpaque(false);
        add.setContentAreaFilled(false);
        add.setBorderPainted(false);
  
         view=new JButton ("View Employees");
        view.setBounds(850,80,150,40);
        view.addActionListener(this);
        view.setForeground(Color.white);
        image.add(view);
        view.setOpaque(false);
        view.setContentAreaFilled(false);
        view.setBorderPainted(false);
	
            update=new JButton ("Update Employee");
        update.setBounds(650,140,150,40);
        update.addActionListener(this);
        update.setForeground(Color.white);
        image.add(update);
        update.setOpaque(false);
        update.setContentAreaFilled(false);
        update.setBorderPainted(false);
       
        
        remove=new JButton ("Remove Employee");
       remove.setBounds(850,140,150,40);
       remove.addActionListener(this);
       remove.setForeground(Color.white);
       image.add(remove);
       remove.setOpaque(false);
       remove.setContentAreaFilled(false);
       remove.setBorderPainted(false);
	
        
       JLabel heading = new JLabel("Employee Management System");
       heading.setBounds(650,20,400,40);
       heading.setFont(new Font("serif",Font.BOLD,25));
       image.add(heading);
        

         setSize(1120, 630);
         setLocation(250, 100);
         setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){//due to implement of action listener
        if(ae.getSource()==add){
            setVisible(false);
            new AddEmployee();
        }else if(ae.getSource()==view){
            setVisible(false);
            new ViewEmployee();
        }else if(ae.getSource()==update){
             setVisible(false);
            new ViewEmployee();
        }else{
            setVisible(false);
            new RemoveEmployee();
        }
    }
    
    public static void main(String args[]){
        
        new Home();//constrator
  
    }}
