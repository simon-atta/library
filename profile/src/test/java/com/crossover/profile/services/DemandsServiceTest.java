package com.crossover.profile.services;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ProfileApplication;
import com.crossover.profile.model.Demand;
import com.crossover.profile.model.DemandStatus;
import com.crossover.profile.repositories.DemandsRepository;

/**
 * User demands test case.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProfileApplication.class)
@WebAppConfiguration
public class DemandsServiceTest {

    @InjectMocks
    private DemandsService userDemands;

    @Mock
    private DemandsRepository demandsRepository;

    private Demand demand;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test method for
     * {@link com.crossover.profile.services.IDemandsService#addNewDemand(Demand)
     *
     * @throws Exception
     */
    @Test
    public void testAddNewDemand() {
        demand = createNewDemand();
        when(demandsRepository.save(any(Demand.class))).thenAnswer(new Answer<Demand>() {
            @Override
            public Demand answer(InvocationOnMock invocation) throws Throwable {
                demand = (Demand) invocation.getArguments()[0];
                return demand;
            }
        });

        userDemands.addNewDemand(new Demand("The Beauty of the Infinite", DemandStatus.NEW, "simon"));

        verify(demandsRepository, times(1)).save(demand);
        verifyNoMoreInteractions(demandsRepository);
    }

    /**
     * Test method for
     * {@link com.crossover.profile.services.IDemandsService#getUserDemands(String)
     *
     * @throws Exception
     */
    @Test
    public void testGetUserDemands() {
        when(demandsRepository.findByUserName("simon")).thenReturn(handleUserAccount());
        List<Demand> result = userDemands.getUserDemands("simon");
        Assert.assertNotNull(result);
        Assert.assertEquals(result.size(), 2);
    }

    private Demand createNewDemand() {
        Demand demand = new Demand("The Beauty of the Infinite", DemandStatus.NEW, "simon");
        return demand;
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
