package com.hibernate.annotation;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.annotation.Employee;

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


		/*System.out.println("***************** This is to list the data from employee table *******************");*/
		/* List down all the employees */
		/*manageEmployee.listEmployees();
		System.out.println("**** Before record inserting");*/
		
		Employee employee = new Employee("Srujana", "Gummadi", 100000);
			EmpSalary empSalary = new EmpSalary(60000, 25000, 120000);
			employee.setEmpSalary(empSalary);
		int genId = manageEmployee.insertEmployee(employee);
		
		System.out.println("Inserted employee id is : "+genId);
		System.out.println("**** After record inserting");
		manageEmployee.listEmployees();
		
		// This is for update
		/*
		Employee employee = new Employee("SriChanged", "Harsha Changed", 200000);
			employee.setId(4);
		manageEmployee.updateEmployee(employee);
		
		System.out.println("**** After record updating");
		manageEmployee.listEmployees();
		*/
	//	manageEmployee.deleteEmployee(6);
		
		//System.out.println("************** After record deleting *************");
		//manageEmployee.listEmployees();
		
	}
	public void deleteEmployee(int empId){
		
		Session session = factory.openSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			Employee employee =  (Employee)session.get(Employee.class, empId);
				session.delete(employee);
			tx.commit();
		}catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	public void updateEmployee(Employee changedEmployee){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Employee employee =  (Employee)session.get(Employee.class, changedEmployee.getId());
				employee.setFirstName(changedEmployee.getFirstName());
				employee.setLastName(changedEmployee.getLastName());
				employee.setSalary(changedEmployee.getSalary());
				
				session.update(employee);
			tx.commit();
		}catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	public int insertEmployee(Employee employee){
		Session session = factory.openSession();
		Transaction tx = null;
		int empId=0;
		try{
			tx = session.beginTransaction();
				empId = (Integer)session.save(employee);
			tx.commit();
		}catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return empId;
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
				System.out.println("\t Emp Salary components ");
					System.out.println("; Salary Basic: " + employee.getEmpSalary().getBasic());
					System.out.println("; Salary HRA: " + employee.getEmpSalary().getHra());
					System.out.println("; Salary Gross: " + employee.getEmpSalary().getGorss());
				
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

	

}