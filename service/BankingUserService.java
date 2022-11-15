package service;

import dao.BankingUserDAO;

public class BankingUserService {

    private static BankingUserService bankingUserService = null;

    public static BankingUserService getInstance(){
        if (bankingUserService==null){
            bankingUserService=new BankingUserService();
        }
        return bankingUserService;
    }

    public boolean signUp(String userId, String userPw){
        BankingUserDAO temp = new BankingUserDAO();
        if(!temp.checkIfUserExists(userId,userPw)){
            temp.insertUser(userId,userPw);
            return true;
        }else{
            System.out.println("이미 존재하는 회원입니다.");
            return false;
        }
    }
}
