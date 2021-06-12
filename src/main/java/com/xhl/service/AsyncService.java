package com.xhl.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    @Async
    public void async(){
        try {
            Thread.sleep(3000);
            System.out.println("等待三秒钟");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
}
}
