package com.example.demo.service;

import com.example.demo.domain.BaseCalculateMsg;

import java.util.concurrent.LinkedTransferQueue;

/**
 * 计算交换机,用于管理服务和子线程通信交互
 */
public class CalculateExchanger {
    private LinkedTransferQueue<BaseCalculateMsg> managerMsgQueue;



    /**
     * 发送冻结消息
     */
    public void publishFrezonQtyMsg(){
    }
}
