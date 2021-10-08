package com.crossover.controllers.profile;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crossover.services.profile.IProfileService;

import io.swagger.client.ApiException;

/**
 * This controller handle sign up users.
 *
 * @author Simon Ghobreil
 */
@Controller
public class SignupController {

    private Logger logger = Logger.getLogger(SignupController.class);

    @Autowired
    private IProfileService profileService;

    private static String SIGNUP_VIEW = "profile/signup";

    /**
     * This method will login view.
     *
     * @return login view.
     */
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String getSignupPage() {
        logger.debug("SignupController - getSignupPage BEGIN");
        return SIGNUP_VIEW;
    }

    /**
     * This method will handle user's sign up.
     * if request successfully will be redirect to login page. if request fails
     * will return to
     *
     * @param fullname
     * @param email
     * @param password
     * @param username
     * @return
     */
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String createNewUser(@RequestParam("fullname") String fullname, @RequestParam("email") String email,
            @RequestParam("password") String password, @RequestParam("username") String username, Model model) {

        logger.debug("SignupController - createNewUser BEGIN");

        try {
            profileService.createNewUser(fullname, email, password, username);
        } catch (ApiException e) {
            e.printStackTrace();
            model.addAttribute("error", e.getCode());
            return SIGNUP_VIEW;
        }

        return "redirect:/login";
    }
}
