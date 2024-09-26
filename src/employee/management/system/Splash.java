package employee.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Splash extends JFrame implements ActionListener{
	
	Splash(){ // constrator call karna ...
	
	getContentPane().setBackground(Color.black); //getcontent to access all frame
	setLayout(null);// not using swing layout
	

	JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");//component
	heading.setBounds(65,30,1200,60);//this is my style layout
	heading.setFont(new Font("serif",Font.PLAIN, 60));
	
	heading.setForeground(Color.red);
	add(heading);
	
	ImageIcon i1 = new ImageIcon("C:/Users/User/Desktop/Employee123/pexels-josh-hild-1270765-2422588.jpg");
	Image i2 = i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);//convert into icon new obj ...i2 ko jlbel mei pass karna thai..
	JLabel image = new JLabel(i3);//direct add nhi kar sakte
	image.setBounds(50,100,1050,500);
	add(image);
	
	JButton clickhere= new JButton ("CLICK HERE TO CONTINUE");
	clickhere.setBounds(400,400,300,20);
	clickhere.setBackground(Color.black);
	clickhere.setForeground(Color.white);
	clickhere.addActionListener(this);
	image.add(clickhere);
	
	
	clickhere.setOpaque(false);
clickhere.setContentAreaFilled(false);
clickhere.setBorderPainted(false);
	
	//while(true) {
		
	//	heading.setVisible(false);
	//	try{ Thread.sleep(500);} catch (Exception e){}
	//	heading.setVisible(true); try{Thread.sleep(500);}catch(Exception e){}
		
	Timer timer = new Timer(500, e -> heading.setVisible(!heading.isVisible()));
        timer.start();

	
	
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit screen work...static hai ishle className. used karna hoga..
	
		setSize(1170,650);//frame white plate
		setLocation(200,50);//begin opening time
	setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		setVisible(false);
		new Login();
	}
	
	public static void main(String args[]){
		new Splash();// splash constrator just obj create hai bhai....
		
	}
}
	
