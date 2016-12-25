package com.hibernate.association.Many2Many;

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
		
		/* Inserting 2 emplyees 		
		HashSet<Certificate> certificates = new HashSet<Certificate>();
		certificates.add(new Certificate("MCA"));
		certificates.add(new Certificate("MBA"));
		certificates.add(new Certificate("PMP"));
	
		// Add employee records in the database
		Integer empID1 = mangeEmployee.addEmployee("Manoj", "Kumar", 4000, certificates); 
		mangeEmployee.listEmployees(); 
		
		
			certificates.add(new Certificate("OCJP"));
		// Add another employee record in the database
		Integer empID2 = mangeEmployee.addEmployee("Dilip", "Kumar", 3000, certificates); 
		
		// List down all the employees 
		mangeEmployee.listEmployees(); 
		*/
		
		//Update employee's salary records for employee table
		/*
		mangeEmployee.updateEmployee(11, 10000); 
		mangeEmployee.listEmployees(); 
		*/
		/*
		//updating the certificate table
		HashSet<Certificate> certificates = new HashSet<Certificate>();
			certificates.add(new Certificate("MCA"));
			certificates.add(new Certificate("MBA"));
			certificates.add(new Certificate("PMP"));
			certificates.add(new Certificate("OCJP"));
			certificates.add(new Certificate("MangoDB"));
		mangeEmployee.updateEmployee(11, 10000,certificates); 
			mangeEmployee.listEmployees(); 
		
		*/
		
		/* Delete an employee from the database */
			mangeEmployee.deleteEmployee(11); 
		
		/* List down all the employees */
		//ME.listEmployees();
	} 
	
	/* Method to add an employee record in the database */

	public Integer addEmployee(String fname, String lname, int salary, Set<Certificate> certificatesSet) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try {
			tx = session.beginTransaction();
			
			Employee employee = new Employee(fname, lname, salary);
				employee.setCertificates(certificatesSet);
			
			employeeID = (Integer) session.save(employee);
			
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
				Set certificates = employee.getCertificates();
				
				for (Iterator iterator2 = certificates.iterator(); iterator2.hasNext();) {					
					Certificate certName = (Certificate) iterator2.next();
					System.out.println("Certificate: " + certName.getName());
				}
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
			Employee employee = (Employee) session.get(Employee.class,EmployeeID);
				employee.setSalary(salary);
			session.update(employee);
			
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	} 
	
	public void updateEmployee(Integer EmployeeID, int salary,Set<Certificate> certificates) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class,EmployeeID);
				employee.setSalary(salary);
				Set<Certificate> tmpCertificates = employee.getCertificates();
					tmpCertificates.addAll(certificates);
			session.update(employee);
			
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
			Employee employee = (Employee) session.get(Employee.class,EmployeeID);
			session.delete(employee);
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
