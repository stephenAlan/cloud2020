package com.stephen.springcloud;

import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * Created by ssc on 2021-01-07 17:42 .
 * Description:
 */
public class TimeTest {

    // 生成指定格式的时间
    @Test
    public void getTime() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now); // 2021-01-07T17:43:19.812+08:00[Asia/Shanghai]
    }

}
