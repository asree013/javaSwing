package packages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class RouterButton extends JButton {
    // Constructor รับค่าชื่อปุ่มและหน้าที่จะไป
    public RouterButton(String routerTitle, Class<? extends JFrame> nextPageClass) {
        super(routerTitle);
        setBounds(50, 80, 200, 25);

        // เพิ่ม ActionListener ให้ปุ่ม
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // สร้าง instance ของหน้าถัดไป
                    JFrame nextPage = nextPageClass.getDeclaredConstructor().newInstance();
                    nextPage.setVisible(true);
                    // ปิดหน้าต่างปัจจุบัน
                    ((JFrame) SwingUtilities.getWindowAncestor(RouterButton.this)).dispose();
                } catch (Exception ex) {
                    ex.printStackTrace(); // จัดการข้อผิดพลาด
                }
            }
        });
    }
}
