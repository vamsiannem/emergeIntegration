package com.lister.emerge.rest;

import retrofit.RestAdapter;

import com.lister.emerge.enums.EntityOperation;
import com.lister.emerge.enums.Operation;

public class EmergeRestClient {
	
	private static String EMERGE_BASE_ENDPOINT = "http://localhost:8080/EmergeServices/org";
	
	
	
	public void invoke(Operation entityOperation, String inputJson){
		RestAdapter restAdapter = new RestAdapter.Builder()
	    .setEndpoint(EMERGE_BASE_ENDPOINT)
	    .build();
		switch(entityOperation){
		case CUSTOMER_CREATE:
			CustomerService service = restAdapter.create(CustomerService.class);
			service.createCustomer(false, "em_members_update", inputJson);
			break;
			
			default: 
			
		}
		
		
	};

}
