package io.swagger.client.api;

import org.junit.Ignore;
import org.junit.Test;

import io.swagger.client.ApiException;
import io.swagger.client.model.UserAccount;

/**
 * API tests for UsersendpointApi
 */
@Ignore
public class UsersendpointApiTest {

    private final UsersendpointApi api = new UsersendpointApi();

    /**
     * Add new user
     *
     * @throws ApiException
     *         if the Api call fails
     */
    @Test
    public void addNewUserAccountUsingPOSTTest() throws ApiException {
        UserAccount user = null;
        // Boolean response = api.addNewUserAccountUsingPOST(user);

        // TODO: test validations
    }

    /**
     * Get user account by username
     *
     * @throws ApiException
     *         if the Api call fails
     */
    @Test
    public void getUserAccountByUserNameUsingGETTest() throws ApiException {
        String username = null;
        // UserAccount response =
        // api.getUserAccountByUserNameUsingGET(username);

        // TODO: test validations
    }

}
