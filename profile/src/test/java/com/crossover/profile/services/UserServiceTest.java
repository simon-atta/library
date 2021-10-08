package com.crossover.profile.services;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ProfileApplication;
import com.crossover.profile.model.Role;
import com.crossover.profile.model.UserAccount;
import com.crossover.profile.repositories.UserAccountRepository;

/**
 * User test Cases.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProfileApplication.class)
@WebAppConfiguration
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserAccountRepository userAccountRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test method for
     * {@link com.crossover.profile.services.IUserAccountService#addNewUserAccount(UserAccount)}
     */
    @Test
    public void testCreateNewUserSuccess() {
        when(userAccountRepository.save(new UserAccount())).thenReturn(handleCreateUserAccount());
        Boolean result = userService.addNewUserAccount(handleCreateUserAccount());
        Assert.assertEquals(result, true);
    }

    /**
     * Test method for
     * {@link com.crossover.profile.services.IUserAccountService#addNewUserAccount(UserAccount)}
     */
    @Test
    public void testCreateNewUserFail() {
        when(userAccountRepository.save(new UserAccount())).thenReturn(handleCreateUserAccount());
        when(userAccountRepository.findByUsername(Mockito.anyString())).thenReturn(handleCreateUserAccount());
        Boolean result = userService.addNewUserAccount(handleCreateUserAccount());
        Assert.assertEquals(result, false);
    }

    /**
     * Test method for
     * {@link
     * com.crossover.profile.services.IUserAccountService#getUserAccountByUsername(String)
     */
    @Test
    public void testGetUserAccountByUsername() {
        when(userAccountRepository.findByUsername(Mockito.anyString())).thenReturn(handleSaveUserAccount());
        UserAccount userAccount = userService.getUserAccountByUsername("simon");

        Assert.assertNotNull(userAccount);
        Assert.assertEquals(userAccount.getEmail(), "semonsamir@gmail.com");
    }

    private UserAccount handleSaveUserAccount() {
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail("semonsamir@gmail.com");
        userAccount.setEnabled(true);
        userAccount.setFullname("simon samir");
        userAccount.setPassword("test123");
        userAccount.setRoles(Role.USER);
        userAccount.setStatus("NEW");
        userAccount.setUsername("simon");
        userAccount.setId("123445");

        return userAccount;

    }

    private UserAccount handleCreateUserAccount() {
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail("semonsamir@gmail.com");
        userAccount.setEnabled(true);
        userAccount.setFullname("simon samir");
        userAccount.setPassword("test123");
        userAccount.setRoles(Role.USER);
        userAccount.setStatus("NEW");
        userAccount.setUsername("simon.samir");

        return userAccount;

    }
}
