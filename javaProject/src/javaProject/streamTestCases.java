package javaProject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class streamTestCases {

	private int age;
	
	
	
	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public streamTestCases() {
		
		System.out.println("Calling Constructor");
	}
	
	
	public void testCases() {
		
		List<String> numbers = Arrays.asList("1", "2", "3","3","2","4");

		
		List<String> distinctList = numbers.stream().distinct().collect(Collectors.toList());
		double sumValue = numbers.stream().distinct().mapToInt(Integer::parseInt).filter(num -> num % 2 == 0).average().orElse(0.0);
		System.out.println("Sumvalue::"+sumValue);
		System.out.println("distinctList::"+distinctList);
		
		
		List < String > colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown", "Blue","Red");
	    System.out.println("Original List of strings(colors): " + colors);
	    
	    
	    List<String> ascOrder = colors.stream().distinct().sorted().collect(Collectors.toList());
	    System.out.println("ascOrder::"+ascOrder);
	    
	    List<String> descOrder = colors.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	    System.out.println("descOrder::"+descOrder);
	    
	    
		List<String> arr = colors.stream().limit(getAge()).peek(u -> System.out.println("Before: " + u))
				.map(u -> u+1)
				.peek(u -> System.out.println("After: " + u)).collect(Collectors.toList());
	    System.out.println(arr);
	    
		
	}
	
}
