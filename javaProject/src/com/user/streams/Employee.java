package com.user.streams;

public class Employee {
	
	private int id;
	
	private String name;

	private String department;
	
	private int salary;
	
	private int age;

	
	public Employee(int id, String name, String ddpt, int salary, int age) {
		super();
		this.id = id;
		this.name = name;
		this.department = ddpt;
		this.salary = salary;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDdpt(String ddpt) {
		this.department = ddpt;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


}
