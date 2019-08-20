package com.clark.blog.exception;

import cn.hutool.http.HttpStatus;
import com.clark.blog.entity.ResponseBean;
import com.clark.blog.util.ResponseBeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: ClarkRao
 * @Date: 2019/8/21 0:30
 * @Description: 全局异常处理器
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 异常Code
     */
    private static final int EXCEPTION_CODE = 10000;

    /**
     * 运行时异常Code
     */
    private static final int RUNTIME_EXCEPTION_CODE = 10001;

    /**
     * 算术异常Code
     */
    private static final int ARITHMETIC_EXCEPTION_CODE = 10002;

    /**
     * 空指针异常Code
     */
    private static final int NULL_POINTER_EXCEPTION_CODE = 10003;

    /**
     * 运行时异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseBean runtimeExceptionHandler(RuntimeException ex) {
        return ResponseBeanUtil.error(RUNTIME_EXCEPTION_CODE, ex.getMessage());
    }

    /**
     * 空指针异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    public ResponseBean nullPointerExceptionHandler(NullPointerException ex) {
        return ResponseBeanUtil.error(NULL_POINTER_EXCEPTION_CODE, ex.getMessage());
    }

    /**
     * 500错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public ResponseBean server500Handler(RuntimeException ex) {
        log.info("server500 HTTP_INTERNAL_ERROR");
        return ResponseBeanUtil.error(HttpStatus.HTTP_INTERNAL_ERROR, ex.getMessage());
    }

    /**
     * 算术异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({ArithmeticException.class})
    public ResponseBean arithmeticException(ArithmeticException ex) {
        return ResponseBeanUtil.error(ARITHMETIC_EXCEPTION_CODE, ex.getMessage());
    }

    /**
     * 其他错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({Exception.class})
    public ResponseBean exception(Exception ex) {
        return ResponseBeanUtil.error(EXCEPTION_CODE, ex.getMessage());
    }

}
