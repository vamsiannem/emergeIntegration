package com.lister.emerge.dto.helper;

import com.lister.emerge.dto.CartDTO;
import org.apache.commons.lang.time.DateFormatUtils;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.web.order.model.AddToCartItem;
import org.broadleafcommerce.core.web.order.security.CartStateRequestProcessor;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: vamsi
 * Date: 4/24/14
 * Time: 11:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class CartDTOBuilderHelper {

    /**
     *
     * @param cartItem
     * @param request
     * @param cartDTOBuilder
     * @return
     */
    public CartDTO createCartItemAdd(AddToCartItem cartItem, WebRequest request, CartDTOBuilder cartDTOBuilder){

        Order cart = (Order) request.getAttribute("cart", WebRequest.SCOPE_REQUEST);
        /*CartDTO cartDTO = new CartDTO();
        cartDTO.setCartId(String.valueOf(cart.getId()));
        cartDTO.setEventId(104); // 104 - Add item to cart.
        // If item attributes have name in it, then we can use that here.
        cartDTO.setEventValue(cartItem.getProductId().toString());
        //responseMap.put("productName", catalogService.findProductById(addToCartItem.getProductId()).getName());
        cartDTO.setMemberId(((Customer)request.getAttribute("customer", WebRequest.SCOPE_REQUEST)).getId().intValue());*/
        return cartDTOBuilder.withCartId(String.valueOf(cart.getId()))
                .withEventValue(String.valueOf(cartItem.getProductId()))
                .withEventId(104)
                .withMemberId(((Customer)request.getAttribute("customer", WebRequest.SCOPE_REQUEST)).getId().intValue())
                .withCreatedDate(DateFormatUtils.format(cart.getSubmitDate(), "yyyyMMdd")).build();

    }

    /**
     *
     * @param cartItem
     * @param request
     * @param cartDTOBuilder
     * @return  CartDTO
     */
    public CartDTO cartItemRemove(AddToCartItem cartItem, WebRequest request, CartDTOBuilder cartDTOBuilder){

        Order cart = (Order) request.getAttribute("cart", WebRequest.SCOPE_REQUEST);
        return cartDTOBuilder.withCartId(String.valueOf(cart.getId()))
                .withEventValue(String.valueOf(cartItem.getProductId()))
                .withEventId(105)
                .withMemberId(((Customer)request.getAttribute("customer", WebRequest.SCOPE_REQUEST)).getId().intValue())
                .withCreatedDate(DateFormatUtils.format(cart.getSubmitDate(), "yyyyMMdd")).build();

    }

    /**
     *
     *
     * @param request
     * @param cartDTOBuilder
     * @return  CartDTO
     */
    public CartDTO cartCheckout(WebRequest request, CartDTOBuilder cartDTOBuilder){

        Order cart = (Order) request.getAttribute("cart", WebRequest.SCOPE_REQUEST);
        return cartDTOBuilder.withCartId(String.valueOf(cart.getId()))
                .withEventValue(String.valueOf(cart.getId()))
                .withEventId(107)
                .withMemberId(((Customer)request.getAttribute("customer", WebRequest.SCOPE_REQUEST)).getId().intValue())
                .withCreatedDate(DateFormatUtils.format(cart.getSubmitDate(), "yyyyMMdd")).build();

    }


}
