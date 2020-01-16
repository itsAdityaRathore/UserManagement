package com.usermngmt.UserManagement.Controller;

import com.usermngmt.UserManagement.Model.User;

import com.usermngmt.UserManagement.Repository.UserRepository;
import com.usermngmt.UserManagement.Service.PaginationService;
import com.usermngmt.UserManagement.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;
    @PersistenceContext
    EntityManager entityManager;
    private UserRepository userRepository;
    @Autowired
    private PaginationService paginationService;


    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Creates Bulk User
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String bulkcreate() {
        return userService.bulkcreate();
    }

    // Create a Single User
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Find all the users using in-built method
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findAll() {
        return userService.findAllUsers();
    }

    // Search user by Id
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public Optional<User> search(@PathVariable long id) {
        return userService.searchUserById(id);
    }

    // Delete a user by Id
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    // Find user by its manager
    @RequestMapping(value = "user/{umanager}", method = RequestMethod.GET)
    public List<User> searchByManager(@PathVariable String umanager) {
        return userService.searchByManager(umanager);
    }

    // Find user by its role and manager
    @RequestMapping(value = "user/", method = RequestMethod.GET)
    public List<User> searchByUroleAndUmanager(@RequestParam("urole") String urole, @RequestParam("umanager") String umanager) {
        return userService.searchByUroleAndUmanager(urole, umanager);
    }

    // Find user by passing Role in the body(JSON) with custom query
    @RequestMapping(value = "/users/body")
    public List<User> searchByUrole(@RequestBody User user) {
        return userService.searchByUrole(user);
    }

    // Returns the hierarchy of the USERS in Json format
    @RequestMapping(value = "/users/hierarchy")
    public String all() {
        return userService.all();
    }

    @RequestMapping(value = "/conditionalPagination", params = {"page", "size"}, method = RequestMethod.GET)
    public Page<User> findJsonDataByPageAndSize(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<User> list = paginationService.findJsonDataByCondition(page, size);
        return list;
    }

}




