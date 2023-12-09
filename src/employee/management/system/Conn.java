package employee.management.system;
import java.sql.*;

public class Conn {
    Connection c;
    Statement stmt;
    public Conn(){
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           c=DriverManager.getConnection("jdbc:mysql:///emp","root","satendrasa123@");
           stmt=c.createStatement();
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
