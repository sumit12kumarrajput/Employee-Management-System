package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Remove extends JFrame implements ActionListener{
    Choice cempid;
    JButton delete,back;
    Remove(){
        setLayout(null);
        setSize(500,500);
        setLocation(200,30);
        setVisible(true);
        
        JLabel labelempid=new JLabel("Employee id");
        labelempid.setBounds(50,50,100,30);
        add(labelempid);
        
        cempid=new Choice();
        cempid.setBounds(200,50,150,30);
        add(cempid);
        
        try{
            Conn c=new Conn();
            String query="select * from employee";
            ResultSet rs=c.stmt.executeQuery(query);
            while(rs.next()){
                cempid.add(rs.getString("EmpID"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        add(labelname);
        
         JLabel lblname=new JLabel();
        lblname.setBounds(200,100,150,30);
        add(lblname);
        
        JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        add(labelphone);
        
        JLabel lblphone=new JLabel();
        lblphone.setBounds(200,150,100,30);
        add(lblphone);
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        add(labelemail);
        
        JLabel lblemail=new JLabel();
        lblemail.setBounds(200,200,200,30);
        add(lblemail);
        
        try{
            Conn c=new Conn();
            String query="select * from employee where EmpID='"+cempid.getSelectedItem()+"'";
            ResultSet rs=c.stmt.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("Name"));
                lblphone.setText(rs.getString("Phone"));
                lblemail.setText(rs.getString("Email"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        cempid.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
            try{
            Conn c=new Conn();
            String query="select * from employee where EmpID='"+cempid.getSelectedItem()+"'";
            ResultSet rs=c.stmt.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("Name"));
                lblphone.setText(rs.getString("Phone"));
                lblemail.setText(rs.getString("Email"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
    });
        delete=new JButton("Delete");
        delete.setBounds(220,300,100,30);
        delete.addActionListener(this);
        add(delete);
        
        back=new JButton("Back");
        back.setBounds(80,300,100,30);
        back.addActionListener(this);
        add(back);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                Conn c=new Conn();
                String query="delete from employee where EmpID='"+cempid.getSelectedItem()+"'";
                c.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Successfully Deleted");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String args[]){
        new Remove();
        
    }
    
}
