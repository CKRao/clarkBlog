package com.clark.blog.entity;

import io.swagger.annotations.ApiParam;
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

    @ApiParam(name = "code",value = "状态码",required = true)
    private int code;


    @ApiParam(name = "msg",value = "返回信息",required = true)
    private String msg;

    @ApiParam(name = "data",value = "返回数据")
    private Object data;


    @ApiParam(name = "success",value = "是否成功状态",required = true)
    private boolean success;
}
