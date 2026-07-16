package com.user.streams;

import java.nio.file.DirectoryStream.Filter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
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
		
		
		Comparator<Employee> byName =
			    (e1, e2) -> e1.getName().compareTo(e2.getName());
			    
		//Find second higest unique number
			    
			    int[] numbers = {12, 5, 18, 9, 25, 30, 18, 5, 40};
			    Optional<Integer> num = Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(n -> n, Collectors.counting())).entrySet()
			    .stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).sorted(Comparator.reverseOrder()).skip(1).findFirst();
			    
			    System.out.println(num);
			    
			    
			    //Find the total amount spent by each customer.
			    String[][] orders = {
			    	    {"John", "Laptop", "80000"},
			    	    {"John", "Mouse", "1000"},
			    	    {"David", "Laptop", "80000"},
			    	    {"David", "Keyboard", "2500"},
			    	    {"Mary", "Mouse", "1000"},
			    	    {"Mary", "Keyboard", "2500"},
			    	    {"John", "Keyboard", "2500"}
			    	};
			    
			    
			    Map<String, Integer> retMap = Arrays.stream(orders).collect(Collectors.groupingBy(e -> e[0], Collectors.summingInt(e -> Integer.parseInt(e[2]))));
			    System.out.println(retMap);
			    
			    //second most frequent word.
			    String[] words = {
			    	    "java",
			    	    "spring",
			    	    "boot",
			    	    "java",
			    	    "react",
			    	    "spring",
			    	    "java",
			    	    "docker"
			    	};	
			    
			    Optional<Map.Entry<String, Long>> aa =  Arrays.stream(words).collect(Collectors.groupingBy(ch -> ch,Collectors.counting())).entrySet().stream().
			    sorted(
			        Comparator.comparing(Map.Entry<String, Long>::getValue)
			                  .reversed()).skip(1).findFirst();
			    
			    
			    
			    //employee with the highest salary in each department
			    String[][] employeesdetails = {
			    	    {"IT", "John", "70000"},
			    	    {"IT", "David", "80000"},
			    	    {"HR", "Mary", "60000"},
			    	    {"HR", "Mike", "65000"},
			    	    {"Finance", "Sara", "90000"},
			    	    {"Finance", "Tom", "85000"},
			    	    {"IT", "James", "75000"}
			    	};
			    
			    Map<String, String> result = Arrays.stream(employeesdetails)
							.collect(Collectors.groupingBy(e -> e[0],
									Collectors.collectingAndThen(
											Collectors.maxBy(Comparator.comparingInt(e -> Integer.parseInt(e[2]))),
											optional -> optional.get()[1])));
			    
			    
			    
			    Map<Character,Long> finalmap = new LinkedHashMap<Character, Long>();
			    
			    String word = "swissw";
			    
			    Character chars = word.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(
			    		Function.identity(), Collectors.counting()
			    		)).entrySet().stream().peek(e -> System.out.println("value::"+e)).filter(e -> e.getValue() > 1).peek(e -> System.out.println("valuesss::"+e.getValue())).map(e -> e.getKey()).findFirst().orElse(null);
			    System.out.println(chars);
			    
			    
			    //Return all numbers divisible by 10 in descending order.
			    int[] arr = {10, 20, 30, 40, 50, 60, 70};
			   
			    List<Integer> retList1 = Arrays.stream(arr).boxed().filter(n -> n%10 == 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
			    
				// The most frequent word.
				String[] wordsarr = { "Java", "Spring", "Java", "React", "Spring", "Java" };
			    
				Optional<Map.Entry<String, Long>> retList2 = Arrays.stream(wordsarr)
			    .collect(Collectors.groupingBy( Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet()
			    .stream().max(Comparator.comparing(Map.Entry::getValue));
				
				
				//The first name that appears exactly once.
				String[] namesarr = { "John", "David", "Mary", "John", "Sara", "David", "John" };
			    
				
				String name = Arrays.stream(namesarr).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet()
						.stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).findFirst().orElse("No Name Found");
				
				
				//The second highest number that appears exactly once.
				
				int[] arr1={10,20,30,40,50,20,30,70};
				
				Integer retNum = Arrays.stream(arr1).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet()
						.stream().filter(e -> e.getValue() == 1).map(e ->e.getKey()).sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
				
				//Department having the highest average salary.
				String[][] employeessss = {
						 {"IT", "John", "100000"},
						    {"IT", "David", "20000"},
						    {"IT", "James", "20000"},
						    {"HR", "Mary", "40000"},
						    {"HR", "Mike", "30000"},
						    {"Finance", "Sara", "30000"},
						    {"Finance", "Tom", "10000"},
						    {"Finance", "Anna", "40000"}
					};
				
				
//				Optional<Map.Entry<String, Double>> retList3 = Arrays.stream(employeessss).
//						collect(Collectors.groupingBy(e -> e[0],Collectors.averagingDouble(e -> Double.parseDouble(e[2])))).entrySet()
//						.stream().max(Comparator.comparing(Map.Entry::getValue));
//				
				//Customer who spent the highest total amount.
				String[][] sales = {
					    {"John","Laptop","80000"},
					    {"John","Mouse","1000"},
					    {"David","Laptop","80000"},
					    {"David","Keyboard","2500"},
					    {"Mary","Mouse","1000"},
					    {"Mary","Keyboard","2500"},
					    {"John","Keyboard","2500"}
					};
				
				Optional<Map.Entry<String, Integer>> retList4 = Arrays.stream(sales).collect(Collectors.groupingBy(e -> e[0],Collectors.summingInt(e -> Integer.parseInt(e[2]))))
						.entrySet().stream().max(Comparator.comparing(Map.Entry<String,Integer>::getValue));
				
				
				String[][] products = {
					    {"P101","Laptop","80000"},
					    {"P102","Mouse","1000"},
					    {"P101","Laptop","82000"},
					    {"P103","Keyboard","2500"},
					    {"P102","Mouse","1200"},
					    {"P104","Monitor","15000"}
					};
				
				Map<String,Integer> retList5 = Arrays.stream(products).collect(Collectors.toMap(i -> i[0], i -> Integer.parseInt(i[2]),Integer::sum,TreeMap::new));
				
				
				String[][] ordersss = {
					    {"John","Laptop"},
					    {"John","Mouse"},
					    {"David","Laptop"},
					    {"David","Keyboard"},
					    {"Mary","Mouse"},
					    {"Mary","Keyboard"},
					    {"John","Keyboard"},
					    {"David","Mouse"},
					    {"John","Laptop"}
					};
				
				
				Map<String,String> retList6 = Arrays.stream(ordersss).collect(Collectors.toMap(i -> i[0],i -> i[1], (a,b) -> a+","+b));
				
				System.out.println("retList6::"+retList6);
				
				
				
				List<Integer> numbersss= new ArrayList<>();

				numbersss.add(30);
				numbersss.add(10);
				numbersss.add(20);
				
				numbersss.sort(Comparator.naturalOrder());
				
//				Collections.sort(numbersss);
				
				System.out.println(numbersss);
				
				
				
				List<Employee> employeeList = new ArrayList<>();

				employeeList.add(new Employee(101, "Agnes", 60000));
				employeeList.add(new Employee(103, "John", 50000));
				employeeList.add(new Employee(102, "David", 70000));
				
				
				employeeList.sort(Comparator.comparing(Employee::getSalary));
				
				for(Employee a : employeeList) {
					System.out.println(a.toString());
				}
				
				
				Collections.sort(employeeList);
				
				for(Employee a : employeeList) {
					System.out.println(a.toString());
				}
				
				
				List<String> names_SS = Arrays.asList(
						"Harris",
					    "Agnes",
					    "John",
					    "David",
					    "Sam"
					);
				
				names_SS.stream()
			     .filter(a -> {
			         System.out.println("Filtering: " + a);
			         return a.startsWith("A");
			     })
			     .map(a -> {
			         System.out.println("Mapping: " + a);
			         return a.toUpperCase();
			     })
			     .findFirst();
				
				
				
				
				//Employee name having the highest salary in that department
				Map<String, String> retList7  = Arrays.stream(employeessss).collect(Collectors.groupingBy(e -> e[0], Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(e -> Integer.parseInt(e[2]))), optional -> optional.get()[1] )));
				System.out.println("retList7: " + retList7);
				
				
				
				Map<String,Integer> retList8 = Arrays.stream(employeessss).collect(Collectors.toMap(e -> e[0], e -> Integer.parseInt(e[2]),Integer::max));
				System.out.println("retList8: " + retList8);
				
				
				
				String[][] employeesz = {
					    {"IT", "John"},
					    {"IT", "David"},
					    {"IT", "James"},
					    {"HR", "Mary"},
					    {"HR", "Mike"},
					    {"Finance", "Sara"}
					};
				
				
				Map<String, String> retList9 = Arrays.stream(employeesz).collect(Collectors.toMap(e -> e[0], e -> e[1],(a,b) -> a+","+b));
				System.out.println("retList9: " + retList9);
				
				
				Map<String, List<String>> retList10 = Arrays.stream(employeesz).collect(Collectors.groupingBy(e -> e[0],Collectors.mapping(e -> e[1], Collectors.toList() ) ));
				System.out.println("retList10: " + retList10);
				
				
				Map<String, Integer> retList11 = Arrays.stream(employeessss).collect(Collectors.groupingBy(e -> e[0],Collectors.collectingAndThen(Collectors.toSet(), Optional -> Optional.size())));
				System.out.println("retList11: " + retList11);
				
				Map<String, List<String>> retList12 = Arrays.stream(employeessss).sorted(Comparator.comparing(e -> Integer.parseInt(e[2])))
						.collect(Collectors.groupingBy(e -> e[0], Collectors.mapping(e -> e[2], Collectors.toList())));
				
				Map<String, Integer> retList13 = Arrays.stream(employeessss).filter(n -> Integer.parseInt(n[2]) >= 70000).collect(Collectors.groupingBy(e -> e[0],Collectors.summingInt(e -> 1)));
	
	
	
	
				String[] wordss = { "Java", "Spring", "Java", "React", "Spring", "Java", "SQL", "React" };
				
				//Task 1 Using HashMap, find the frequency of each word.
				//Normal code
				Map<String,Integer> retmap = new HashMap();
				
				for(int i=0 ;i< wordss.length; i++) {
					
					retmap.put(wordss[i], retmap.getOrDefault(wordss[i], 0) + 1);
						
				}
				
				System.out.println("retmap::"+retmap);
				
				
				//Task2 find the frequency of each word.
				//Stream
				retmap = new HashMap<String, Integer>();
				
				retmap = Arrays.stream(wordss).collect(Collectors.groupingBy(Function.identity(),Collectors.summingInt(e -> 1)));
				
				System.out.println("retmap::"+retmap);
				

				//Task 3  Find the first word whose frequency is exactly 1.
				//Normal code
				retmap = new LinkedHashMap();
				
				for(int i=0 ;i< wordss.length; i++) {
					
					retmap.put(wordss[i], retmap.getOrDefault(wordss[i], 0) + 1);
						
				}
				
				String str = "";
				for (Map.Entry<String, Integer> a : retmap.entrySet()) {

					if (a.getValue() == 1) {
						str = a.getKey();
						break;
					}

				}
				
				System.out.println("str::"+str);
				
				
				//Task 4  Find the first word whose frequency is exactly 1.
				//Stream
				str = "";
				str = Arrays.stream(wordss).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
						.entrySet()
						.stream()
						.filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst().orElseGet(null);
				System.out.println("str::"+str);
				
				
				//Task 5 Find the most frequent word.
				str = "";
				str = Arrays.stream(wordss).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet()	
						.stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).orElseGet(() -> null);
				
	}

}

class Employee implements Comparable<Employee>{

    String name;
    int id;
    double salary;
	List<String> skills;
    
    
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
	public String toString() {
		// TODO Auto-generated method stub
    	
    	
		return id+"-"+name+"-"+salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

    
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

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.id - o.id;
	}


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
