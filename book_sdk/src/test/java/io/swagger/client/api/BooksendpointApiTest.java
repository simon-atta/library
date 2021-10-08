package io.swagger.client.api;

import org.junit.Ignore;
import org.junit.Test;

import io.swagger.client.ApiException;

/**
 * API tests for BooksendpointApi
 */
@Ignore
public class BooksendpointApiTest {

    private final BooksendpointApi api = new BooksendpointApi();

    /**
     * Get all books
     *
     * @throws ApiException
     *         if the Api call fails
     */
    @Test
    public void getAllBooksUsingGETTest() throws ApiException {
        // List<Book> response = api.getAllBooksUsingGET();

        // TODO: test validations
    }

    /**
     * Get book by title
     *
     * @throws ApiException
     *         if the Api call fails
     */
    @Test
    public void getBookByTitleUsingGETTest() throws ApiException {
        String booktitle = null;
        // List<Book> response = api.getBookByTitleUsingGET(booktitle);

        // TODO: test validations
    }

    /**
     * Get publisher books
     *
     * @throws ApiException
     *         if the Api call fails
     */
    @Test
    public void getPublisherBooksUsingGETTest() throws ApiException {
        String publisher = null;
        // List<Book> response = api.getPublisherBooksUsingGET(publisher);

        // TODO: test validations
    }

}
