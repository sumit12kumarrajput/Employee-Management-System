package employee.management.system;
import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
public class AddEmployee extends JFrame implements ActionListener {
    Random ran=new Random();
    int number=ran.nextInt(999999);
    
    JTextField tfname,tffname,tfsalary,tfaddress,tfphone,tfemail,tfAid;
    JLabel lblempid;
    JButton add,back;
    JDateChooser dcdob;
    JComboBox course;
    
    AddEmployee(){
            setSize(700,600);
            setLocation(300,30);
            setVisible(true);
            setLayout(null);
            
            JLabel heading=new JLabel("Add Employee Details");
            heading.setBounds(240,20,400,30);
            heading.setFont(new Font("SAN_SERIF",Font.BOLD,20));
            add(heading);
            
            JLabel labelname=new JLabel("Name");
            labelname.setBounds(80,120,150,30);
            labelname.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(labelname);
            
            tfname=new JTextField();
            tfname.setBounds(190,120,150,30);
            add(tfname);
            
            JLabel labelfname=new JLabel("Father's Name");
            labelfname.setBounds(80,170,150,30);
            labelfname.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(labelfname);
            
            tffname=new JTextField();
            tffname.setBounds(190,170,150,30);
            add(tffname);
            
            JLabel labeldob=new JLabel("Date of Birth");
            labeldob.setBounds(80,220,150,30);
            labeldob.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(labeldob);
            
            dcdob=new JDateChooser();
            dcdob.setBounds(190,220,150,30);
            add(dcdob);

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
            
            lblempid=new JLabel(""+number);
            lblempid.setBounds(190,420,150,30);
            lblempid.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(lblempid);
            
            add=new JButton("Add Details");
           add.setBounds(190,470,150,30);
           add.setBackground(Color.BLACK);
           add.setForeground(Color.WHITE);
           add.addActionListener(this);
           add(add);
            
            JLabel labelcourse=new JLabel("Course");
            labelcourse.setBounds(390,170,150,30);
            labelcourse.setFont(new Font("SAN_SERIF",Font.BOLD,15));
            add(labelcourse);
            
            String courses[]={"Select","B.Tech","BCA","M.Tech","MCA","DIPLOMA","BBA","MBA"};
            course=new JComboBox(courses);
            course.setBounds(490,170,150,30);
            add(course);
            
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
            
            tfAid=new JTextField();
            tfAid.setBounds(490,120,150,30);
            add(tfAid);
            
           back=new JButton("Back");
          back.setBounds(390,470,150,30);
          back.setBackground(Color.BLACK);
           back.setForeground(Color.WHITE);
           back.addActionListener(this);
           add(back);
    }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==add){
            String namee=tfname.getText();
            String fname=tffname.getText();
            String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary=tfsalary.getText();
            String address=tfaddress.getText();
            String phone=tfphone.getText();
            String email=tfemail.getText();
            String aid=tfAid.getText();
            String education=(String)course.getSelectedItem();
            String empid=lblempid.getText();
            try{
                Conn conn=new Conn();
                String query="insert into employee values('"+namee+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+aid+"','"+empid+"')";
                conn.stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Successfully");
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
        new AddEmployee();
    }
    
}
