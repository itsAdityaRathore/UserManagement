package com.usermngmt.UserManagement.Repository;

import com.usermngmt.UserManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUmanager(String umanager);

    List<User> findByUroleAndUmanager(String urole, String umanager);

    List<User> findByUrole(User user);

}
