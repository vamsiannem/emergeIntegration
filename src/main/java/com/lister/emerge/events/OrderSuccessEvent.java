/**
 * 
 */
package com.lister.emerge.events;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.lister.emerge.enums.UserDeviceType;
import com.lister.emerge.util.UAgentInfo;

/**
 * @author vamsikrishna
 *
 */
//@Component

public class OrderSuccessEvent extends BaseEvent{
	private Logger logger = Logger.getLogger(OrderSuccessEvent.class);
	
	//@After(" execution(* org.broadleafcommerce.core.web.controller.checkout.)")
	public void logOrderSuccess(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		String orderNumber = String.valueOf(args[0]);
		Model modelVars = (Model) args[1];
		HttpServletRequest request = (HttpServletRequest) args[2];
		HttpServletResponse response= (HttpServletResponse) args[3];
		UserDeviceType userDevice = detectUserDevice(request);
		logger.info("Order confirmation success");
	}
 
	/*private UserDeviceType detectUserDevice(HttpServletRequest request) {
		String userAgent = request.getHeader("User-Agent");
	    String httpAccept = request.getHeader("Accept");
	    UserDeviceType userDevice = null;
	    UAgentInfo detector = new UAgentInfo(userAgent, httpAccept);
	    
	     if(detector.detectMobileQuick())
	    	 userDevice = UserDeviceType.MOBILE;
	     else if( detector.detectTierTablet())
	    	 userDevice = UserDeviceType.TAB;
	     else 
	    	 userDevice = UserDeviceType.WEB_BROWSER;
	     
	     return userDevice;
		
	}*/
	
	

}
