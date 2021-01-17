package com.stephen.springcloud.dao;

import com.stephen.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ssc on 2021-01-17 10:52 .
 * Description:
 */
@Mapper
public interface OrderDao {

    // 新建订单
    void create(Order order);

    // 修改订单状态,从0到1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
