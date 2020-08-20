package com.hejinkang.spring.ioc;

import com.hejinkang.spring.annotion.CustomerComponent;
import com.hejinkang.spring.bean.BeanConfig;
import com.hejinkang.spring.ioc.singleton.BeanConfigContainer;
import com.hejinkang.spring.ioc.singleton.Context;

import java.util.Iterator;
import java.util.Set;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2020/8/14 8:40
 * 创建对象保存对象的工厂
 */

public class BeanFactory {
    private Context context = Context.getInstance();
    private BeanConfigContainer beanConfigContainer = BeanConfigContainer.getInstance();

    public void class2Obj(){
        Set set = beanConfigContainer.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String clsName = (String) iterator.next();
            BeanConfig beanConfig = beanConfigContainer.get(clsName);
            Class<?> cls = beanConfig.getCls();
            CustomerComponent annotation = cls.getAnnotation(CustomerComponent.class);
            if (annotation != null) {
                System.out.println(annotation.value());
                Object o = null;
                try {
                    o = cls.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                context.put(clsName, o);
            }
        }
    }
}
