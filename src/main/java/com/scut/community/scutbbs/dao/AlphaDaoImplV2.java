package com.scut.community.scutbbs.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author wuyuda
 * @date 2022-11-08 20:54
 * @Repository
 * @Primary  加上这个注解会优先装配
 */
@Repository
@Primary
public class AlphaDaoImplV2 implements AlphaDao {
    @Override
    public String select() {
        return "select * from user where name = wuyuda and age = 19";
    }
}
