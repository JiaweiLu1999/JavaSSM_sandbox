package com.jiawei.spring_transaction.dao;

public interface BookshopDao {
    Integer findBookPriceByIsbn(String isbn);

    void updateBookStock(String isbn);

    void updateUserAccount(String username, Integer price);
}
