package com.clark.blog.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 21:13
 * @Description: 加密工具类
 */
@Slf4j
public class Encrypt {

    /**
     * 盐值
     */
    private static final String SALT = "clarkrao";
    /**
     * 加密算法类型
     */
    public static final String KEY_MD5 = "MD5";

    private final static String[] HEX_DIGITS = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};

    /**
     * 密码加密
     * @param password
     * @return
     */
    public static String passwordEncrypt(String password) {
        String encrypt = "";
        byte[]  data = (password + SALT).getBytes();
        try {
            log.info("Start password Encrypt");
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_MD5);
            messageDigest.update(data);
            encrypt = byteArrayToHexString(messageDigest.digest());
            log.info("End password Encrypt");
        } catch (NoSuchAlgorithmException e) {
            log.info("Error password Encrypt");
            e.printStackTrace();
        }
        return encrypt;
    }


    private static String byteArrayToHexString(byte[] b){
        StringBuffer resultSb = new StringBuffer();
        for(int i=0;i<b.length;i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b){
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n/16;
        int d2 = n%16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }
}
