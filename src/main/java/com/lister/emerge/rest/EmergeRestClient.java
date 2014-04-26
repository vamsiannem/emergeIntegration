package com.lister.emerge.rest;

import retrofit.RestAdapter;

import com.lister.emerge.enums.EntityOperation;
import com.lister.emerge.enums.Operation;

public class EmergeRestClient {

    private static String EMERGE_BASE_ENDPOINT = "http://localhost:8080/EmergeServices/org";


    public void invoke(Operation entityOperation, String inputJson) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(EMERGE_BASE_ENDPOINT)
                .build();
        Service service = null;
        switch (entityOperation) {
            case CUSTOMER_CREATE:
                CustomerService customerService =  restAdapter.create(CustomerService.class);
                customerService.createCustomer(false, "em_members_update", inputJson);
                break;
            case CART_ITEM_ADD:
                CartService cartService = restAdapter.create(CartService.class);
                cartService.createCart(false, "cartAbandonment", inputJson);
                break;
            default:

        }


    }

    ;

}
