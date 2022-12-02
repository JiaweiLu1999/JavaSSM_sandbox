package com.jiawei.spring_transaction.dao.impl;

import com.jiawei.spring_transaction.dao.BookshopDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookshopDao")
public class BookshopDaoImpl implements BookshopDao {
    private final JdbcTemplate jdbcTemplate;

    public BookshopDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Integer findBookPriceByIsbn(String isbn) {
        String sql = "select price from book where isbn=?";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    @Override
    public void updateBookStock(String isbn) {
        String sql2 = "select stock from book_stock where isbn=?";
        Integer stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);

        assert stock != null;
        if (stock <= 0) {
            throw new RuntimeException("Out of stock!");
        }

        String sql = "update book_stock set stock=stock-1 where isbn=?";
        jdbcTemplate.update(sql, isbn);

    }

    @Override
    public void updateUserAccount(String username, Integer price) {
        String sql = "select balance from account where username=?";
        Integer balance = jdbcTemplate.queryForObject(sql, Integer.class, username);

        assert balance != null;
        if (balance < price) {
            throw new RuntimeException("Out of Balance!");
        }

        String sql2 = "update account set balance=balance-? where username=?";
        jdbcTemplate.update(sql2, price, username);
    }
}
