package com.hejinkang.spring.instance.service;

import com.jack.spring.annotion.CustomerComponent;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2020/8/13 15:39
 */

@CustomerComponent("teacher")
public class Teacher {
    private String name;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                '}';
    }
}
