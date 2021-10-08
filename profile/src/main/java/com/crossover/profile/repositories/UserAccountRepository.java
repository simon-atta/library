package com.crossover.profile.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crossover.profile.model.UserAccount;

/**
 * User account repository has all methods for deal with database.
 *
 * @author Simon Ghobreil.
 */
public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

    /**
     * Find user by username.
     *
     * @param username
     *        String
     * @return user account matches username.
     */
    UserAccount findByUsername(final String username);

}
