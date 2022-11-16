package dto;

public class BankingAccountDTO {

    private String AccountNum;
    private String AccountName;
    private int balance;
    private String userId;

    public BankingAccountDTO() {
    }

    public BankingAccountDTO(String accountNum, String accountName, int balance) {
        AccountNum = accountNum;
        AccountName = accountName;
        this.balance = balance;
    }

    public BankingAccountDTO(String accountNum, String accountName, String userId) {
        AccountNum = accountNum;
        AccountName = accountName;
        this.userId = userId;
    }



    public String getAccountNum() {
        return AccountNum;
    }

    public void setAccountNum(String accountNum) {
        AccountNum = accountNum;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
