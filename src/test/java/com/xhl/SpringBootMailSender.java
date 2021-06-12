package com.xhl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@SpringBootTest
public class SpringBootMailSender {
    //这里是2.2.6以后不能使用Autowired注入了？
    @Resource
    JavaMailSenderImpl javaMailSender;
    @Autowired
    TemplateEngine templateEngine;
    //简单的邮件发送
    @Test
    public void simpleSender(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("我是标题");
        mailMessage.setText("我是内容");
        mailMessage.setTo("1017767391@qq.com");
        mailMessage.setFrom("3190497579@qq.com");
        mailMessage.setCc("1207588932@qq.com");
        mailMessage.setSentDate(new Date());
        javaMailSender.send(mailMessage);
    }

    //带附件的邮件发送
    @Test
    public void complex() throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //组装
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setSubject("我是一个带附件的邮件");
        mimeMessageHelper.setText("<Strong style='color:red'>带html的邮件内容</strong>",true);

        //附件
        mimeMessageHelper.addAttachment("1.jpg",new File("E:\\youngCloud\\readfile\\rearEnd\\java\\code\\图片1.png"));
        mimeMessageHelper.addAttachment("1.pdf",new File("E:\\youngCloud\\readfile\\rearEnd\\java\\code\\异步任务.docx"));


        mimeMessageHelper.setTo("1017767391@qq.com");
        mimeMessageHelper.setFrom("3190497579@qq.com");
        javaMailSender.send(mimeMessage);

    }


    @Test
    public void sendThymeleafMail() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("这是一封测试邮件");
        helper.setTo("1017767391@qq.com");
        helper.setFrom("3190497579@qq.com");
        helper.setCc("1207588932@qq.com");
        helper.setSentDate(new Date());
        Context context = new Context();
        context.setVariable("username", "javaboy");
        context.setVariable("num","000001");
        context.setVariable("salary", "99999");
        String process = templateEngine.process("mail.html", context);
        helper.setText(process,true);
        javaMailSender.send(mimeMessage);;
    }
}
