package com.user.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class comparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hello World");
		
		
		Comparator<Integer> comp = new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				
				if(o1 > o2) {
					return 1;
				} else {
					return -1;
				}
			}
			
		};
		
		
		List<Integer> nums = new ArrayList<>();
		
		nums.add(10);
		nums.add(1);
		nums.add(5);
		nums.add(6);
		
		Collections.sort(nums,comp);
		System.out.println(nums);
		
		
		List<employee> employeeess =  new ArrayList<>();
		
		employeeess.add(new employee(40, 50000, "Kiran"));
		employeeess.add(new employee(30, 50000, "Hari"));
		employeeess.add(new employee(60, 40000, "Ramesh"));
		employeeess.add(new employee(20, 80000, "Raghu"));
		employeeess.add(new employee(45, 70000, "Suresh"));
		
		Comparator<employee> empComp = (i,j) -> i.age > j.age?1:-1;
		
		Collections.sort(employeeess,empComp.reversed());
		
		for(employee e : employeeess)
			System.out.println(e.toString());
		
	}

}


class employee implements Comparable<employee>{
	
	public int age;
	public int salary;
	public String name;
	
	
	@Override
	public String toString() {
		return "employee [age=" + age + ", salary=" + salary + ", name=" + name + "]";
	}


	public employee(int age, int salary, String name) {
		super();
		this.age = age;
		this.salary = salary;
		this.name = name;
	}
	
	public int compareTo(employee that) {
		
		return this.salary> that.salary ?1:-1;
		
	}
	
}