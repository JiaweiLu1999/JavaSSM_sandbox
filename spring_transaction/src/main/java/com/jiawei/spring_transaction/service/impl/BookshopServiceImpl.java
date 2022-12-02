package com.jiawei.spring_transaction.service.impl;

import com.jiawei.spring_transaction.dao.BookshopDao;
import com.jiawei.spring_transaction.service.BookshopService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookshopService")
public class BookshopServiceImpl implements BookshopService {
    private final BookshopDao bookshopDao;

    public BookshopServiceImpl(BookshopDao bookshopDao) {
        this.bookshopDao = bookshopDao;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            isolation = Isolation.REPEATABLE_READ,
            timeout = 100)
    public void purchase(String username, String isbn) {
        Integer price = bookshopDao.findBookPriceByIsbn(isbn);
        bookshopDao.updateBookStock(isbn);
        bookshopDao.updateUserAccount(username, price);
    }
}
