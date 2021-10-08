package com.crossover.model;

import io.swagger.client.model.UserAccount;

import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Current User model extends spring security user object.
 *
 * @author Simon Ghobreil.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;
    private UserAccount user;

    /**
     * Constructor take user account as model.
     *
     * @param user
     *        UserAccount
     */
    public CurrentUser(UserAccount user) {
        super(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, AuthorityUtils
                .createAuthorityList(user.getRoles().toString()));
        this.user = user;
    }

    public UserAccount getUser() {
        return user;
    }

}
