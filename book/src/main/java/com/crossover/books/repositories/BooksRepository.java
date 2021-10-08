package com.crossover.books.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.crossover.books.model.Book;

/**
 * Book repository have all methods to deal with mongo db.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestResource
public interface BooksRepository extends MongoRepository<Book, String> {

    /**
     * Find books by title. This method use like operation to find all books
     * with
     * same title.
     *
     * @param title
     *        String
     * @return list of books match searching title.
     */
    List<Book> findByTitleLike(@Param("title") String title);

    /**
     * Find books by publisher name.
     *
     * @param publisher
     *        String
     * @return list of books match searching publisher name.
     */
    List<Book> findByPublisher(@Param("publisher") String publisher);
}
