package com.codegeek.day3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class LazyBean {

    private Boolean flag;


    public void setFlag(Boolean flag) {
        System.out.println("设置了flag："+flag);
        this.flag = flag;
    }
}
