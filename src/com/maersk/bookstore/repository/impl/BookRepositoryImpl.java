package com.maersk.bookstore.repository.impl;

import com.maersk.bookstore.entity.BookEntity;
import com.maersk.bookstore.repository.BookRepository;
import com.maersk.bookstore.serdeser.BookSerializer;
import com.maersk.bookstore.service.impl.BookServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    /*private List<BookEntity> booksList;
    public BookRepositoryImpl(){
        this.booksList = new ArrayList<>();
    }*/

    @Override
    public Long add(BookEntity bookEntity) throws IOException {
        BookSerializer.serializeBook(bookEntity);
        return bookEntity.getBookId();
    }

    @Override
    public BookEntity getDetail(Long bookId) throws IOException {
        BookEntity be = BookSerializer.deSerializeBook(bookId);
        return be;
    }
}
