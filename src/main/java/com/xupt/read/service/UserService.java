package com.xupt.read.service;

import com.xupt.read.model.User;

import java.util.List;

public interface UserService {

    User getById(Integer id);

    List<User> getByIds(List<Integer> ids);

    Integer addUser(User user);

    Integer addFriend(Integer id, String friendIds);
}
