package employee.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//static method
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "1992");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
