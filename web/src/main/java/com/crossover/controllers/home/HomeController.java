package com.crossover.controllers.home;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller handle landing page.
 *
 * @author Simon Ghobreil
 */
@Controller
public class HomeController {

    private Logger logger = Logger.getLogger(HomeController.class);

    private static String INDEX_VIEW = "index/home";

    /**
     * This method handle library landing page.
     *
     * @return library view - String.
     */
    @RequestMapping(value = "/library", method = RequestMethod.GET)
    public String getLibraryView() {
        logger.debug("HomeController - getLibraryView BEGIN");
        return INDEX_VIEW;
    }

    /**
     * This method handle home URL. Redirect to library view.
     *
     * @return library view - String.
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomeView() {
        logger.debug("HomeController - getHomeView BEGIN");
        return "redirect:/library";
    }

}
