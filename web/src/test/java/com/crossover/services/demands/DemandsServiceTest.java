package com.crossover.services.demands;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
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

import com.CrossoverWebApplication;
import com.crossover.config.RestClientConfig;
import com.crossover.services.EndPointsFactory;

import io.swagger.client.ApiException;
import io.swagger.client.api.DemandsendpointApi;
import io.swagger.client.model.Demand;
import io.swagger.client.model.Demand.StatusEnum;

/**
 * Home Controller Test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrossoverWebApplication.class)
@WebAppConfiguration
public class DemandsServiceTest {

    @InjectMocks
    private DemandsService demandsService;

    @Mock
    private DemandsendpointApi demandsendpointApi;

    @Mock
    private RestClientConfig restClient;

    @Mock
    private EndPointsFactory endPointsFactory;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserDemands() throws ApiException {
        when(endPointsFactory.getDemandsendpointApi()).thenReturn(demandsendpointApi);
        when(demandsendpointApi.getAllUserDemandsUsingGET(Mockito.anyObject())).thenReturn(getUserDemands());
        when(demandsendpointApi.addNewDemandUsingPOST(Mockito.anyObject())).thenReturn(new Demand());

        List<Demand> demands = demandsService.getUserDemands("");
        Assert.assertEquals(demands.size(), 1);
    }

    @Test
    public void testRegisterNewDemand() throws ApiException {
        when(endPointsFactory.getDemandsendpointApi()).thenReturn(demandsendpointApi);
        when(demandsendpointApi.getAllUserDemandsUsingGET(Mockito.anyObject())).thenReturn(getUserDemands());
        when(demandsendpointApi.addNewDemandUsingPOST(Mockito.anyObject())).thenReturn(new Demand());

        List<Demand> demands = demandsService.registerNewDemand("", "");
        Assert.assertEquals(demands.size(), 1);
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
