package com.hejinkang.spring.ioc;

import com.hejinkang.spring.annotion.CustomerAutowire;
import com.hejinkang.spring.annotion.CustomerComponent;
import com.hejinkang.spring.bean.BeanConfig;
import com.hejinkang.spring.ioc.singleton.BeanConfigContainer;
import com.hejinkang.spring.ioc.singleton.Context;
import com.hejinkang.spring.util.NameUtil;

import java.lang.reflect.Field;
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

    public void class2Obj() {
        Set set = beanConfigContainer.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String clsName = (String) iterator.next();
            Object o = getBeanByName(clsName);
            context.put(clsName, o);
        }
    }

    public Object getBeanByName(String name) {
        if (context.get(name) != null) {
            return context.get(name);
        }
        BeanConfig beanConfig = beanConfigContainer.get(name);
        System.out.println(beanConfig.getCls());
        Class<?> cls = beanConfig.getCls();
        CustomerComponent annotation = cls.getAnnotation(CustomerComponent.class);
        if (annotation != null) {
            //System.out.println(annotation.value());
            Object o = null;
            try {
                //实例化对象
                o = cls.newInstance();
                //获取对象内的所有属性，进行判断是否需要自动注入
                Field[] declaredFields = cls.getDeclaredFields();

                for (int i = 0; i < declaredFields.length; i++) {
                    Field field = declaredFields[i];
                    //如果该属性有CustomerAutowire注解，则需要注入
                    if (field.getAnnotation(CustomerAutowire.class) != null) {
                        //递归调用
                        //System.out.println("name = " + field.getType().getSimpleName());
                        //根据属性的类型进行注入
                        Object bean = getBeanByName(NameUtil.objectNameFirstLetterToLowerCase(field.getType().getSimpleName()));
                        field.setAccessible(true);
                        field.set(o, bean);
                        //放进容器里，避免多次实例化
                        context.put(declaredFields[i].getName(),bean);

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return o;
        }
        return null;
    }
}