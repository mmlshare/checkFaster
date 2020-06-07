package com.example.demo.service;

import com.example.demo.domain.BaseCalculateMsg;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedTransferQueue;

public class CalculateMsgListenner {
    private LinkedTransferQueue<BaseCalculateMsg> managerMsgQueue;
    private Map<String,CalculateGroup> calculateGroupMap;

    private void notifyStop(){

    }

    /**
     * 注册计算组
     * @param calculateGroup
     */
    public synchronized void registerCalculateGroup(final CalculateGroup calculateGroup){

    if(calculateGroupMap == null){
        calculateGroupMap = new ConcurrentHashMap<String,CalculateGroup>(24);
    }
    calculateGroupMap.put(calculateGroup.getGroupName(),calculateGroup);

    }

    @Data
    public static class CalculateGroup{
        private String groupName;

        private CalculateManager calculateManager;

        private List<PartCalculateRunable> partCalculateRunableList;

        public CalculateGroup() {
        }

        public CalculateGroup(final CalculateManager calculateManager, final List<PartCalculateRunable> partCalculateRunableList) {
            this.calculateManager = calculateManager;
            this.partCalculateRunableList = partCalculateRunableList;
        }
    }
}
