package service;


import dao.BankingAccountDAO;
import dao.BankingUserDAO;
import dto.BankingAccountDTO;
import dto.BankingUserDTO;
import entity.BankingAccountEntity;
import org.h2.command.dml.Insert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BankingAccountService {

    Scanner sc = new Scanner(System.in);
    int money;
    String id;

    private BankingAccountDAO bankingAccountDAO = BankingAccountDAO.getInstance();

    private static BankingAccountService bankingAccountService = null;

    public static BankingAccountService getInstance(){
        if (bankingAccountService == null) {
            bankingAccountService = new BankingAccountService();
        }
        return bankingAccountService;
    }

    // 게좌 생성
//    public static void main(String[] args) {
//        BankingAccountService temp = new BankingAccountService();
//        temp.createAccount("테스트a1234","테스트",0,"a1234");
//    }
    public boolean createAccount(String accountNum, String accountName, int balance, String userId){
        BankingAccountDAO temp = new BankingAccountDAO();
        if (!temp.checkAccount(accountNum)){
            int inserted = temp.insertAccount(accountName+userId, accountName, balance, userId);
            System.out.println(inserted);
            return true;
        } else {
            System.out.println("이미 존재하는 계좌번호입니다.");
            return false;
        }
    }
    //인출
//    public BankingAccountEntity withdraw(String accountNum) {
//       BankingAccountDAO show = new BankingAccountDAO();
//        money = sc.nextInt();
//        if (money < show.withdrawDAO(BankingAccountEntity)) {
//            bankingAccountEntity = new BankingAccountEntity(accountNum, balance - money);
//            bankingAccountDAO.withdrawDAO(bankingAccountEntity);
//        } else {
//            // 실패시 돌아간다.?
//            System.out.println("통잔 잔고보다 많은 량을 요구합니다.");
//            return null;
//        }
//        return bankingAccountEntity;
//    }

// 입금
    public BankingAccountEntity deposit(String accountNum, int balance) {

        BankingAccountEntity bankingAccountEntity = null;
        money = sc.nextInt();

        bankingAccountEntity = new BankingAccountEntity(accountNum, balance + money);
        bankingAccountDAO.withdrawDAO(bankingAccountEntity);

        return bankingAccountEntity;
    }



}
