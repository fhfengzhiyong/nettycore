package com.straw.email.mail.core;

import com.straw.email.mail.dao.JokeMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;

/**
 * @author fengzy
 * @date 2/12/2018
 */
public class IdReset implements ApplicationContextAware {
    @Resource
    JokeMapper jokeMapper;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Integer max = jokeMapper.selectMaxId();
        if (max != null) {
            max = 1;
        }
        IdCache.reSetMaxId(max);

    }
}
