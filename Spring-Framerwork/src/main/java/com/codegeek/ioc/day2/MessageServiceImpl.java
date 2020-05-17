package com.codegeek.ioc.day2;

/**
 * 消息服务实现
 */
public class MessageServiceImpl implements MessageService {

    private String name;

    private int age;



    public MessageServiceImpl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getMessage() {

        return "this is a message comes from a "+age+" year's boy whose name is "+name;
    }
}
