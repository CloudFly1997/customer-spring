package com.hejinkang.spring.instance.controller;


import com.hejinkang.spring.annotion.CustomerAutowire;
import com.hejinkang.spring.annotion.CustomerComponent;
import com.hejinkang.spring.instance.service.Teacher;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2020/8/13 16:28
 */

@CustomerComponent("controller")
public class StudentController {
    @CustomerAutowire
    private Teacher teacher;

    public String string;

    public void test() {
        teacher.print();;
    }

    @Override
    public String toString() {
        return teacher.toString();
    }
}
