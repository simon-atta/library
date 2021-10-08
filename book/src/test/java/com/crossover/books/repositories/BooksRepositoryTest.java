package com.crossover.books.repositories;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.BooksApplication;
import com.crossover.books.model.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BooksApplication.class)
@WebAppConfiguration
public class BooksRepositoryTest {

    @Autowired
    private BooksRepository booksRepository;

    @Before
    public void setUp() throws Exception {
        booksRepository.save(createNewBook());
    }

    @Test
    public void testFindByTitleLike() {

        List<Book> books = booksRepository.findByTitleLike("Ecclesiastical");
        Assert.assertEquals(books.size(), 2);

    }

    @Test
    public void testFindByPublisher() {

        List<Book> books = booksRepository.findByPublisher("simon");
        Assert.assertEquals(books.size(), 3);

    }

    private List<Book> createNewBook() {

        List<Book> books = new ArrayList<Book>();
        Book book = new Book();
        book.setTitle("The Ecclesiastical Organisation of the Church of the East, 1318-1913");
        book.setPublisher("simon");
        book.setDescription("desc");

        Book book1 = new Book();
        book1.setTitle("The Fifth Discipline");
        book1.setPublisher("simon");
        book1.setDescription("desc");

        Book book2 = new Book();
        book2.setTitle("The Beauty of the Infinite");
        book2.setPublisher("simon");
        book2.setDescription("desc");
        books.add(book);
        books.add(book1);
        books.add(book2);
        return books;
    }

}