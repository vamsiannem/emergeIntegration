package com.lister.emerge.dto;


import java.io.Serializable;
import java.util.Date;

import com.lister.emerge.dto.helper.Json;

/**
 * Customer related details.
 *
 */
public class CustomerDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2200460991285446043L;

	private Long memberId;

    private Long emId;

    private String firstName;

    private String lastName;

    private String dob;

    private String sex;

    private String city;

    private String state;

    private String pinCode;

    private String country;

    private String occupation;

    private String maritalStatus;

    private String email1;

    private String emailPermStatus;

    private String emailPermReason;

    private String emailPermDate;

    private String emailDelStatus;

    private String emailDelReason;

    private String emailDelDate;

    private String email2;

    private String mobileNumber;

    private String mobileOptinStatus;

    private String mobileDelStatus;

    private String mobileNumber2;

    private String memberType;

    private String activeStatus;

    private Date enrollmentDate;

    private String enrollmentOuCode;

    private Long minOrderValue;

    private Long maxOrderValue;

    private Long maxDiscountValue;

    private Long lastPurchaseValue;

    private Date lastPurchaseDate;

    private String distinctPurchaseDates;

    private Long totalPurchaseAmount;

	private Long totalOrdersValue;

    private String c2;

	private String c3;

    private String c4;

	private String c5;

    private String createdDate;

    private String modifiedDate;

    private String createdBy;

    private String modifiedBy;

    //private String
    @Json
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Json
    public Long getEmId() {
        return emId;
    }

    public void setEmId(Long emId) {
        this.emId = emId;
    }
    @Json
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Json
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Json
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Json
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Json
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Json
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Json
    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    @Json
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Json
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Json
    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    @Json
    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    @Json
    public String getEmailPermStatus() {
        return emailPermStatus;
    }

    public void setEmailPermStatus(String emailPermStatus) {
        this.emailPermStatus = emailPermStatus;
    }

    @Json
    public String getEmailPermReason() {
        return emailPermReason;
    }

    public void setEmailPermReason(String emailPermReason) {
        this.emailPermReason = emailPermReason;
    }

    @Json
    public String getEmailPermDate() {
        return emailPermDate;
    }

    public void setEmailPermDate(String emailPermDate) {
        this.emailPermDate = emailPermDate;
    }

    @Json
    public String getEmailDelStatus() {
        return emailDelStatus;
    }

    public void setEmailDelStatus(String emailDelStatus) {
        this.emailDelStatus = emailDelStatus;
    }

    @Json
    public String getEmailDelReason() {
        return emailDelReason;
    }

    public void setEmailDelReason(String emailDelReason) {
        this.emailDelReason = emailDelReason;
    }

    @Json
    public String getEmailDelDate() {
        return emailDelDate;
    }

    public void setEmailDelDate(String emailDelDate) {
        this.emailDelDate = emailDelDate;
    }

    @Json
    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    @Json
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Json
    public String getMobileOptinStatus() {
        return mobileOptinStatus;
    }

    public void setMobileOptinStatus(String mobileOptinStatus) {
        this.mobileOptinStatus = mobileOptinStatus;
    }

    @Json
    public String getMobileDelStatus() {
        return mobileDelStatus;
    }

    public void setMobileDelStatus(String mobileDelStatus) {
        this.mobileDelStatus = mobileDelStatus;
    }

    @Json
    public String getMobileNumber2() {
        return mobileNumber2;
    }

    public void setMobileNumber2(String mobileNumber2) {
        this.mobileNumber2 = mobileNumber2;
    }

    @Json
    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    @Json
    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Json
    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Json
    public String getEnrollmentOuCode() {
        return enrollmentOuCode;
    }

    public void setEnrollmentOuCode(String enrollmentOuCode) {
        this.enrollmentOuCode = enrollmentOuCode;
    }

    @Json
    public Long getMinOrderValue() {
        return minOrderValue;
    }

    public void setMinOrderValue(Long minOrderValue) {
        this.minOrderValue = minOrderValue;
    }

    @Json
    public Long getMaxOrderValue() {
        return maxOrderValue;
    }

    public void setMaxOrderValue(Long maxOrderValue) {
        this.maxOrderValue = maxOrderValue;
    }

    @Json
    public Long getMaxDiscountValue() {
        return maxDiscountValue;
    }

    public void setMaxDiscountValue(Long maxDiscountValue) {
        this.maxDiscountValue = maxDiscountValue;
    }

    @Json
    public Long getLastPurchaseValue() {
        return lastPurchaseValue;
    }

    public void setLastPurchaseValue(Long lastPurchaseValue) {
        this.lastPurchaseValue = lastPurchaseValue;
    }

    @Json
    public Date getLastPurchaseDate() {
        return lastPurchaseDate;
    }

    public void setLastPurchaseDate(Date lastPurchaseDate) {
        this.lastPurchaseDate = lastPurchaseDate;
    }

    @Json
    public String getDistinctPurchaseDates() {
        return distinctPurchaseDates;
    }

    public void setDistinctPurchaseDates(String distinctPurchaseDates) {
        this.distinctPurchaseDates = distinctPurchaseDates;
    }

    @Json
    public Long getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public void setTotalPurchaseAmount(Long totalPurchaseAmount) {
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    @Json
    public Long getTotalOrdersValue() {
        return totalOrdersValue;
    }

    public void setTotalOrdersValue(Long totalOrdersValue) {
        this.totalOrdersValue = totalOrdersValue;
    }

    @Json
    public String getC2() {
        return c2;
    }


    public void setC2(String c2) {
        this.c2 = c2;
    }

    @Json
    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }

    @Json
    public String getC4() {
        return c4;
    }


    public void setC4(String c4) {
        this.c4 = c4;
    }

    @Json
    public String getC5() {
        return c5;
    }

    public void setC5(String c5) {
        this.c5 = c5;
    }

    @Json
    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Json
    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Json
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Json
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
