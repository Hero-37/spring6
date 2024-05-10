package com.atguigu.spring6.tx.controller;

import com.atguigu.spring6.tx.service.BookService;
import com.atguigu.spring6.tx.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CheckoutService checkoutServiceImpl;

    /**
     * 买一本书
     * @param bookId
     * @param userId
     */
    public void buyBook(Integer bookId, Integer userId) {
        bookService.buyBook(bookId, userId);
    }

    /**
     * 买多本书
     * @param bookIds
     * @param userId
     */
    public void buyBook(Integer[] bookIds, Integer userId) {
        checkoutServiceImpl.checkout(bookIds, userId);
    }
}
