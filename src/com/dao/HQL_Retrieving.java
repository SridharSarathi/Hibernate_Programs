package com.dao;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import java.util.*;
import com.model.Employee;


public class HQL_Retrieving {

	public static void main(String[] args) {
		
		HQL_Retrieving hql=new HQL_Retrieving();
				hql.Retrieving('A');
				
			}

	public void Retrieving(char f)
	{
		try {

				Configuration cf=new Configuration();
				cf.configure("hibernate.cfg.xml");
				
				SessionFactory sf=cf.buildSessionFactory();
				Session ss=sf.openSession();
				
				Transaction tx=ss.beginTransaction();
				
				Query q=ss.createQuery("from Employee e where e.empname like '"+f+"%' ");
				
				ArrayList<Employee> list=(ArrayList<Employee>)q.getResultList();
				
				int size=list.size();

				if(size>=1)
				{
					System.out.println("\n|--------------------------------------Employee list----------------------------------");
					for(Employee emp:list)
					{
						System.out.print("\n|Id: "+emp.getempno()+" |Name: "+emp.getEmpname()+" | Salary: "+emp.getSalary()+" | Job: "+emp.getJob()+" | DepartementID :"+emp.getDeptno()+"|\n");
					}
					System.out.println("-----------------------------------------------------------------------------------------");
					
				}
				else
					System.out.println("No Record Available ");
				
				tx.commit();
				ss.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}	
}
