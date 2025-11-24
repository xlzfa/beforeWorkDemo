package com.xlzfa.beforeworkdemo.common;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseResult handleBusinessException(BusinessException ex) {
        return ResponseResult.error(ex.getCode(), ex.getMessage());
    }

    /**
     * 运行时异常
     * @param ex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseResult handleRuntimeException(RuntimeException ex) {
        return ResponseResult.error(500, "系统运行异常： " + ex.getMessage());
    }

    /**
     * 其他异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult handleException(Exception ex) {
        return ResponseResult.error(500, "未知异常： " + ex.getMessage());
    }


}
