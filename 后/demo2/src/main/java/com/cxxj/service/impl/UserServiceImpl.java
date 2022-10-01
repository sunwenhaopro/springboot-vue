package com.cxxj.service.impl;

import com.cxxj.mapper.UserMapper;
import com.cxxj.model.User;
import com.cxxj.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUser (String username, int pageNum, int pageSize) throws Exception {
        //开启分页
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList =  userMapper.findAllUser(username);
        PageInfo pageInfo = new PageInfo(userList);
        return pageInfo;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return  userMapper.deleteByPrimaryKey(id);

    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return  userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        User user =  userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        int ret =  userMapper.updateByPrimaryKeySelective(record);
        return ret;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        int ret =  userMapper.updateByPrimaryKey(record);
        return ret;
    }
}
