package com.qg.blog.util;
// 文件名 SendEmail.java


import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail
{
    public static void main(String[] args) throws MessagingException {
        Properties props = new Properties();
        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.163.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        // 设置环境信息
        Session session = Session.getInstance(props);

        // 创建邮件对象
        Message msg = new MimeMessage(session);
        msg.setSubject("JavaMail测试");
        // 设置邮件内容
        msg.setText("这是由JavaMail发送的邮件！");
        // 设置发件人
        msg.setFrom(new InternetAddress("linhunger@163.com"));

        Transport transport = session.getTransport();
        // 连接邮件服务器
        transport.connect("linhunger", "a8848967");
        // 发送邮件
        transport.sendMessage(msg, new Address[] {new InternetAddress("983214067@qq.com")});
        // 关闭连接
        transport.close();
    }
}