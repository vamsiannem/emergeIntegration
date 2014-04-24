/**
 * 
 */
package com.lister.emerge.events;

import org.aopalliance.intercept.Joinpoint;
import org.apache.log4j.Logger;

import com.lister.emerge.dto.json.JsonBuilder;

/**
 * @author vamsikrishna
 *
 */
public class CartEvent extends BaseEvent {


	private Logger logger = Logger.getLogger(CustomerEvent.class);

	/**
	 *  
	 */
	public CartEvent() {
		super();
		logger.info("Customer Event Created...");
	}

	//@Autowired	
	private JsonBuilder jsonBuilder;
	
	public void addToCart(Joinpoint joinpoint, Object returnValue){
		
	}
}
