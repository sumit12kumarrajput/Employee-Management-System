package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener {
    JButton view,remove,update,add;
    Home(){
        setLayout(null);
        setSize(900,650);
        setLocation(150,10);
        setVisible(true);
        
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,650,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(0,0,900,650);
       add(image);
       
       JLabel heading=new JLabel("Employee Management System");
       heading.setBounds(450,20,400,40);
       heading.setFont(new Font("serif",Font.BOLD,25));
       image.add(heading);
       
       add=new JButton("Add Employee");
       add.setBounds(460,90,150,40);
       add.addActionListener(this);
       image.add(add);
       
       view=new JButton("View Employee");
       view.setBounds(640,90,150,40);
       view.addActionListener(this);
       image.add(view);
       
       remove=new JButton("Remove Employee");
       remove.setBounds(460,140,150,40);
       remove.addActionListener(this);
       image.add(remove);
       
       update=new JButton("Update Emplyee");
       update.setBounds(640,140,150,40);
       update.addActionListener(this);
       image.add(update);
       
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            setVisible(false);
            new AddEmployee();
        }
        else if(ae.getSource()==view){
            setVisible(false);
            new view();            
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new view();
        }
        else{
            setVisible(false);
            new Remove();
        }
    }
    public static void main(String args[]){
        new Home();
    }
}
