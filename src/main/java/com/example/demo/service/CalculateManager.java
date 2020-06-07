package com.example.demo.service;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;
import java.util.Set;

public class CalculateManager {
    /**
     * 区块数量
     */
    private int partNum;
    /**
     * 总量
     */
    private Map<String, RiskStatus> totalRiskStatus;

    /**
     * 分配到的风控规则
     */
    private Set<String> riksKeys;

    /**
     * 计算执行线程
     */
    private ThreadPoolTaskExecutor taskExecutor;

    /**
     * 管理线程
     */
    private ThreadPoolTaskExecutor managerExecutor;


}
