package com.crossover.books.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.crossover.books.model.Book;
import com.crossover.books.repositories.BooksRepository;

/**
 * This is concrete implementation of {@link IBooksService}
 *
 * @author Simon Ghobreil.
 */
@Service
public class BooksService implements IBooksService {

    @Autowired
    private BooksRepository booksRepo;

    /**
     * (non-Javadoc)
     *
     * @see com.crossover.books.services.IBooksService#getBookByTitle(String)
     */
    @Override
    public List<Book> getBookByTitle(String booktitle) {

        List<Book> list = booksRepo.findByTitleLike(booktitle);
        Assert.notEmpty(list, "There is no results for this book title");

        Map<String, Book> map = new HashMap<>();
        for (Book i : list)
            map.put(i.getTitle(), i);

        List<Book> values = new ArrayList<>(map.values());

        return values;

    }

    /**
     * (non-Javadoc)
     *
     * @see com.crossover.books.services.IBooksService#getAllBooks()
     */
    @Override
    public List<Book> getAllBooks() {
        List<Book> list = booksRepo.findAll();
        Assert.notEmpty(list, "There is no results");

        return list;
    }

    /**
     * (non-Javadoc)
     *
     * @see com.crossover.books.services.IBooksService#getPublisherBooks(String)
     */
    @Override
    public List<Book> getPublisherBooks(String publisher) {

        List<Book> list = booksRepo.findByPublisher(publisher);
        Assert.notEmpty(list, "There is no results for this book title");

        Map<String, Book> map = new HashMap<>();
        for (Book i : list)
            map.put(i.getTitle(), i);

        List<Book> values = new ArrayList<>(map.values());

        return values;

    }
}
