package com.hejinkang.spring.ioc.singleton;

import com.hejinkang.spring.bean.BeanConfig;

import java.util.HashMap;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2020/8/20 15:42
 * 保存beanConfig对象，对象工厂通过bean名称获取beanConfig进行对象的创建
 */

public class BeanConfigContainer extends HashMap<String, BeanConfig> {
    private static BeanConfigContainer beanConfigContainer = new BeanConfigContainer();
    private BeanConfigContainer() {

    }

    public static BeanConfigContainer getInstance() {
        return beanConfigContainer;
    }
}
