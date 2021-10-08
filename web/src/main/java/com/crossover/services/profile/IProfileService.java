package com.crossover.services.profile;

import io.swagger.client.ApiException;

/**
 * This is profile service interface contains all profile methods.
 *
 * @author Simon Ghobreil.
 */
public interface IProfileService {

    /**
     * This method for sign up new user.
     *
     * @param fullname
     *        String
     * @param email
     *        String
     * @param password
     *        String
     * @param username
     *        String
     * @return true or false , true if signup successfully , false if backend
     *         fails.
     * @throws ApiException
     */
    boolean createNewUser(String fullname, String email, String password, String username) throws ApiException;

}
