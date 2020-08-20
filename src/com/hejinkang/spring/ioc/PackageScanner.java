package com.hejinkang.spring.ioc;

import com.hejinkang.spring.common.Constant;
import com.hejinkang.spring.bean.BeanConfig;
import com.hejinkang.spring.ioc.singleton.BeanConfigContainer;

import java.io.File;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2020/8/14 8:40
 * 包扫描
 */

public class PackageScanner {

    public void componentScan(String rootPath,String packagePath) {
        BeanConfigContainer beanConfigContainer = BeanConfigContainer.getInstance();
        File[] files = new File(rootPath).listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                componentScan(files[i].getPath(),packagePath);
            }
            if (files[i].getName().endsWith(Constant.CLASS_SUFFIX)) {
                String fullPath = files[i].getPath().replace("\\", "/");
                String classFullName =
                        fullPath.substring(fullPath.indexOf(packagePath)).replace(Constant.CLASS_SUFFIX, "").replace(
                        "/", ".");
                String className = classFullName.substring(classFullName.lastIndexOf(Constant.POINT) + 1);
                Class<?> cls = null;
                try {
                    cls = Class.forName(classFullName);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                BeanConfig beanConfig = new BeanConfig();
                beanConfig.setClsName(className);
                beanConfig.setCls(cls);
                beanConfigContainer.put(className, beanConfig);
            }
        }
    }
}
