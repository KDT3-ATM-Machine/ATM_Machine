package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopMenu {
    public static int topMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("로그인 메뉴");
        System.out.println("-------------------");
        System.out.println("1 . 로그인");
        System.out.println("2 . 회원가입");
        System.out.println("3 . 종료");
        System.out.println("-------------------");
        return Integer.parseInt(br.readLine());
    }
}
