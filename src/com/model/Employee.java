	package com.model;
	import java.io.Serializable;
	import javax.persistence.Entity;
	import javax.persistence.Table;
	import javax.persistence.Id;
	@Entity
	@Table(name="employee")
	public class Employee {
		@Id
		private int empno;
		private String empname;
		private int salary;
		private String job;
		private int deptno;
		public Employee()
		{
		
		}
		
		public void setempno( int empno)
		{
			this.empno=empno;
			System.out.println("calling variable");
		}
		public long getempno()
		{
			return empno;
		}
		public String getEmpname() {
			return empname;
		}
		public void setEmpname(String empname) {
			this.empname = empname;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public int getDeptno() {
			return deptno;
		}
		public void setDeptno(int deptno) {
			this.deptno = deptno;
		}
		
		
		
	
	}
