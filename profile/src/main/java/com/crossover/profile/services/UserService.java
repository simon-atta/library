package com.crossover.profile.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.profile.model.Role;
import com.crossover.profile.model.UserAccount;
import com.crossover.profile.model.UserAccountStatus;
import com.crossover.profile.repositories.UserAccountRepository;

@Service
public class UserService implements IUserAccountService {

    @Autowired
    private UserAccountRepository userRepository;

    @Override
    public Boolean addNewUserAccount(UserAccount user) {
        // Check if user already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return false;
        }
        user.setEnabled(true);
        user.setStatus(UserAccountStatus.STATUS_APPROVED.name());
        user.setRoles(Role.USER);
        userRepository.save(user);
        return true;
    }

    @Override
    public UserAccount getUserAccountByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
