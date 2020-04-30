package com.soft1851.validator.handler;

import com.soft1851.validator.common.ResultCode;
import com.soft1851.validator.exception.APIException;
import com.soft1851.validator.vo.ResultVO;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/30 18:33
 * @Version 1.0
 **/
@RestControllerAdvice
public class ExceptionControllerAdvice {
//    @ExceptionHandler(APIException.class)
//    public String MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
//        //从异常对象中拿到ObjectError对象
//        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
//        //然后提取错误提示信息返回
//        return objectError.getDefaultMessage();
//    }

//    @ExceptionHandler(APIException.class)
//    public String APIExceptionHandler(APIException e) {
//        return e.getMsg();
//    }

    @ExceptionHandler(APIException.class)
    public ResultVO<String> APIExceptionHandler(APIException e) {
        //这里返回类型是自定义响应体
//        return new ResultVO<>(e.getCode(), "响应失败", e.getMsg());
        return new ResultVO<>(ResultCode.FAILED,e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        //从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        //这里返回类型是自定义响应体
//        return new ResultVO<>(1001, "参数校验失败", objectError.getDefaultMessage());
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }
}
