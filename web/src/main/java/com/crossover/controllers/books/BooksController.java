package com.crossover.controllers.books;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crossover.services.books.IBookService;

import io.swagger.client.ApiException;

/**
 * Books controller handle book search by book title and by publisher.
 *
 * @author Simon Ghobreil
 */
@Controller
public class BooksController {

    private Logger logger = Logger.getLogger(BooksController.class);

    private static String SEARCH_VIEW = "books/book_search";
    private static String PUBLISHER_VIEW = "books/publisher_search";

    @Autowired
    private IBookService bookService;

    /**
     * Get book search landing page.
     *
     * @return book search view.
     */
    @RequestMapping(value = "/booksearch", method = RequestMethod.GET)
    public String getBookSearchView() {
        logger.debug("BooksController - getBookSearchView BEGIN");
        return SEARCH_VIEW;
    }

    /**
     * This method responsible to handle all requests for book search by title
     *
     * @param bookTitle
     *        String
     * @param model
     *        Model
     * @return search view page has all results.
     */
    @RequestMapping(value = "/searchforbook", method = RequestMethod.GET)
    public String searchForBook(@RequestParam("bookname") String bookTitle, Model model) {
        logger.debug("BooksController - searchForBook BEGIN");
        try {
            model.addAttribute("results", bookService.searchForBook(bookTitle));
        } catch (ApiException e) {
            logger.error("Something went wrong", e);
            model.addAttribute("error", "Something went wrong, please try again later!");
        } catch (Exception e) {
            logger.error("Something went wrong", e);
            model.addAttribute("error", "There is no results matchs this key word!");
        }

        logger.debug("BooksController - searchForBook END");
        return SEARCH_VIEW;
    }

    /**
     * Get publisher search view landing page.
     *
     * @return search by publisher view.
     */
    @RequestMapping(value = "/publishersearch", method = RequestMethod.GET)
    public String getPublisherSearchView() {
        return PUBLISHER_VIEW;
    }

    /**
     * This method responsible to handle all requests for book search by
     * publisher
     *
     * @param publisherName
     *        String
     * @param model
     *        Model
     * @return search view page has all results.
     */
    @RequestMapping(value = "/searchbypublisher", method = RequestMethod.GET)
    public String searchByPublisher(@RequestParam("publishername") String publisherName, Model model) {

        logger.debug("BooksController - searchByPublisher BEGIN");

        try {
            model.addAttribute("results", bookService.searchByPublisher(publisherName));
        } catch (ApiException e) {
            logger.error("Something went wrong", e);
            model.addAttribute("error", "Something went wrong, please try again later!");
        } catch (Exception e) {
            logger.error("Something went wrong", e);
            model.addAttribute("error", "There is no results matchs this key word!");
        }
        logger.debug("BooksController - searchByPublisher END");

        return PUBLISHER_VIEW;
    }
}
