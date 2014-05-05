package com.lister.emerge.rest;

import retrofit.RestAdapter;

import com.lister.emerge.enums.Operation;

public class EmergeRestClient {

    private static String EMERGE_BASE_ENDPOINT = "http://localhost:8080/EmergeServices/org";


    public void invoke(Operation entityOperation, String inputJson) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(EMERGE_BASE_ENDPOINT)
                .build();
        switch (entityOperation) {
            case CUSTOMER_CREATE:
                CustomerService customerService =  restAdapter.create(CustomerService.class);
                customerService.createCustomer(false, Service.PRC_CREATE_CUSTOMER, inputJson);
                break;
            case CART_ITEM_ADD:
                CartService cartService = restAdapter.create(CartService.class);
                cartService.cartItemAdd(false, Service.PRC_CART_ITEM_ADD, inputJson);
                break;
            case CART_ITEM_REMOVE:
                cartService = restAdapter.create(CartService.class);
                cartService.cartItemRemove(false, Service.PRC_CART_ITEM_REMOVE, inputJson);
                break;
            case CART_CHECKOUT:
                cartService = restAdapter.create(CartService.class);
                cartService.cartCheckout(false, Service.PRC_CART_CHECKOUT, inputJson);
                break;
            default:
        }
    }
}
