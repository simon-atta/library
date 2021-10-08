package com.crossover.profile.endpoints;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ProfileApplication;
import com.crossover.profile.model.Demand;
import com.crossover.profile.model.DemandStatus;
import com.crossover.profile.services.IDemandsService;
import com.google.gson.Gson;

/**
 * Demands end point test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProfileApplication.class)
@WebAppConfiguration
public class DemandsEndPointTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @InjectMocks
    private DemandsEndPoint demandsEndPoint;

    @Mock
    private IDemandsService demandsService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(demandsEndPoint).build();
    }

    /**
     * Test method for
     * {@link com.crossover.profile.endpoints.DemandsEndPoint#addNewDemand(com.crossover.profile.model.Demand)
     *
     * @throws Exception
     */
    @Test
    public void testAddNewDemand() throws Exception {

        doNothing().when(demandsService).addNewDemand(any(Demand.class));
        Gson gson = new Gson();
        String json = gson.toJson(createNewDemand());

        mockMvc.perform(post("/api/demands/addNewDemand").content(json).contentType(contentType))
                .andExpect(status().isCreated());

    }

    /**
     * Test method for
     * {@link com.crossover.profile.endpoints.DemandsEndPoint#addNewDemand(com.crossover.profile.model.Demand)
     *
     * @throws Exception
     */
    @Test
    public void testAddNewDemandFail() throws Exception {

        doThrow(Exception.class).when(demandsService).addNewDemand(any(Demand.class));
        Gson gson = new Gson();
        String json = gson.toJson(createNewDemand());

        mockMvc.perform(post("/api/demands/addNewDemand").content(json).contentType(contentType))
                .andExpect(status().isInternalServerError());

    }

    /**
     * Test method for
     * {@link com.crossover.profile.endpoints.DemandsEndPoint#getAllUserDemands(String)
     *
     * @throws Exception
     */
    @Test
    public void testGetAllUserDemands() throws Exception {
        when(demandsService.getUserDemands(Mockito.anyString())).thenReturn(getDemandsList());

        mockMvc.perform(get("/api/demands/getAllUserDemands").param("username", "test")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].bookName").value("The Beauty of the Infinite"));

    }

    /**
     * Test method for
     * {@link com.crossover.profile.endpoints.DemandsEndPoint#getAllUserDemands(String)
     *
     * @throws Exception
     */
    @Test
    public void testGetAllUserDemandsEmpty() throws Exception {
        mockMvc.perform(get("/api/demands/getAllUserDemands").param("username", "")).andExpect(status().isNoContent());
    }

    /**
     * Test method for
     * {@link com.crossover.profile.endpoints.DemandsEndPoint#getAllUserDemands(String)
     *
     * @throws Exception
     */
    @Test
    public void testGetAllUserDemandsFail() throws Exception {
        when(demandsService.getUserDemands(Mockito.anyString())).thenThrow(new Exception("internal error"));

        mockMvc.perform(get("/api/demands/getAllUserDemands").param("username", "test"))
                .andExpect(status().isInternalServerError());
    }

    private Demand createNewDemand() {
        Demand demand = new Demand("The Beauty of the Infinite", DemandStatus.NEW, "simon");
        return demand;
    }

    private List<Demand> getDemandsList() {

        List<Demand> demands = new ArrayList<>();
        demands.add(new Demand("The Beauty of the Infinite", DemandStatus.NEW, "simon"));
        demands.add(new Demand("The Beauty of the Infinite2", DemandStatus.NEW, "simon"));

        return demands;
    }

}
