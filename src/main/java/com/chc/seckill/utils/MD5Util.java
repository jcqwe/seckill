package com.chc.seckill.utils;


import cn.hutool.crypto.digest.DigestUtil;

/***
 *@title MD5Util
 *@description MD5工具类
 *@author chc
 *@version 1.0.0
 *@create 2023/3/16 10:50
 **/
public class MD5Util {
    //前端加密
    private static final String salt = "1a2b3c4d";

    /**
     *
     * @param content 加密内容
     * @return
     */
    public static String md5(String content){
         return DigestUtil.md5Hex(content);
    }

    /**
     * 根据前端传的密码进行加密(第一次加密)
     * @param password
     * @return
     */
    public static String frontendPassToBackendPass(String password){
        String content = "" + salt.charAt(0) + salt.charAt(3) + password;
        return md5(content);
    }

    /**
     * 存入数据库之前在进行一次加密(第二次加密)
     * @param firstMD5Pass
     * @return
     */
    public static String backendPassToDB(String firstMD5Pass,String salt){
        String content = salt.charAt(0) + salt.charAt(3) + firstMD5Pass;
        return md5(content);
    }

    public static void main(String[] args) {
        System.out.println(frontendPassToBackendPass("123456"));
        System.out.println(backendPassToDB("2e1a3c7426e2cff404c546887e0054fd","chccc"));
    }

}
