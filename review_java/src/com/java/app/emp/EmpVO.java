package com.java.app.emp;

import java.util.Date;

public class EmpVO {
	//필드 객체가 가져야 하는 정보
	private Integer employeeId;
	private String lastName;
	private Date hireDate;
	private double salary;
	
	//생성자 클랙스 -> 인스턴스를 생성할떄 초기화
	public EmpVO(){}
	public EmpVO(Integer employeeId,String lastName){
		this.employeeId = employeeId;
		this.lastName = lastName;
		this.hireDate = new Date();
		this.salary = 100.0;
	}
	
	
	
	// 메소드 객체가 동자하는 부분
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "EmpVO [employeeId=" + employeeId + ", lastName=" + lastName + ", hireDate=" + hireDate + ", salary="
				+ salary + "]";
	}
	
	
}
