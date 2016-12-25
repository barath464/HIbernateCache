package com.hibernate.association.Many2One;

public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private int salary;
	
	private Address address;

	public Employee() {

	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param salary
	 * @param address
	 */
	public Employee(String firstName, String lastName, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;		

	}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param salary
	 * @param address
	 */
	public Employee(String firstName, String lastName, int salary, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;		
		this.address = address;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}


	

}
