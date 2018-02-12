package com.straw.email.mail.controller;

import com.straw.email.mail.model.Joke;
import com.straw.email.mail.service.JokeService;
import com.straw.email.mail.service.MeilSessageService;
import com.straw.email.mail.model.MailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fengzy
 * @date 2/12/2018
 */
@Controller
public class JokeController {

    @Autowired
    MeilSessageService meilSessageService;

    @Autowired
    JokeService jokeService;

    @RequestMapping("/")
    @ResponseBody
    public MailMessage Index() {
        MailMessage mailMessage = meilSessageService.gainMesage();
        if (mailMessage != null) {
            return mailMessage;
        }
        return null;
    }

    @RequestMapping("/add")
    @ResponseBody
    public boolean addJoke(Joke joke) {
        if (joke != null) {
            jokeService.insertJoke(joke);
        }
        return true;
    }
}
