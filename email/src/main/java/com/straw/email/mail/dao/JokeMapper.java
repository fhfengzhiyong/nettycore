package com.straw.email.mail.dao;

import com.straw.email.mail.model.Joke;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JokeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Joke record);

    int insertSelective(Joke record);

    Joke selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Joke record);

    int updateByPrimaryKey(Joke record);

    Integer selectMaxId();

    Joke selectNext();

    void setConsumption(Integer id);
}