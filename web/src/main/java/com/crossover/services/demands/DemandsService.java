package com.crossover.services.demands;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.services.EndPointsFactory;

import io.swagger.client.ApiException;
import io.swagger.client.api.DemandsendpointApi;
import io.swagger.client.model.Demand;
import io.swagger.client.model.Demand.StatusEnum;

/**
 * This is concrete implementation of Demand Service interface.
 *
 * @author Simon Ghobreil.
 */
@Service
public class DemandsService implements IDemandsService {

    @Autowired
    private EndPointsFactory endPointsFactory;

    @Override
    public List<Demand> registerNewDemand(String bookTitle, String userName) throws ApiException {
        DemandsendpointApi demandsendpointApi = endPointsFactory.getDemandsendpointApi();

        Demand demand = new Demand();
        demand.setBookName(bookTitle);
        demand.setUserName(userName);
        demand.setStatus(StatusEnum.NEW);

        demandsendpointApi.addNewDemandUsingPOST(demand);

        return demandsendpointApi.getAllUserDemandsUsingGET(userName);
    }

    @Override
    public List<Demand> getUserDemands(String userName) throws ApiException {

        DemandsendpointApi demandsendpointApi = endPointsFactory.getDemandsendpointApi();
        return demandsendpointApi.getAllUserDemandsUsingGET(userName);

    }

}
