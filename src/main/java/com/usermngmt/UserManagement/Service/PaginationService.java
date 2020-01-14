package com.usermngmt.UserManagement.Service;

import com.usermngmt.UserManagement.Model.User;
import com.usermngmt.UserManagement.Repository.PaginationDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PaginationService {
    @Autowired
    public PaginationDao paginationDao;

    public Page<User> findJsonDataByCondition(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<User> data = paginationDao.findAll(pageable);
        return data;
    }
}
