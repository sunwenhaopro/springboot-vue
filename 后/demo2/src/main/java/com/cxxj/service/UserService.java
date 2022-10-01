package com.cxxj.service;

import com.cxxj.model.User;
import com.github.pagehelper.PageInfo;


public interface UserService {

    PageInfo findAllUser (String username, int pageNum, int pageSize) throws Exception ;

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}