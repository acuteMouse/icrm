package com.zy.log;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * @autor cgl
 * @time 2016/9/29.
 * 作用:  日志类
 */
@Component
public class Log {

    //日志生成器
    Logger logger=Logger.getLogger(Log.class);

    private StringBuffer common(JoinPoint joinPoint){
        StringBuffer msg=new StringBuffer(100);
        msg.append(joinPoint.getTarget().getClass());//拦截到的类
        msg.append("---");
        msg.append(joinPoint.getSignature().getName());//拦截到的方法
        return  msg;
    }

    /**
     * 方法执行之前
     * @param joinPoint
     */
    public void before(JoinPoint joinPoint){
        logger.info(common(joinPoint).append("--开始执行"));
    }

    /**
     * 方法执行时通知，主要捕获异常，发生问题快速定位
     * @param joinPoint
     */
    public  void arround(ProceedingJoinPoint joinPoint){
        StringBuffer msg=new StringBuffer(100);
        msg=common(joinPoint);
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            msg.append(throwable.getStackTrace());
            msg.append("第"+throwable.getStackTrace()[0].getLineNumber()+"行发生错误！");
            logger.info(msg);
        }
    }

    /**
     * 方法执行结束通知
     * @param joinPoint
     */
    public void  after(JoinPoint joinPoint){
        logger.info(common(joinPoint).append("--执行结束！"));
    }

}
