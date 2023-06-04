package org.telran.prof.com.homework29;

public class User {
    private String userName;
    private String userIp;

    public User(String userName, String userIp) {
        this.userName = userName;
        this.userIp = userIp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userIp='" + userIp + '\'' +
                '}';
    }
}
