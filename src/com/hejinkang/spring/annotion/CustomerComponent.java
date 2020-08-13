package com.hejinkang.spring.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2020/8/13 13:30
 */

//表示注解使用的地方，METHOD是方法上，TYPE是类上
@Target({ElementType.METHOD,ElementType.TYPE})
//表示可以在运行期间能够通过反射获取到该注解
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomerComponent {
    String value() default "";
    String des() default "des";
}
