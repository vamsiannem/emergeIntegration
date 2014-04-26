/**
 *
 */
package com.lister.emerge.rest;

import retrofit.http.EncodedQuery;


/**
 * @author vamsikrishna
 *
 */
public interface CustomerService extends Service {

    @retrofit.http.POST("/customers")
    @retrofit.http.Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "Dummy: true",
            "User-Agent: Retrofit-Sample-App"
    })

    String createCustomer(@retrofit.http.EncodedQuery(value="isResponseRequired") Boolean isResponseRequired,@EncodedQuery(value="storedProcedureName") String storedProcedureName, @retrofit.http.Body String bodyJson);


}
