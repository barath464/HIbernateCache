package com.hibernate.association.one2Many;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageEmployeeList {

	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		ManageEmployeeList manageEmployeeList = new ManageEmployeeList();

		/* Let us have a set of certificates for the first employee */
		List<Certificate> certificateList1 = new ArrayList<Certificate>();
		certificateList1.add(new Certificate("MCA"));
		certificateList1.add(new Certificate("MBA"));
		certificateList1.add(new Certificate("PMP"));
		
		//Integer empId1 = manageEmployeeList.addEmployee("Manoj", "Kumar", 4000,certificateList1);

		//manageEmployeeList.listEmployees();
		 System.out.println("**************List Created****************");
		 
		 
		/* Another set of certificates for the second employee 
		List<Certificate> certificateList2 = new ArrayList<Certificate>();
		certificateList2.add(new Certificate("BCA"));
		certificateList2.add(new Certificate("BBA"));
		*/
		
		/* Add another employee record in the database */
		
		
		//Integer empId2 = ME.addEmployee("Dilip", "Kumar", 3000,, certificateList2);

		/* List down all the employees */
		manageEmployeeList.listEmployees();
		 System.out.println("**************List Created****************");
		/* Update employee's salary records */
		//ME.updateEmployee(empId1, 5000);
		
		 /* Delete an employee from the database */
		// ME.deleteEmployee(empId2);
		
		 /* List down all the employees */
		//ME.listEmployees();

	}

	/* Method to add an employee record in the database */
	public Integer addEmployee(String fname, String lname, int salary,List<Certificate> certificates) {
		
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		
		try {
			tx = session.beginTransaction();
				Employee employee = new Employee(fname, lname, salary);
					employee.setCertificates(certificates);
					
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
			List<Employee> employees = session.createQuery("FROM Employee").list();
			
			for (Iterator<Employee> iterator1 = employees.iterator(); iterator1.hasNext();) {
				
				Employee employee = (Employee) iterator1.next();
				System.out.print("First Name: " + employee.getFirstName());
				System.out.print(" Last Name: " + employee.getLastName());
				System.out.println(" Salary: " + employee.getSalary());
				
				List<Certificate> certificates = employee.getCertificates();
				for (Iterator<Certificate> iterator2 = certificates.iterator(); iterator2.hasNext();) {
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
			/*
			Certificate certificate = (Certificate) session.get(Certificate.class, 26);
			certificate.setName("OCJP");
			employee.getCertificates().add(certificate); 
			*/			
			 
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
