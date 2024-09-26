package employee.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tffname, tfaddress, tfphone, tfemail, tfsalary, tfdesignation, tfeducation;
    JLabel lname, udob, uaadhar, lblempId;
    JButton update, back;
    String empID;

    UpdateEmployee(String empID) {
        this.empID = empID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelname = new JLabel("Name :");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        lname = new JLabel();
        lname.setBounds(200, 150, 150, 30);
        add(lname);

        JLabel labelfname = new JLabel("Father's Name :");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        JLabel labeldob = new JLabel("Date of Birth :");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        udob = new JLabel();
        udob.setBounds(200, 200, 150, 30);
        add(udob);

        JLabel labelsalary = new JLabel("Salary :");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);

        JLabel labeladdress = new JLabel("Address :");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel labelphone = new JLabel("Contact Number :");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel labelemail = new JLabel("Email :");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel labeleducation = new JLabel("Education :");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);

        tfeducation = new JTextField();
        tfeducation.setBounds(600, 300, 150, 30);
        add(tfeducation);

        JLabel labeldesignation = new JLabel("Designation :");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);

        JLabel labelaadhar = new JLabel("Aadhar Number :");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);

        uaadhar = new JLabel();
        uaadhar.setBounds(600, 350, 150, 30);
        add(uaadhar);

        JLabel labelempId = new JLabel("Employee ID :");
        labelempId.setBounds(50, 400, 150, 30);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);

        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);

        try {
            Conn c = new Conn();
            String query = "select * from Employee1 where empID = '" + empID + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fathername"));
                udob.setText(rs.getString("DOB"));
                tfsalary.setText(rs.getString("salary"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfdesignation.setText(rs.getString("designation"));
                uaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        update = new JButton("Update Details");
        update.setBounds(250, 550, 150, 40);
        update.addActionListener(this);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        add(update);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String name = lname.getText();
            String fname = tffname.getText();
            String DOB = udob.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            String aadhar = uaadhar.getText();
            String empId = lblempId.getText();

            try {
                Conn conn = new Conn();
                String query = "update Employee1 set name = '" + name + "', fathername = '" + fname + "', DOB = '" + DOB + "', salary = '" + salary + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "', education = '" + education + "', designation = '" + designation + "' where empID = '" + empId + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
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

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
