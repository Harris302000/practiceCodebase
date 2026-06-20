package com.user.streams;

import java.nio.file.DirectoryStream.Filter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamcasesChatGPT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employee> employees = Arrays.asList(new Employee(1, "John", "IT", 70000, 28),
				new Employee(2, "Mary", "HR", 50000, 30), new Employee(3, "David", "IT", 80000, 35),
				new Employee(4, "Sara", "Finance", 90000, 40), new Employee(5, "Mike", "HR", 60000, 25));

		List<String> names = employees.stream().filter(n -> n.getAge() > 30).map(n -> n.getName())
				.collect(Collectors.toList());
		System.out.println("names::" + names);

		long Count = employees.stream().filter(n -> n.getSalary() > 70000).count();
		System.out.println("Count::" + Count);

		List<String> NamessortedBysal = employees.stream().sorted(Comparator.comparing(Employee::getSalary))
				.map(Employee::getName).collect(Collectors.toList());
		System.out.println("NamessortedBysal::" + NamessortedBysal);

		String nameHighestSal = employees.stream().max(Comparator.comparing(Employee::getSalary)).map(Employee::getName)
				.orElse("No Employee");
		System.out.println("nameHighestSal::" + nameHighestSal);

		String secHighestPaid = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1)
				.findFirst().map(Employee::getName).orElse("Not found");
		System.out.println("secHighestPaid::" + secHighestPaid);

		Map<String, Long> deptMemberCount = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("deptMemberCount::" + deptMemberCount);

		Map<String, Double> dptMemberAvgsal = employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("dptMemberAvgsal::" + dptMemberAvgsal);

		Map<String, Optional<Employee>> highPaidEmp = employees.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		System.out.println("highPaidEmp::" + highPaidEmp);

		Map<String, Optional<Employee>> dptYoungEmp = employees.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.minBy(Comparator.comparing(Employee::getAge))));
		System.out.println("dptYoungEmp::" + dptYoungEmp);

		Map<String, Optional<Employee>> dptOldestEmp = employees.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getAge))));
		System.out.println("dptOldestEmp::" + dptOldestEmp);

		Map<String, Long> countEmpWithSalCond = employees.stream().filter(n -> n.getSalary() > 70000)
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("countEmpWithSalCond::" + countEmpWithSalCond);

		Optional<Map.Entry<String, Double>> maxsalarySum = employees.stream()
				.collect(
						Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
				.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
		System.out.println("maxsalarySum::" + maxsalarySum);

		Optional<Map.Entry<String, Double>> minsalarySum = employees.stream()
				.collect(
						Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
				.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue));
		System.out.println("minsalarySum::" + minsalarySum);

		Map<String, Employee> highPaid = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparing(Employee::getSalary)), Optional::get)));
		System.out.println("highPaid::" + highPaid);

		Map<String, Map<String, List<Employee>>> multigroup = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.groupingBy( e -> e.getAge()<30 ?"Young" : "Senior", Collectors.toList())));
		
		System.out.println("multigroup::"+multigroup);
		
		
		Map<String, List<String>> empList = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("empList::"+empList);
		
		
		Map<String,Employee> p1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)) ,Optional::get)));
		
		Map<String, Map<String, List<Employee>>> p2 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.groupingBy(e -> e.getAge()>=30?"Senior":"Junior",Collectors.toList())));
		
		Map<String ,List<String>> p3 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName, Collectors.toList())));
 		

	}

}
