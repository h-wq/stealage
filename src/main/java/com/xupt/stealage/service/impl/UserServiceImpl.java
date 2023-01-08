package com.xupt.stealage.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.xupt.stealage.mapper.UserMapper;
import com.xupt.stealage.model.User;
import com.xupt.stealage.model.UserExample;
import com.xupt.stealage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
        if (CollectionUtils.isEmpty(ids)) {
            return Lists.newArrayList();
        }
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
    public User login(String name, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
        return userMapper.selectByExample(example).stream().findFirst().orElse(null);
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public Integer addFriend(Integer id, Integer friendId) {
        User user = getById(id);
        List<Integer> friendIds = StringUtils.isEmpty(user.getFriendIds()) ? new ArrayList<>() : JSONObject.parseArray(user.getFriendIds(), Integer.class);
        friendIds.add(friendId);
        addFriend(id, friendIds);

        User friendUser = getById(friendId);
        List<Integer> friendFriendIds = StringUtils.isEmpty(friendUser.getFriendIds()) ? new ArrayList<>() : JSONObject.parseArray(friendUser.getFriendIds(), Integer.class);
        friendFriendIds.add(id);
        return addFriend(friendId, friendFriendIds);
    }

    private Integer addFriend(Integer id, List<Integer> friendIds) {
        User record = new User();
        record.setId(id);
        record.setFriendIds(JSONObject.toJSONString(friendIds));
        return userMapper.updateByPrimaryKeySelective(record);
    }
}
