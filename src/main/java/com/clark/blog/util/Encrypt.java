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
    private static final String SALT = "dPBQ6pbaCBaQjwlXv0B44gj4ErTRMo+1Dn5BQPgdxeMNvZu3qV+XlBlG+nict9bN0rQITbqzpzY1zXG5JxkBPQeVagsk05nUqDamP7Lhc4XEFrQrQn86oqKsCaG988Too2ad85ns4B7TmMswTWKsGzA3xWKQj2qjtMnaMB2NwHBpMD2jxnQLdGQEtIw8n";

    /**
     * 加密算法类型
     */
    public static final String KEY_SHA = "SHA";

    /**
     * 密码加密
     * @param password
     * @return
     */
    public static String passwordEncrypt(String password) {
        String encrypt = "";
        byte  data =Byte.parseByte(password + SALT);
        try {
            log.info("Start password Encrypt");
            MessageDigest messageDigest = MessageDigest.getInstance(KEY_SHA);
            messageDigest.update(data);
            encrypt = messageDigest.digest().toString();
            log.info("End password Encrypt");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encrypt;
    }
}
