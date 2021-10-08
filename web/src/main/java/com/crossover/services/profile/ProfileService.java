package com.crossover.services.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.crossover.services.EndPointsFactory;

import io.swagger.client.ApiException;
import io.swagger.client.api.UsersendpointApi;
import io.swagger.client.model.UserAccount;

/**
 * This is concrete implementation of profile service interface.
 *
 * @author Simon Ghobreil.
 */
@Service
public class ProfileService implements IProfileService {

    @Autowired
    private EndPointsFactory endPointsFactory;

    @Override
    public boolean createNewUser(String fullname, String email, String password, String username) throws ApiException {
        UsersendpointApi usersendpointApi = endPointsFactory.getUserEndPointApi();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserAccount userAccount = new UserAccount();
        userAccount.setFullname(fullname);
        userAccount.setEmail(email);
        userAccount.setEnabled(true);
        userAccount.setPassword(passwordEncoder.encode(password));
        userAccount.setUsername(username);

        return usersendpointApi.addNewUserAccountUsingPOST(userAccount);
    }

}
