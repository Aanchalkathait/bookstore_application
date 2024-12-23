package com.maersk.bookstore.service;

import com.maersk.bookstore.dto.BookDTO;

import java.io.IOException;

public interface BookService {
    public Long add(BookDTO bookDTO) throws IOException;
    public BookDTO getBook(Long bookId) throws IOException;
}
