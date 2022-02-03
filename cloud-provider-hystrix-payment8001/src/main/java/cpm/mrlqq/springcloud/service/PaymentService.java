package cpm.mrlqq.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
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
}
