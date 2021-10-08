package com.crossover.profile.services;

import com.crossover.profile.model.UserAccount;

/**
 * This is contract interface for all user account service methods.
 *
 * @author Simon Ghobreil.
 */
public interface IUserAccountService {

    /**
     * Add new user account.
     * <p>
     * will return true in case of user account added successfully
     * <p>
     * will return false in case of customer already exists.
     *
     * @param user
     *        UserAccount
     * @return boolean value.
     * @throws Exception
     */
    Boolean addNewUserAccount(UserAccount user) throws Exception;;

    /**
     * Get user account by username.
     *
     * @param username
     *        String
     * @return user account match username.
     * @throws Exception
     */
    UserAccount getUserAccountByUsername(String username) throws Exception;;

}
