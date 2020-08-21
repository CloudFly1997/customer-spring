package com.hejinkang.spring.ioc;

import com.hejinkang.spring.common.Constant;
import com.hejinkang.spring.bean.BeanConfig;
import com.hejinkang.spring.ioc.singleton.BeanConfigContainer;
import com.hejinkang.spring.util.NameUtil;

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
                //获取类的全路径
                String classFullName =
                        fullPath.substring(fullPath.indexOf(packagePath)).replace(Constant.CLASS_SUFFIX, "").replace(
                        "/", ".");
                //去掉最后一个点
                String className = classFullName.substring(classFullName.lastIndexOf(Constant.POINT) + 1);
                Class<?> cls = null;
                try {
                    cls = Class.forName(classFullName);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                BeanConfig beanConfig = new BeanConfig();
                String classKey = NameUtil.objectNameFirstLetterToLowerCase(className);
                beanConfig.setClsName(classKey);
                beanConfig.setCls(cls);
                beanConfigContainer.put(classKey, beanConfig);
            }
        }
    }
}
