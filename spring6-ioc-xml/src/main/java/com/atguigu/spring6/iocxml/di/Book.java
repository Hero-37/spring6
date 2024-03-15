package com.atguigu.spring6.iocxml.di;

public class Book {

    private String bname;

    private String author;

    public Book() {

    }

    public Book(String bname, String author) {
        this.bname = bname;
        this.author = author;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Book book = new Book();

        // set 方法注入
        book.setBname("java");
        book.setAuthor("Hero");

        // 构造器注入
        Book book1 = new Book("C++", "Hero");
    }
}
