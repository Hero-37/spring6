package com.atguigu.spring6.xmltx;

import com.atguigu.spring6.xmltx.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class TestBookTx {

    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook() {
        bookController.buyBook(1, 1);
    }

    @Test
    public void testBuySomeBook() {
        Integer bookId = 1;
        bookController.buyBook(bookId, 1);
    }
}
