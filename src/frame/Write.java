package frame;

import data.BoardRW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Write extends JFrame {

    public Write() {
        setTitle("Write");
        setSize(300, 300);
        setLocationRelativeTo(null);

        JPanel p = new JPanel(new GridLayout(4,1));

        JPanel p0 = new JPanel();
        // 드롭다운 박스로 공지사항과 자유게시판 선택
        String[] board = {"공지사항", "자유게시판"};
        JComboBox<String> cb = new JComboBox<>(board);
        p0.add(cb);

        JPanel p1 = new JPanel();
        JLabel j1 = new JLabel("Title");
        JTextField t1 = new JTextField(10);
        p1.add(j1);
        p1.add(t1);

        JPanel p2 = new JPanel();
        JLabel j2 = new JLabel("Content");
        JTextArea t2 = new JTextArea(10, 20);
        p2.add(j2);
        p2.add(t2);

        JPanel p3 = new JPanel();
        JButton b1 = new JButton("Write");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 타이틀
                String title = t1.getText();
                // 내용
                String content = t2.getText();
                // 공지사항인지 자유게시판인지 확인
                String boardType = (String)cb.getSelectedItem();
                // 공지사항이면 1, 자유게시판이면 2
                String filePath = boardType.equals("공지사항") ? "notice.csv" : "board.csv";

                BoardRW boardRw = new BoardRW();
                boardRw.writerBoard(title,content,filePath);


            }
        });


        JButton b2 = new JButton("Cancel");
        b2.addActionListener(e -> {
            dispose();
            new Notice();
        });
        p3.add(b1);
        p3.add(b2);

        p.add(p0);
        p.add(p1);
        p.add(p2);
        p.add(p3);

        add(p);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Write();
    }
}
