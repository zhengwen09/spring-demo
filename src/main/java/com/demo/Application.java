package com.demo;

import com.demo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

/**
 * Created by zhengw on 2018/3/12.
 */
public class Application {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = context.getBean(UserService.class);


        userService.getUserById(1);
        System.out.println(1);

    }

}