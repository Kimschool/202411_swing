package data;


import entity.Board;
import entity.Comment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoardRW {

    public List<Comment> readComment(String path, int boardNo) {
        String filePath =
                path.equals("notice") ? "notice_comment.csv" : "board_comment.csv";
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            List<Comment> commentList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] datas = line.split(",");
                // 해당 게시글 번호와 일치하는 댓글만 가져오기
                if (Integer.parseInt(datas[0]) != boardNo) {
                    continue; // 다음 댓글로 넘어가기
                }
                Comment comment = new Comment();
                comment.setBoardNo(Integer.parseInt(datas[0]));
                comment.setWriter(datas[1]);
                comment.setContent(datas[2]);
                comment.setDate(datas[3]);
                commentList.add(comment);
            }
            return commentList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

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
                board.setContent(datas[2]);
                board.setWriter(datas[3]);
                board.setDate(datas[4]);
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
