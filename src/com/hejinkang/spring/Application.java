package com.hejinkang.spring;


import com.hejinkang.spring.instance.service.Teacher;
import com.hejinkang.spring.instance.service.impl.ServiceImpl;
import com.hejinkang.spring.ioc.SpringApplication;

import java.util.Map;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2020/8/13 14:33
 * 通过注解的方式，进行包扫描，依赖注入等功能的实现
 */

public class Application {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Map<String, Object> factory = SpringApplication.run(Application.class);
        Teacher teacher = (Teacher) factory.get("Teacher");
        System.out.println(teacher);
        ServiceImpl service = (ServiceImpl)factory.get("ServiceImpl");
        System.out.println(service);
    }
}
