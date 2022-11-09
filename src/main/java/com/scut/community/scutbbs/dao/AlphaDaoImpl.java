package com.scut.community.scutbbs.dao;

import org.springframework.stereotype.Repository;

/**
 * @author wuyuda
 * @date 2022-11-08 20:50
 *
 * @Repository 这个注解使得SpringIoC容器可以扫描到这个bean
 */
@Repository("alphaV1")
public class AlphaDaoImpl implements AlphaDao {
    @Override
    public String select() {
        return "select * from user where name = wuyuda";
    }
}
