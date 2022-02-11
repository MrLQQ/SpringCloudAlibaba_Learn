package com.mrlqq.springcloud.service;

import com.mrlqq.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Classname StorageService
 * @Description TODO
 * @Date 2022/2/11 22:17
 * @Created by LQQ
 */
@FeignClient("seata-storage-service")
public interface StorageService{

    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,
                                 @RequestParam("count")Integer count);
}

