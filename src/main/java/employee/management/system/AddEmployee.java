

package employee.management.system;

import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname,tffname,tfsalary,tfaddress,tfaadhar,tfemail,tfphone,tfdesignation;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempid;
    JButton add,back;
            
    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("Serif",Font.ITALIC,20));
        add(labelname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        
        
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(450,150,150,30);
        labelfname.setFont(new Font("Serif",Font.ITALIC,20));
        add(labelfname);
        
        tffname = new JTextField();
        tffname.setBounds(650,150, 150, 30);
        add(tffname);
        
        
        
        
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("Serif",Font.ITALIC,20));
        add(labeldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
        
        
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(450,200,150,30);
        labelsalary.setFont(new Font("Serif",Font.ITALIC,20));
        add(labelsalary);
        
        tfsalary = new JTextField();
        tfsalary.setBounds(650, 200, 150, 30);
        add(tfsalary);
        
        
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("Serif",Font.ITALIC,20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(450,250,150,30);
        labelphone.setFont(new Font("Serif",Font.ITALIC,20));
        add(labelphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(650, 250, 150, 30);
        add(tfphone);
        
        
        
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("Serif",Font.ITALIC,20));
        add(labelemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
        
        JLabel labeleducation = new JLabel("Higher Education");
        labeleducation.setBounds(450,300,150,30);
        labeleducation.setFont(new Font("Serif",Font.ITALIC,20));
        add(labeleducation);
        
        String courses[] = {"BTech","MTech","MS","MCA","MBA","BCA"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(650, 300, 150, 30);
        add(cbeducation);
        
        
        
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("Serif",Font.ITALIC,20));
        add(labeldesignation);
        
        tfdesignation = new JTextField();
        tfdesignation.setBounds(200, 350, 150, 30);
        add(tfdesignation);
        
        
        
        JLabel labelaadhar = new JLabel("Aadhar");
        labelaadhar.setBounds(450,350,150,30);
        labelaadhar.setFont(new Font("Serif",Font.ITALIC,20));
        add(labelaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(650, 350, 150, 30);
        add(tfaadhar);
        
        
        
        
        JLabel labelempid = new JLabel("Employee id");
        labelempid.setBounds(50,400,150,30);
        labelempid.setFont(new Font("Serif",Font.ITALIC,20));
        add(labelempid);
        
        
        
        lblempid = new JLabel("" + number);
        lblempid.setBounds(200,400,150,30);
        lblempid.setFont(new Font("Serif",Font.ITALIC,20));
        add(lblempid);
        
        
        
        add = new JButton("Add Details");
        add.setBounds(250,550,150,50);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        
        
        back = new JButton("Back");
        back.setBounds(450,550,150,50);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        setVisible(true);
        setSize(900,700);
        setLocation(300,50);
    }
    
    
    
    
    
public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == add){
        String name = tfname.getText().trim();
        String fname = tffname.getText().trim();
        String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText().trim();
        String salary = tfsalary.getText().trim();
        String address = tfaddress.getText().trim();
        String phone = tfphone.getText().trim();
        String email = tfemail.getText().trim();
        String education = (String)cbeducation.getSelectedItem();
        String designation = tfdesignation.getText().trim();
        String aadhar = tfaadhar.getText().trim();
        String empid = lblempid.getText().trim();

        // Basic validation
        if(name.isEmpty() || fname.isEmpty() || dob.isEmpty() || salary.isEmpty() || address.isEmpty() ||
           phone.isEmpty() || email.isEmpty() || designation.isEmpty() || aadhar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all fields.");
            return;
        }

        // Validate phone number (10 digits only)
        if(!phone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(null, "Invalid phone number. Must be 10 digits.");
            return;
        }

        // Validate email
        if(!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
            JOptionPane.showMessageDialog(null, "Invalid email format.");
            return;
        }

        // Validate Aadhar number (12 digits only)
        if(!aadhar.matches("\\d{12}")) {
            JOptionPane.showMessageDialog(null, "Invalid Aadhar number. Must be 12 digits.");
            return;
        }

        // Validate salary (positive number)
        try {
            double sal = Double.parseDouble(salary);
            if (sal <= 0) {
                JOptionPane.showMessageDialog(null, "Salary must be a positive number.");
                return;
            }
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Salary must be a valid number.");
            return;
        }

        // All validations passed, proceed to insert
        try {
            Conn conn = new Conn();
            String query = "insert into employee values('" + name + "', '" + fname + "', '" + dob + "', '" + salary + "', '" +
                           address + "', '" + phone + "', '" + email + "', '" + education + "', '" + designation + "', '" + 
                           aadhar + "', '" + empid + "')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Details added successfully");
            setVisible(false);
            new Home();
        } catch(Exception e){
            e.printStackTrace();
        }
    } else if(ae.getSource() == back){
        setVisible(false);
        new Home();
    }
}
    
    public static void main(String[] args){
        new AddEmployee();
    }
        
}
