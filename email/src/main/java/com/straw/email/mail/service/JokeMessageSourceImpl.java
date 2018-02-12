package com.straw.email.mail.service;

import com.straw.email.mail.core.IdCache;
import com.straw.email.mail.dao.JokeMapper;
import com.straw.email.mail.model.Joke;
import com.straw.email.mail.model.MailMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fengzy
 * @date 2/12/2018
 */
@Service("meilSessageService")
public class JokeMessageSourceImpl implements MeilSessageService {

    @Resource
    JokeMapper jokeMapper;
    @Resource
    JokeService jokeService;

    @Override
    public MailMessage gainMesage() {
        Joke joke = jokeService.selectNext();

        if (joke != null) {
            return new MailMessage(joke.getTitle(), joke.getContext());
        }
        return null;
    }

}
