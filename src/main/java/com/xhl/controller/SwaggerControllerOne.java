package com.xhl.controller;

import com.xhl.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/swaggerOne")
//@Controller
@RestController
public class SwaggerControllerOne {
    //如果使用RequestMapping将能测试到很多种请求方式
    @GetMapping("/getSwagger")
    @ResponseBody
    public String getSwagger(){
        System.out.println("getgggggggggggg");
        return "getSwagger";
    }


    @RequestMapping("/requestSwagger")
    public void swaggerTwo(){
        System.out.println("swaggertwo");
        User user = new User();

    }


   @GetMapping("/user")
    public User GetUser(User user){
       //int i=1/0;
       System.out.println(user);
       return user;
    }

    @ApiOperation("getHello测试在接口方法上描述")
    @GetMapping("/getHello")
  /* 1. 给方法的参数加上注解会有问题，会将get请求query变换为body参数。@ApiParam("参数是姓名") String name
  *  2. 并且给下面的postHello方法加也有问题
  * */
    public String getHello( String name){
        System.out.println(name);
        return name;
    }


    @ApiOperation("postHello测试在接口方法上描述")
    @PostMapping("/postHello")
    public String postHello(String name){
        System.out.println(name);
        return name;
    }


}
