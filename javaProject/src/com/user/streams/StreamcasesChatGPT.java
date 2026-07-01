package com.user.streams;

import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamcasesChatGPT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<EmployeeDets> employees = Arrays.asList(new EmployeeDets(1, "John", "IT", 70000, 28),
				new EmployeeDets(2, "Mary", "HR", 50000, 30), new EmployeeDets(3, "David", "IT", 80000, 35),
				new EmployeeDets(4, "Sara", "Finance", 90000, 40), new EmployeeDets(5, "Mike", "HR", 60000, 25));

		List<String> names = employees.stream().filter(n -> n.getAge() > 30).map(n -> n.getName())
				.collect(Collectors.toList());
		System.out.println("names::" + names);

		long Count = employees.stream().filter(n -> n.getSalary() > 70000).count();
		System.out.println("Count::" + Count);

		List<String> NamessortedBysal = employees.stream().sorted(Comparator.comparing(EmployeeDets::getSalary))
				.map(EmployeeDets::getName).collect(Collectors.toList());
		System.out.println("NamessortedBysal::" + NamessortedBysal);

		String nameHighestSal = employees.stream().max(Comparator.comparing(EmployeeDets::getSalary)).map(EmployeeDets::getName)
				.orElse("No Employee");
		System.out.println("nameHighestSal::" + nameHighestSal);

		String secHighestPaid = employees.stream().sorted(Comparator.comparing(EmployeeDets::getSalary).reversed()).skip(1)
				.findFirst().map(EmployeeDets::getName).orElse("Not found");
		System.out.println("secHighestPaid::" + secHighestPaid);

		Map<String, Long> deptMemberCount = employees.stream()
				.collect(Collectors.groupingBy(EmployeeDets::getDepartment, Collectors.counting()));
		System.out.println("deptMemberCount::" + deptMemberCount);

		Map<String, Double> dptMemberAvgsal = employees.stream().collect(
				Collectors.groupingBy(EmployeeDets::getDepartment, Collectors.averagingDouble(EmployeeDets::getSalary)));
		System.out.println("dptMemberAvgsal::" + dptMemberAvgsal);

		Map<String, Optional<EmployeeDets>> highPaidEmp = employees.stream().collect(Collectors
				.groupingBy(EmployeeDets::getDepartment, Collectors.maxBy(Comparator.comparing(EmployeeDets::getSalary))));
		System.out.println("highPaidEmp::" + highPaidEmp);

		Map<String, Optional<EmployeeDets>> dptYoungEmp = employees.stream().collect(Collectors
				.groupingBy(EmployeeDets::getDepartment, Collectors.minBy(Comparator.comparing(EmployeeDets::getAge))));
		System.out.println("dptYoungEmp::" + dptYoungEmp);

		Map<String, Optional<EmployeeDets>> dptOldestEmp = employees.stream().collect(Collectors
				.groupingBy(EmployeeDets::getDepartment, Collectors.maxBy(Comparator.comparing(EmployeeDets::getAge))));
		System.out.println("dptOldestEmp::" + dptOldestEmp);

		Map<String, Long> countEmpWithSalCond = employees.stream().filter(n -> n.getSalary() > 70000)
				.collect(Collectors.groupingBy(EmployeeDets::getDepartment, Collectors.counting()));
		System.out.println("countEmpWithSalCond::" + countEmpWithSalCond);

		Optional<Map.Entry<String, Double>> maxsalarySum = employees.stream()
				.collect(
						Collectors.groupingBy(EmployeeDets::getDepartment, Collectors.averagingDouble(EmployeeDets::getSalary)))
				.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
		System.out.println("maxsalarySum::" + maxsalarySum);

		Optional<Map.Entry<String, Double>> minsalarySum = employees.stream()
				.collect(
						Collectors.groupingBy(EmployeeDets::getDepartment, Collectors.averagingDouble(EmployeeDets::getSalary)))
				.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue));
		System.out.println("minsalarySum::" + minsalarySum);

		Map<String, EmployeeDets> highPaid = employees.stream()
				.collect(Collectors.groupingBy(EmployeeDets::getDepartment, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparing(EmployeeDets::getSalary)), Optional::get)));
		System.out.println("highPaid::" + highPaid);

		Map<String, Map<String, List<EmployeeDets>>> multigroup = employees.stream()
				.collect(Collectors.groupingBy(EmployeeDets::getDepartment,Collectors.groupingBy( e -> e.getAge()<30 ?"Young" : "Senior", Collectors.toList())));
		
		System.out.println("multigroup::"+multigroup);
		
		
		Map<String, List<String>> empList = employees.stream()
				.collect(Collectors.groupingBy(EmployeeDets::getDepartment, Collectors.mapping(EmployeeDets::getName, Collectors.toList())));
		System.out.println("empList::"+empList);
		
		
		Map<String,EmployeeDets> p1 = employees.stream().collect(Collectors.groupingBy(EmployeeDets::getDepartment,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(EmployeeDets::getSalary)) ,Optional::get)));
		
		Map<String, Map<String, List<EmployeeDets>>> p2 = employees.stream()
				.collect(Collectors.groupingBy(EmployeeDets::getDepartment,Collectors.groupingBy(e -> e.getAge()>=30?"Senior":"Junior",Collectors.toList())));
		
		Map<String ,List<String>> p3 = employees.stream()
				.collect(Collectors.groupingBy(EmployeeDets::getDepartment,Collectors.mapping(EmployeeDets::getName, Collectors.toList())));
		
		
		Map<String, EmployeeDets> p4 = employees.stream().collect(Collectors.groupingBy(EmployeeDets::getDepartment,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(EmployeeDets::getSalary)), Optional::get)));
 		
		
		Map<String, Map<String, List<String>>> p5 = employees.stream()
				.collect(Collectors.groupingBy(EmployeeDets::getDepartment,Collectors.groupingBy(e -> e.getAge() >= 30 ?"Senior":"Junior",Collectors.mapping(EmployeeDets::getName, Collectors.toList()))));

		
		
//		Customer c = new Customer();
	
		List<Customer> customer = new ArrayList<Customer>();;
		
		Map<String, Double> p6 = customer.stream().flatMap(e -> e.getOrders().stream()).collect(Collectors.groupingBy(Order::getProduct,Collectors.summingDouble(Order::getAmount)));
		
//		c.getOrders().stream().flatMap(C -> c.getOrders()).collect(c)
		
		
		List<Employee> employeesss = new ArrayList();
		
		Map<String, Long> p7  = employeesss.stream().flatMap(e -> e.getSkills().stream()).collect(Collectors.groupingBy(e -> e,Collectors.counting()));
		
		
		
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		List<String> liststr = Arrays.asList("a", "b", "c", "d");
		
		System.out.println("Stream result::"+liststr.stream()
        .reduce(String::concat));
		
		Stream<Integer> stream = list.stream();

		stream.forEach(System.out::println);
		
		
		
		liststr.stream()
	    .peek(System.out::println)
	    .count();
		
		
		int xOO = 10;

		Predicate<Integer> p = (Integer n) -> n > xOO;

		System.out.println(p.test(15));
		
		Predicate<String> namecheck12 = (String a) -> !a.isEmpty();
		
		
		
		
		Map<String, Integer> p8 = customer.stream().flatMap(e -> e.getOrders().stream()).flatMap(e -> e.getItems().stream())
				.collect(Collectors.groupingBy(OrderItem::getProduct,Collectors.summingInt(OrderItem::getQuantity)));
		
	}

}

class Employee {

    String name;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	List<String> skills;

}


class Customer {

    private int customerId;
    private String customerName;
    private List<Order> orders;
    
    
    public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
    
    
    

}

class Order {
	
	private int orderId;
    private String product;
    private double amount;
    
    private List<OrderItem> items;
    

    public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	

}

class OrderItem {
    private String product;
    private int quantity;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
    
    

    // getters
}
