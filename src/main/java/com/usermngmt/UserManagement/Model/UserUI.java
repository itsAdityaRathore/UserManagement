package com.usermngmt.UserManagement.Model;

import javax.persistence.Column;

public class UserUI {

    private Long uid;

    private String uname;
    private String uemail;
    private String uaddress;
    private String uphone;
    private String urole;
    private String umanager;

    public UserUI() {
    }

    public UserUI(Long uid, String uname, String urole) {
        this.uid = uid;
        this.uname = uname;
        this.urole = urole;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUrole() {
        return urole;
    }

    public void setUrole(String urole) {
        this.urole = urole;
    }

    public String getUmanager() {
        return umanager;
    }

    public void setUmanager(String umanager) {
        this.umanager = umanager;
    }

    @Override
    public String toString() {
        return "UserUI{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uemail='" + uemail + '\'' +
                ", uaddress='" + uaddress + '\'' +
                ", uphone='" + uphone + '\'' +
                ", urole='" + urole + '\'' +
                ", umanager='" + umanager + '\'' +
                '}';
    }
}
