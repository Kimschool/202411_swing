package frame;

import data.BoardRW;
import entity.Board;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Notice extends JFrame {

    public Notice() {
        setTitle("Notice");
        setSize(500, 300);
        setLocationRelativeTo(null);

        JPanel p1 = new JPanel();
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 모든 셀을 수정 불가로 설정
            }
        };
        JTable table = new JTable(model);
        // 단일 행만 선택 가능하게 설정
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        // 테이블에 HEADER 추가
        model.addColumn("No");
        model.addColumn("Title");
        model.addColumn("Writer");
        model.addColumn("Date");

        // 테이블에 ROW 추가
        // 테이블에 있는 데이터는 수정 불가
        BoardRW boardRW = new BoardRW();
        List<Board> boardList = boardRW.readBoard("notice.csv");

        for(Board board : boardList) {
            model.addRow(new Object[]{board.getNo(), board.getTitle(), board.getWriter(), board.getDate()});
        }


        JScrollPane sp = new JScrollPane(table);
        p1.add(sp);

        JPanel p2 = new JPanel();
        JButton b1 = new JButton("글쓰기");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Write();
            }
        });

        JButton b2 = new JButton("상세보기");
        JButton b3 = new JButton("뒤로");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Main();
            }
        });

        add(p1);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Notice();
    }
}
