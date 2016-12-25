package com.hibernate.association.Many2One;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MangeEmployee {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		MangeEmployee mangeEmployee = new MangeEmployee();
		
		Address address = new Address("1234-56-78", "Miyapur", "Hyderabad");
			int addId = mangeEmployee.addAddress(address);
			address.setAddId(addId);
			
		Employee employee1 = new Employee("Rajesh", "Reddy", 100000, address);
			int empId1 = mangeEmployee.addEmployee(employee1);
			System.out.println("This employee with ID "+empId1+" inserted");
		
		Employee employee2 = new Employee("Srinu", "Reddy", 50000, address);
			int empId2 = mangeEmployee.addEmployee(employee2);
			System.out.println("\nThis employee with ID "+empId2+" inserted");
			
			mangeEmployee.listEmployees();
			
	} 
	
	
	public int addAddress(Address address){		
		
		Session session = factory.openSession();
		Transaction tx = null;
		Integer addId = null;
		try {
			tx = session.beginTransaction();
			
			addId = 	(Integer)session.save(address);
			
			tx.commit();
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return addId;
	}
	/* Method to add an employee record in the database */

	public Integer addEmployee(Employee employee) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			
			employeeID = (Integer)session.save(employee);
			
			tx.commit();
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return employeeID;
	} 
	
	/* Method to list all the employees detail */
	public void listEmployees() {
		
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			
			tx = session.beginTransaction();
			List employees = session.createQuery("FROM Employee").list();
			
			for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();) {
				Employee employee = (Employee) iterator1.next();
				System.out.print("First Name: " + employee.getFirstName());
				System.out.print(" Last Name: " + employee.getLastName());
				System.out.println(" Salary: " + employee.getSalary());
				Address address = employee.getAddress();
					System.out.print("Dr No : " + address.getDrNo());
					System.out.print(" Street No: " + address.getStreet());
					System.out.println(" City: " + address.getCity());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	} 
	
	/* Method to update salary for an employee */
	public void updateEmployee(Integer EmployeeID, int salary) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	} 
	
	
	
	/* Method to delete an employee from the records */
	public void deleteEmployee(Integer EmployeeID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
