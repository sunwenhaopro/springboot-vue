package com.cxxj.service2;

import org.springframework.jdbc.core.JdbcTemplate;
import com.cxxj.bean.User;
import com.cxxj.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Userservice {
    @Autowired
    UserDAO userDAO;
    @Autowired
   JdbcTemplate jdbcTemplate;


    public int isExist(String username) {
        User user = getByname(username);
        if(user==null){    //user.getPassword().length()==0
            return 1;
        }else{
            return 0;
        }

    }
    public void save(User user) {
        String sql = "INSERT INTO user(username, password) VALUES (?,?);";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
    }

    public User getByname(String username) {
        return userDAO.findByUsername(username);
    }


    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }


}