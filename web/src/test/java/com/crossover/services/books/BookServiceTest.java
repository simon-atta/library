package com.crossover.services.books;

import static org.mockito.Mockito.when;
import io.swagger.client.ApiException;
import io.swagger.client.api.BooksendpointApi;
import io.swagger.client.model.Book;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.CrossoverWebApplication;
import com.crossover.config.RestClientConfig;
import com.crossover.services.EndPointsFactory;

/**
 * Home Controller Test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrossoverWebApplication.class)
@WebAppConfiguration
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private RestClientConfig restClient;

    @Mock
    private EndPointsFactory endPointsFactory;

    @Mock
    private BooksendpointApi booksendpointApi;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSearchForBook() throws ApiException {
        when(endPointsFactory.getBooksendpointApi()).thenReturn(booksendpointApi);
        when(booksendpointApi.getBookByTitleUsingGET(Mockito.anyString())).thenReturn(getBookResults());
        List<Book> books = bookService.searchForBook("test");
        Assert.assertEquals(books.size(), 1);
    }

    @Test
    public void testSearchByPublisher() throws ApiException {
        when(endPointsFactory.getBooksendpointApi()).thenReturn(booksendpointApi);
        when(booksendpointApi.getPublisherBooksUsingGET(Mockito.anyString())).thenReturn(getBookResults());
        List<Book> books = bookService.searchByPublisher("test");
        Assert.assertEquals(books.size(), 1);
    }

    private List<Book> getBookResults() {

        List<Book> books = new ArrayList<Book>();
        Book book = new Book();
        book.setTitle("test1");
        book.setPublisher("simon");
        book.setDescription("desc");
        books.add(book);
        return books;
    }

}
