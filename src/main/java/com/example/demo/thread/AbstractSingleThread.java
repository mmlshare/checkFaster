package com.example.demo.thread;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public abstract class AbstractSingleThread {
    /**
     * 管理线程
     */
    private ThreadPoolTaskExecutor executor;

    private boolean active = false;

    @PostConstruct
    public void init(){
        active = true;
        if(executor ==null){
            executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(1);
            executor.setMaxPoolSize(1);
            executor.setQueueCapacity(0);
        }
        executor.initialize();
        executor.execute(this::runTask);
    }

    public abstract  void runTask();
    @PreDestroy
    public void stop(){
        active = false;
        executor.destroy();
    }

    public boolean isActive() {
        return active;
    }
}
