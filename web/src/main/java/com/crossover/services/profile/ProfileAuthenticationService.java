package com.crossover.services.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.crossover.model.CurrentUser;
import com.crossover.services.EndPointsFactory;

import io.swagger.client.ApiException;
import io.swagger.client.api.UsersendpointApi;
import io.swagger.client.model.UserAccount;

/**
 * This is service responsible for authenticate user.
 *
 * @author Simon Ghobreil
 */
@Component
public class ProfileAuthenticationService implements UserDetailsService {

    @Autowired
    private EndPointsFactory endPointsFactory;

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UsersendpointApi usersendpointApi = endPointsFactory.getUserEndPointApi();

            UserAccount profile = usersendpointApi.getUserAccountByUserNameUsingGET(username);

            return new CurrentUser(profile);
        } catch (ApiException e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("User not found");
        }

    }

}
