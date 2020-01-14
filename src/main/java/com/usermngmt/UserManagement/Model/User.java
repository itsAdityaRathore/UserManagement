package com.usermngmt.UserManagement.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    @SequenceGenerator(name = "my_seq", initialValue = 1001, allocationSize = 100, sequenceName = "user_seq")
    private Long uid;

    @Column(name = "uname")
    private String uname;
    @Column(name = "uemail")
    private String uemail;
    @Column(name = "uaddress")
    private String uaddress;
    @Column(name = "uphone")
    private String uphone;
    @Column(name = "urole")
    private String urole;
    @Column(name = "umanager")
    private String umanager;

    public User() {
    }

    public User(String s) {
    }


    public User(String uname, String uemail, String uaddress, String uphone, String urole, String umanager) {
        this.uname = uname;
        this.uemail = uemail;
        this.uaddress = uaddress;
        this.uphone = uphone;
        this.urole = urole;
        this.umanager = umanager;
    }

    public User(Long uid) {
        this.uid = uid;
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
        return "User{" +
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

