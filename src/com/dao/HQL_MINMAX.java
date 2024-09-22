package com.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.*;
import com.model.Employee;

public class HQL_MINMAX {

	public static void main(String[] args) {
		HQL_MINMAX ms2=new HQL_MINMAX();
		
		ms2.salary();
	}

	public void salary()
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		
		Transaction t=ss.beginTransaction();
		//Second Maximum salary query
		Query q=ss.createQuery("from Employee  where salary<(select max (salary) from Employee) order by salary desc ");
		q.setMaxResults(1);
		List<Employee> maxlist=q.getResultList();
		int maxsize=maxlist.size();
				
		//Second Minimum Salary
		Query qry=ss.createQuery("from Employee where salary>(select min(salary) from Employee) order by salary asc");
		qry.setMaxResults(1);
		
		List<Employee> minlist=qry.getResultList();
		int minsize=minlist.size();
		
		if(maxsize>=1)
		{
			System.out.println("\n-------------------------------Second Maximum salary----------------------------------");
			for(Employee emp:maxlist)
			{
				System.out.print("\n|Id: "+emp.getempno()+" |Name: "+emp.getEmpname()+" | Salary: "+emp.getSalary()+" | Job: "+emp.getJob()+" | DepartementID :"+emp.getDeptno()+"|\n");
			}
			System.out.println("-----------------------------------------------------------------------------------------");
			
		}
		else
			System.out.println("No Record Available ");
		
		if(minsize>=1)
		{
			System.out.println("\n-------------------------------Second Minimum salary------------------------------------");
			for(Employee emp:minlist)
			{
				System.out.print("\n|Id: "+emp.getempno()+" |Name: "+emp.getEmpname()+" | Salary: "+emp.getSalary()+" | Job: "+emp.getJob()+" | DepartementID :"+emp.getDeptno()+"|\n");
			}
			System.out.println("----------------------------------------------------------------------------------------");
			
		}
		else
			System.out.println("No Record Available ");
		
		
		t.commit();
		ss.close();
		
	}
}
