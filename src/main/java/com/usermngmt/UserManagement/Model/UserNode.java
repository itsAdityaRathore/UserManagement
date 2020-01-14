package com.usermngmt.UserManagement.Model;

import java.util.ArrayList;
import java.util.List;

public class UserNode {

    public List<UserNode> children;
    private Long uid;
    private String root;
    private String uname;
    private String uemail;
    private String uaddress;
    private String uphone;
    private String urole;
    private String umanager;

    public UserNode(Long uid, String uname, String uemail, String uaddress, String uphone, String urole, String umanager) {
        this.uid = uid;
        this.uname = uname;
        this.uemail = uemail;
        this.uaddress = uaddress;
        this.uphone = uphone;
        this.urole = urole;
        this.umanager = umanager;
    }

    public UserNode(String root) {
        this.root = root;
    }

    public UserNode(User user) {
        this.uid = user.getUid();
        this.uname = user.getUname();
        this.uemail = user.getUemail();
        this.uaddress = user.getUaddress();
        this.uphone = user.getUphone();
        this.urole = user.getUrole();
        this.umanager = user.getUmanager();
    }


    public void add(UserNode node) {
        if (children == null)
            children = new ArrayList<UserNode>();
        children.add(node);
    }


}
