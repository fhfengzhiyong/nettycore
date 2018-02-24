package com.straw.email.mail.core;

import com.straw.email.mail.model.MailMessage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author fengzy
 * @date 2/12/2018
 */
@org.springframework.stereotype.Service("sendEmail")
public class SendEmail {
    public static void main(String[] args) {
        SendEmail sendEmail = new SendEmail();
        sendEmail.sendEmail(new MailMessage("a", "joseil"));
    }

    void sendEmail(MailMessage mailMessage) {
        if (mailMessage == null) {
            return;
        }
        // 收件人电子邮箱
        String to = "1616682274@qq.com";
        // 发件人电子邮箱
        String from = "1307247006@qq.com";

        // 获取系统属性
        final Properties props = System.getProperties();

        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");

        props.put("mail.smtp.port", "587");
        props.put("mail.user", from);
        // 此处的密码就是前面说的16位STMP口令
        props.put("mail.password", "1jhsuzpeypmrrbibf");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(props);
        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        try {
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            // 设置发件人
            InternetAddress form = new InternetAddress(
                    props.getProperty("mail.user"));
            message.setFrom(form);

            // 设置收件人的邮箱
            InternetAddress toAdd = new InternetAddress(to);
            message.setRecipient(Message.RecipientType.TO, toAdd);

            // 设置邮件标题
            message.setSubject(mailMessage.getTitle());

            // 设置邮件的内容体
            message.setContent(mailMessage.getContext(), "text/html;charset=UTF-8");

            // 最后当然就是发送邮件啦
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
