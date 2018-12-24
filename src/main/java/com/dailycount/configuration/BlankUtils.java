package com.dailycount.configuration;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 *
 *@类名称	: BlankUtil.java
 *@类描述	：空对象、空字符串判断工具类
 *@创建人	：kwy
 *@创建时间	：2018年8月14日 09:42:35
 *@修改人	：zc
 *@修改时间	：2018年12月7日09:57:06
 *@版本号	:v1.1
 */
public abstract class BlankUtils {

    /**
     *
     * @param str
     * @return
     * @description：   判断字符串是否为空
     * @return: boolean
     * @method: isBlank
     * @author: kwy
     * @version: 2018年8月14日 09:42:54
     */
    public static boolean isBlank(final String str) {
        return str == null || str.trim().isEmpty();
    }
    public static boolean isNotBlank(final String str) {
        return str != null && str.trim().length()>0;
    }



    public static boolean isBlank(final BigDecimal str) {
        return (str == null);
    }
    public static boolean isNotBlank(final BigDecimal str) {
        return (str != null);
    }



    /**
     *
     * 方法说明：判断数组是否为空<p>
     * 作者：kwy
     * 时间：2018年8月14日 09:43:55
     * @param arr Object[]
     * @return boolean
     */
    public static boolean isBlank(final Object... arr) {
        return arr == null || arr.length == 0;
    }
    public static boolean isNotBlank(final Object... arr) {
        return arr != null && arr.length > 0;
    }


    /**
     *
     * @param cha
     * @return
     * @description：   判断字符是否为空
     * @return: boolean
     * @method: isBlank
     * @author: kwy
     * @version: 2018年8月14日 09:44:17
     */
    public static boolean isBlank(final Character cha) {
        return (cha == null) || cha.equals(' ');
    }
    public static boolean isNotBlank(final Character cha) {
        return (cha != null) && cha !='\0';
    }

    /**
     *
     * @param obj
     * @return
     * @description：   判断对象是否为空
     * @return: boolean
     * @method: isBlank
     * @author: kwy
     * @version: 2018年8月14日 09:44:27
     */
    public static boolean isBlank(final Object obj) {
        return !(obj != null &&!"null".equalsIgnoreCase(String.valueOf(obj)));
    }
    public static boolean isNotBlank(final Object obj) {
        return obj != null &&!"null".equalsIgnoreCase(String.valueOf(obj));
    }

    /**
     *
     * @param
     * @return
     * @description：   判断对象是否为空
     * @return: boolean
     * @method: isBlank
     * @author: kwy
     * @version: 2018年8月14日 09:44:44
     */
    public static boolean isBlank(final Properties properties) {
        return (properties == null||properties.isEmpty());
    }
    public static boolean isNotBlank(final Properties properties) {
        return (properties != null&&properties.size()>0);
    }



    /**
     *
     * @param obj
     * @return
     * @description：   判断Collectionj是否为空
     * @return: boolean
     * @method: isBlank
     * @author: kwy
     * @version: 2018年8月14日 09:44:53
     */
    public static <E> boolean isBlank(final Collection<E> obj) {
        return obj == null || obj.isEmpty();
    }
    public static <E> boolean isNotBlank(final Collection<E> obj) {
        return obj != null && (!obj.isEmpty());
    }

    /**
     *
     * @param obj
     * @return
     * @description：   判断AbstractList是否为空
     * @return: boolean
     * @method: isBlank
     * @author: kwy
     * @version: 2018年8月14日 09:45:00
     */
    public static <E> boolean isBlank(final Vector<E> obj) {
        return (obj == null) || (obj.size() <= 0);
    }
    public static <E> boolean isNotBlank(final Vector<E> obj) {
        return (obj != null) && (obj.size() > 0);
    }


    /**
     *
     * @param obj
     * @return
     * @description：   判断Set是否为空
     * @return: boolean
     * @method: isBlank
     * @author: kwy
     * @version: 2018年8月14日 09:45:08
     */
    public static <E> boolean isBlank(final Set<E> obj) {
        return (obj == null) || (obj.size() <= 0);
    }
    public static <E> boolean isNotBlank(final Set<E> obj) {
        return (obj != null) && (obj.size() > 0);
    }

    /**
     *
     * @param obj
     * @return
     * @description：   判断Serializable是否为空
     * @return: boolean
     * @method: isBlank
     * @author: kwy
     * @version: 2018年8月14日 09:45:16
     */
    public static boolean isBlank(final Serializable obj) {
        return obj == null;
    }
    public static boolean isNotBlank(final Serializable obj) {
        return obj != null;
    }

    /**
     *
     * @param obj
     * @return
     * @description：   判断Map是否为空
     * @return: boolean
     * @method: isBlank
     * @author: kwy
     * @version: 2018年8月14日 09:45:24
     */
    public static <K,V> boolean isBlank(final Hashtable<K,V> obj) {
        return (obj == null) || obj.isEmpty();
    }
    public static <K,V> boolean isNotBlank(final Hashtable<K,V> obj) {
        return (obj!= null) || obj.size()>0;
    }

    /**
     *
     * @param obj
     * @return
     * @description：   判断Map是否为空
     * @return: boolean
     * @method: isBlank
     * @author: kwy
     * @version: 2018年8月14日 09:45:31
     */
    public static <K,V> boolean isBlank(final Map<K,V> obj) {
        return obj == null || obj.isEmpty();
    }
    public static <K,V> boolean isNotBlank(final Map<K,V> obj) {
        return obj != null && (!obj.isEmpty());
    }


}

