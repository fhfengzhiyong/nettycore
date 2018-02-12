package com.straw.email.mail.service;

import com.straw.email.mail.core.IdCache;
import com.straw.email.mail.dao.JokeMapper;
import com.straw.email.mail.model.Joke;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fengzy
 * @date 2/12/2018
 */
@Service
public class JokeServiceImpl implements JokeService {

    @Resource
    JokeMapper jokeMapper;

    @Override
    public void insertJoke(Joke joke) {
        joke.setVar1("1");
        jokeMapper.insert(joke);
    }

    @Override
    public Joke selectNext() {
        Joke joke = jokeMapper.selectNext();
        if (joke != null) {
            Integer id = joke.getId();
            jokeMapper.setConsumption(id);
        }
        return joke;
    }
}
