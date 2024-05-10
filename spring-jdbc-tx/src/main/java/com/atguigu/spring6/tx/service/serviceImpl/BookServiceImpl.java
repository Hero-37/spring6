package com.atguigu.spring6.tx.service.serviceImpl;

import com.atguigu.spring6.tx.dao.BookDao;
import com.atguigu.spring6.tx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer bookId, Integer userId) {
        // 根据 bookId 查询 图书价格
        Integer price =  bookDao.getBookPriceByBookId(bookId);
        // 更新图书表库存量 - 1
        bookDao.updateStock(bookId);
        // 更新用户表用户口余额 - 图书价格
        bookDao.updateUserBalance(userId, price);
    }
}
