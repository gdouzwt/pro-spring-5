package com.apress.prospring5.ch6;

import com.apress.prospring5.ch6.dao.SingerDao;
import com.apress.prospring5.ch6.entities.Singer;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcSingerDao implements SingerDao, InitializingBean {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 一个基于 JDBC 的实现
    @Override
    public String findNameById(Long id) {
        return jdbcTemplate.queryForObject(
            // 有毒啊，这段 SQL 是 H2 的方言， 两个管道符号是连接字符串的操作符，
            // 所以这段 SQL 意思是，按 ID=？的条件分别搜索 FIRST_NAME 和 LAST_NAME
            // 将结果拼接，作为返回结果
            //"SELECT FIRST_NAME || ' ' || LAST_NAME FROM SINGER WHERE id = ?",
            // 以下为 MySQL 版本，H2也支持 CONCAT函数
            "SELECT CONCAT(FIRST_NAME,' ',LAST_NAME) FROM SINGER WHERE id = ?",
            new Object[]{id}, String.class);
    }

    // 一个基于 JDBC 的实现
    @Override
    public String findFirstNameById(Long id) {
        return jdbcTemplate.queryForObject(
            "SELECT FIRST_NAME FROM SINGER WHERE ID = ?",
            new Object[]{id}, String.class);
    }

    // Unimplemented methods, add implementations and tests as practice
    @Override
    public List<Singer> findAll() {
        throw new NotImplementedException("findAll");
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        throw new NotImplementedException("findByFirstName");
    }

    @Override
    public String findLastNameById(Long id) {
        throw new NotImplementedException("findLastNameById");
    }

    @Override
    public void insert(Singer singer) {
        throw new NotImplementedException("insert");
    }

    @Override
    public void update(Singer singer) {
        throw new NotImplementedException("update");
    }

    @Override
    public void delete(Long singerId) {
        throw new NotImplementedException("delete");
    }

    @Override
    public List<Singer> findAllWithAlbums() {
        throw new NotImplementedException("findAllWithAlbums");
    }

    @Override
    public void insertWithAlbum(Singer singer) {
        throw new NotImplementedException("insertWithAlbum");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (jdbcTemplate == null) {
            throw new BeanCreationException("Null JdbcTemplate on SingerDao");
        }
    }
}
