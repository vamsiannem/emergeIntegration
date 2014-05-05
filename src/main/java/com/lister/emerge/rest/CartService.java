package com.lister.emerge.rest;

import retrofit.http.EncodedQuery;

/**
 * Created with IntelliJ IDEA.
 * User: vamsi
 * Date: 4/25/14
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CartService extends Service{

    @retrofit.http.POST("/cart")
    @retrofit.http.Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "Dummy: true",
            "User-Agent: Retrofit-Sample-App"
    })

    String cartItemAdd(@retrofit.http.EncodedQuery(value = "isResponseRequired") Boolean isResponseRequired, @EncodedQuery(value = "storedProcedureName") String storedProcedureName, @retrofit.http.Body String bodyJson);

    @retrofit.http.POST("/cart")
    @retrofit.http.Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "Dummy: true",
            "User-Agent: Retrofit-Sample-App"
    })

    String cartItemRemove(@retrofit.http.EncodedQuery(value="isResponseRequired") Boolean isResponseRequired,@EncodedQuery(value="storedProcedureName") String storedProcedureName, @retrofit.http.Body String bodyJson);

    @retrofit.http.POST("/cart")
    @retrofit.http.Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "Dummy: true",
            "User-Agent: Retrofit-Sample-App"
    })

    String cartCheckout(@retrofit.http.EncodedQuery(value="isResponseRequired") Boolean isResponseRequired,@EncodedQuery(value="storedProcedureName") String storedProcedureName, @retrofit.http.Body String bodyJson);

}
