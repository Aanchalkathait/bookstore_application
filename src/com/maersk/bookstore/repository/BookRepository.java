package com.maersk.bookstore.repository;

import com.maersk.bookstore.entity.BookEntity;
import com.maersk.bookstore.serdeser.BookSerializer;

import java.io.IOException;

public interface BookRepository {

    public default Long add(BookEntity bookEntity) throws IOException{
        BookSerializer.serializeBook(bookEntity);
        return bookEntity.getBookId();
    }


    public default BookEntity getDetail(Long bookId) throws IOException {
        return null;
    }
}
