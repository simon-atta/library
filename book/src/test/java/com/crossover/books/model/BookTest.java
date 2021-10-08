package com.crossover.books.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Simon Ghobreil.
 */
public class BookTest {

    /**
     * Test method for {@link com.crossover.books.model.Book#getTitle()}.
     */
    @Test
    public void testGetTitle() {

        Book book = new Book();
        book.setTitle("Title");

        Assert.assertEquals(book.getTitle(), "Title");
    }

    /**
     * Test method for
     * {@link com.crossover.books.model.Book#setTitle(java.lang.String)}.
     */
    @Test
    public void testSetTitle() {
        Book book = new Book();
        book.setTitle("Title");

        Assert.assertEquals(book.getTitle(), "Title");
    }

    /**
     * Test method for {@link com.crossover.books.model.Book#getPublisher()}.
     */
    @Test
    public void testGetPublisher() {
        Book book = new Book();
        book.setPublisher("simon");

        Assert.assertEquals(book.getPublisher(), "simon");
    }

    /**
     * Test method for
     * {@link com.crossover.books.model.Book#setPublisher(java.lang.String)}.
     */
    @Test
    public void testSetPublisher() {
        Book book = new Book();
        book.setPublisher("simon");

        Assert.assertEquals(book.getPublisher(), "simon");
    }

    /**
     * Test method for {@link com.crossover.books.model.Book#getDescription()}.
     */
    @Test
    public void testGetDescription() {
        Book book = new Book();
        book.setDescription("desc");

        Assert.assertEquals(book.getDescription(), "desc");
    }

    /**
     * Test method for
     * {@link com.crossover.books.model.Book#setDescription(java.lang.String)}.
     */
    @Test
    public void testSetDescription() {
        Book book = new Book();
        book.setDescription("desc");

        Assert.assertEquals(book.getDescription(), "desc");
    }

}
