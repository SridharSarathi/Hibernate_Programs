package com.dao;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.model.Employee;
import org.hibernate.Transaction;
import java.util.Scanner;

public class InsertOperation {
	
	

	public static void main(String[] args) {
		

		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory fact=cfg.buildSessionFactory();
		Session session=fact.openSession();
		Transaction txt=session.beginTransaction();
		try {
				for(int i=1;i<=2;i++)
				{	
					
				Employee emp=new Employee();
				Scanner s=new Scanner(System.in);
				System.out.println("Enter Employee ID");
				int no=s.nextInt();
				System.out.println("Enter Employee Name");
				String name=s.next();
				System.out.println("Enter Employee Job");
				String job=s.next();
				System.out.println("Enter Employee Salary");
				int  salary=s.nextInt();
				System.out.println("Enter Employee Department ID");
				int deptid=s.nextInt();
				emp.setempno(no);
				emp.setEmpname(name);
				emp.setSalary(salary);
				emp.setJob(job);
				emp.setDeptno(deptid);
				session.save(emp);
				
				System.out.println("1 Record Inserted Successfully");
				
				}
				txt.commit();
				session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
