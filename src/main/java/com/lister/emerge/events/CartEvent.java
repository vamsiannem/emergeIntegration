/**
 * 
 */
package com.lister.emerge.events;

import com.lister.emerge.dto.CartDTO;
import com.lister.emerge.dto.helper.CartDTOBuilder;
import com.lister.emerge.dto.helper.CartDTOBuilderHelper;
import com.lister.emerge.dto.json.JsonBuilder;
import com.lister.emerge.enums.Operation;
import com.lister.emerge.rest.EmergeRestClient;
import com.lister.emerge.util.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.broadleafcommerce.core.web.order.model.AddToCartItem;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vamsikrishna
 *
 */
public class CartEvent extends BaseEvent {


    private Logger logger = Logger.getLogger(CartEvent.class);
    private JsonBuilder jsonBuilder;
    private EmergeRestClient emergeRestClient;
    private CartDTOBuilder cartDTOBuilder;
    private CartDTOBuilderHelper cartDTOBuilderHelper;
	/**
	 *  
	 */
	public CartEvent(JsonBuilder jsonBuilder, EmergeRestClient emergeRestClient) {
		super();
        this.jsonBuilder = jsonBuilder;
        this.emergeRestClient = emergeRestClient;
		logger.info("Customer Event Created...");
	}

	public void addToCart(JoinPoint joinPoint, Object returnValue){
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = (HttpServletRequest) args[0];
        AddToCartItem cartItem = (AddToCartItem) args[3];
        WebRequest webRequest = new ServletWebRequest(request);
        CartDTO cartDTO = cartDTOBuilderHelper.createCartItemAdd(cartItem, webRequest, cartDTOBuilder);
        List<CartDTO> cartDTOs = new ArrayList<CartDTO>(1);
        cartDTOs.add(cartDTO);
        String cartItemAddJson = StringUtils.removeQuotesFirstAndLast(jsonBuilder.toJson(cartDTOs));
        emergeRestClient.invoke(Operation.CART_ITEM_ADD, cartItemAddJson);
	}

    public void setCartDTOBuilder(CartDTOBuilder cartDTOBuilder) {
        this.cartDTOBuilder = cartDTOBuilder;
    }

    public void setCartDTOBuilderHelper(CartDTOBuilderHelper cartDTOBuilderHelper) {
        this.cartDTOBuilderHelper = cartDTOBuilderHelper;
    }
}
