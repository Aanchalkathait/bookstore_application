package com.maersk.bookstore.controller;

import com.maersk.bookstore.dto.BookDTO;
import com.maersk.bookstore.service.BookService;
import com.maersk.bookstore.service.impl.BookServiceImpl;

import java.io.IOException;

public class BookController {

    private BookService bookService;

    public BookController(){
        //dynamic/runtime polymorphism
        this.bookService = new BookServiceImpl();
    }

    public Long add(BookDTO bookDTO) throws IOException {
        //call to the service layer add method
        return this.bookService.add(bookDTO);
    }

    public BookDTO getBook(Long bookId) throws IOException {
        //call the service layer get book method and return the book dto object
        return this.bookService.getBook(bookId);
    }
}
