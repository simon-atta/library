package com.crossover.profile.services;

import java.util.List;

import com.crossover.profile.model.Demand;

/**
 * This is contract interface for all user demands service methods.
 *
 * @author Simon Ghobreil.
 */
public interface IDemandsService {

    /**
     * Add new demand for user.
     *
     * @param demand
     *        Demand
     */
    void addNewDemand(Demand demand) throws Exception;

    /**
     * Get user demands by his username.
     *
     * @param userName
     *        String
     * @return list of user demands.
     */
    List<Demand> getUserDemands(String userName) throws Exception;

}
