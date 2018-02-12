package com.straw.email.mail.core;

import com.straw.email.mail.model.MailMessage;
import com.straw.email.mail.service.MeilSessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author fengzy
 * @date 2/12/2018
 */
@Component
public class Jobs {
    @Autowired
    SendEmail sendEmail;
    @Autowired
    MeilSessageService meilSessageService;

    @Scheduled(cron = "0 */20 * * * ?")
    public void cronJob() {
        System.out.println("开启定时任务");
        MailMessage mailMessage = meilSessageService.gainMesage();
        sendEmail.sendEmail(mailMessage);
        System.out.println("send.....");
    }
}

