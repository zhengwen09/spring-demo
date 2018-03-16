package com.demo.exception;

/**
 * Created by zhengw on 2018/3/12.
 */
public class MyException extends Exception {

    private String content;

    public MyException(String content) {
        this.content=content;
    }

    public String getContent(){
        return  this.content;
    }

}
