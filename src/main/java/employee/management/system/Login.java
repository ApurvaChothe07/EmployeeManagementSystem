
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField tfusername;
    JPasswordField tfpassword;
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,30,100,30);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(150,30,150,30);
        add(tfusername);
        
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,70,100,30);
        add(lblpassword);
        
        tfpassword = new JPasswordField();  
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        

        
        JButton login = new JButton("Login");
        login.setBounds(180,130,90,30);
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        JButton forgotPassword = new JButton("Forgot Password?");
        forgotPassword.setBounds(150, 170, 150, 30);
        forgotPassword.setBorderPainted(false);
        forgotPassword.setFocusPainted(false);
        forgotPassword.setContentAreaFilled(false);
        forgotPassword.setFont(new Font("Tahoma", Font.ITALIC, 12));
        forgotPassword.addActionListener(e -> {
        new ForgotPassword();
        });
        add(forgotPassword);
        

        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);  
        add(image);
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }
    

    
    
    
    
    public void actionPerformed(ActionEvent ae){
    String username = tfusername.getText().trim();
    String password = new String(tfpassword.getPassword()).trim();

    if (username.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter both username and password.");
        return;
    }

    try {
        Conn c = new Conn();
        String query = "SELECT * FROM login WHERE username = ? AND password = ?";
        PreparedStatement ps = c.c.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            setVisible(false);
            new Home(); // replace with your dashboard or home screen
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password.");
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database connection error.");
    }
}

    
    
    
    
    public static void main(String[] args){
        new Login();
    }
}
