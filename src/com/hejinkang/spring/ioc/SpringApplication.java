package com.hejinkang.spring.ioc;



import com.hejinkang.spring.annotion.CustomerComponent;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2020/8/13 13:09
 */

public class SpringApplication {

    private static String packageName;
    private static String packagePath;
    private static String rootPath;
    private static Map<String, Class<?>> name_clazz_map = new HashMap<>();

    /**
     * 通过启动类 获取包名，包的全路径相关信息
     * @param c 传入启动类的Class信息
     */
    public static void run(Class<?> c) {
        getPackageInfo(c);
        new PackageScanner().componentScan(rootPath, packagePath);
        new BeanFactory().class2Obj();
    }

    public static void getPackageInfo(Class c) {
        packageName = c.getPackage().getName();
        packagePath = packageName.replace(".", "/");
        URL resource = Thread.currentThread().getContextClassLoader().getResource(packagePath);
        rootPath = resource.getPath();
    }


}
