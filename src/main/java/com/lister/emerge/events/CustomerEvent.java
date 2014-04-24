package com.lister.emerge.events;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.broadleafcommerce.core.web.controller.account.UpdateAccountForm;
import org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import com.lister.emerge.dto.CustomerDTO;
import com.lister.emerge.dto.CustomerDTOBuilder;
import com.lister.emerge.dto.helper.CustomerDTOBuildHelper;
import com.lister.emerge.dto.json.JsonBuilder;
import com.lister.emerge.enums.Operation;
import com.lister.emerge.enums.UserDeviceType;
import com.lister.emerge.rest.EmergeRestClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component("customerEvent")
public class CustomerEvent extends BaseEvent{

    private Logger logger = Logger.getLogger(CustomerEvent.class);

    /**
     *
     */
    public CustomerEvent() {
        super();
        logger.info("Customer Event Created...");
    }

    //@Autowired
    private JsonBuilder jsonBuilder;

    public void setJsonBuilder(JsonBuilder jsonBuilder) {
        this.jsonBuilder = jsonBuilder;
    }

    //@After(" execution(* org.broadleafcommerce.core.web.controller.checkout.)")
    public void registerUser(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        HttpServletResponse response= (HttpServletResponse) args[1];
        UserDeviceType userDevice = detectUserDevice(request);
        JSONArray cutomersJsonArray = null;

        RegisterCustomerForm customerForm = (RegisterCustomerForm) args[3];
        CustomerDTO customerDto = createCustomerDTO(customerForm);
        logger.info("Order confirmation success");
        String customerJson  = jsonBuilder.toJson(customerDto);
        try {
            cutomersJsonArray = new JSONArray(customerJson);
        } catch (JSONException e) {
            logger.error("Error in tranforming customer object to JSON, can't send this notification to eMerge");
            e.printStackTrace();
        }
        callEmerge(cutomersJsonArray.toString());
    }

    /**
     * Collects the update user data [email, firstName, lastName] and send it to eMerge
     * @param joinPoint
     */
    public void updateUserAcccount(JoinPoint joinPoint){
        logger.info("Update User Account Success");
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        //HttpServletResponse response= (HttpServletResponse) args[1];
        UserDeviceType userDevice = detectUserDevice(request);
        JSONArray cutomersJsonArray = null;
        UpdateAccountForm updateAccountForm = (UpdateAccountForm) args[2];
        CustomerDTO customerDto = createCustomerDTO(updateAccountForm);
        String customerJson  = jsonBuilder.toJson(customerDto);
        try {
            cutomersJsonArray = new JSONArray(customerJson);
        } catch (JSONException e) {
            logger.error("Error in tranforming customer object to JSON, can't send this notification to eMerge");
            e.printStackTrace();
        }
        callEmerge(cutomersJsonArray.toString());
    }






    private CustomerDTO createCustomerDTO(RegisterCustomerForm customerForm) {
        CustomerDTOBuilder cuDtoBuilder = applicationContext.getBean(CustomerDTOBuilder.class);
        CustomerDTOBuildHelper cuDtoBuildHelper = applicationContext.getBean(CustomerDTOBuildHelper.class);
        return cuDtoBuildHelper.createCustomerDTO(customerForm, cuDtoBuilder);
    }

    private CustomerDTO createCustomerDTO(UpdateAccountForm updateAccountForm) {
        CustomerDTOBuilder cuDtoBuilder = applicationContext.getBean(CustomerDTOBuilder.class);
        CustomerDTOBuildHelper cuDtoBuildHelper = applicationContext.getBean(CustomerDTOBuildHelper.class);
        return cuDtoBuildHelper.createCustomerDTO(updateAccountForm, cuDtoBuilder);
    }

    private void callEmerge(String customerJson){
        //new EmergeRestClient().invoke(  , "");
        new EmergeRestClient().invoke(Operation.CUSTOMER_CREATE, customerJson);

    }

    public static void main(String[] args){
        EmergeRestClient client = new EmergeRestClient();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setMemberId(1234L);
        customerDTO.setEmId(1234L);
        customerDTO.setFirstName("Hello");
        customerDTO.setLastName("Acting");
        customerDTO.setEmail1("vamsiannem@gmail.com");
        List<CustomerDTO> list = new ArrayList<CustomerDTO>();
        list.add(customerDTO);
        String customerJson  = new JsonBuilder().toJson(list);
        customerJson = removeQuotesFirstAndLast(customerJson);
        System.out.println(customerJson);
        client.invoke(Operation.CUSTOMER_CREATE, customerJson);
    }

    private static String removeQuotesFirstAndLast(String customerJson) {
        customerJson = customerJson.replaceFirst("\"","").replace("}\"", "}").replace("\\","");
        //customerJson = customerJson.replace("}\"", "}");

        return customerJson;
    }

}
