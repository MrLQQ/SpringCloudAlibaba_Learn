package com.mrlqq.springcloud.dao;

import com.mrlqq.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname OrderDao
 * @Description TODO
 * @Date 2022/2/11 22:06
 * @Created by LQQ
 */
public interface OrderDao
{
    //新建订单
    void create(Order order);

    //修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
