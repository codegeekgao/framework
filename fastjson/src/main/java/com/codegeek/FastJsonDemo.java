package com.codegeek;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FastJsonDemo {

    public static void main(String[] args) {
            Student student = new Student();
            student.setName("小明");
            student.setGender("男");
            student.setAge(15);
        String s = JSON.toJSONString(student);
        System.out.println(s);
    }

}
