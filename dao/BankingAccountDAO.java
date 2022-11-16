package dao;

import DB.JDBCMgr;
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
    private static final String UpdateBalance = "INSERT INTO BankingAccount (AccountNum, Balance) VALUES(?, ?)";

    private static final String ViewAccount = "INSERT INTO BankingAccount (AccountNum, AccountName, Balance) VALueS(?, ?, ?)";
    private static final String CheckAccount = "SELECT * FROM BankingAccount WHERE AccountNum = ?";

    private static final String ViewBalance = "SELECT * FROM BankingAccount WHERE Balance = ?";

    public static BankingAccountDAO getInstance() {
        if (bankingAccountDAO == null){
            bankingAccountDAO = new BankingAccountDAO();
        }
        return null;
    }

    //계좌 생성
    public int insertAccount(String accountNum, String accountName, int balance, String userId){
        int inserted = 0;
        try {
            conn = JDBCMgr.getConnection();
            pstmt = conn.prepareStatement(BankingAccount);
            pstmt.setString(1, accountNum);
            pstmt.setString(2, accountName);
            pstmt.setInt(3, balance);
            pstmt.setString(4, userId);
            inserted = pstmt.executeUpdate();
            System.out.println("계좌번호: " + accountNum + "계좌이름: " + accountName + "잔고: " + balance + "이름: " + userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCMgr.close(pstmt, conn);
        }
        return inserted;
    }

    // userid랑 accountNum 합쳐서 accountNum으로 변경하기
    public int UpdateDAO (BankingAccountEntity bankingAccountEntity){
        int result = 0;
        try {
            conn = JDBCMgr.getConnection();
            pstmt = conn.prepareStatement(BankingAccount);
            pstmt.setString(1,bankingAccountEntity.getAccountNum());
            pstmt.setString(2,bankingAccountEntity.getAccountName());
            pstmt.setInt(3,bankingAccountEntity.getBalance());
            pstmt.setString(4,bankingAccountEntity.getUserId());
            int updated = pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            JDBCMgr.close(pstmt, conn);
        }
        return result;
    }

    // 해당 계좌가 있는지 확인
    public boolean checkAccount(String accountNum){
        boolean exists = false;
        try {
            conn = JDBCMgr.getConnection();
            pstmt = conn.prepareStatement(CheckAccount);
            pstmt.setString(1, accountNum);
            exists = pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(pstmt,conn);
            return exists;
        }
    }

    // 잔액 확인?
//    public boolean checkBalance(BankingAccountEntity bankingAccountEntity){
//        boolean exists = false;
//        try{
//            conn = JDBCMgr.getConnection();
//            pstmt = conn.prepareStatement(ViewBalance);
//
//
//        }
//    }

    // 인출
    public int withdrawDAO(BankingAccountEntity bankingAccountEntity) {
        int result = 0;
        try {
            conn = JDBCMgr.getConnection();
            pstmt = conn.prepareStatement(UpdateBalance);
            pstmt.setString(1,bankingAccountEntity.getAccountNum());
            pstmt.setInt(2,bankingAccountEntity.getBalance());
            rs = pstmt.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            JDBCMgr.close(pstmt, conn);
            return result;
        }
    }

    //입금
    public int depositDAO(BankingAccountEntity bankingAccountEntity) {
        int result = 0;
        try {
            conn = JDBCMgr.getConnection();
            pstmt = conn.prepareStatement(UpdateBalance);
            pstmt.setString(1,bankingAccountEntity.getAccountNum());
            pstmt.setInt(2,bankingAccountEntity.getBalance());
            rs = pstmt.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            JDBCMgr.close(pstmt, conn);
            return result;
        }
    }






}
