package com.clark.blog.exception;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 22:22
 * @Description: 用户认证异常
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}
