package com.dao;
import java.util.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.SQLQuery;
import com.model.*;


public class HQL_GetUpdate {

	public static void main(String[] args) {
		

		HQL_GetUpdate gu=new HQL_GetUpdate();
		
		gu.getafterUpdate();
	}

	public void getafterUpdate()
	{
		try {
				
				Configuration cfg=new Configuration();
				cfg.configure("hibernate.cfg.xml");
				
				SessionFactory ssf=cfg.buildSessionFactory();
				Session ss=ssf.openSession();
				
				Transaction t=ss.beginTransaction();
				
				String s="select * from employee where salary in(select salary from employee group by salary having count(empname)>1)";
				
				SQLQuery sql=ss.createSQLQuery(s).addEntity(Employee.class);
				ArrayList<Employee> list=(ArrayList<Employee>) sql.list();
				int size=list.size();
				if(size>=1)
				{
					System.out.println("\n|-------------------------------------- Same Salary Employee list----------------------------------");
					for(Employee emp:list)
					{
						System.out.print("\n|Id: "+emp.getempno()+" |Name: "+emp.getEmpname()+" | Salary: "+emp.getSalary()+" | Job: "+emp.getJob()+" | DepartementID :"+emp.getDeptno()+"|\n");
					}
					System.out.println("-----------------------------------------------------------------------------------------");
					
				}
				else
					System.out.println("No Record Available ");
				
				String sq="update employee set salary = 5000 where salary in(select salary from(select salary from employee group by salary having count(empname) > 1) as t)";
						
				SQLQuery q1=ss.createSQLQuery(sq);
				int sucess=q1.executeUpdate();
				
				System.out.println(sucess);
				
				if(sucess>0)
				{
				System.out.println("Salary Updated");
			}	
			
				else
				{
					System.out.println("Update Failed...!!!");
			}
			
				String rs="select * from employee where salary in(select salary from employee group by salary having count(empname)>1)";
				SQLQuery sl=ss.createSQLQuery(rs).addEntity(Employee.class);
				ArrayList<Employee> list2=(ArrayList<Employee>) sql.list();
				int size2=list.size();
				if(size2>0)
				{
					System.out.println("\n|------------------------------------- Same Salary Employee list----------------------------------");
					for(Employee emp:list)
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
		catch(Exception E)
		
		{
			E.printStackTrace();
		}
		

	}
}
