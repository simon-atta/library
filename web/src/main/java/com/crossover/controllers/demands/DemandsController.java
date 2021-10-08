package com.crossover.controllers.demands;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crossover.services.demands.IDemandsService;
import com.crossover.util.SecurityUtil;

import io.swagger.client.ApiException;

/**
 * Demands controller handle Add and View all user demands.
 *
 * @author Simon Ghobreil
 */
@Controller
public class DemandsController {

    private Logger logger = Logger.getLogger(DemandsController.class);

    private static String DEMANDS_VIEW = "demands/demands_table";

    @Autowired
    private IDemandsService iDemandsService;

    /**
     * Add Book Demands will be responsible for adding demand of specific user.
     *
     * @param title
     *        String
     * @param request
     *        HttpServletRequest
     * @param model
     *        Model
     * @return demands view has all user demands.
     */
    @RequestMapping(value = "/demands/submit/", method = RequestMethod.GET)
    public String addBookDemands(@RequestParam("title") String title, HttpServletRequest request, Model model) {

        logger.debug("DemandsController - addBookDemands BEGIN");

        try {
            model.addAttribute("demands", iDemandsService.registerNewDemand(title, SecurityUtil.getUserName(request)));
        } catch (ApiException e) {
            logger.error("Something went wrong", e);
            model.addAttribute("error", "Something went wrong, please try again later!");
        } catch (Exception e) {
            logger.error("Something went wrong", e);
            model.addAttribute("error", "Something went wrong, please try again later!");
        }

        logger.debug("DemandsController - addBookDemands End");

        return "redirect:/demands/view/";
    }

    /**
     * View Books Demands will be responsible for view all user demands.
     *
     * @param request
     *        HttpServletRequest
     * @param model
     *        Model
     * @return demands view has all user demands.
     */
    @RequestMapping(value = "/demands/view/", method = RequestMethod.GET)
    public String viewBooksDemands(HttpServletRequest request, Model model) {

        logger.debug("DemandsController - viewBooksDemands BEGIN");

        try {
            model.addAttribute("demands", iDemandsService.getUserDemands(SecurityUtil.getUserName(request)));
        } catch (ApiException e) {
            logger.error("Something went wrong", e);
            model.addAttribute("error", "Something went wrong, please try again later!");
        } catch (Exception e) {
            logger.error("Something went wrong", e);
            model.addAttribute("error", "There is no demands for you!");
        }

        logger.debug("DemandsController - viewBooksDemands End");

        return DEMANDS_VIEW;
    }
}
