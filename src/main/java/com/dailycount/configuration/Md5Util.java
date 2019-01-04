package com.dailycount.configuration;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName Md5Util
 * @Description TODO
 * @Author cheng
 * @Date 2019/1/3 23:03
 **/
public class Md5Util {
    /**
     * Description md5+base64加密，不可逆
     * @Param [str]
     * @Return java.lang.String
     * @Author zhangcheng
     * @Date 2019/1/4 0:02
     */
    public static String encode(String str) {
        String newStr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            newStr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return newStr;
    }

    /**
     * Description MD5加码。32位
     * @Param [inStr]
     * @Return java.lang.String
     * @Author zhangcheng
     * @Date 2019/1/4 0:02
     */
    public static String MD5(String inStr) {
        MessageDigest md5 = null ;
        try  {
            md5 = MessageDigest.getInstance("MD5" );
        } catch  (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return   "" ;
        }
        char [] charArray = inStr.toCharArray();
        byte [] byteArray =  new   byte [charArray.length];
        for  ( int  i =  0 ; i < charArray.length; i++){
            byteArray[i] = (byte ) charArray[i];
        }
        byte [] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new  StringBuffer();
        for  ( int  i =  0 ; i < md5Bytes.length; i++) {
            int  val = (( int ) md5Bytes[i]) &  0xff ;
            if  (val <  16 ){
                hexValue.append("0" );
            }
            hexValue.append(Integer.toHexString(val));
        }
        return  hexValue.toString();
    }

    /**
     * Description 可逆的加密算法
     * @Param [inStr]
     * @Return java.lang.String
     * @Author zhangcheng
     * @Date 2019/1/4 0:02
     */
    public static String KL(String inStr) {
        char [] a = inStr.toCharArray();
        for  ( int  i =  0 ; i < a.length; i++) {
            a[i] = (char ) (a[i] ^  't' );
        }
        String s = new  String(a);
        return  s;
    }

    /**
     * Description 加密后解密
     * @Param [inStr]
     * @Return java.lang.String
     * @Author zhangcheng
     * @Date 2019/1/4 0:03
     */
    public static String JM(String inStr) {
        char [] a = inStr.toCharArray();
        for  ( int  i =  0 ; i < a.length; i++) {
            a[i] = (char ) (a[i] ^  't' );
        }
        String k = new  String(a);
        return  k;
    }

    // 测试主函数
    public   static   void  main(String args[]) {
        String s = new  String( "a" );
        System.out.println("原始："  + s);
        System.out.println("MD5后："  + MD5(s));
        System.out.println("MD5后再加密："  + KL(MD5(s)));
        System.out.println("解密为MD5后的："  + JM(KL(MD5(s))));

        String str = "123456";
        System.out.println(Md5Util.MD5(str));
        String s1 = Md5Util.KL(Md5Util.MD5(str));
        System.out.println(s1);
        String s2 = Md5Util.JM(s1);
        System.out.println(s2);
    }

}
