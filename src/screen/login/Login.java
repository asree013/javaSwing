package screen.login;

import javax.swing.*;

import models.user.UserModel;
import packages.RouterButton; // เพิ่มการนำเข้า RouterButton
import screen.register.Register;

public class Login extends JFrame {
    public Login() {
        // ตั้งค่าหน้าต่าง
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // จัดหน้าต่างให้อยู่ตรงกลางหน้าจอ

        // สร้าง panel สำหรับวางองค์ประกอบต่าง ๆ
        JPanel panel = new JPanel();
        panel.setLayout(null); // ตั้งค่า layout แบบกำหนดตำแหน่งเอง
        add(panel);

        // เรียกใช้เมธอดสำหรับออกแบบหน้า Login
        setupLoginForm(panel);

        // แสดงหน้าต่าง
        setVisible(true);
    }

    private void setupLoginForm(JPanel panel) {
        // Label สำหรับชื่อผู้ใช้
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 80, 25);
        panel.add(userLabel);

        // Text field สำหรับกรอกชื่อผู้ใช้
        JTextField userText = new JTextField(20);
        userText.setBounds(150, 50, 165, 25);
        panel.add(userText);

        // Label สำหรับรหัสผ่าน
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 80, 25);
        panel.add(passwordLabel);

        // Text field สำหรับกรอกรหัสผ่าน
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 100, 165, 25);
        panel.add(passwordText);

        // ปุ่ม Login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 150, 100, 25);
        loginButton.addActionListener(e -> {
            // ตรวจสอบข้อมูลที่กรอก
            String username = userText.getText();
            String password = new String(passwordText.getPassword());
            UserModel users = new UserModel();
            users.setUsername(username);
            users.setPassword(password);

            if (username.equals("admin") && password.equals("password")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                // เปิดหน้าถัดไปโดยใช้ RouterButton
                new Register(); // เปิดหน้าลงทะเบียน
                dispose(); // ปิดหน้าต่าง Login
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        });
        panel.add(loginButton);

        // ใช้ RouterButton สำหรับไปยังหน้าลงทะเบียน
        RouterButton registerButton = new RouterButton("Register", Register.class);
        registerButton.setBounds(150, 150, 100, 25); // ตั้งค่าตำแหน่ง
        panel.add(registerButton);
    }

    public static void main(String[] args) {
        new Login(); // เรียกใช้งานหน้า Login
    }
}
