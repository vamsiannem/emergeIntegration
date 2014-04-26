package com.lister.emerge.dto.helper;

import com.lister.emerge.dto.CartDTO;

/**
 * Created with IntelliJ IDEA.
 * User: vamsi
 * Date: 4/24/14
 * Time: 11:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class CartDTOBuilder extends AbstractBuilder<CartDTO>{
    private String sessionKey;

    private String cartId;

    private int eventId;

    private String eventValue;

    private int memberId;

    private String createdDate;

    private int displayCookieId;

    public CartDTOBuilder withSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
        return this;
    }

    public CartDTOBuilder withCartId(String cartId) {
        this.cartId = cartId;
        return this;
    }

    public CartDTOBuilder withEventId(int eventId) {
        this.eventId = eventId;
        return this;
    }

    public CartDTOBuilder withEventValue(String eventValue) {
        this.eventValue = eventValue;
        return this;
    }

    public CartDTOBuilder withMemberId(int memberId) {
        this.memberId = memberId;
        return this;
    }

    public CartDTOBuilder withCreatedDate(String createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public CartDTOBuilder withDisplayCookieId(int displayCookieId) {
        this.displayCookieId = displayCookieId;
        return this;
    }
}
