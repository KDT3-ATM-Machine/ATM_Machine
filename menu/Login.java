package menu;

import controller.BankingUserController;

import java.io.*;

public class Login {

    public static String login() throws IOException {
        String correctUserId=null;
        String correctUserPw;
        BankingUserController theController = BankingUserController.getInstance();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (correctUserId==null){
            System.out.println("아이디 입력:");
            String userId = br.readLine();
            System.out.println(userId);
            System.out.println("비밀번호 입력:");
            String userPw = br.readLine();
            System.out.println(userPw);
            if (theController.checkLogIn(userId,userPw)){
                System.out.println(userId + " 님, 반갑습니다.");
                correctUserId=userId;
            }else{
                System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");

            }
        }
        return correctUserId;
    }
}
