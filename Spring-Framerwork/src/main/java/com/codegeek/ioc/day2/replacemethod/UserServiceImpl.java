package com.codegeek.ioc.day2.replacemethod;

public class UserServiceImpl implements UserService {
    @Override
    public void findUserNameById(String userId) {
        String desc = userId == "1" ? "主角" : "路人";
        System.out.println(desc);
    }
}
