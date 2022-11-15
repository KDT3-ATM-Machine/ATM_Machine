package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDAO {

    private static TestDAO testDAO = null;
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;

    private static final String SELECT_ALLUSERS =
            "SELECT * FROMB BankingUser";

    private static final String INSERT_USER =
            "INSERT INTO user_table (user_id, user_pw, VALUES (?,?)";

    public static void main(String[] args) {
        TestDAO temp =TestDAO.getInstance();
        temp.selectAll();
    }
    public static TestDAO getInstance() {
        if (testDAO == null) {
            testDAO = new TestDAO();
        }
        return testDAO;
    }
//asd
    public void selectAll() {
        try {
            conn = JDBCMgr.getConnection();
            stmt = conn.prepareStatement(SELECT_ALLUSERS);
            rs = stmt.executeQuery();
            System.out.println(rs.getString("UserId"));
            System.out.println(rs.getString("Userpw"));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCMgr.close(stmt, conn);
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
}
