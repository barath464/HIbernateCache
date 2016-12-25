package com.hibernate.batchprocessing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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


		System.out.println("***************** This is to list the data from employee table *******************");
		/* List down all the employees */
		manageEmployee.listEmployees();
		System.out.println("**** Before record inserting");
		
		List<Employee> employeesList = new ArrayList<Employee>(1000);
		
		for(int i=0;i<1000;i++){
			Employee employee = new Employee();
			employee.setFirstName("f_name-"+i+1);
			employee.setLastName("l_name-"+i+1);
			employee.setSalary(100+(i+1*10));
			employeesList.add(employee);
			
		}
		
			
		List<Integer> genIdList = manageEmployee.insertEmployee(employeesList);
		
		
		System.out.println("**** After record inserting");
		manageEmployee.listEmployees();		
		
		
	}
	

	public List<Integer> insertEmployee(List<Employee> employeeList){
		Session session = factory.openSession();
		Transaction tx = null;
		List<Integer> empIdList = new ArrayList<Integer>();
		int empId=0;
		try{
		//tx = session.beginTransaction();
			for(int i=0;i<1000;i++){
				empId = (Integer)session.save(employeeList.get(i));				
				empIdList.add(empId);
				/*
				if(i%100==0){
					session.flush();
					session.clear();
				}*/
				if(i==210){
					throw new HibernateException("My own exception to check batch processing");
				}				
			}			
			//tx.commit();
		}catch (HibernateException e) {
			//if (tx != null)
				//tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return empIdList;
	}

	/**
	 * Method to READ all the employees
	 */
	public void listEmployees() {

		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			List<?> employees = session.createQuery("FROM Employee").list();
			
			

			for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();) {

				Employee employee = (Employee) iterator.next();
				System.out.print("Emp Id: " + employee.getId());
				System.out.print("; First Name: " + employee.getFirstName());
				System.out.print("; Last Name: " + employee.getLastName());
				System.out.println("; Salary: " + employee.getSalary());
			}
			//tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	

}