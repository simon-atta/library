package com.crossover.services.books;

import io.swagger.client.ApiException;
import io.swagger.client.api.BooksendpointApi;
import io.swagger.client.model.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.services.EndPointsFactory;

/**
 * This is concrete implementation of Book Service interface.
 *
 * @author Simon Ghobreil.
 */
@Service
public class BookService implements IBookService {

    @Autowired
    private EndPointsFactory endPointsFactory;

    @Override
    public List<Book> searchForBook(String bookName) throws ApiException {
        BooksendpointApi booksendpointApi = endPointsFactory.getBooksendpointApi();
        return booksendpointApi.getBookByTitleUsingGET(bookName);
    }

    @Override
    public List<Book> searchByPublisher(String publisherName) throws ApiException {
        BooksendpointApi booksendpointApi = endPointsFactory.getBooksendpointApi();
        return booksendpointApi.getPublisherBooksUsingGET(publisherName);
    }

}
