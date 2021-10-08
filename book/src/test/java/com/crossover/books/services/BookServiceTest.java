package com.crossover.books.services;

import static org.mockito.Mockito.when;

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

import com.BooksApplication;
import com.crossover.books.model.Book;
import com.crossover.books.repositories.BooksRepository;

/**
 * Home Controller Test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BooksApplication.class)
@WebAppConfiguration
public class BookServiceTest {

    @InjectMocks
    private BooksService bookService;

    @Mock
    private BooksRepository booksRepo;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetBookByTitle() {
        when(booksRepo.findByTitleLike(Mockito.anyString())).thenReturn(getRedundantBookResults());
        List<Book> books = bookService.getBookByTitle("title");
        Assert.assertEquals(books.size(), 1);
    }

    @Test
    public void testGetAllBooks() {
        when(booksRepo.findAll()).thenReturn(getRedundantBookResults());
        List<Book> books = bookService.getAllBooks();
        Assert.assertEquals(books.size(), 2);
    }

    @Test
    public void testGetPublisherBooks() {
        when(booksRepo.findByPublisher(Mockito.anyString())).thenReturn(getRedundantBookResults());
        List<Book> books = bookService.getPublisherBooks("title");
        Assert.assertEquals(books.size(), 1);
    }

    private List<Book> getRedundantBookResults() {

        List<Book> books = new ArrayList<Book>();
        Book book = new Book();
        book.setTitle("The Ecclesiastical Organisation of the Church of the East, 1318-1913");
        book.setPublisher("simon");
        book.setDescription("desc");
        Book book2 = new Book();
        book2.setTitle("The Ecclesiastical Organisation of the Church of the East, 1318-1913");
        book2.setPublisher("simon");
        book2.setDescription("desc");
        books.add(book);
        books.add(book2);
        return books;
    }

}
