package com.lister.emerge.events;

import com.lister.emerge.dto.CartDTO;
import com.lister.emerge.dto.CustomerpurchaseDTO;
import com.lister.emerge.dto.PurchaseDTO;
import com.lister.emerge.dto.helper.CustomerDTOBuildHelper;
import com.lister.emerge.dto.helper.CustomerDTOBuilder;
import com.lister.emerge.dto.json.JsonBuilder;
import com.lister.emerge.rest.EmergeRestClient;
import com.lister.emerge.util.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * When an item is purchased by the customer, this event will get triggered. It will persist the item purchase event
 * in eMerge through REST API call. Three updates will be made on eMerge :  Upadate member purchase, update purchase history
 * and make purchase event  on eMerge.
 * Created with IntelliJ IDEA.
 * User: vamsi
 * Date: 5/4/14
 * Time: 6:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class PurchaseEvent extends BaseEvent {
    private Logger logger = Logger.getLogger(CustomerEvent.class);
    private JsonBuilder jsonBuilder;
    private EmergeRestClient emergeRestClient;

    /*private PurchaseDTOBuilder purchaseDTOBuilder;
    private PurchaseDTOBuildHelper purchaseDTOBuildHelper;
*/
    /**
     * Constructor
     */
    public PurchaseEvent(JsonBuilder jsonBuilder, EmergeRestClient emergeRestClient) {
        super();
        this.jsonBuilder = jsonBuilder;
        this.emergeRestClient = emergeRestClient;

    }

    /**
     * An order has been placed successfully.
     * @param joinPoint
     * @param returnValue
     */
    public void processOrder(JoinPoint joinPoint, Object returnValue){
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        WebRequest webRequest = new ServletWebRequest(request);
        Order cart = (Order) webRequest.getAttribute("cart", WebRequest.SCOPE_REQUEST);
        Customer customer = (Customer)webRequest.getAttribute("customer", WebRequest.SCOPE_REQUEST);
        // update customer purchase table
        CustomerpurchaseDTO customerpurchaseDTO = new CustomerpurchaseDTO();
        customerpurchaseDTO.setMemberId(customer.getId());
        customerpurchaseDTO.setMemberName(getName(customer.getFirstName(), customer.getLastName()));
        customerpurchaseDTO.setDiscount(cart.getTotalAdjustmentsValue().getAmount().longValue());
        customerpurchaseDTO.setTotalAmount(cart.getTotal().getAmount().longValue());
        List<CustomerpurchaseDTO> customerpurchaseDTOs = Collections.singletonList(customerpurchaseDTO);
        String customerPurchaseDTO = StringUtils.removeQuotesFirstAndLast(jsonBuilder.toJson(customerpurchaseDTOs));
        // create a rest client and call customer purchase controller.
        // update cat history
        PurchaseDTO purchaseDTO = new PurchaseDTO();
        purchaseDTO.setMemberId(customer.getId());
        purchaseDTO.setMemberName(getName(customer.getFirstName(), customer.getLastName()));
        List<OrderItem> items = cart.getOrderItems();

        for (OrderItem item: items){
            item.getCategory().getId();
            item.getCategory().getName();
            if(  !(item instanceof OrderItemImpl)){

            }

        }



    }

    private String getName(String firstName, String lastName){
        return lastName + ", "+ firstName;
    }

}
