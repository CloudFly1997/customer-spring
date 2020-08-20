package com.hejinkang.spring.ioc.singleton;

import java.util.HashMap;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2020/8/19 16:53
 * 单例模式,可以通过这个全局获取对象
 */

public class Context {
    private static Context context = new Context();
    private static HashMap<String,Object> beanContainer = new HashMap<>();
    private Context() {

    }

    public static Context getInstance() {
        return context;
    }

    public void put(String clsName, Object obj) {
        this.beanContainer.put(clsName, obj);
    }

    public Object get(String clsName) {
        return this.beanContainer.get(clsName);
    }
}
