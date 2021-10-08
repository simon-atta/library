package com.crossover.controllers.demands;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.RequestContextFilter;

import com.CrossoverWebApplication;
import com.crossover.services.demands.IDemandsService;
import com.crossover.util.SecurityUtil;

import io.swagger.client.ApiException;
import io.swagger.client.model.Demand;
import io.swagger.client.model.Demand.StatusEnum;

/**
 * Home Controller Test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { CrossoverWebApplication.class })
@WebAppConfiguration
@PrepareForTest(value = SecurityUtil.class)
public class DemandsControllerTest {

    private static String DEMANDS_VIEW = "demands/demands_table";

    @InjectMocks
    private DemandsController demandsController;

    @Mock
    private IDemandsService demandsService;

    private MockMvc mockMvc;

    @Autowired
    private MockHttpServletRequest request;

    @Before
    public void setUp() throws Exception {

        // initializeUser();
        PowerMockito.mockStatic(SecurityUtil.class);
        PowerMockito.when(SecurityUtil.getUserName(request)).thenReturn("simon");
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(demandsController).addFilters(new RequestContextFilter())
                .build();
    }

    @Test
    public void testAddBookDemands_Success() throws Exception {

        when(demandsService.registerNewDemand(Mockito.anyString(), Mockito.anyString())).thenReturn(getUserDemands());

        mockMvc.perform(get("/demands/submit/").param("title", ""))
                .andExpect(model().attribute("demands", getUserDemands()))
                .andExpect(view().name("redirect:/demands/view/"));
    }

    @Test
    public void testAddBookDemands_Fails_ApiException() throws Exception {

        when(demandsService.registerNewDemand(Mockito.anyString(), Mockito.anyString()))
                .thenThrow(new ApiException("internal error"));

        mockMvc.perform(get("/demands/submit/").param("title", ""))
                .andExpect(model().attribute("error", "Something went wrong, please try again later!"))
                .andExpect(view().name("redirect:/demands/view/"));
    }

    @Test
    public void testAddBookDemands_Fails_Exception() throws Exception {

        when(demandsService.registerNewDemand(Mockito.anyString(), Mockito.anyString()))
                .thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/demands/submit/").param("title", ""))
                .andExpect(model().attribute("error", "Something went wrong, please try again later!"))
                .andExpect(view().name("redirect:/demands/view/"));
    }

    @Test
    public void testViewBooksDemands_Success() throws Exception {

        when(demandsService.getUserDemands(Mockito.anyString())).thenReturn(getUserDemands());

        mockMvc.perform(get("/demands/view/")).andExpect(model().attribute("demands", getUserDemands()))
                .andExpect(view().name(DEMANDS_VIEW));
    }

    @Test
    public void testViewBooksDemands_Fails_ApiException() throws Exception {

        when(demandsService.getUserDemands(Mockito.anyString())).thenThrow(new ApiException("internal error"));

        mockMvc.perform(get("/demands/view/"))
                .andExpect(model().attribute("error", "Something went wrong, please try again later!"))
                .andExpect(view().name(DEMANDS_VIEW));
    }

    @Test
    public void testViewBooksDemands_Fails_Exception() throws Exception {

        when(demandsService.getUserDemands(Mockito.anyString())).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/demands/view/")).andExpect(model().attribute("error", "There is no demands for you!"))
                .andExpect(view().name(DEMANDS_VIEW));
    }

    private List<Demand> getUserDemands() {
        List<Demand> demands = new ArrayList<>();
        Demand demand = new Demand();
        demand.setBookName("test");
        demand.setStatus(StatusEnum.NEW);
        demand.setUserName("simon");
        demands.add(demand);
        return demands;
    }

}
