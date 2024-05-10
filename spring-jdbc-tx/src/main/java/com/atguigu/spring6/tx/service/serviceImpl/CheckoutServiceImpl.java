package com.atguigu.spring6.tx.service.serviceImpl;

import com.atguigu.spring6.tx.service.BookService;
import com.atguigu.spring6.tx.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    @Autowired
    private BookService bookServiceImpl;

    /**
     * 买多本书
     * @param bookIds
     * @param userId
     */
    @Override
    @Transactional
    public void checkout(Integer[] bookIds, Integer userId) {
        for (Integer bookId : bookIds) {
            bookServiceImpl.buyBook(bookId, userId);
        }
    }
}
