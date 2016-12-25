package com.hibernate.caching;

public class Employee {
	
	private static final long serialVersionUID = 1L;

	private int id;
	
	private  String firstName;
	
	private String lastName;
	
	private int salary;
	
	public Employee(){
	}
		
	
	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param salary
	 */
	public Employee(int id, String firstName, String lastName, int salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}


	/**
	 * @param firstName
	 * @param lastName
	 * @param salary
	 * @param certificates
	 */
	public Employee(String firstName, String lastName, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;		
	}
	
	public String toString(){
		return "EmpId :: "+id+"; firstName:: "+firstName+" lastName:: "+"; salary:: "+salary;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
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
	 * @param firstName the firstName to set
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
	 * @param lastName the lastName to set
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
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}