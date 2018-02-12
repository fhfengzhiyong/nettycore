package com.straw.email.mail.service;

import com.straw.email.mail.model.Joke;

/**
 * @author fengzy
 * @date 2/12/2018
 */
public interface JokeService {

    /**
     * 添加
     *
     * @param joke
     */
    void insertJoke(Joke joke);

    /**
     * 消费一条数据
     *
     * @return
     */
    Joke selectNext();

}
