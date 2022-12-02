package com.jiawei.spring_transaction.service;

import java.util.List;

public interface CashierService {
    void checkout(String username, List<String> isbnList);
}
