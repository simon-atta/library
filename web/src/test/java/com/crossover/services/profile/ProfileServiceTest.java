package com.crossover.services.profile;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.CrossoverWebApplication;
import com.crossover.config.RestClientConfig;
import com.crossover.services.EndPointsFactory;

import io.swagger.client.ApiException;
import io.swagger.client.api.UsersendpointApi;
import io.swagger.client.model.UserAccount;
import io.swagger.client.model.UserAccount.RolesEnum;

/**
 * Home Controller Test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrossoverWebApplication.class)
@WebAppConfiguration
public class ProfileServiceTest {

    @InjectMocks
    private ProfileService profileService;

    @Mock
    private RestClientConfig restClient;

    @Mock
    private EndPointsFactory endPointsFactory;

    @Mock
    private UsersendpointApi usersendpointApi;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateNewUser() throws ApiException {
        when(endPointsFactory.getUserEndPointApi()).thenReturn(usersendpointApi);
        when(usersendpointApi.addNewUserAccountUsingPOST(getUserAccount())).thenReturn(true);
        boolean result = profileService.createNewUser("simon", "semonsamir@gmail.com", "test123", "simon");
        Assert.assertEquals(result, false);
    }

    private UserAccount getUserAccount() {

        UserAccount account = new UserAccount();
        account.setEmail("semonsamir@gmail.com");
        account.setEnabled(true);
        account.setFullname("simon samir");
        account.setPassword("test1234");
        account.setRoles(RolesEnum.USER);
        account.setStatus("New");
        account.setUsername("simon");
        return account;
    }

}
