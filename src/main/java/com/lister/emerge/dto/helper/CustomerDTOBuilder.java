package com.lister.emerge.dto.helper;


import com.lister.emerge.dto.CustomerDTO;

public class CustomerDTOBuilder extends AbstractBuilder<CustomerDTO> {
	private Long memberId;
	private String firstName;
    private String lastName;
    private String email1;
    private Long emId;
    private String mobileNumber;
    private String city;
    private String state;
    private String country;
    private String pinCode;
    private String createdDate;
    private String modifiedDate;
    private String createdBy;
    private String modifiedBy;



    public CustomerDTOBuilder withMemberId(Long memberId){
		this.memberId = memberId;
		return this;
	}
	
	public CustomerDTOBuilder withFirstName(String firstName){
		this.firstName = firstName;
		return this;
	}
	public CustomerDTOBuilder withLastName(String lastName){
		this.lastName = lastName;
		return this;
	}
	public CustomerDTOBuilder withEmail1(String email1){
		this.email1 = email1;
		return this;
	}

    public CustomerDTOBuilder withEmId(Long emId){
        this.emId = emId;
        return this;
    }

    public CustomerDTOBuilder withMobileNum(String mobileNum){
        this.mobileNumber = mobileNum;
        return this;
    }

    public CustomerDTOBuilder withCity(String city){
        this.city = city;
        return this;
    }
    public CustomerDTOBuilder withState(String state){
        this.state = state;
        return this;
    }
    public CustomerDTOBuilder withCountry(String country){
        this.country = country;
        return this;
    }
    public CustomerDTOBuilder withPinCode(String pinCode){
        this.pinCode = pinCode;
        return this;
    }
    public CustomerDTOBuilder withCreatedDate(String createdDate){
        this.createdDate = createdDate;
        return this;
    }
    public CustomerDTOBuilder withModifiedDate(String modifiedDate){
        this.modifiedDate = modifiedDate;
        return this;
    }
    public CustomerDTOBuilder withCreatedBy(String createdBy){
        this.createdBy = createdBy;
        return this;
    }
    public CustomerDTOBuilder withModifiedBy(String modifiedBy){
        this.modifiedBy = modifiedBy;
        return this;
    }
	

}
