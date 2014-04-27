package com.lister.emerge.events;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lister.emerge.util.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.broadleafcommerce.core.web.controller.account.UpdateAccountForm;
import org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import com.lister.emerge.dto.CustomerDTO;
import com.lister.emerge.dto.helper.CustomerDTOBuilder;
import com.lister.emerge.dto.helper.CustomerDTOBuildHelper;
import com.lister.emerge.dto.json.JsonBuilder;
import com.lister.emerge.enums.Operation;
import com.lister.emerge.enums.UserDeviceType;
import com.lister.emerge.rest.EmergeRestClient;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles all events related to Customer.
 * When a customer registers or updates his profile, the Customer info will be sent to Emerge via restClient.
 */
//@Component("customerEvent")
public class CustomerEvent extends BaseEvent {

    private Logger logger = Logger.getLogger(CustomerEvent.class);
    private JsonBuilder jsonBuilder;
    private EmergeRestClient emergeRestClient;

    private CustomerDTOBuilder customerDTOBuilder;
    private CustomerDTOBuildHelper customerDTOBuildHelper;

    /**
     * Constructor
     */
    public CustomerEvent(JsonBuilder jsonBuilder, EmergeRestClient emergeRestClient) {
        super();
        this.jsonBuilder = jsonBuilder;
        this.emergeRestClient = emergeRestClient;
        logger.info("Customer Event Created...");
    }

    //@Autowired


    //@After(" execution(* org.broadleafcommerce.core.web.controller.checkout.)")
    public void registerUser(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        HttpServletResponse response = (HttpServletResponse) args[1];
        UserDeviceType userDevice = detectUserDevice(request);
        JSONArray cutomersJsonArray = null;

        RegisterCustomerForm customerForm = (RegisterCustomerForm) args[3];
        CustomerDTO customerDto = createCustomerDTO(customerForm);
        List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();
        customerDTOs.add(customerDto);
        logger.info("Order confirmation success");
        String customerJson = StringUtils.removeQuotesFirstAndLast(jsonBuilder.toJson(customerDTOs));
        emergeRestClient.invoke(Operation.CUSTOMER_CREATE, customerJson);
    }

    /**
     * Collects the update user data [email, firstName, lastName] and send it to eMerge
     *
     * @param joinPoint
     */
    public void updateUserAccount(JoinPoint joinPoint) {
        logger.info("Update User Account Success");
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        //HttpServletResponse response= (HttpServletResponse) args[1];
        UserDeviceType userDevice = detectUserDevice(request);
        JSONArray cutomersJsonArray = null;
        UpdateAccountForm updateAccountForm = (UpdateAccountForm) args[2];
        CustomerDTO customerDto = createCustomerDTO(updateAccountForm);
        List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();
        customerDTOs.add(customerDto);
        String customerJson = StringUtils.removeQuotesFirstAndLast(jsonBuilder.toJson(customerDTOs));
        emergeRestClient.invoke(Operation.CUSTOMER_CREATE, customerJson);
    }

    private CustomerDTO createCustomerDTO(RegisterCustomerForm customerForm) {
        return customerDTOBuildHelper.createCustomerDTO(customerForm, customerDTOBuilder);
    }

    private CustomerDTO createCustomerDTO(UpdateAccountForm updateAccountForm) {
        return customerDTOBuildHelper.createCustomerDTO(updateAccountForm, customerDTOBuilder);
    }

    /**
     * For Testing .
     *
     * @param args
     */
    public static void main(String[] args) {
        EmergeRestClient client = new EmergeRestClient();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setMemberId(1234L);
        customerDTO.setEmId(1234L);
        customerDTO.setFirstName("Hello");
        customerDTO.setLastName("Acting");
        customerDTO.setEmail1("vamsiannem@gmail.com");
        List<CustomerDTO> list = new ArrayList<CustomerDTO>();
        list.add(customerDTO);
        String customerJson = new JsonBuilder().toJson(list);
        customerJson = StringUtils.removeQuotesFirstAndLast(customerJson);
        System.out.println(customerJson);
        client.invoke(Operation.CUSTOMER_CREATE, customerJson);
    }

    public void setCustomerDTOBuilder(CustomerDTOBuilder customerDTOBuilder) {
        this.customerDTOBuilder = customerDTOBuilder;
    }

    public void setCustomerDTOBuildHelper(CustomerDTOBuildHelper customerDTOBuildHelper) {
        this.customerDTOBuildHelper = customerDTOBuildHelper;
    }
}
