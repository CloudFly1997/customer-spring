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
    public static final String CLASS_SUFFIX = ".class";
    public static final String POINT = ".";
    private static String packageName;
    private static String packagePath;
    private static Map<String, Class<?>> name_clazz_map = new HashMap<>();

    public static Map<String, Object> run(Class<?> c) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException {
        packageName = c.getPackage().getName();
        packagePath = packageName.replace(".", "/");
        URL resource = Thread.currentThread().getContextClassLoader().getResource(packagePath);
        String root = resource.getPath();
        scan(root);
        return class2Obj();
    }

    public static void scan(String root) throws ClassNotFoundException {
        File[] files = new File(root).listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                scan(files[i].getPath());
            }
            if (files[i].getName().endsWith(CLASS_SUFFIX)) {
                String fullPath = files[i].getPath().replace("\\", "/");
                String classFullName = fullPath.substring(fullPath.indexOf(packagePath)).replace(CLASS_SUFFIX, "").replace(
                        "/", ".");

                String className = classFullName.substring(classFullName.lastIndexOf(".") + 1);
                Class<?> cls = Class.forName(classFullName);
                name_clazz_map.put(className, cls);
            }
        }
    }

    public static Map<String, Object> class2Obj() throws IllegalAccessException,
            InstantiationException {
        Map<String, Object> objectMap = new HashMap<>();
        Set set = name_clazz_map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String clsName = (String) iterator.next();
            Class<?> cls = name_clazz_map.get(clsName);
            CustomerComponent annotation = cls.getAnnotation(CustomerComponent.class);
            if (annotation != null) {
                System.out.println(annotation.value());
                Object o = cls.newInstance();
                objectMap.put(clsName, o);
            }
        }
        return objectMap;
    }


}
