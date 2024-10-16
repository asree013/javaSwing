package screen.home;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {
    public Home() {
        setTitle("Home EMS");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Home();
    }
}
