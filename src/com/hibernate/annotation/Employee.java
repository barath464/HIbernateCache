package com.hibernate.annotation;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
@Cacheable
public class Employee {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	
	@Column(name="first_name")
	private  String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="salary")
	private int salary;
	
	@Embedded
	private EmpSalary empSalary;
	
	
	public Employee(){
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

	/**
	 * @return the empSalary
	 */
	public EmpSalary getEmpSalary() {
		return empSalary;
	}

	/**
	 * @param empSalary the empSalary to set
	 */
	public void setEmpSalary(EmpSalary empSalary) {
		this.empSalary = empSalary;
	}

	
}
