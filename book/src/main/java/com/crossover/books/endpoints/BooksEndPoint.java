package com.crossover.books.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossover.books.model.Book;
import com.crossover.books.services.IBooksService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Books end point has all exposed services for books API.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/api/books")
@Api(value = "BooksEndPoint", produces = "application/json")
@Configuration
public class BooksEndPoint {

    @Autowired
    private IBooksService booksService;

    /**
     * Get book by title.
     * <p>
     * if parameter is empty will return all books available in database.
     * <p>
     * if return list is empty will return HTTP response code 204 mean there is
     * no content.
     *
     * @param booktitle
     *        String
     * @return ResponseEntity which has either results or error codes.
     */
    @ApiOperation(value = "Get book by title")
    @ApiResponses(value = { @ApiResponse(code = 204, message = "There is no results for this book title"),
            @ApiResponse(code = 500, message = "Somthing went wrong!") })
    @RequestMapping(method = RequestMethod.GET, path = "/getBookByTitle", produces = "application/json")
    public @ResponseBody ResponseEntity<List<Book>> getBookByTitle(
            @RequestParam(value = "booktitle") String booktitle) {
        try {
            return new ResponseEntity<>(booksService.getBookByTitle(booktitle), HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get book by publisher.
     * <p>
     * if parameter is empty will return all books available in database.
     * <p>
     * if return list is empty will return HTTP response code 204 mean there is
     * no content.
     *
     * @param publisher
     *        String
     * @return ResponseEntity which has either results or error codes.
     */
    @ApiOperation(value = "Get publisher books")
    @ApiResponses(value = { @ApiResponse(code = 204, message = "There is no results"),
            @ApiResponse(code = 500, message = "Somthing went wrong!") })
    @RequestMapping(method = RequestMethod.GET, path = "/getPublisherBooks", produces = "application/json")
    public @ResponseBody ResponseEntity<List<Book>> getPublisherBooks(
            @RequestParam(value = "publisher") String publisher) {

        try {
            return new ResponseEntity<>(booksService.getPublisherBooks(publisher), HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Get all books available in database.
     * <p>
     * if return list is empty will return HTTP response code 204 mean there is
     * no content.
     *
     * @return ResponseEntity which has either results or error codes.
     */
    @ApiOperation(value = "Get all books")
    @ApiResponses(value = { @ApiResponse(code = 204, message = "There is no results for this book publisher"),
            @ApiResponse(code = 500, message = "Somthing went wrong!") })
    @RequestMapping(method = RequestMethod.GET, path = "/getAllBooks", produces = "application/json")
    public @ResponseBody ResponseEntity<List<Book>> getAllBooks() {

        try {
            return new ResponseEntity<>(booksService.getAllBooks(), HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
