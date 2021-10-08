package com.crossover.services.books;

import io.swagger.client.ApiException;
import io.swagger.client.model.Book;

import java.util.List;

/**
 * Book Service interface.
 *
 * @author Simon Ghobreil.
 */
public interface IBookService {

    /**
     * This method will handle search for book by title.
     *
     * @param bookTitle
     * @return list of books.
     * @throws ApiException
     */
    List<Book> searchForBook(String bookTitle) throws Exception;

    /**
     * This method will handle search for book by publisher.
     *
     * @param publisherName
     * @return list of books.
     * @throws ApiException
     */
    List<Book> searchByPublisher(String publisherName) throws Exception;

}
