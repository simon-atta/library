package com.crossover.services.demands;

import io.swagger.client.ApiException;
import io.swagger.client.model.Demand;

import java.util.List;

/**
 * This is demands service interface contains all method for user demands.
 *
 * @author Simon Ghobreil.
 */
public interface IDemandsService {

    /**
     * This method is responsible for adding new user demand.
     *
     * @param bookTitle
     *        String
     * @param userName
     *        String
     * @return list of user demands.
     * @throws ApiException
     */
    List<Demand> registerNewDemand(String bookTitle, String userName) throws Exception;

    /**
     * This method get all user demands by user name.
     *
     * @param userName
     *        String
     * @return list of demands.
     * @throws ApiException
     */
    List<Demand> getUserDemands(String userName) throws Exception;

}
