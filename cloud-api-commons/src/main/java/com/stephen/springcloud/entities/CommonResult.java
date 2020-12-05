package com.stephen.springcloud.entities;

import com.stephen.springcloud.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by ssc on 2020-04-19 18:36 .
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T  data;

    public CommonResult(Integer code,String message) {
        this(code,message,null);
    }

    public CommonResult(ResultEnum resultEnum) {
        this(resultEnum.getCode(),resultEnum.getMsg());
    }

    public CommonResult(ResultEnum resultEnum,T data) {
        this(resultEnum.getCode(),resultEnum.getMsg(),data);
    }
    public CommonResult(T data) {
        this(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMsg(),data);
    }


}
