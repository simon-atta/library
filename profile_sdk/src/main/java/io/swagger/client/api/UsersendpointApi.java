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
import io.swagger.client.model.UserAccount;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen",
                            date = "2016-07-25T15:10:43.065Z")
public class UsersendpointApi {
    private ApiClient apiClient;

    public UsersendpointApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UsersendpointApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Add new user
     * 
     * @param user
     *        user (required)
     * @return Boolean
     * @throws ApiException
     *         if fails to make API call
     */
    public Boolean addNewUserAccountUsingPOST(UserAccount user) throws ApiException {
        Object localVarPostBody = user;

        // verify the required parameter 'user' is set
        if (user == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'user' when calling addNewUserAccountUsingPOST");
        }

        // create path and map variables
        String localVarPath = "/api/user/addNewUserAccount".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        Map<String, String> localVarHeaderParams = new HashMap<>();
        Map<String, Object> localVarFormParams = new HashMap<>();

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BasicAuth" };

        GenericType<Boolean> localVarReturnType = new GenericType<Boolean>() {
        };
        return apiClient.invokeAPI(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get user account by username
     * 
     * @param username
     *        userName (required)
     * @return UserAccount
     * @throws ApiException
     *         if fails to make API call
     */
    public UserAccount getUserAccountByUserNameUsingGET(String username) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'username' is set
        if (username == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'username' when calling getUserAccountByUserNameUsingGET");
        }

        // create path and map variables
        String localVarPath = "/api/user/getUserByUserName".replaceAll("\\{format\\}", "json");

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

        GenericType<UserAccount> localVarReturnType = new GenericType<UserAccount>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
