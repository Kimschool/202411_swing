package frame;

import data.BoardRW;
import entity.Comment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Comments extends JFrame {

    public Comments(String path, int boardNo) {
        setTitle("Comment");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2,1));

        BoardRW boardRW = new BoardRW();
        List<Comment> commentList = boardRW.readComment(path, boardNo);

        JPanel p = new JPanel(new GridLayout(commentList.size()+1, 1));
        JLabel l = new JLabel("Comments");


        p.add(l);

        for(int i = 0; i < commentList.size(); i++) {
            JPanel p_main = new JPanel(new GridLayout(2, 1));
            Comment comment = commentList.get(i);
            JLabel l_u = new JLabel(i + 1 + " " + comment.getWriter() + " " + comment.getDate());
            p_main.add(l_u);
            JLabel l_b = new JLabel(comment.getContent());
            p_main.add(l_b);
            p.add(p_main);
        }

        // p에 스크롤추가
        JScrollPane commentScrollPane = new JScrollPane(p);

        add(commentScrollPane);

        JButton b = new JButton("Close");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        add(b);


        setVisible(true);
    }
}
