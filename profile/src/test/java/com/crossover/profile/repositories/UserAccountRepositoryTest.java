package com.crossover.profile.repositories;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ProfileApplication;
import com.crossover.profile.model.Role;
import com.crossover.profile.model.UserAccount;

/**
 * User account repository test case.
 * <p>
 * All tests using embedded database.
 *
 * @author Simon Ghobreil.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ProfileApplication.class)
@WebAppConfiguration
public class UserAccountRepositoryTest {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Before
    public void setUp() throws Exception {
        userAccountRepository.save(handleUserAccount());
    }

    /**
     * Test method for
     * {@link com.crossover.profile.repositories.UserAccountRepository#findByUsername(String)}
     *
     * @throws Exception
     */
    @Test
    public void testFindByUsername() {
        UserAccount user = userAccountRepository.findByUsername("simon");
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getEmail(), "semonsamir@gmail.com");
    }

    private UserAccount handleUserAccount() {
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail("semonsamir@gmail.com");
        userAccount.setEnabled(true);
        userAccount.setFullname("simon samir");
        userAccount.setPassword("test123");
        userAccount.setRoles(Role.USER);
        userAccount.setStatus("NEW");
        userAccount.setUsername("simon");

        return userAccount;

    }

}