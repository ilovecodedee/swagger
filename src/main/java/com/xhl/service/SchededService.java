package com.xhl.service;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service

/*
*有两个相关的接口
* TaskScheduler  任务调度者
*TaskExecutor     任务执行者
* */
public class SchededService {
    //这里是2.2.6以后不能使用Autowired注入了？
    @Resource
    JavaMailSenderImpl javaMailSender;

    //每隔一分钟执行一次
    //可以使用它来实现每分钟都发邮件等功能
    @Scheduled(cron = "0 */1 * * * ?")
    public void  testSched() throws MessagingException {
        System.out.println("开始发送邮件了哟");
        complex();
    }



    public void complex() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //组装
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setSubject("我是一个带附件的邮件");
        mimeMessageHelper.setText("<Strong style='color:red'>带html的邮件内容</strong>",true);

        //附件
        //附件
        mimeMessageHelper.addAttachment("1.jpg",new File("E:\\youngCloud\\readfile\\rearEnd\\java\\code\\图片1.png"));
        mimeMessageHelper.addAttachment("1.pdf",new File("E:\\youngCloud\\readfile\\rearEnd\\java\\code\\微人事.doc"));

        mimeMessageHelper.setTo("1017767391@qq.com");
        mimeMessageHelper.setFrom("3190497579@qq.com");
        mimeMessageHelper.setCc("1207588932@qq.com");
        javaMailSender.send(mimeMessage);

    }
}
