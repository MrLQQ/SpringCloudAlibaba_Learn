package com.mrlqq.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mrlqq.springcloud.entities.CommonResult;

/**
 * @Classname CustomerBlockHandler
 * @Description TODO
 * @Date 2022/2/11 15:55
 * @Created by LQQ
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult<>(444,"按客户自定义,global handlerException-----1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult<>(444,"按客户自定义,global handlerException-----2");
    }

}
