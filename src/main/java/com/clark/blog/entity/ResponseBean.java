package com.clark.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ClarkRao
 * @Date: 2019/4/5 22:20
 * @Description: 响应返回体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean {
    /**
     * 状态码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 是否成功状态
     */
    private boolean success;
}
