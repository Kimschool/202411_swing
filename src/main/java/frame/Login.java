package frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    public Login() {
        setTitle("Login"); // 프레밈의 타이틀
        setSize(300, 200); // 프레임의 크기
        setLocationRelativeTo(null); // 화면 중앙에 프레임이 뜨도록

        JPanel p = new JPanel();

        JPanel p1 = new JPanel();
        JLabel j1 = new JLabel("ID");
        JTextField t1 = new JTextField(10);

        p1.add(j1);
        p1.add(t1);

        JPanel p2 = new JPanel();
        JLabel j2 = new JLabel("Password");
        JPasswordField t2 = new JPasswordField(10);

        p2.add(j2);
        p2.add(t2);

        JPanel p3 = new JPanel();
        JButton b1 = new JButton("Sign In");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = t1.getText();
                String password = new String(t2.getPassword());

                if(id.equals("admin") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(null, "로그인 성공");
                } else {
                    JOptionPane.showMessageDialog(null, "로그인 실패");
                }
            }
        });

        JButton b2 = new JButton("Sign Up");

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SignUp();
            }
        });

        p3.add(b1);
        p3.add(b2);

        p.add(p1);
        p.add(p2);
        p.add(p3);

        add(p);


        setVisible(true); // 프레임을 보이도록 설정 (맨 마지막에 호출)

    }

    public static void main(String[] args) {
        new Login(); // GUI 생성
    }
}
