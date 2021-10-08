package com.crossover.profile.endpoints;

import java.util.List;

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

import com.crossover.profile.model.Demand;
import com.crossover.profile.services.IDemandsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Demands end point.
 *
 * @author Simon Ghobreil.
 */
@RepositoryRestController
@RequestMapping("/api/demands")
@Api(value = "DemandsEndPoint", produces = "application/json")
@Configuration
public class DemandsEndPoint {

    @Autowired
    private IDemandsService demandsService;

    /**
     * Add new demand for specific user.
     *
     * @param demand
     *        Demand
     * @return HTTP status indicate success or failure,
     */
    @ApiOperation(value = "ِAdd new demand")
    @RequestMapping(method = RequestMethod.POST, path = "/addNewDemand", produces = "application/json")
    public @ResponseBody ResponseEntity<Demand> addNewDemand(@RequestBody Demand demand) {

        try {
            demandsService.addNewDemand(demand);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * Get all user demands.
     *
     * @param userName
     *        String
     * @return list of demands for specific user.
     */
    @ApiResponses(value = { @ApiResponse(code = 204, message = "User name empty"),
            @ApiResponse(code = 500, message = "Somthing went wrong!") })
    @ApiOperation(value = "Get all user demand")
    @RequestMapping(method = RequestMethod.GET, path = "/getAllUserDemands", produces = "application/json")
    public @ResponseBody ResponseEntity<List<Demand>> getAllUserDemands(
            @RequestParam(value = "username") String userName) {

        try {
            Assert.hasText(userName);
            return new ResponseEntity<>(demandsService.getUserDemands(userName), HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
