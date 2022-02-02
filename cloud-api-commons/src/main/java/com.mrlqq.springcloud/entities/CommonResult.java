package com.mrlqq.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname CommonResult
 * @Description TODO
 * @Date 2022/1/25 18:37
 * @Created by LQQ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult <T>{

    private Integer code;
    private String message;
    private  T data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
