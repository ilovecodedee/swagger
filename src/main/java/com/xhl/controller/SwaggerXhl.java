package com.xhl.controller;


import com.xhl.pojo.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/xhl")
@Api(tags = "对类的说明")
public class SwaggerXhl {

    @GetMapping("/saveUser")
    @ApiOperation(value = "查询用户的所有接口",
        notes="<span style='color:red;'>描述</span>&nbsp;" +
        "用来保存用户的信息"
)
    public User saveUser(){
        User u=new User();
        u.setName("熊道理");
        u.setOld("123");
        return u;

    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "姓名",defaultValue = "熊熊"),
            @ApiImplicitParam(name = "old",value = "年龄",defaultValue ="17" ),
    })
    @GetMapping("/getUser")
    public User getUser(User user){

        System.out.println("user:  "+user);
        return user;
    }


    @ApiResponses({
            @ApiResponse(code=200,message = "请求成功了"),
            @ApiResponse(code=403,message = "没有权限"),
    })
    @GetMapping("/getReturnCode")
    public Map getReturnCode(){
        Map map = new HashMap<>();
        map.put("interest","看电影");
        map.put("motion","慢跑");
        new User("熊号令","123");
        map.put("people","我是map1");
        return map;
    }


}
