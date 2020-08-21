package com.hejinkang.spring.instance.service;


import com.hejinkang.spring.annotion.CustomerAutowire;
import com.hejinkang.spring.annotion.CustomerComponent;
import com.hejinkang.spring.instance.service.impl.ServiceImpl;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2020/8/13 15:39
 */

@CustomerComponent("teacher")
public class Teacher {

    @CustomerAutowire
    private ServiceImpl service;

    public void print() {
        System.out.println("i am a teacher");
        System.out.println(service.toString());
    }

}
