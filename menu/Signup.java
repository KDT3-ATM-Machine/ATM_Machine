package menu;

import controller.BankingUserController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Signup {

    public static String signup() throws IOException {
        String correctSignUpId = null;
        String correctSignUpPw = null;
        BankingUserController theSignUpController = BankingUserController.getInstance();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (correctSignUpId == null) {
            System.out.println("회원가입 아이디 입력:");
            String userId = br.readLine();
            System.out.println(userId);
            System.out.println("회원가입 비밀번호 입력:");
            String userPw = br.readLine();
            System.out.println(userPw);
            if (theSignUpController.checkSignUp(userId, userPw)) {
                System.out.println(userId + " 님, 회원가입 성공.");
                correctSignUpId = userId;
            }
        }
        return correctSignUpId;
    }

    public static String login() throws IOException {
        String correctUserId=null;
        String correctUserPw;
        BankingUserController theLogInController = BankingUserController.getInstance();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (correctUserId==null){
            System.out.println("로그인 아이디 입력:");
            String userId = br.readLine();
            System.out.println(userId);
            System.out.println("로그인 비밀번호 입력:");
            String userPw = br.readLine();
            System.out.println(userPw);
            if (theLogInController.checkLogIn(userId,userPw)){
                System.out.println(userId + " 님, 반갑습니다.");
                correctUserId=userId;
            }else{
                System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");

            }
        }
        return correctUserId;
    }
}
