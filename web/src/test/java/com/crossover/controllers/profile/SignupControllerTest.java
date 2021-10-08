package com.crossover.controllers.profile;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.CrossoverWebApplication;
import com.crossover.services.profile.IProfileService;

import io.swagger.client.ApiException;

/**
 * Home Controller Test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrossoverWebApplication.class)
@WebAppConfiguration
public class SignupControllerTest {

    private static String SIGNUP_VIEW = "profile/signup";

    @InjectMocks
    private SignupController signupController;

    @Mock
    private IProfileService profileService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(signupController).build();
    }

    @Test
    public void testCreateNewUser_Success() throws Exception {

        when(profileService.createNewUser(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
                Mockito.anyString())).thenReturn(true);

        mockMvc.perform(
                post("/signup").param("fullname", "").param("email", "").param("password", "").param("username", ""))
                .andExpect(redirectedUrl("/login"));
    }

    @Test
    public void testCreateNewUser_Fail() throws Exception {

        when(profileService.createNewUser(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(),
                Mockito.anyString())).thenThrow(new ApiException(409, "internal error"));

        mockMvc.perform(
                post("/signup").param("fullname", "").param("email", "").param("password", "").param("username", ""))
                .andExpect(model().attribute("error", 409)).andExpect(view().name(SIGNUP_VIEW));
    }

    @Test
    public void testGetSignupPage() throws Exception {
        mockMvc.perform(get("/signup")).andExpect(view().name(SIGNUP_VIEW));
    }
}
