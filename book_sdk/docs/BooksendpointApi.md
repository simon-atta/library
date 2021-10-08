# BooksendpointApi

All URIs are relative to *https://localhost:8081/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAllBooksUsingGET**](BooksendpointApi.md#getAllBooksUsingGET) | **GET** /api/books/getAllBooks | Get all books
[**getBookByTitleUsingGET**](BooksendpointApi.md#getBookByTitleUsingGET) | **GET** /api/books/getBookByTitle | Get book by title
[**getPublisherBooksUsingGET**](BooksendpointApi.md#getPublisherBooksUsingGET) | **GET** /api/books/getPublisherBooks | Get publisher books


<a name="getAllBooksUsingGET"></a>
# **getAllBooksUsingGET**
> List&lt;Book&gt; getAllBooksUsingGET()

Get all books

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BooksendpointApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

BooksendpointApi apiInstance = new BooksendpointApi();
try {
    List<Book> result = apiInstance.getAllBooksUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BooksendpointApi#getAllBooksUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Book&gt;**](Book.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getBookByTitleUsingGET"></a>
# **getBookByTitleUsingGET**
> List&lt;Book&gt; getBookByTitleUsingGET(booktitle)

Get book by title

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BooksendpointApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

BooksendpointApi apiInstance = new BooksendpointApi();
String booktitle = "booktitle_example"; // String | booktitle
try {
    List<Book> result = apiInstance.getBookByTitleUsingGET(booktitle);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BooksendpointApi#getBookByTitleUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **booktitle** | **String**| booktitle |

### Return type

[**List&lt;Book&gt;**](Book.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPublisherBooksUsingGET"></a>
# **getPublisherBooksUsingGET**
> List&lt;Book&gt; getPublisherBooksUsingGET(publisher)

Get publisher books

### Example
```java
// Import classes:
//import io.swagger.client.ApiClient;
//import io.swagger.client.ApiException;
//import io.swagger.client.Configuration;
//import io.swagger.client.auth.*;
//import io.swagger.client.api.BooksendpointApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure HTTP basic authorization: BasicAuth
HttpBasicAuth BasicAuth = (HttpBasicAuth) defaultClient.getAuthentication("BasicAuth");
BasicAuth.setUsername("YOUR USERNAME");
BasicAuth.setPassword("YOUR PASSWORD");

BooksendpointApi apiInstance = new BooksendpointApi();
String publisher = "publisher_example"; // String | publisher
try {
    List<Book> result = apiInstance.getPublisherBooksUsingGET(publisher);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling BooksendpointApi#getPublisherBooksUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **publisher** | **String**| publisher |

### Return type

[**List&lt;Book&gt;**](Book.md)

### Authorization

[BasicAuth](../README.md#BasicAuth)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

