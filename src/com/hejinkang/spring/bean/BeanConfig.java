package com.hejinkang.spring.bean;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2020/8/14 8:46
 * Bean类,包含了Bean的名字，Class信息和是否为单例，Bean工厂
 */

public class BeanConfig {
    private String clsName;
    private Class<?> cls;
    private boolean singleton;

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public Class<?> getCls() {
        return cls;
    }

    public void setCls(Class<?> cls) {
        this.cls = cls;
    }

    public boolean isSingleton() {
        return singleton;
    }

    public void setSingleton(boolean singleton) {
        this.singleton = singleton;
    }
}
