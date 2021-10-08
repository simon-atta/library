package com.crossover.model;

import io.swagger.client.model.UserAccount;
import io.swagger.client.model.UserAccount.RolesEnum;

import org.junit.Assert;
import org.junit.Test;

public class CurrentUserTest {

    @Test
    public void testGetUser() {
        CurrentUser currentUser = new CurrentUser(getUserAccount());
        UserAccount userAccount = currentUser.getUser();
        Assert.assertEquals(userAccount.getUsername(), getUserAccount().getUsername());
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
        account.setId("12344");
        return account;
    }

}
