package com.usermngmt.UserManagement.Repository;

import com.usermngmt.UserManagement.Model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaginationDao extends PagingAndSortingRepository<User, Long> {

}
