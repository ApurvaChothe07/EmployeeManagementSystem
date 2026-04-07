package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgotPassword extends JFrame implements ActionListener {

    JTextField tfUsername;
    JPasswordField tfNewPass, tfConfirmPass;
    JButton resetButton;

    ForgotPassword() {
        setTitle("Reset Password");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblUser = new JLabel("Username");
        lblUser.setBounds(40, 30, 100, 30);
        add(lblUser);

        tfUsername = new JTextField();
        tfUsername.setBounds(150, 30, 150, 30);
        add(tfUsername);

        JLabel lblNewPass = new JLabel("New Password");
        lblNewPass.setBounds(40, 70, 100, 30);
        add(lblNewPass);

        tfNewPass = new JPasswordField();
        tfNewPass.setBounds(150, 70, 150, 30);
        add(tfNewPass);

        JLabel lblConfirmPass = new JLabel("Confirm Password");
        lblConfirmPass.setBounds(40, 110, 150, 30);
        add(lblConfirmPass);

        tfConfirmPass = new JPasswordField();
        tfConfirmPass.setBounds(150, 110, 150, 30);
        add(tfConfirmPass);

        resetButton = new JButton("Reset Password");
        resetButton.setBounds(100, 160, 150, 30);
        resetButton.setBackground(Color.BLUE);
        resetButton.setForeground(Color.WHITE);
        resetButton.addActionListener(this);
        add(resetButton);

        setSize(400, 280);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    
    
    
    
    
    public void actionPerformed(ActionEvent e) {
    String username = tfUsername.getText().trim();
    String newPass = new String(tfNewPass.getPassword()).trim();
    String confirmPass = new String(tfConfirmPass.getPassword()).trim();

    if (username.isEmpty() || newPass.isEmpty() || confirmPass.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill all fields.");
        return;
    }

    if (!newPass.equals(confirmPass)) {
        JOptionPane.showMessageDialog(null, "Passwords do not match.");
        return;
    }

    try {
        Conn c = new Conn(); // your DB connection class

        String query = "UPDATE login SET password = ? WHERE username = ?";
        PreparedStatement ps = c.c.prepareStatement(query);
        ps.setString(1, newPass);
        ps.setString(2, username);

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Password updated successfully!");
            setVisible(false); // close the window
        } else {
            JOptionPane.showMessageDialog(null, "Username not found. Password not updated.");
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating password.");
    }
}
}


