package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
public class Update extends JFrame implements ActionListener {
    
    JTextField tfname,education,tffname,tfsalary,tfaddress,tfphone,tfemail,tfAid;
    JLabel lblempid,lblaadhar,lblfather;
    JButton add,back;
    String EmpID;
    JComboBox course;
    JDateChooser dcdob;
    
    
    Update(String EmpID){
        this.EmpID=EmpID;
            setSize(700,600);
            setLocation(300,30);
            setVisible(true);
            setLayout(null);
            
            JLabel heading=new JLabel("Update Employee Details");
            heading.setBounds(240,20,400,30);
            heading.setFont(new Font("SAN_SERIF",Font.BOLD,20));
            add(heading);
            
            JLabel labelname=new JLabel("Name");
            labelname.setBounds(80,120,150,30);
            labelname.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(labelname);
            
            JLabel lblname=new JLabel();
            lblname.setBounds(190,120,150,30);
            add(lblname);
            
            JLabel labelfname=new JLabel("Father's Name");
            labelfname.setBounds(80,170,150,30);
            labelfname.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(labelfname);
            
            JLabel lblfather=new JLabel();
            lblfather.setBounds(190,170,150,30);
            add(lblfather);
            
            JLabel labeldob=new JLabel("Date of Birth");
            labeldob.setBounds(80,220,150,30);
            labeldob.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(labeldob);
            
            JLabel lbldob=new JLabel();
            lbldob.setBounds(190,220,150,30);
            add(lbldob);

            JLabel labelsalary=new JLabel("Salary");
            labelsalary.setBounds(80,270,150,30);
            labelsalary.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(labelsalary);
            
            tfsalary=new JTextField();
            tfsalary.setBounds(190,270,150,30);
            add(tfsalary);
            
            JLabel labeladdress=new JLabel("Address");
            labeladdress.setBounds(80,320,150,30);
            labelsalary.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(labeladdress);
            
            tfaddress=new JTextField();
            tfaddress.setBounds(190,320,150,30);
            add(tfaddress);
            
            JLabel labelphone=new JLabel("Phone");
            labelphone.setBounds(80,370,150,30);
            labelphone.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(labelphone);
            
            tfphone=new JTextField();
            tfphone.setBounds(190,370,150,30);
            add(tfphone);
            
            
            JLabel labelempid=new JLabel("Employee Id : ");
            labelempid.setBounds(80,420,150,30);
            labelempid.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(labelempid);
            
            lblempid=new JLabel();
            lblempid.setBounds(190,420,150,30);
            lblempid.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(lblempid);
            
            
           add=new JButton("Update Details");
           add.setBounds(190,470,150,30);
           add.setBackground(Color.BLACK);
           add.setForeground(Color.WHITE);
           add.addActionListener(this);
           add(add);
            
            JLabel labelcourse=new JLabel("Course");
            labelcourse.setBounds(390,170,150,30);
            labelcourse.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(labelcourse);
            
            education=new JTextField();
            education.setBounds(490,170,150,30);
            add(education);
            
            JLabel labelemail=new JLabel("Email");
            labelemail.setBounds(390,220,150,30);
            labelemail.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(labelemail);
            
            tfemail=new JTextField();
            tfemail.setBounds(490,220,150,30);
            add(tfemail);
            
            JLabel labelAid=new JLabel("Aadhar No");
            labelAid.setBounds(390,120,150,30);
            labelAid.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(labelAid);
            
            
            JLabel lblaadhar=new JLabel();
            lblaadhar.setBounds(490,120,150,30);
            add(lblaadhar);
            
           back=new JButton("Back");
           back.setBounds(390,470,150,30);
           back.setBackground(Color.BLACK);
           back.setForeground(Color.WHITE);
           back.addActionListener(this);
           add(back);
           
           try{
                Conn c=new Conn();
                String query="select * from employee where EmpID='"+EmpID+"'";
                ResultSet rs=c.stmt.executeQuery(query);
                while(rs.next()){
                    lblname.setText(rs.getString("Name"));
                    lblfather.setText(rs.getString("FatherName"));
                    lbldob.setText(rs.getString("DOB"));
                    tfphone.setText(rs.getString("Phone"));
                    tfaddress.setText(rs.getString("Address"));
                    tfsalary.setText(rs.getString("Salary"));
                    tfemail.setText(rs.getString("Email"));
                    education.setText(rs.getString("Education"));
                    lblaadhar.setText(rs.getString("AadharNo"));
                    lblempid.setText(rs.getString("EmpID"));
                    
                    
                   
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
    }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==add){
           
           
            String salary=tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            
            String educationn=education.getText();
             
            try{
                Conn conn=new Conn();
                String query="update employee set Salary='"+salary+"',Address='"+address+"',Phone='"+phone+"',Email='"+email+"',Education='"+educationn+"' where EmpID='"+EmpID+"'";
                conn.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                setVisible(false);
                new Home();
                
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
    public static void main(String Args[]){
        new Update("");
    }
    
}
