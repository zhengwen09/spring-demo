package com.demo.dao.impl;

import com.demo.common.SqlSessionFactoryManager;
import com.demo.dao.UserDao;
import com.demo.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

/**
 * Created by zhengw on 2018/3/16.
 */

@Service
public class UserDaoImpl implements UserDao {
    @Override
    public User getUserById(Integer id) {

        try( SqlSession session = SqlSessionFactoryManager.sqlSessionFactory.openSession()){
            User user =  session.selectOne("com.demo.mapper.UserMapper.getUserByID", id);
            session.close();
            return user;
        }
    }

    @Override
    public Integer insertUser(User user) {
        try( SqlSession session = SqlSessionFactoryManager.sqlSessionFactory.openSession()){
            Integer integer;
            integer=session.insert("com.demo.mapper.UserMapper.insertUser",user);
            session.commit();
            session.close();
            return integer;
        }
    }

    @Override
    public Integer updateUser(User user){
        try( SqlSession session = SqlSessionFactoryManager.sqlSessionFactory.openSession()){
            Integer integer;
            integer=session.update("com.demo.mapper.UserMapper.updateUser",user);
            session.commit();
            session.close();
            return integer;
        }
    }
}
