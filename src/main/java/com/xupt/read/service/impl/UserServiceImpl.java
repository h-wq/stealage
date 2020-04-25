package com.xupt.read.service.impl;

import com.xupt.read.mapper.UserMapper;
import com.xupt.read.model.User;
import com.xupt.read.model.UserExample;
import com.xupt.read.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getByIds(List<Integer> ids) {
        UserExample example = new UserExample();
        example.createCriteria().andIdIn(ids);
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> getByName(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name);
        return userMapper.selectByExample(example);
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public Integer addFriend(Integer id, String friendIds) {
        User record = new User();
        record.setId(id);
        record.setFriendIds(friendIds);
        return userMapper.updateByPrimaryKeySelective(record);
    }
}
