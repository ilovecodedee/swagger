package com.xhl.controller;

import com.xhl.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
*异步任务
* http://localhost:8081/async/asyncTest
*通过加两个注解实现异步操作@EnableAsync   @Async

未加异步任务之前的效果是需要线程Thread.sleep(3000);等待三秒才能返回asyncTest。
加了异步任务后，等待和返回分别进行
 * */

@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    private AsyncService asyncService;
    @GetMapping("/asyncTest")
    public String asyncTest(){
        asyncService.async();
        return "asyncTest";
    }
}
