package com.crossover.controllers.profile;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This controller handle login requests.
 *
 * @author Simon Ghobreil
 */
@Controller
public class LoginController {

    private Logger logger = Logger.getLogger(LoginController.class);

    private static String LOGIN_VIEW = "profile/login";

    /**
     * This method will login view.
     *
     * @return login view.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(@RequestParam(name = "error", required = false) String error, Model model) {
        logger.debug("LoginController - getLoginPage BEGIN");
        if (error != null) model.addAttribute("error", true);
        return LOGIN_VIEW;
    }

}
