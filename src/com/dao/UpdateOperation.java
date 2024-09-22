package com.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import com.model.Employee;
import java.util.Scanner;

public class UpdateOperation {

	public static void main(String[] args)
	{	Scanner sc=new Scanner(System.in);
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session session=sf.openSession();
		
		Transaction txt=session.beginTransaction();
		Employee emp=session.get(Employee.class, 1001);
		System.out.println("\nWhich field you want to update...!\n");
		System.out.println("Enter any one Option\n"+"1.EMP_NO\n"+"2.EMP_NAME\n"+"3.SALARY\n"+"4.DEPARTMENT ID\n"+"5.JOB");
		int option=sc.nextInt();
		switch(option)
		{
			case 1:
			{
				System.out.println("ID-"+emp.getempno()+"\nEnter the new id");
				int id=sc.nextInt();
				emp.setempno(id);
				session.update(emp);
				System.out.println(emp.getempno()+" Update Successfully");
				txt.commit();
				session.close();
			}
			

			case 2:
			{
				System.out.println("Name"+emp.getEmpname()+"\nEnter the Name");
				String name=sc.next();
				emp.setEmpname(name);
				session.update(emp);
				System.out.println(emp.getempno()+" Update Successfully");
				txt.commit();
				session.close();
			}
			case 3:
			{
				System.out.println("Salary="+emp.getSalary()+"\nEnter the Salary");
				int salary=sc.nextInt();
				emp.setSalary(salary);
				session.update(emp);
				System.out.println(emp.getempno()+" Update Successfully");
				txt.commit();
				session.close();
			}
			case 4:
			{
				System.out.println("Department id="+emp.getDeptno()+"\nEnter the  Department id");
				int deptid=sc.nextInt();
				emp.setDeptno(deptid);
				session.update(emp);
				System.out.println(emp.getempno()+" Update Successfully");
				txt.commit();
				session.close();
			}
			case 5:
			{
				System.out.println("Job="+emp.getJob()+"\nEnter the Job");
				String job=sc.next();
				emp.setJob(job);
				session.update(emp);
				System.out.println(emp.getempno()+" Update Successfully");
				txt.commit();
				session.close();
			}
		    
		
		}
		
		

		
		

	}

}
