package com.jiawei.spring_transaction.service.impl;

import com.jiawei.spring_transaction.service.BookshopService;
import com.jiawei.spring_transaction.service.CashierService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("cashierService")
public class CashierServiceImpl implements CashierService {
    private final BookshopService bookshopService;

    public CashierServiceImpl(BookshopService bookshopService) {
        this.bookshopService = bookshopService;
    }

    @Override
    @Transactional
    public void checkout(String username, List<String> isbnList) {
        for (String s : isbnList) {
            bookshopService.purchase(username, s);
            System.out.println(username + " purchased book " + s);
        }
    }
}
