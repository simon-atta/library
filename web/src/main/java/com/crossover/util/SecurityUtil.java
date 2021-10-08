package com.crossover.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Component;

import com.crossover.model.CurrentUser;

/**
 * This is utility class for get user info from spring framework after begging
 * logged in.
 *
 * @author Simon Ghobreil.
 */
@Component
public class SecurityUtil {

    /**
     * This method take HTTP request and extract user name from spring security
     * framework.
     * 
     * @param request
     *        HttpServletRequest
     * @return user name.
     */
    public static String getUserName(HttpServletRequest request) {

        HttpSession session = request.getSession();
        SecurityContext ctx = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");

        Authentication auth = ctx.getAuthentication();
        CurrentUser currentUser = (CurrentUser) auth.getPrincipal();

        return currentUser.getUsername();
    }

}
