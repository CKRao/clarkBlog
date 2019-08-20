package com.clark.blog.util;

import cn.hutool.http.HttpStatus;
import com.clark.blog.entity.ResponseBean;

/**
 * @Author: ClarkRao
 * @Date: 2019/8/21 0:20
 * @Description: 返回数据实体工具类
 */
public class ResponseBeanUtil {

    public static ResponseBean success(String msg) {
        return new ResponseBean(HttpStatus.HTTP_OK, msg, null, true);
    }

    public static ResponseBean success( String msg, Object data) {
        return new ResponseBean(HttpStatus.HTTP_OK, msg, data, true);
    }

    public static ResponseBean success(int code, String msg, Object data) {
        return new ResponseBean(code, msg, data, true);
    }

    public static ResponseBean error(int code, String msg) {
        return new ResponseBean(code, msg, null, false);
    }
}
