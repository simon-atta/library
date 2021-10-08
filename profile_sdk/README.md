# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.DemandsendpointApi;

import java.io.File;
import java.util.*;

public class DemandsendpointApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure HTTP basic authorization: BasicAuth
        HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
        BasicAuth.setUsername("YOUR USERNAME");
        BasicAuth.setPassword("YOUR PASSWORD");

        DemandsendpointApi apiInstance = new DemandsendpointApi();
        Demand demand = new Demand(); // Demand | demand
        try {
            Demand result = apiInstance.addNewDemandUsingPOST(demand);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DemandsendpointApi#addNewDemandUsingPOST");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://localhost:8082/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DemandsendpointApi* | [**addNewDemandUsingPOST**](docs/DemandsendpointApi.md#addNewDemandUsingPOST) | **POST** /api/demands/addNewDemand | ِAdd new demand
*DemandsendpointApi* | [**getAllUserDemandsUsingGET**](docs/DemandsendpointApi.md#getAllUserDemandsUsingGET) | **GET** /api/demands/getAllUserDemands | Get all user demand
*UsersendpointApi* | [**addNewUserAccountUsingPOST**](docs/UsersendpointApi.md#addNewUserAccountUsingPOST) | **POST** /api/user/addNewUserAccount | Add new user
*UsersendpointApi* | [**getUserAccountByUserNameUsingGET**](docs/UsersendpointApi.md#getUserAccountByUserNameUsingGET) | **GET** /api/user/getUserByUserName | Get user account by username


## Documentation for Models

 - [Demand](docs/Demand.md)
 - [UserAccount](docs/UserAccount.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### BasicAuth

- **Type**: HTTP basic authentication


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author



