package com.crossover.books.services;

import java.util.List;

import com.crossover.books.model.Book;

/**
 * This is contract interface for all books service methods.
 *
 * @author Simon Ghobreil.
 */
public interface IBooksService {

    /**
     * Get all books by title.
     * <p>
     * if method parameter is empty method will return all books.
     * <p>
     * if method didn't found any results match searching key word will through
     * runtime exception.
     *
     * @param booktitle
     *        String
     * @return list of books.
     */
    List<Book> getBookByTitle(String booktitle) throws Exception;

    /**
     * Get all books.
     *
     * @return list of all books.
     */
    List<Book> getAllBooks() throws Exception;

    /**
     * Get all books by publisher.
     * <p>
     * if method parameter is empty method will return all books.
     * <p>
     * if method didn't found any results match searching key word will through
     * runtime exception.
     *
     * @param publisher
     *        String
     * @return list of books.
     */
    List<Book> getPublisherBooks(String publisher) throws Exception;

}
