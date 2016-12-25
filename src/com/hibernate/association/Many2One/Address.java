package com.hibernate.association.Many2One;

public class Address {
	
	private int addId;
	
	private String drNo;
	
	private String street;
	
	private String city;
	
	public Address(){
		
	}

	public Address(String drNo, String street, String city) {
		this.drNo = drNo;
		this.street = street;
		this.city = city;
	}



	/**
	 * @return the addId
	 */
	public int getAddId() {
		return addId;
	}

	/**
	 * @param addId the addId to set
	 */
	public void setAddId(int addId) {
		this.addId = addId;
	}

	/**
	 * @return the drNo
	 */
	public String getDrNo() {
		return drNo;
	}

	/**
	 * @param drNo the drNo to set
	 */
	public void setDrNo(String drNo) {
		this.drNo = drNo;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	

}
