package screen.register;

import javax.swing.*;

import packages.RouterButton;
import screen.login.Login;

public class Register extends JFrame {
    public Register() {
        setTitle("Register Ems");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        setUpDisplayRegister(panel);
        setLocationRelativeTo(panel);

        setVisible(true);
    }

    private void setUpDisplayRegister(JPanel panel) {
        
        JLabel title = new JLabel("สมัครสมาชิก ระบบ ems");
        title.setBounds(110, 20, 200, 25);
        panel.add(title); 

        JLabel lUsername = new JLabel("Username");
        lUsername.setBounds(20, 50, 100, 25);
        panel.add(lUsername);

        JTextField username = new JTextField(10);
        username.setBounds(90, 50, 190, 25);
        panel.add(username);

        JLabel lPassword = new JLabel("Password");
        lPassword.setBounds(20, 80, 100, 25);
        panel.add(lPassword);

        JTextField password = new JTextField(10);
        password.setBounds(90, 80, 190, 25);
        panel.add(password);

        JLabel lFirstname = new JLabel("Firstname");
        lFirstname.setBounds(20, 110, 100, 25);
        panel.add(lFirstname);

        JTextField fistname = new JTextField(10);
        fistname.setBounds(90, 110, 190, 25);
        panel.add(fistname);

        JLabel lLastname = new JLabel("Lastname");
        lLastname.setBounds(20, 140, 190, 25);
        panel.add(lLastname);

        JTextField lastname = new JTextField(10);
        lastname.setBounds(90, 140, 190, 25);
        panel.add(lastname);


        RouterButton prevButton = new RouterButton("< Back", Login.class);
        prevButton.setBounds(20, 300, 70, 30);
        panel.add(prevButton);

        JButton registerButton = new JButton("สมัครสมาชิก");
        registerButton.setBounds(100, 300, 280, 30);
        panel.add(registerButton);

    }

    public static void main(String[] args) {
        new Register();
    }
}
