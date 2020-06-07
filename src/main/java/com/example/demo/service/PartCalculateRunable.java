package com.example.demo.service;

import com.example.demo.domain.BaseCalculateMsg;
import com.example.demo.domain.CheckRequest;
import com.example.demo.domain.CheckResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;
import java.util.concurrent.Future;


@Slf4j
public class PartCalculateRunable extends AbstractNotifyCalculateRunable{

    /**
     * 总量
     */
    private Map<String, RiskStatus> totalRiskStatusMap;

    private ThreadPoolTaskExecutor executor;
    /**
     * 计算线程状态
     */
    private int calculateStatus;

    public CheckResult check(final CheckRequest request){
        final Future<CheckResult> future = executor.submit(()->{

            //检查逻辑
            return null;
        });

        CheckResult result=null;
        try {
            result= future.get();
        } catch (final InterruptedException e) {
            log.error("处理数据被打断");
        } catch (final Exception e) {
            log.error("处理数据发生异常",e);
        }
        return result;
    }

    @Override
    void handMsg(final BaseCalculateMsg msg) {

    }
}
