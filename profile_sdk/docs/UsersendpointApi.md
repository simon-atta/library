# UsersendpointApi

All URIs are relative to *https://localhost:8082/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addNewUserAccountUsingPOST**](UsersendpointApi.md#addNewUserAccountUsingPOST) | **POST** /api/user/addNewUserAccount | Add new user
[**getUserAccountByUserNameUsingGET**](UsersendpointApi.md#getUserAccountByUserNameUsingGET) | **GET** /api/user/getUserByUserName | Get user account by username


<a name="addNewUserAccountUsingPOST"></a>
# **addNewUserAccountUsingPOST**
> Boolean addNewUserAccountUsingPOST(user)

Add new user

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UsersendpointApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

UsersendpointApi apiInstance = new UsersendpointApi();
UserAccount user = new UserAccount(); // UserAccount | user
try {
    Boolean result = apiInstance.addNewUserAccountUsingPOST(user);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersendpointApi#addNewUserAccountUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **user** | [**UserAccount**](UserAccount.md)| user |

### Return type

**Boolean**

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getUserAccountByUserNameUsingGET"></a>
# **getUserAccountByUserNameUsingGET**
> UserAccount getUserAccountByUserNameUsingGET(username)

Get user account by username

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.UsersendpointApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

UsersendpointApi apiInstance = new UsersendpointApi();
String username = "username_example"; // String | userName
try {
    UserAccount result = apiInstance.getUserAccountByUserNameUsingGET(username);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersendpointApi#getUserAccountByUserNameUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **username** | **String**| userName |

### Return type

[**UserAccount**](UserAccount.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

