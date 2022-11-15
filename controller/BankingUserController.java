package controller;

import dao.BankingUserDAO;

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
        return temp.selectUser(userId,userPw);
    }
}
