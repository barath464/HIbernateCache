package com.hibernate.caching;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {

	private static SessionFactory factory;

	public static void main(String[] args) {
		
		try {
			
			Configuration configuration = new Configuration();
			factory = configuration.configure().buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);			
		}
		
		ManageEmployee manageEmployee = new ManageEmployee();

		manageEmployee.listEmployees();
		
		
	}
	
	/**
	 * Method to READ all the employees
	 */
	public void listEmployees() {

		Session session = factory.openSession();
		Transaction tx = null;

		try {
			
			//Employee emp1 = new Employee("Srujana", "Gummadi", 100000);
			//Employee emp2 = new Employee("Srujana", "Gummadi", 100000);
			//session.save(emp1);
			//session.save(emp2);
			Employee employee1 = (Employee)session.get(Employee.class, 1);
			
				System.out.println("Employee details: " + employee1);
				
				
			Employee employee2 = (Employee)session.get(Employee.class, 1);
			System.out.println("Employee details: " + employee2);
				
			
				session.close();
				
			System.out.println("******************************* Second Session Started  *******************************");
				Session session2 = factory.openSession();
				
					Employee employee3 = (Employee)session2.get(Employee.class, 1);
					System.out.println("Employee details: " + employee3);
				session2.close();
				
			/*
			for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();) {

				Employee employee = (Employee) iterator.next();
				System.out.print("Emp Id: " + employee.getId());
				System.out.print("; First Name: " + employee.getFirstName());
				System.out.print("; Last Name: " + employee.getLastName());
				System.out.println("; Salary: " + employee.getSalary());
			}
			*/
			
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			
		}
	}

	

}