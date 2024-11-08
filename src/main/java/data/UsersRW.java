package data;

import java.io.*;
import java.util.Scanner;

public class UsersRW {


    public static void main(String[] args) {

//        String filePath = "output.txt";
//
//        try {
//            FileWriter fw = new FileWriter(filePath, true);
//            fw.write("Hello, World!\n");
//            fw.close();
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        Scanner sc = new Scanner(System.in);
        System.out.println("ID를 입력하세요.");
        String id = sc.next();
        System.out.println("Password를 입력하세요.");
        String password = sc.next();

        String filePath = "output.txt";
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            boolean isLogin = false;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] datas = line.split(",");
                if(datas[0].equals(id) && datas[1].equals(password)) {
                    isLogin = true;
                    break;
                }
            }

            if(isLogin) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
