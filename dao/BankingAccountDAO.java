package dao;

import dto.BankingAccountDTO;
import entity.BankingAccountEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BankingAccountDAO {

    private static BankingAccountDAO bankingAccountDAO = null;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    // 계좌 정보 확인
    private static final String BankingAccount  =  "INSERT INTO BankingAccount (AccountNum, AccountName, Balance, UserId) VALUES(?, ?, ?, ?)";

    private static final String UpdateAccount = "INSERT INTO BankingAccount (AccountNum, Balance) VALUES(?, ?)";

    private static final String ViewAccount = "INSERT INTO BankingAccount (AccountNum, AccountName, Balance) VALueS(?, ?, ?)";

    public static BankingAccountDAO getInstance() {
        if (bankingAccountDAO == null){
            bankingAccountDAO = new BankingAccountDAO();
        }
        return null;
    }
}
