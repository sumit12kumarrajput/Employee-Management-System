package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Splash extends JFrame implements ActionListener {
    Splash(){
       setLayout(null);
       getContentPane().setBackground(Color.BLACK);
       setSize(810,600);
       setLocation(200,50);
       setVisible(true);
       
       JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
       heading.setBounds(150,35,600,40);
       heading.setFont(new Font("serif",Font.PLAIN,30));
       heading.setForeground(Color.WHITE);
       add(heading);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
       Image i2=i1.getImage().getScaledInstance(600,550,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel image=new JLabel(i3);
       image.setBounds(100,100,600,300);
       add(image);
       
       JButton clickhere=new JButton("CLICK HERE TO CONTINUE");
       clickhere.setBounds(250,450,300,70);
       clickhere.addActionListener(this);
       //clickhere.setBackground(Color.BLACK);
       add(clickhere);
       while(true){
           heading.setVisible(false);
           try{
               Thread.sleep(500);
           }
           catch(Exception e){
               
           }
           heading.setVisible(true);
            try{
               Thread.sleep(500);
           }
           catch(Exception e){
               
           }
       }
       
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[]){
        new Splash();
    }
}
