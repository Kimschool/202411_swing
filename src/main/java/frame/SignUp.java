package frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame {

    public SignUp() {
        setTitle("Sign Up");
        setSize(300, 300);
        setLocationRelativeTo(null);

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
        JLabel j3 = new JLabel("Password(re)");
        JPasswordField t3 = new JPasswordField(10);
        p3.add(j3);
        p3.add(t3);

        JPanel p4 = new JPanel();
        JLabel j4 = new JLabel("Name");
        JTextField t4 = new JTextField(10);
        p4.add(j4);
        p4.add(t4);

        JPanel p5 = new JPanel();
        JButton b1 = new JButton("Sign up");
        JButton b2 = new JButton("Cancel");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
        });
        p5.add(b1);
        p5.add(b2);

        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        p.add(p5);

        add(p);

        setVisible(true);
    }
}
