
package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener{
 
    JButton add,view,update,remove;
    
    Home(){
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);  
        add(image);
        
        JLabel heading = new JLabel ("Empolyee Management System");
        heading.setBounds(650,20,400,40);
        heading.setFont(new Font("serif",Font.BOLD,25));
        image.add(heading);
        
        
        add = new JButton("Add Employee");
        add.setBounds(650,80,150,40);
        add.setBackground(Color.ORANGE);
        add.setForeground(Color.BLACK);
        add.addActionListener(this);
        image.add(add);
        
        
        view = new JButton("View Employees");
        view.setBounds(820,80,150,40);
        view.setBackground(Color.YELLOW);
        view.setForeground(Color.BLACK);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Employee");
        update.setBounds(650,140,150,40);
        update.setBackground(Color.YELLOW);
        update.setForeground(Color.BLACK);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("Remove Employee");
        remove.setBounds(820,140,150,40);
        remove.setBackground(Color.ORANGE);
        remove.setForeground(Color.BLACK);
        remove.addActionListener(this);
        image.add(remove);
        
     setSize(1120,630);
     setLocation(250,100);
     setVisible(true);
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            setVisible(false);
            new AddEmployee();
        }else if(ae.getSource()== view){
            setVisible(false);
            new ViewEmployee();
        }else if(ae.getSource()== update){
            setVisible(false);
             new ViewEmployee();
        }else if(ae.getSource()== remove){
            setVisible(false);
            new RemoveEmployee();
        }
        else{
            setVisible(false);
            
        }
    }
    
    public static void main(String[] args){
        new Home();
    }
}
