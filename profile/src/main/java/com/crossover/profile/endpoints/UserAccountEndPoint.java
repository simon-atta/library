package com.crossover.profile.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crossover.profile.model.UserAccount;
import com.crossover.profile.services.IUserAccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * User account end point.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/api/user")
@Api(value = "UsersEndPoint", produces = "application/json")
@Configuration
public class UserAccountEndPoint {

    @Autowired
    private IUserAccountService userAccountService;

    /**
     * Add new user account.
     * <p>
     * 1. Check if user already exists if yes will return false.
     * <p>
     * 2. When user account successfully saved will return true.
     *
     * @param user
     *        UserAccount
     * @return boolean value indicate status.
     */
    @ApiOperation(value = "Add new user")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "User created"),
            @ApiResponse(code = 500, message = "Somthing went wrong!") })
    @RequestMapping(method = RequestMethod.POST, path = "/addNewUserAccount", produces = "application/json")
    public @ResponseBody ResponseEntity<Boolean> addNewUserAccount(@RequestBody UserAccount user) {
        try {

            if (userAccountService.addNewUserAccount(user)) {
                return new ResponseEntity<>(true, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(false, HttpStatus.CONFLICT);
            }

        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get user account by username.
     *
     * @param userName
     *        String
     * @return UserAccount match username.
     */
    @ApiOperation(value = "Get user account by username")
    @ApiResponses(value = { @ApiResponse(code = 204, message = "User name empty"),
            @ApiResponse(code = 500, message = "Somthing went wrong!") })
    @RequestMapping(method = RequestMethod.GET, path = "/getUserByUserName", produces = "application/json")
    public @ResponseBody ResponseEntity<UserAccount> getUserAccountByUserName(
            @RequestParam(value = "username") String userName) {
        try {
            Assert.hasText(userName);
            return new ResponseEntity<>(userAccountService.getUserAccountByUsername(userName), HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
