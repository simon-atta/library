package com.crossover.services;

import io.swagger.client.ApiException;
import io.swagger.client.api.BooksendpointApi;
import io.swagger.client.api.DemandsendpointApi;
import io.swagger.client.api.UsersendpointApi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.CrossoverWebApplication;
import com.crossover.config.RestClientConfig;

/**
 * Home Controller Test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrossoverWebApplication.class)
@WebAppConfiguration
public class EndPointsFactoryTest {

    @InjectMocks
    private EndPointsFactory factory;

    @Mock
    private RestClientConfig restClient;

    @Mock
    private UsersendpointApi usersendpointApi;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserEndPointApi() throws ApiException {
        UsersendpointApi usersendpointApi = factory.getUserEndPointApi();

        Assert.assertNotNull(usersendpointApi);
    }

    @Test
    public void testGetBooksendpointApi() throws ApiException {
        BooksendpointApi booksendpointApi = factory.getBooksendpointApi();

        Assert.assertNotNull(booksendpointApi);
    }

    @Test
    public void testGetDemandsendpointApi() throws ApiException {
        DemandsendpointApi demandsendpointApi = factory.getDemandsendpointApi();

        Assert.assertNotNull(demandsendpointApi);
    }

}
