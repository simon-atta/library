package com.crossover.util;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.crossover.controllers.home.HomeController;
import com.crossover.model.CurrentUser;

import io.swagger.client.model.UserAccount;
import io.swagger.client.model.UserAccount.RolesEnum;

/**
 * Home Controller Test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HomeController.class)
@WebAppConfiguration
public class SecurityUtilTest {

    @Autowired
    private MockHttpServletRequest request;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserName() throws Exception {
        initializeUser();
        SecurityUtil.getUserName(request);
    }

    private void initializeUser() {
        CurrentUser user = new CurrentUser(getUserAccount());
        /* fill user object */

        Authentication auth = new UsernamePasswordAuthenticationToken(user, null);

        SecurityContextHolder.getContext().setAuthentication(auth);

        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
    }

    private UserAccount getUserAccount() {

        UserAccount account = new UserAccount();
        account.setEmail("semonsamir@gmail.com");
        account.setEnabled(true);
        account.setFullname("simon samir");
        account.setPassword("test1234");
        account.setRoles(RolesEnum.USER);
        account.setStatus("New");
        account.setUsername("simon");
        return account;
    }

}
