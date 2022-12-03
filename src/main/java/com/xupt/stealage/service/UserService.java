package com.xupt.stealage.service;

import com.xupt.stealage.model.User;

import java.util.List;

public interface UserService {

    User getById(Integer id);

    List<User> getByIds(List<Integer> ids);

    List<User> getByName(String name);

    Integer addUser(User user);

    Integer addFriend(Integer id, Integer friendId);
}
