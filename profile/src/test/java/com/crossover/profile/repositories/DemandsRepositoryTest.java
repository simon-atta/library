package com.crossover.profile.repositories;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ProfileApplication;
import com.crossover.profile.model.Demand;
import com.crossover.profile.model.DemandStatus;

/**
 * Demands repository test case.
 * <p>
 * All tests using embedded database.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProfileApplication.class)
@WebAppConfiguration
public class DemandsRepositoryTest {

    @Autowired
    private DemandsRepository demandsRepository;

    @Before
    public void setUp() throws Exception {
        demandsRepository.save(handleUserAccount());
    }

    /**
     * Test method for
     * {@link com.crossover.profile.repositories.DemandsRepository#findByUserName(String)}
     *
     * @throws Exception
     */
    @Test
    public void testFindByUsername() {
        List<Demand> demands = demandsRepository.findByUserName("simon");
        Assert.assertNotNull(demands);
        Assert.assertEquals(demands.size(), 2);
    }

    private List<Demand> handleUserAccount() {

        List<Demand> demands = new ArrayList<>();

        Demand demand = new Demand("The Beauty of the Infinite", DemandStatus.NEW, "simon");
        Demand demand2 = new Demand("The Ecclesiastical Organisation of the Church", DemandStatus.NEW, "simon");
        demands.add(demand);
        demands.add(demand2);

        return demands;
    }

}