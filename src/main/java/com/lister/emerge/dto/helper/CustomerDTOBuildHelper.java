package com.lister.emerge.dto.helper;

import org.broadleafcommerce.core.web.controller.account.UpdateAccountForm;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerAddress;
import org.broadleafcommerce.profile.core.domain.CustomerPhone;
import org.broadleafcommerce.profile.web.core.form.RegisterCustomerForm;

import com.lister.emerge.dto.CustomerDTO;

import java.util.Date;
import java.util.List;

/**
 * This is a helper class to build {@link CustomerDTO}. All Event capturing classes
 * should use this helper to build customer dto objects.
 * @author vamsikrishna
 *
 */
public class CustomerDTOBuildHelper {

    public CustomerDTO createCustomerDTO(RegisterCustomerForm customerForm, CustomerDTOBuilder cuDtoBuilder) {
        Customer customer = customerForm.getCustomer();
        List<CustomerPhone> customerPhones = customer.getCustomerPhones();
        List<CustomerAddress> customerAddresses = customer.getCustomerAddresses();
        CustomerAddress customerAddress = customerAddresses!=null ? customerAddresses.get(0): null;

        String phoneNumber="";
        if(customerPhones != null &&
                customerPhones.get(0) != null &&
                customerPhones.get(0).getPhone()!=null){
            phoneNumber = customerPhones.get(0).getPhone().getPhoneNumber();
        }
        // Add more data from customer object
        CustomerDTOBuilder customerDTOBuilder = cuDtoBuilder.withMemberId(customer.getId())
                .withEmId(customer.getId())
                .withFirstName(customer.getFirstName())
                .withLastName(customer.getLastName())
                .withEmail1(customer.getEmailAddress())
                .withMobileNum(phoneNumber);
        CustomerDTO customerDTO = null;
        if( customerAddress !=null && customerAddress.getAddress() !=null){
            Address address = customerAddress.getAddress();
            customerDTO = customerDTOBuilder.withCity(address.getCity())
                    .withState(address.getState().getName())
                    .withCountry(address.getCountry().getName())
                    .withPinCode(address.getPostalCode())
                    .withCreatedBy("EMERGE")
                    .withCreatedDate(new Date().toString())
                    .build();
        }
        return customerDTO;
    }

    /**
     * User can update only email, firstName and lastName information.
     * @param updateAccountForm
     * @param cuDtoBuilder
     * @return
     */

    public CustomerDTO createCustomerDTO(UpdateAccountForm updateAccountForm, CustomerDTOBuilder cuDtoBuilder) {
        CustomerDTO customerDTO = cuDtoBuilder.withFirstName(updateAccountForm.getFirstName())
                .withLastName(updateAccountForm.getLastName())
                .withEmail1(updateAccountForm.getEmailAddress()).build();
        return customerDTO;
    }

}
