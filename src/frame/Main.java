package frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public Main() {
        setTitle("Main");
        setSize(300, 300);
        setLocationRelativeTo(null);

        JPanel p = new JPanel();
        JButton b1 = new JButton("Logout");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login.LOGIN_ID = null;
                Login.LOGIN_NAME = null;
                new Login();
            }
        });
        JButton b2 = new JButton("공지게시판");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Notice();
            }
        });
        JButton b3 = new JButton("자유게시판");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
//                new Board();
            }
        });

        p.add(b1);
        p.add(b2);
        p.add(b3);

        add(p);

        setVisible(true);
    }

}
