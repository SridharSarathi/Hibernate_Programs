package com.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.*;
import com.model.Employee;

public class HQL_BetweenSalary {

	public static void main(String[] args) 
	{
		HQL_BetweenSalary bs=new HQL_BetweenSalary();
			bs.salary(5000,7000);

	}
	
	public void salary(int amount1,int amount2)
	{
		
		try
		{
			Configuration cfg=new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			SessionFactory sf=cfg.buildSessionFactory();
			Session ss=sf.openSession();
			
			Transaction t=ss.beginTransaction();
			
			Query query=ss.createQuery("from Employee e where e.salary between "+amount1+" and "+amount2);
			
			List<Employee> li=query.getResultList();
			int size=li.size();
			
			if(size>=1)
			{
				System.out.println("\n|-------------------------------Salary 5000 to 7000 Employees list----------------------------------");
				for(Employee emp:li)
				{
					System.out.print("\n|Id: "+emp.getempno()+" |Name: "+emp.getEmpname()+" | Salary: "+emp.getSalary()+" | Job: "+emp.getJob()+" | DepartementID :"+emp.getDeptno()+"|\n");
				}
				System.out.println("-----------------------------------------------------------------------------------------");
				
			}
			else
				System.out.println("No Record Available ");
			
			t.commit();
			ss.close();
			
		}
		 
		
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}
	

}
