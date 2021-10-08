package com.crossover.controllers.books;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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

import com.CrossoverWebApplication;
import com.crossover.services.books.IBookService;

import io.swagger.client.ApiException;
import io.swagger.client.model.Book;

/**
 * Home Controller Test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrossoverWebApplication.class)
@WebAppConfiguration
public class BooksControllerTest {

    @InjectMocks
    private BooksController booksController;

    @Mock
    private IBookService bookService;

    private static String SEARCH_VIEW = "books/book_search";
    private static String PUBLISHER_VIEW = "books/publisher_search";
    private static String BOOKSEARCH_URL = "/booksearch";
    private static String PUBLISHER_URL = "/publishersearch";

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(booksController).build();
    }

    @Test
    public void testGetBookSearchView() throws Exception {
        mockMvc.perform(get(BOOKSEARCH_URL)).andExpect(view().name(SEARCH_VIEW));
    }

    @Test
    public void testSearchForBook_Success() throws Exception {

        when(bookService.searchForBook(Mockito.anyString())).thenReturn(getBookResults());

        mockMvc.perform(get("/searchforbook").param("bookname", ""))
                .andExpect(model().attribute("results", getBookResults())).andExpect(view().name(SEARCH_VIEW));
    }

    @Test
    public void testSearchForBook_Fails_ApiException() throws Exception {

        when(bookService.searchForBook(Mockito.anyString())).thenThrow(new ApiException("internal error"));

        mockMvc.perform(get("/searchforbook").param("bookname", ""))
                .andExpect(model().attribute("error", "Something went wrong, please try again later!"))
                .andExpect(view().name(SEARCH_VIEW));
    }

    @Test
    public void testSearchForBook_Fails_GeneralException() throws Exception {

        when(bookService.searchForBook(Mockito.anyString())).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/searchforbook").param("bookname", ""))
                .andExpect(model().attribute("error", "There is no results matchs this key word!"))
                .andExpect(view().name(SEARCH_VIEW));
    }

    @Test
    public void testGetPublisherSearchView() throws Exception {
        mockMvc.perform(get(PUBLISHER_URL)).andExpect(view().name(PUBLISHER_VIEW));
    }

    @Test
    public void testSearchByPublisher_Success() throws Exception {

        when(bookService.searchByPublisher(Mockito.anyString())).thenReturn(getBookResults());

        mockMvc.perform(get("/searchbypublisher").param("publishername", ""))
                .andExpect(model().attribute("results", getBookResults())).andExpect(view().name(PUBLISHER_VIEW));
    }

    @Test
    public void testSearchByPublisher_Fails_ApiException() throws Exception {

        when(bookService.searchByPublisher(Mockito.anyString())).thenThrow(new ApiException("internal error"));

        mockMvc.perform(get("/searchbypublisher").param("publishername", ""))
                .andExpect(model().attribute("error", "Something went wrong, please try again later!"))
                .andExpect(view().name(PUBLISHER_VIEW));
    }

    @Test
    public void testSearchByPublisher_Fails_GeneralException() throws Exception {

        when(bookService.searchByPublisher(Mockito.anyString())).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/searchbypublisher").param("publishername", ""))
                .andExpect(model().attribute("error", "There is no results matchs this key word!"))
                .andExpect(view().name(PUBLISHER_VIEW));
    }

    private List<Book> getBookResults() {

        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setTitle("test1");
        book.setPublisher("simon");
        book.setDescription("desc");
        books.add(book);
        return books;
    }

}
