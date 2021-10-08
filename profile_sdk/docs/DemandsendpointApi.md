# DemandsendpointApi

All URIs are relative to *https://localhost:8082/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addNewDemandUsingPOST**](DemandsendpointApi.md#addNewDemandUsingPOST) | **POST** /api/demands/addNewDemand | ِAdd new demand
[**getAllUserDemandsUsingGET**](DemandsendpointApi.md#getAllUserDemandsUsingGET) | **GET** /api/demands/getAllUserDemands | Get all user demand


<a name="addNewDemandUsingPOST"></a>
# **addNewDemandUsingPOST**
> Demand addNewDemandUsingPOST(demand)

ِAdd new demand

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DemandsendpointApi;

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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **demand** | [**Demand**](Demand.md)| demand |

### Return type

[**Demand**](Demand.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAllUserDemandsUsingGET"></a>
# **getAllUserDemandsUsingGET**
> List&lt;Demand&gt; getAllUserDemandsUsingGET(username)

Get all user demand

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.DemandsendpointApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

DemandsendpointApi apiInstance = new DemandsendpointApi();
String username = "username_example"; // String | userName
try {
    List<Demand> result = apiInstance.getAllUserDemandsUsingGET(username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DemandsendpointApi#getAllUserDemandsUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| userName |

### Return type

[**List&lt;Demand&gt;**](Demand.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

