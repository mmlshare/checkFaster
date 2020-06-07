package com.example.demo.service;

import com.example.demo.domain.BaseCalculateMsg;
import com.example.demo.thread.AbstractSingleThread;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedTransferQueue;
@Slf4j
public abstract class AbstractNotifyCalculateRunable extends AbstractSingleThread {
    private LinkedTransferQueue<BaseCalculateMsg> notifyMsgQueue = new LinkedTransferQueue<BaseCalculateMsg>();

    protected void acceptMsg(final BaseCalculateMsg msg){
        notifyMsgQueue.add(msg);
    }

    @Override
    public void runTask() {
    while (isActive()){
        try {
            final BaseCalculateMsg msg = notifyMsgQueue.take();
            this.handMsg(msg);
        } catch (final InterruptedException e) {
            log.error("处理通知消息线程被打断");
        }catch (final Exception e){
            log.error("处理通知消息线程发生异常",e);
        }
    }
    }

    abstract void handMsg(BaseCalculateMsg msg);




}
