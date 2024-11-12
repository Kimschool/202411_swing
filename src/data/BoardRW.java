package data;


import entity.Board;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoardRW {




    public List<Board> readBoard(String path) {
        String filePath = path;
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            List<Board> boardList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] datas = line.split(",");
                Board board = new Board();
                board.setNo(Integer.parseInt(datas[0]));
                board.setTitle(datas[1]);
                board.setWriter(datas[2]);
                board.setDate(datas[3]);
                boardList.add(board);
            }
            return boardList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writerBoard(String title, String content, String path) {

        List<Board> boardList = readBoard(path);
        int lastIdx = boardList.size();
        int idx = boardList.get(lastIdx).getNo() + 1;




    }
}
