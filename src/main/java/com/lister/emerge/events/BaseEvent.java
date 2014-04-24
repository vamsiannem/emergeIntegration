package com.lister.emerge.events;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.lister.emerge.enums.UserDeviceType;
import com.lister.emerge.util.UAgentInfo;

public class BaseEvent implements ApplicationContextAware{
	
	ApplicationContext applicationContext;
	
	UserDeviceType detectUserDevice(HttpServletRequest request) {
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
		
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
		
	}
}
