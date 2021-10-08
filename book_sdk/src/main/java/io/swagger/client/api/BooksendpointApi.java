package io.swagger.client.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.jersey.api.client.GenericType;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.model.Book;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen",
                            date = "2016-07-24T23:33:05.911Z")
public class BooksendpointApi {
    private ApiClient apiClient;

    public BooksendpointApi() {
        this(Configuration.getDefaultApiClient());
    }

    public BooksendpointApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get all books
     * 
     * @return List<Book>
     * @throws ApiException
     *         if fails to make API call
     */
    public List<Book> getAllBooksUsingGET() throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/books/getAllBooks".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        Map<String, String> localVarHeaderParams = new HashMap<>();
        Map<String, Object> localVarFormParams = new HashMap<>();

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BasicAuth" };

        GenericType<List<Book>> localVarReturnType = new GenericType<List<Book>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get book by title
     * 
     * @param booktitle
     *        booktitle (required)
     * @return List<Book>
     * @throws ApiException
     *         if fails to make API call
     */
    public List<Book> getBookByTitleUsingGET(String booktitle) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'booktitle' is set
        if (booktitle == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'booktitle' when calling getBookByTitleUsingGET");
        }

        // create path and map variables
        String localVarPath = "/api/books/getBookByTitle".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        Map<String, String> localVarHeaderParams = new HashMap<>();
        Map<String, Object> localVarFormParams = new HashMap<>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "booktitle", booktitle));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BasicAuth" };

        GenericType<List<Book>> localVarReturnType = new GenericType<List<Book>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }

    /**
     * Get publisher books
     * 
     * @param publisher
     *        publisher (required)
     * @return List<Book>
     * @throws ApiException
     *         if fails to make API call
     */
    public List<Book> getPublisherBooksUsingGET(String publisher) throws ApiException {
        Object localVarPostBody = null;

        // verify the required parameter 'publisher' is set
        if (publisher == null) {
            throw new ApiException(400,
                    "Missing the required parameter 'publisher' when calling getPublisherBooksUsingGET");
        }

        // create path and map variables
        String localVarPath = "/api/books/getPublisherBooks".replaceAll("\\{format\\}", "json");

        // query params
        List<Pair> localVarQueryParams = new ArrayList<>();
        Map<String, String> localVarHeaderParams = new HashMap<>();
        Map<String, Object> localVarFormParams = new HashMap<>();

        localVarQueryParams.addAll(apiClient.parameterToPairs("", "publisher", publisher));

        final String[] localVarAccepts = { "application/json" };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

        final String[] localVarContentTypes = { "application/json" };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "BasicAuth" };

        GenericType<List<Book>> localVarReturnType = new GenericType<List<Book>>() {
        };
        return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
                localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
    }
}
