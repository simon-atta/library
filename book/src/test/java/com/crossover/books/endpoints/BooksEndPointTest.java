package com.crossover.books.endpoints;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.BooksApplication;
import com.crossover.books.model.Book;
import com.crossover.books.services.IBooksService;

/**
 * Home Controller Test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BooksApplication.class)
@WebAppConfiguration
public class BooksEndPointTest {

    @InjectMocks
    private BooksEndPoint booksEndPoint;

    @Mock
    private IBooksService booksService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(booksEndPoint).build();
    }

    /**
     * Test method for
     * {@link com.crossover.books.endpoints.BooksEndPoint#getBookByTitle(String)}.
     *
     * @throws Exception
     */
    @Test
    public void testGetBookByTitle() throws Exception {

        when(booksService.getBookByTitle(Mockito.anyString())).thenReturn(getBookResults());

        mockMvc.perform(get("/api/books/getBookByTitle").param("booktitle", Mockito.anyString()))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].title").value("The Ecclesiastical"));
    }

    /**
     * Test method for
     * {@link com.crossover.books.endpoints.BooksEndPoint#getBookByTitle(String)}.
     *
     * @throws Exception
     */
    @Test
    public void testGetBookByTitleEmptyResults() throws Exception {

        when(booksService.getBookByTitle(Mockito.anyString()))
                .thenThrow(new IllegalArgumentException("internal error"));

        mockMvc.perform(get("/api/books/getBookByTitle").param("booktitle", Mockito.anyString()))
                .andExpect(status().isNoContent());
    }

    /**
     * Test method for
     * {@link com.crossover.books.endpoints.BooksEndPoint#getBookByTitle(String)}.
     *
     * @throws Exception
     */
    @Test
    public void testGetBookByTitleInternalServerError() throws Exception {

        when(booksService.getBookByTitle(Mockito.anyString())).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/api/books/getBookByTitle").param("booktitle", Mockito.anyString()))
                .andExpect(status().isInternalServerError());
    }

    /**
     * Test method for
     * {@link com.crossover.books.endpoints.BooksEndPoint#getPublisherBooks(String)}.
     *
     * @throws Exception
     */
    @Test
    public void testGetPublisherBooks() throws Exception {

        when(booksService.getPublisherBooks(Mockito.anyString())).thenReturn(getBookResults());

        mockMvc.perform(get("/api/books/getPublisherBooks").param("publisher", Mockito.anyString()))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].publisher").value("simon"));
    }

    /**
     * Test method for
     * {@link com.crossover.books.endpoints.BooksEndPoint#getPublisherBooks(String)}.
     *
     * @throws Exception
     */
    @Test
    public void testGetPublisherBooksInternalServerError() throws Exception {

        when(booksService.getPublisherBooks(Mockito.anyString())).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/api/books/getPublisherBooks").param("publisher", Mockito.anyString()))
                .andExpect(status().isInternalServerError());

    }

    /**
     * Test method for
     * {@link com.crossover.books.endpoints.BooksEndPoint#getPublisherBooks(String)}.
     *
     * @throws Exception
     */
    @Test
    public void testGetPublisherBooksEmptyResults() throws Exception {

        when(booksService.getPublisherBooks(Mockito.anyString()))
                .thenThrow(new IllegalArgumentException("internal error"));

        mockMvc.perform(get("/api/books/getPublisherBooks").param("publisher", Mockito.anyString()))
                .andExpect(status().isNoContent());

    }

    /**
     * Test method for
     * {@link com.crossover.books.endpoints.BooksEndPoint#getAllBooks()}.
     *
     * @throws Exception
     */
    @Test
    public void testGetAllBooks() throws Exception {

        when(booksService.getAllBooks()).thenReturn(getBookResults());

        mockMvc.perform(get("/api/books/getAllBooks")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].publisher").value("simon"))
                .andExpect(jsonPath("$[0].title").value("The Ecclesiastical"));
    }

    /**
     * Test method for
     * {@link com.crossover.books.endpoints.BooksEndPoint#getAllBooks()}.
     *
     * @throws Exception
     */
    @Test
    public void testGetAllBooksEmptyResults() throws Exception {

        when(booksService.getAllBooks()).thenThrow(new IllegalArgumentException("internal error"));

        mockMvc.perform(get("/api/books/getAllBooks")).andExpect(status().isNoContent());
    }

    /**
     * Test method for
     * {@link com.crossover.books.endpoints.BooksEndPoint#getAllBooks()}.
     *
     * @throws Exception
     */
    @Test
    public void testGetAllBooksInternalServerError() throws Exception {

        when(booksService.getAllBooks()).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/api/books/getAllBooks")).andExpect(status().isInternalServerError());
    }

    private List<Book> getBookResults() {

        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setTitle("The Ecclesiastical");
        book.setPublisher("simon");
        book.setDescription("desc");
        Book book2 = new Book();
        book2.setTitle("The Beauty of the Infinite");
        book2.setPublisher("simon");
        book2.setDescription("desc");
        books.add(book);
        books.add(book2);
        return books;
    }

}
