package service;


import dao.BankingAccountDAO;
import dao.BankingUserDAO;
import dto.BankingAccountDTO;

public class BankingAccountService {

    private BankingAccountDAO bankingAccountDAO = BankingAccountDAO.getInstance();

    private static BankingAccountService bankingAccountService = null;

    public static BankingAccountService getInstance(){
        if (bankingAccountService == null) {
            bankingAccountService = new BankingAccountService();
        }
        return bankingAccountService;
    }

    @Override
    public BankingAccountDTO withdraw(String accountNum, String accountName, int balance){
        BankingAccountDTO bankingAccountDTO = new BankingAccountDTO(accountNum, accountName, balance);

        if (bankingAccountDTO == null) return null;

    }

}
