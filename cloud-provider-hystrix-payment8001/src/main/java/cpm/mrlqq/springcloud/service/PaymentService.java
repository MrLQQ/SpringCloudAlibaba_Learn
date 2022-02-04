package cpm.mrlqq.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Classname PaymentService
 * @Description TODO
 * @Date 2022/2/3 22:57
 * @Created by LQQ
 */
@Service
public class PaymentService {

    /**
     * 可正常访问的
     * @param id
     * @return
     */
    public String PaymentInfo_OK(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "  paymentInfo_OK,id:" + id + "\t";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
         @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000") // 设置超时时间为3秒钟
    })
    public String PaymentInfo_TimeOut(Integer id){
        // 故意写个计算异常，会导致程序出错，用此来验证是否会走fallback
        //int age = 10/0;
        int timeNumber = 3;
        // 暂停几秒钟线程，模拟业务复杂，花费时间
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "  PaymentInfo_TimeOut,id:" + id + "\t" + " 耗时(秒):" + timeNumber;
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " 系统繁忙，请稍后再试,id:" + id + "\t" + "fallback" ;
    }

    // =====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            // 是否开启熔断器
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            // 断路器熔断的最小值阀值，如果单位时间内（具体时间以sleepWindowInMilliseconds为准）请求小于这个值，断路器永远不会熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            // 调用链路熔断后，一定时间后(默认5秒)，将再次重试调用run()方法，检测是否需要闭合调用链路。
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            // 在一定时间范围内（默认10秒）错误率达到或超过配置值时，执行熔断操作
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t" + "调用成功，流水号：" + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数，请稍后再试……";
    }
}
