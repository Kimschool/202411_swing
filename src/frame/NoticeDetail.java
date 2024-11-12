package frame;

import entity.Board;

import javax.swing.*;
import java.awt.*;

public class NoticeDetail extends JFrame {

    public NoticeDetail(Board board) {
        setTitle("Notice Detail");
        setSize(500, 300);
        setLocationRelativeTo(null);

        JPanel p = new JPanel(new GridLayout(6, 1));

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("No");
        JTextField t1 = new JTextField(10);
        t1.setText(String.valueOf(board.getNo()));
        t1.setEditable(false);

        p1.add(l1); p1.add(t1);


        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("Title");
        JTextField t2 = new JTextField(10);
        t2.setText(board.getTitle());
        t2.setEditable(false);

        p2.add(l2); p2.add(t2);

        JPanel p3 = new JPanel();
        JLabel l3 = new JLabel("Writer");
        JTextField t3 = new JTextField(10);
        t3.setText(board.getWriter());
        t3.setEditable(false);

        p3.add(l3); p3.add(t3);

        JPanel p4 = new JPanel();
        JLabel l4 = new JLabel("Date");
        JTextField t4 = new JTextField(10);
        t4.setText(board.getDate());
        t4.setEditable(false);

        p4.add(l4); p4.add(t4);

        JPanel p5 = new JPanel();
        JTextArea ta = new JTextArea(10, 30);
        ta.setText(board.getContent());
        ta.setEditable(false);

        p5.add(ta);

        JPanel p6 = new JPanel();
        JButton b1 = new JButton("Back");
        b1.addActionListener(e -> {
            dispose();
            new Notice();
        });

        p6.add(b1);

        p.add(p1); p.add(p2); p.add(p3); p.add(p4); p.add(p5); p.add(p6);

        add(p);

        setVisible(true);
    }

}
