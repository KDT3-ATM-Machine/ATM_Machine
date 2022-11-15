package entity;

public class BankingUserEntity {
    private String userId;
    private String userPw;

    public BankingUserEntity(){}

    public BankingUserEntity(String userId, String userPw){
        this.userId=userId;
        this.userPw=userPw;
    }

    public String getUserId() {
        return userId;
    }
    public String getUserPw() {
        return userPw;
    }
}
