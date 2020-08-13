package com.hejinkang.spring.instance.service.impl;


import com.hejinkang.spring.annotion.CustomerComponent;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2020/8/13 16:28
 */

@CustomerComponent
public class ServiceImpl {
    private int i;
    private String str = "test";

    @Override
    public String toString() {
        return "ServiceImpl{" +
                "i=" + i +
                ", str='" + str + '\'' +
                '}';
    }
}
