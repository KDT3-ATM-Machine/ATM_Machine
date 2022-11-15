package dao;

import DB.JDBCMgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankingUserDAO {
    private static BankingUserDAO bankingUserDAO = null;
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String SELECT_ALLUSERS =
            "SELECT * FROM BankingUser";

    private static final String SELECT_USER_BYIDANDPW=
            "SELECT * FROM BANKINGUSER WHERE USERID = ? and USERPW = ?";

    private static final String SELECT_USER_BYID=
            "SELECT * FROM BANKINGUSER WHERE USERID = ?";

    private static final String INSERT_USER=
            "INSERT INTO BANKINGUSER (USERID, USERPW) VALUES (?,?)";



    public static BankingUserDAO getInstance() {
        if (bankingUserDAO == null) {
            bankingUserDAO = new BankingUserDAO();
        }
        return bankingUserDAO;
    }

    public boolean insertUser(String userId, String userPw){
        int result=0;
        try{
            conn= JDBCMgr.getConnection();
            stmt=conn.prepareStatement(INSERT_USER);
            stmt.setString(1,userId);
            stmt.setString(2,userPw);
            result= stmt.executeUpdate();
            System.out.println("아이디: " +userId + " 비밀번호: "+ userPw + " 회원가입 성공!");

        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            JDBCMgr.close(stmt,conn);
            return result!=0;
        }
    }

    public boolean checkUserIdDuplicate(String userId){
        boolean exists = false;
        try{
            conn=JDBCMgr.getConnection();
            stmt=conn.prepareStatement(SELECT_USER_BYID);
            stmt.setString(1,userId);
            rs=stmt.executeQuery();

            while(rs.next()){
                exists=true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            JDBCMgr.close(stmt,conn);
            return exists;
        }
    }

    public boolean checkIfUserExists(String userId, String userPw){
        boolean correctIdAndPassword=false;
        try{
            conn= JDBCMgr.getConnection();
            stmt=conn.prepareStatement(SELECT_USER_BYIDANDPW);
            stmt.setString(1,userId);
            stmt.setString(2,userPw);
            rs=stmt.executeQuery();

            while (rs.next()){
                correctIdAndPassword=true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            JDBCMgr.close(stmt, conn);
            return correctIdAndPassword;
        }
    }
    public void selectAll() {
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SELECT_ALLUSERS);
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("USERID"));
                System.out.println(rs.getString("USERPW"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
        }
    }

//        }
//        public void insertUser(UserEntity theEntity){
//            try{
//                conn=connectionPoolMgr.getConnection();
//                stmt = conn.prepareStatement(INSERT_USER);
//                stmt.setString(1,theEntity.getUserId());
//                stmt.setString(2,theEntity.getUserPassword());
//                stmt.setString(3,theEntity.getUserName());
//                stmt.setString(4,theEntity.getUserPhone());
//                stmt.setInt(5,theEntity.getUserPoint());
//                stmt.executeUpdate();
//                System.out.println("User Data Insert SUCCESS.");
//            }catch (SQLException e){
//                e.printStackTrace();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        public UserEntity searchUser(String userId, String userPassword){
//            try{
//                conn=connectionPoolMgr.getConnection();
//                stmt = conn.prepareStatement(SELECT_USER_WITHIDANDPASSWORD);
//                stmt.setString(1, userId);
//                stmt.setString(2, userPassword);
//                rs=stmt.executeQuery();
//                while (rs.next()){
//                    String id = rs.getString("user_id");
//                    String pw = rs.getString("user_pw");
//                    String name = rs.getString("user_name");
//                    String phone = rs.getString("user_phone");
//                    int point = rs.getInt("user_point");
//                    UserEntity temp = new UserEntity(id,pw,name,phone,point);
//                    return temp;
//                }
//
//            }catch (SQLException e){
//                e.printStackTrace();
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally{
//                connectionPoolMgr.freeConnection(conn,stmt,rs);
//            }
//            return null;
//        }
}
