package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JTextField tuser,tpass;
    Login(){
        setLayout(null);
        setLocation(450,200);
        setSize(600,300);
        setVisible(true);
        
        JLabel user=new JLabel("UserName :");
        user.setBounds(40,20,100,30);
        add(user);
        
        tuser=new JTextField();
        tuser.setBounds(150,20,150,30);
        add(tuser);
        
        JLabel pass=new JLabel("Passwod :");
        pass.setBounds(40,70,100,30);
        add(pass);
        
        tpass=new JTextField();
        tpass.setBounds(150,70,150,30);
        add(tpass);
        
        JButton login=new JButton("LOGIN");
        login.setBounds(150,150,150,30);
        add(login);
        login.addActionListener(this);
        
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
       Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(350,0,200,240);
       add(image);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String username=tuser.getText();
            String password=tpass.getText();
            Conn c=new Conn();
            String query="select * from login where username='"+username+"' and password='"+password+"'";
            ResultSet rs=c.stmt.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid UserName or Password");
                setVisible(true);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new Login();
    }
}

