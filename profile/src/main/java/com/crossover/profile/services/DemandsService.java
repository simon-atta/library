package com.crossover.profile.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.profile.model.Demand;
import com.crossover.profile.repositories.DemandsRepository;

/**
 * This is concrete implementation of {@link IDemandsService}
 *
 * @author Simon Ghobreil.
 */
@Service
public class DemandsService implements IDemandsService {

    @Autowired
    private DemandsRepository demandsRepository;

    /**
     * (non-Javadoc)
     *
     * @see com.crossover.profile.services.IDemandsService#addNewDemand(Demand)
     */
    @Override
    public void addNewDemand(Demand demand) {
        demandsRepository.save(demand);
    }

    /**
     * (non-Javadoc)
     *
     * @see com.crossover.profile.services.IDemandsService#getUserDemands(String)
     */
    @Override
    public List<Demand> getUserDemands(String userName) {
        return demandsRepository.findByUserName(userName);
    }

}
