package com.cxxj.mapper;

import com.cxxj.model.User;

import java.util.List;


public interface UserMapper {

    List<User> findAllUser(String username);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
