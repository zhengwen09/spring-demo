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
    public User getUserById(Integer id) {

        try( SqlSession session = SqlSessionFactoryManager.sqlSessionFactory.openSession()){
            User user =  session.selectOne("com.demo.mapper.UserMapper.getUserByID", id);
            session.close();
            return user;
        }
    }
}
