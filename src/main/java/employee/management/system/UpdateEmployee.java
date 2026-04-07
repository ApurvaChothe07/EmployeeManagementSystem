
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateEmployee extends JFrame implements ActionListener{
    
   
    JTextField tfeducation,tfname,tffname,tfsalary,tfaddress,tfemail,tfphone,tfdesignation;
   
    JLabel lblempId,lblaadhar,lbldob,lblname;
    JButton add,back;
    String empId;
            
    UpdateEmployee(String empId){
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("Serif",Font.ITALIC,20));
        add(labelname);
        
        lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);
        
        
        
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
        
        lbldob = new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);
        
 
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
        
      
        tfeducation = new JTextField();
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(650, 300, 150, 30);
        add(tfeducation);
        
        
        
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
        
        lblaadhar = new JLabel();
        lblaadhar.setBounds(650, 350, 150, 30);
        add(lblaadhar);
        
        
        
        
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50,400,150,30);
        labelempId.setFont(new Font("Serif",Font.ITALIC,20));
        add(labelempId);
        
        lblempId = new JLabel();
        lblempId.setBounds(200,400,150,30);
        lblempId.setFont(new Font("Serif",Font.ITALIC,20));
        add(lblempId);
        
        try{
            Conn conn = new Conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfdesignation.setText(rs.getString("designation"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));
                
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
        
        
        
        add = new JButton("Update Details");
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
        if(ae.getSource() ==  add){
            
            String fname = tffname.getText();
           
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();
            
            
            try{
                Conn conn = new Conn();
                String query = "update employee set fname = '"+fname+"', salary = '"+salary+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"', education = '"+education+"', designation = '"+designation+"' where empId = '"+empId+"' ";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
             
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() ==  back){
           setVisible(false);
           new ViewEmployee();
        }
    }
    
    public static void main(String[] args){
        new UpdateEmployee("");
    }
        
}

