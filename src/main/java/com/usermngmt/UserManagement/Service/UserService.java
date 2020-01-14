package com.usermngmt.UserManagement.Service;

import com.google.gson.Gson;
import com.usermngmt.UserManagement.Model.User;
import com.usermngmt.UserManagement.Model.UserNode;
import com.usermngmt.UserManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    public String bulkcreate() {
        userRepository.saveAll(Arrays.asList(
                new User("Aditya", "Salim@gmail.com", "Udaipur", "9090909090", "AM", ""),
                new User("Mohan", "Mohan@yahoo.in", "Ajmer", "9090901234", "SM", "1001"),
                new User("Amit", "Amit@gmail.com", "Kolkata", "9093456090", "SM", "1001"),
                new User("Rahul", "Rahul@outlook.com", "Raipur", "9879609090", "LP", "1002"),
                new User("Salim", "Salim@gmail.com", "Bikaner", "8841909090", "AM", ""),
                new User("Parul", "Parul@yahoo.in", "Chennai", "7896909090", "SM", "1005"),
                new User("Gaurav", "Gaurav@gmail.com", "Himachal", "9980789090", "LP", "1006"),
                new User("Avish", "Avish@outlook.com", "Goa", "8890656090", "LP", "1006")
                )
        );
        return "Bulk Creation Completed";
    }

    public String create(User user) {
        // save a single Customer
        userRepository.save(new User(user.getUname(), user.getUemail(), user.getUaddress(), user.getUphone(), user.getUrole(), user.getUmanager()));
        return "Customer is created";
    }

    public List<User> findAll() {
        List<com.usermngmt.UserManagement.Model.User> users = userRepository.findAll();
        return users;
//        List<UserUI> userUI = new ArrayList<>();
//        for (User user : users) {
//            userUI.add(new UserUI(user.getUname(),user.getUemail(),user.getUaddress(),user.getUphone(),user.getUrole(),user.getUmanager()));
//        }
//        return userUI;
    }

    public Optional<User> search(long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    public List<User> deleteUser(Long id) {
        userRepository.deleteById(id);
        List<User> user = userRepository.findAll();
        return user;
    }

    public List<User> searchByName(String umanager) {
        List<User> user = userRepository.findByUmanager(umanager);
        return user;
    }

    public List<User> findByUroleAndUmanager(String urole, String umanager) {
        List<User> user = userRepository.findByUroleAndUmanager(urole, umanager);
        System.out.println(user);
        return user;
    }

    public List<User> findByUrole(User user) {
        Query query = entityManager.createQuery("select u from User u where u.urole = ?1");
        query.setParameter(1, user.getUrole());
        return query.getResultList();
    }
}
