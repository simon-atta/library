package io.swagger.client.api;

import org.junit.Ignore;
import org.junit.Test;

import io.swagger.client.ApiException;
import io.swagger.client.model.Demand;

/**
 * API tests for DemandsendpointApi
 */
@Ignore
public class DemandsendpointApiTest {

    private final DemandsendpointApi api = new DemandsendpointApi();

    /**
     * ِAdd new demand
     *
     * @throws ApiException
     *         if the Api call fails
     */
    @Test
    public void addNewDemandUsingPOSTTest() throws ApiException {
        Demand demand = null;
        // Demand response = api.addNewDemandUsingPOST(demand);

        // TODO: test validations
    }

    /**
     * Get all user demand
     *
     * @throws ApiException
     *         if the Api call fails
     */
    @Test
    public void getAllUserDemandsUsingGETTest() throws ApiException {
        String username = null;
        // List<Demand> response = api.getAllUserDemandsUsingGET(username);

        // TODO: test validations
    }

}
