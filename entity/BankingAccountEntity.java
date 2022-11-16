package entity;

import dto.BankingAccountDTO;
import dto.BankingUserDTO;
public class BankingAccountEntity {

    private String AccountNum;
    private String AccountName;
    private int balance;
    private String userId;

    public BankingAccountEntity(String accountNum, String accountName, int balance, String userId) {
        AccountNum = accountNum;
        AccountName = accountName;
        this.balance = balance;
        this.userId = userId;
    }

    public BankingAccountEntity(String accountNum, int balance) {
        AccountNum = accountNum;
        this.balance = balance;
    }

    public BankingAccountEntity(String accountNum) {
        AccountNum = accountNum;
    }

    public BankingAccountEntity(int balance) {
        this.balance = balance;
    }

    public String getAccountNum() {
        return AccountNum;
    }

    public String getAccountName() {
        return AccountName;
    }

    public int getBalance() {
        return balance;
    }

    public String getUserId() {
        return userId;
    }
}
