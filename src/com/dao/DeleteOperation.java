package com.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import com.model.Employee;

public class DeleteOperation {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session session=sf.openSession();
		
		Transaction txt=session.beginTransaction();
		Employee emp=session.get(Employee.class,1006);
		System.out.println(emp.getEmpname()+" Record deleted successfully");
		session.delete(emp);
	
		
		txt.commit();
		session.close();

	}

}
