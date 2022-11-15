package controller;

import dao.BankingUserDAO;
import service.BankingUserService;

public class BankingUserController {

    private BankingUserController bankingUserController=null;

    public BankingUserController getInstance(){
        if (bankingUserController==null){
            bankingUserController=new BankingUserController();
        }
        return bankingUserController;
    }

    public boolean checkLogIn(String userId, String userPw){
        BankingUserDAO temp = BankingUserDAO.getInstance();
        return temp.checkIfUserExists(userId,userPw);
    }

    public boolean checkSignIn(String userId, String userPw){
        BankingUserService temp = BankingUserService.getInstance();
        return temp.signUp(userId,userPw);
    }
}
