import java.io.IOException;

import static menu.Login.login;
import static menu.Signup.signup;

public class Main {
    public static void main(String[] args) throws IOException {
        String userId;

        //로그인 - 아이디, 비밀번호가 맞을때까지 로그인 메뉴가 뜨고, 아이디, 비밀번호가 맞으면 아이디를 userId 변수에 저장.
        userId=login();

        //회원가입 - 중복된 아이디가 없을때까지 회원가입 메뉴가 뜨고, 중복된 아이디가 없으면 db에 유저 아이디, 비밀번호를 넣고, userId변수에 아이디 저장.
        userId=signup();
    }

}
