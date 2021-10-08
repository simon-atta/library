package com.crossover.controllers.home;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Home Controller Test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HomeController.class)
@WebAppConfiguration
public class HomeControllerTest {

    @InjectMocks
    private HomeController homeController;

    private static String INDEX_VIEW = "index/home";
    private static String LIBRARY_URL = "/library";
    private static String HOME_URL = "/home";

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }

    @Test
    public void testGetLibraryView() throws Exception {
        mockMvc.perform(get(LIBRARY_URL)).andExpect(view().name(INDEX_VIEW));
    }

    @Test
    public void testGetHomeView() throws Exception {
        mockMvc.perform(get(HOME_URL)).andExpect(redirectedUrl(LIBRARY_URL));
    }

}
