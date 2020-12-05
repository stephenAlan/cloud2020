package com.stephen.springcloud.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by ssc on 2020-04-19 19:25 .
 * Description:
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ResultEnum {

    SUCCESS(0,"操作成功"),
    FAIL(11001,"操作失败"),
    ;

    private Integer code;

    private String msg;

}
