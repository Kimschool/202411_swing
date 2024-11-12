package frame;

import entity.Board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class NoticeDetail extends JFrame {

    public NoticeDetail(Board board) {
        setTitle("Notice Detail");
        setSize(500, 700);
        setLocationRelativeTo(null);

        JPanel p = new JPanel(new GridLayout(7, 1));

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

        JScrollPane contentScrollPane = new JScrollPane(ta);
        p5.add(contentScrollPane);

        // 댓글
//        BoardRW boardRW = new BoardRW();
//        List<Comment> commentList = boardRW.readComment("notice", board.getNo());
//        int commentCount = commentList.size();
//        JPanel p6 = new JPanel(new GridLayout(commentCount, 1));
////        JLabel l6 = new JLabel("Comment");
//
//        // CommentList갯수만큼 JPanel생성
//        for(int i = 0; i < commentList.size(); i++) {
//            JPanel p_main = new JPanel(new GridLayout(2,1));
//
//            JPanel p_upper = new JPanel();
//            JLabel l_upper = new JLabel(i + 1 + " " + commentList.get(i).getWriter() + " " + commentList.get(i).getDate());
//            p_upper.add(l_upper);
//
//            JPanel p_bottom = new JPanel();
//            JLabel l_bottom = new JLabel(commentList.get(i).getContent());
//            p_bottom.add(l_bottom);
//
//            p_main.add(p_upper);
//            p_main.add(p_bottom);
//
//            p6.add(p_main);
//        }


        JPanel p6 = new JPanel();
        JButton b1 = new JButton("Back");
        b1.addActionListener(e -> {
            dispose();
            new Notice();
        });
        JButton b2 = new JButton("Comment");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // NoticeDatail Frame을 닫지 않고 선택이 안되게하고, 새로운 Comment Frame을 띄워준다.
                new Comments("notice", board.getNo());
            }
        });

        p6.add(b1);
        p6.add(b2);

        p.add(p1); p.add(p2); p.add(p3); p.add(p4); p.add(p5); p.add(p6);

        add(p);

        setVisible(true);
    }

}
