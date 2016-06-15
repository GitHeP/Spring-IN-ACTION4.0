package kernel.spring.AOP.bean;


import java.util.Date;

/**
 * Created by kernel on 2016/6/14.
 */
public class LoginBean {

    private String userName;

    private String passWord;

    private String loginIP;

    private Date loginDate;

    public LoginBean(){

    }

    public LoginBean(String userName,String passWord,String loginIP,Date loginDate){
        this.userName = userName;
        this.passWord = passWord;
        this.loginIP = loginIP;
        this.loginDate = loginDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getLoginIP() {
        return loginIP;
    }

    public void setLoginIP(String loginIP) {
        this.loginIP = loginIP;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
