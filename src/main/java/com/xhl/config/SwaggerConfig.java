package com.xhl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/*
* swagger的默认地址：http://localhost:8085/swagger-ui.html
* 主要解决前后端分离项目的后端接口返回数据对接问题
* 总共创建了两个bean,分别对应两个group,分别管理ant("/swaggerOne/**")接口，和swaggerTwo接口
* */
@Configuration
//开启swagger2
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {
        //引入Environment和profies根据生产是生产环境还是测试环境自行开启或关闭swagger
        Profiles profiles = Profiles.of("dev", "test");
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println("我进入了swaggerConfig配置类");


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //开启或关闭swagger
                .enable(flag)
                //分组
                .groupName("大无语事件")
                .select()
                //withClassAnnotation扫描类上的注解
                //withMethodAnnotation扫描方法上的注解
                //none

                .apis(RequestHandlerSelectors.basePackage("com.xhl.controller"))
              //  .paths("/swagger/swaggertwo")//过滤请求
                //ant是只管理里面接口的意思
                .paths(PathSelectors.ant("/swaggerOne/**"))
                .build();
    }

    //对每个人的内分别进行分组管理
    @Bean
    public Docket docketone() {
        Contact DEFAULT_CONTACT = new Contact("xhl", "http:www.baidu.com", "3190497579@qq.com");
        ApiInfo apiInfotwo = new ApiInfo("王八八",
                "你好呀",
                "xhl2.0",
                "urn:tos",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());


        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfotwo)
                //开启或关闭swagger
                .enable(true)
                //分组
                .groupName("王八八")
                .select()
                //withClassAnnotation扫描类上的注解
                //withMethodAnnotation扫描方法上的注解
                //none
                .apis(RequestHandlerSelectors.basePackage("com.xhl.controller"))
                //  .paths("/swagger/swaggertwo")//过滤请求
                .paths(PathSelectors.ant("/swaggerTwo/**"))
                .build();

    }

    private ApiInfo apiInfo(){
        Contact DEFAULT_CONTACT = new Contact("xhl", "http:www.baidu.com", "1017767391@qq.com");
        return  new ApiInfo("xhl",
                "今晚我就要远航",
                "xhl2.0",
                "urn:tos",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());

    }



    @Bean
    public Docket docketThree(Environment environment) {



        return new Docket(DocumentationType.SWAGGER_2)

             .pathMapping("/")
                //分组
                .groupName("根据不良人视屏分组")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xhl.controller"))
                //  .paths("/swagger/swaggertwo")//过滤请求
                //ant是只管理里面接口的意思
                .paths(PathSelectors.ant("/xhl/**"))
                .build().apiInfo(new ApiInfo("标题",
                        "详细信息",
                        "xhl3.0",
                        "urn:tos",
                        new Contact("熊海林", "http:www.baidu.com", "1017767391@qq.com"),
                        "Apache 2.0",
                        "http://www.apache.org/licenses/LICENSE-2.0",
                        new ArrayList<VendorExtension>()));
    }

}
