package com.maersk.bookstore.testing;

import com.maersk.bookstore.controller.BookController;
import com.maersk.bookstore.dto.BookDTO;

import java.io.IOException;

public class BookClient {
    public static void main(String[] args) throws IOException {
        BookController controller = new BookController();
        //call the addBook functionality
        addBook(controller);

        //call the getBookDetail functionality
        getBook(controller, 111L);
    }
    private static void getBook(BookController controller, Long bookId) throws IOException {
        BookDTO bookDTO = controller.getBook(bookId);
        System.out.println("Following are details for book with ID: "+bookId);
        System.out.println("Book name: "+bookDTO.getName());
        System.out.println("Book author: "+bookDTO.getAuthorName());
        System.out.println("Book price: "+bookDTO.getPricePerQty());
    }

    private static void addBook(BookController controller) throws IOException {
        //create BookDTO and call the controller add book method
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookId(111L);
        bookDTO.setAuthorEmail("author@gmail.com");
        bookDTO.setAuthorName("Author Aanchal");
        bookDTO.setAvailableQty(10);
        bookDTO.setName("Book One");
        bookDTO.setDescription("Book one description");
        bookDTO.setPricePerQty(19.95);

        //call controller add method and hold the return value
        Long bookId = controller.add(bookDTO);

        if(bookId!=null) {
            System.out.println("Book was successfully created with Id: " + bookId);
        } else{
            System.out.println("Some error occurred while creating new book.");
        }
    }
}
