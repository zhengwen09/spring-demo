package com.demo.dao;


import com.demo.entity.User;

/**
 * Created by zhengw on 2018/3/16.
 */
public interface UserDao {
    public User getUserById(Integer id) ;

    public Integer insertUser(User user);

    public Integer updateUser(User user);


}
