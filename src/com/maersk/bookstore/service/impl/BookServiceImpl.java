package com.maersk.bookstore.service.impl;

import com.maersk.bookstore.converter.BookConverter;
import com.maersk.bookstore.dto.BookDTO;
import com.maersk.bookstore.entity.BookEntity;
import com.maersk.bookstore.repository.BookRepository;
import com.maersk.bookstore.repository.impl.BookRepositoryImpl;
import com.maersk.bookstore.service.BookService;

import java.io.IOException;

public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(){
        this.bookRepository = new BookRepositoryImpl();
    }

    @Override
    public Long add(BookDTO bookDTO) throws IOException {
        //convert the DTO to repository compatible entity class
        //adapter design pattern
        BookEntity bookEntity = BookConverter.convertBookDTOtoBookEntity(bookDTO);
        return this.bookRepository.add(bookEntity);
    }

    @Override
    public BookDTO getBook(Long bookId) throws IOException {
        // First, fetch the BookEntity using the bookId
        BookEntity bookEntity = this.bookRepository.getDetail(bookId);

        // Now convert the BookEntity to BookDTO
        BookDTO bookDTO = BookConverter.convertBookEntitytoBookDTO(bookEntity);  // pass the entity, not the ID

        return bookDTO;
    }
}
