package com.crossover.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component("authenticationFailureHandler")
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(final HttpServletRequest request, final HttpServletResponse response,
            final AuthenticationException exception) throws IOException, ServletException {

        String errorCode = null;

        setDefaultFailureUrl("/login");

        super.onAuthenticationFailure(request, response, exception);

        if (exception.getMessage().equalsIgnoreCase("User is disabled")) {
            errorCode = "user.disabled";
        } else if (exception.getMessage().equalsIgnoreCase("blocked")) {
            errorCode = "user.block";
        } else if (exception.getMessage().equalsIgnoreCase("java.net.ConnectException: Connection refused: connect")) {
            errorCode = "user.connection.refused";
        } else if (exception.getMessage().equalsIgnoreCase("Invaild Customer")) {
            errorCode = "user.invalidUser";
        } else if (exception.getMessage().equalsIgnoreCase(
                "A message body reader for Java class io.swagger.client.model.UserAccount, and Java type class io.swagger.client.model.UserAccount, and MIME media type application/octet-stream was not found")) {
            errorCode = "user.credentials";
        }

        request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, errorCode);
    }
}