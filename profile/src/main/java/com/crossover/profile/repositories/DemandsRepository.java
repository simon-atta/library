package com.crossover.profile.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crossover.profile.model.Demand;

/**
 * Demands repository has all methods for deal with database.
 *
 * @author Simon Ghobreil.
 */
public interface DemandsRepository extends MongoRepository<Demand, String> {

    /**
     * Find all demands for certain user.
     *
     * @param username
     *        String
     * @return list of all user demands.
     */
    List<Demand> findByUserName(String username);

}
