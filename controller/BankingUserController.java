package controller;

import dao.BankingUserDAO;
import service.BankingUserService;

public class BankingUserController {

    private static BankingUserController bankingUserController=null;

    public static BankingUserController getInstance(){
        if (bankingUserController==null){
            bankingUserController=new BankingUserController();
        }
        return bankingUserController;
    }

    public boolean checkLogIn(String userId, String userPw){
        BankingUserDAO temp = BankingUserDAO.getInstance();
        return temp.checkIfUserExists(userId,userPw);
    }

    public boolean checkSignUp(String userId, String userPw){
        BankingUserService temp = BankingUserService.getInstance();
        return temp.signUpSuccess(userId,userPw);
    }
}
