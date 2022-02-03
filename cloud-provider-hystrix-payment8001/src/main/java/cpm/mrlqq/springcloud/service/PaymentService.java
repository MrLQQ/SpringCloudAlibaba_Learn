package cpm.mrlqq.springcloud.service;

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

    /**
     *
     * @param id
     * @return
     */
    public String PaymentInfo_TimeOut(Integer id){
        int timeNumber = 3;
        // 暂停几秒钟线程，模拟业务复杂，花费时间
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "  PaymentInfo_TimeOut,id:" + id + "\t" + " 耗时(秒):" + timeNumber;
    }
}
