package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


class Login extends JFrame implements ActionListener{

	JTextField busername,bpassword;
	
	Login() {
            
            
            
            
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
                
		JLabel ausername=new JLabel("Username :");//username
                 ausername.setOpaque(false);
		ausername.setBounds(80,20,100,30);
		add(ausername);
		 busername=new JTextField();
		busername.setBounds(150,20,150,30);
		add(busername);
		
	
		
		JButton login= new JButton ("LOGIN");
           
	login.setBounds(150,120,150,30);
	login.setBackground(Color.black);
	login.setForeground(Color.white);
	login.addActionListener(this);
	add(login); 
        //login.setOpaque(true);
        //login.setContentAreaFilled(true);
        //login.setBorderPainted(true);
		
		JLabel apassword=new JLabel("Password :");//password
                 apassword.setOpaque(false);
		apassword.setBounds(80,70,100,30);
		add(apassword);
		 bpassword=new JPasswordField();
		bpassword.setBounds(150,70,150,30);
		add(bpassword);
	
                
                ImageIcon i1 = new ImageIcon("C://Users//User//Desktop//Employee123//mobile-login-concept-illustration_114360-83.avif");
	Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
	ImageIcon i3 = new ImageIcon(i2);//convert into icon new obj ...i2 ko jlbel mei pass karna thai..
	JLabel image = new JLabel(i3);//direct add nhi kar sakte
	image.setBounds(0,0,600,300);
	add(image);
                
		setSize(600,300);
		setLocation(450,200);
		setVisible(true);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		
	}

        
        
	public void actionPerformed(ActionEvent ae) {
		try{
			
			//String query = "SELECT * FROM login WHERE username = ? AND password = ?";
//PreparedStatement pstmt = c.s.prepareStatement(query);
//pstmt.setString(1, username);
//pstmt.setString(2, password);
//ResultSet rs = pstmt.executeQuery();

			
			
			
			String username=busername.getText();
			String password=bpassword.getText();

			Conn c =new Conn();

			String query ="select * from login where username ='"+username+"'and password='"+password+"'";//making sql &ddl command

			ResultSet rs = c.s.executeQuery(query);//excuted sql

			if(rs.next()){

				setVisible(false);//next class
                                
                                new Home();
			}else{
				JOptionPane.showMessageDialog(null,"Invalid username or Password");
				setVisible(false);
			}

		}catch ( Exception e){
			e.printStackTrace();

		}

    }


	public static void main(String args[]){
	new Login();
	
}
}

