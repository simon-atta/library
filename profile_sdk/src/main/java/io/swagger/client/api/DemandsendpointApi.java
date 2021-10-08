package io.swagger.client.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.jersey.api.client.GenericType;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.model.Demand;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen",
                            date = "2016-07-25T15:10:43.065Z")
public class DemandsendpointApi {
    private ApiClient apiClient;

    public DemandsendpointApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DemandsendpointApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * ِAdd new demand
     * 
     * @param demand
     *        demand (required)
     * @return Demand
     * @throws ApiException
     *         if fails to make API call
     */
    public Demand addNewDemandUsingPOST(Demand demand) throws ApiException {
        Object localVarPostBody = demand;

        // verify the required parameter 'demand' is set
        if (demand == null) {
            throw new ApiException(400, "Missing the required parameter 'demand' when calling addNewDemandUsingPOST");
        }

        // create path and map variables
        String localVarPath = "/api/demands/addNewDemand".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        Map<String, String> localVarHeaderParams = new HashMap<>();
        Map<String, Object> localVarFormParams = new HashMap<>();

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BasicAuth" };

        GenericType<Demand> localVarReturnType = new GenericType<Demand>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get all user demand
     * 
     * @param username
     *        userName (required)
     * @return List<Demand>
     * @throws ApiException
     *         if fails to make API call
     */
    public List<Demand> getAllUserDemandsUsingGET(String username) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'username' is set
        if (username == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'username' when calling getAllUserDemandsUsingGET");
        }

        // create path and map variables
        String localVarPath = "/api/demands/getAllUserDemands".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        Map<String, String> localVarHeaderParams = new HashMap<>();
        Map<String, Object> localVarFormParams = new HashMap<>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "username", username));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BasicAuth" };

        GenericType<List<Demand>> localVarReturnType = new GenericType<List<Demand>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
