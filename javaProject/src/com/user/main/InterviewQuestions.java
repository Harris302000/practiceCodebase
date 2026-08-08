package com.user.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "swiss";
		
		Map<Character,Integer> map = new LinkedHashMap<>();
		
		
		Character s = str.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
					.entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).findFirst().orElse(null);
		
		Character a = str.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(ch -> ch,LinkedHashMap::new,Collectors.counting())).entrySet()
				.stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).findFirst().orElse(null);
		
		int[] arr = {4,5,1,2,3,2,5,4};
		
		int b = Arrays.stream(arr).boxed()
				.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).map(Map.Entry::getKey).map(e -> (int) e).findFirst().orElse(0);
			
		
		 List<String> cities = Arrays.asList(
	                "Delhi",
	                "Mumbai",
	                "Chennai",
	                "Pune",
	                "Bangalore");
		 
		 
		 String retmsg = cities.stream().max(Comparator.comparing(InterviewQuestions::repeatcharmaxcount)).orElse("");
		 
		System.out.println("retmsg::"+retmsg);

	}
	
	
	public static int repeatcharmaxcount(String city) {
		
		System.out.println("city::"+city);
//		System.out.println("city value::"+(city.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
//				.values()));
				
			
		return Collections.max(city.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.values()).intValue();
		
		
	}

}
