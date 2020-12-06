package com.stephen.springcloud.utils;

import com.stephen.springcloud.entities.CommonResult;
import com.stephen.springcloud.enums.ResultEnum;

/**
 * Created by ssc on 2020-04-19 19:31 .
 * Description:
 */
public class ResultUtils {


    public static <T> CommonResult<T> success(T data) {
        return result(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),data);
    }

    public static <T> CommonResult<T> success(String msg,T data) {
        return result(ResultEnum.SUCCESS.getCode(),msg,data);
    }

    public static <T> CommonResult<T> success() {
        return result(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),null);
    }

    public static <T> CommonResult<T> fail() {
        return result(ResultEnum.FAIL.getCode(),ResultEnum.FAIL.getMsg(),null);
    }

    public static <T> CommonResult<T> fail(T data) {
        return result(ResultEnum.FAIL.getCode(),ResultEnum.FAIL.getMsg(),data);
    }

    public static <T> CommonResult<T> result(ResultEnum resultEnum) {
        return result(resultEnum.getCode(),resultEnum.getMsg(),null);
    }

    public static <T> CommonResult<T> result(ResultEnum resultEnum,T data) {
        return result(resultEnum.getCode(),resultEnum.getMsg(),data);
    }

    public static <T>CommonResult<T>  result(Integer code,String msg,T data) {
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.setCode(code);
        commonResult.setMessage(msg);
        commonResult.setData(data);
        return commonResult;
    }

}
