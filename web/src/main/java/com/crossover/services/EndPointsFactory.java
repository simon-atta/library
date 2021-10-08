package com.crossover.services;

import io.swagger.client.ApiClient;
import io.swagger.client.api.BooksendpointApi;
import io.swagger.client.api.DemandsendpointApi;
import io.swagger.client.api.UsersendpointApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crossover.config.RestClientConfig;

/**
 * This is abstract profile service which contains common code for all profile
 * services.
 *
 * @author Simon Ghobreil.
 */
@Component
public class EndPointsFactory {

    @Autowired
    private RestClientConfig restClient;

    public UsersendpointApi getUserEndPointApi() {
        ApiClient apiClient = new ApiClient();
        apiClient.setUsername(restClient.getProfileUserName());
        apiClient.setPassword(restClient.getProfilePassword());
        apiClient.setBasePath(restClient.getProfileBaseUrl());

        return new UsersendpointApi(apiClient);
    }

    public BooksendpointApi getBooksendpointApi() {
        ApiClient apiClient = new ApiClient();
        apiClient.setUsername(restClient.getBooksUserName());
        apiClient.setPassword(restClient.getBooksPassword());
        apiClient.setBasePath(restClient.getBooksBaseUrl());

        return new BooksendpointApi(apiClient);
    }

    public DemandsendpointApi getDemandsendpointApi() {
        ApiClient apiClient = new ApiClient();
        apiClient.setUsername(restClient.getProfileUserName());
        apiClient.setPassword(restClient.getProfilePassword());
        apiClient.setBasePath(restClient.getProfileBaseUrl());

        return new DemandsendpointApi(apiClient);
    }

}
