package com.hejinkang.spring.util;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2020/8/21 14:19
 * @email 1981530505@qq.com
 */

public class NameUtil {
    public static String objectNameFirstLetterToLowerCase(String objectName) {
        return objectName.substring(0, 1).toLowerCase() + objectName.substring(1,objectName.length());
    }
}
