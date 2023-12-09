package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class view extends JFrame implements ActionListener{
    JTable table;
    Choice choice;
    JButton search,back,update,print;
    view(){
        setLayout(null);
        setSize(900,600);
        setVisible(true);
        setLocation(200,50);
        
        JLabel heading=new JLabel("Search By Id");
        heading.setBounds(20,20,80,20);
        add(heading);
        
        choice=new Choice();
        choice.setBounds(120,20,150,20);
        add(choice);
        
        search=new JButton("Search");
        search.setBounds(290,20,90,20);
        add(search);
        search.addActionListener(this);
        
        back =new JButton("BACK");
        back.setBounds(790,20,90,30);
        add(back);
        back.addActionListener(this);
        
        print=new JButton("Print");
        print.setBounds(690,20,80,30);
        add(print);
        print.addActionListener(this);
        
        update=new JButton("Update");
        update.setBounds(590,20,80,30);
        add(update);
        update.addActionListener(this);
        
        
        table=new JTable();
        try{
            Conn c=new Conn();
            ResultSet rs=c.stmt.executeQuery("Select * from employee");
            
            while(rs.next()){
                choice.add(rs.getString("empid"));
            }  
        }
        catch(Exception e){
            e.printStackTrace();
        }
        try{
            Conn c=new Conn();
            ResultSet rs=c.stmt.executeQuery("Select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            while(rs.next()){
                choice.add(rs.getString("EmpID"));
            }  
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,70,900,600);
        add(jsp);
        
}
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query="Select * from employee where EmpID='"+choice.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.stmt.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==print){
            try{
                table.print();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==update){
            setVisible(false);
            new Update(choice.getSelectedItem());
        }
        else{
            setVisible(false);
            new Home();
        }
    }
    public static void main(String args[]){
    new view();
    }
}
