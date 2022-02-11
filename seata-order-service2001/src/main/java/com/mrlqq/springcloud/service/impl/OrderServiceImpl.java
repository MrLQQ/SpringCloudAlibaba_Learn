package com.mrlqq.springcloud.service.impl;

import com.mrlqq.springcloud.dao.OrderDao;
import com.mrlqq.springcloud.domain.Order;
import com.mrlqq.springcloud.service.AccountService;
import com.mrlqq.springcloud.service.OrderService;
import com.mrlqq.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname OrderServiceImpl
 * @Description TODO
 * @Date 2022/2/11 22:17
 * @Created by LQQ
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;


    /**
     * 下订单->减库存->扣余额->改（订单）状态
     * @param order
     */
    @Override
    @GlobalTransactional(name = "sfp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {

        log.info("----->开始新建订单");
        orderDao.create(order);

        log.info("\t----->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("\t<-----订单微服务开始调用库存，做扣减end");

        log.info("\t----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("\t<-----订单微服务开始调用账户，做扣减end");

        log.info("\t----->修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("\t<-----修改订单状态结束");

        log.info("<-----订单状态结束");

    }
}
