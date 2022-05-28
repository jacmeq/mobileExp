package com.culture.mobileexp;

public class UserAccount { //사용자 계정 정보 모델
    private String idToken; //사용자 키값(고유정보)
    private String emailId;
    private String password;

    public UserAccount() { //firebase 데이터베이스 조회를 위해
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
