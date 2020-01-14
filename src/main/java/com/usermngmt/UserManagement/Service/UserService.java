package com.usermngmt.UserManagement.Service;

import com.google.gson.Gson;
import com.usermngmt.UserManagement.Model.User;
import com.usermngmt.UserManagement.Model.UserNode;
import com.usermngmt.UserManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @PersistenceContext
    EntityManager entityManager;

    public String all() {
        String allData = "";
        Query queryAM = entityManager.createQuery("select u from User u where u.urole = ?1");
        queryAM.setParameter(1, "AM");
        List<User> userAM = queryAM.getResultList();
        UserNode root = new UserNode("User Data");

        for (User user1 : userAM) {
            UserNode u1 = new UserNode(user1);
            root.add(u1);

            allData += user1.toString();
            Query querySM = entityManager.createQuery("select u from User u where u.umanager = ?1");
            querySM.setParameter(1, user1.getUid().toString());
            List<User> userSM = querySM.getResultList();

            for (User user2 : userSM) {
                UserNode u2 = new UserNode(user2);
                u1.add(u2);

                allData += user2.toString();
                Query queryLP = entityManager.createQuery("select u from User u where u.umanager = ?1");
                queryLP.setParameter(1, user2.getUid().toString());
                List<User> userLP = queryLP.getResultList();
                for (User user3 : userLP) {
                    UserNode u3 = new UserNode(user3);
                    u2.add(u3);
                    allData += user3.toString();
                }
            }
        }
        Gson g = new Gson();
        return g.toJson(root);
    }
}
