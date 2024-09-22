package com.dao;
import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Iterator;
import org.hibernate.query.Query;

import com.model.Employee;


import org.hibernate.SessionFactory;


public class SelectOperation {
	
	public static void main(String args[])
	{
		Configuration c=new Configuration();
		c.configure("hibernate.cfg.xml");
		
		SessionFactory sf=c.buildSessionFactory();
		Session session=sf.openSession();

		Query<Employee> query = session.createQuery("FROM Employee", Employee.class);

		List<Employee> emplist = query.list();
	        int size=emplist.size();
		
		session.close();
			if(size>=1)
			{	
				System.out.println("Employee List \n");
				for (Employee emp :emplist ) 
				{
				 System.out.print("\nId="+emp.getempno()+" Name="+emp.getEmpname()+" Salary="+emp.getSalary()+" Job="+emp.getJob()+" DepartementID="+emp.getDeptno()+"\n");
				}
			}
			else
			{
				System.out.println("No Record Yet");
			}
		 
		}

}
