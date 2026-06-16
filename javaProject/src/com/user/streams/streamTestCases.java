package com.user.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


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
		double sumValue = numbers.stream().distinct().mapToInt(Integer::parseInt).map(u -> u+2)
				.filter(num -> num % 2 == 0).average().orElse(0.0);
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
	
	
	
	public void moveAllZeroToEnd(List<Integer> DataList) {
		System.out.println("Inside moveAllZeroToEnd Method");
		
		List<Integer> map = Stream.concat(DataList.stream().filter(e -> e!=0), 
				DataList.stream().filter(e -> e==0)).collect(Collectors.toList());
		
		System.out.println("moveAllZeroToEnd map::"+map);
		
	}
	
	public void sortMapValues() {
		System.out.println("Inside sortMapValues Method");
		
		Map <String,Integer> map = new HashMap<>();
		map.put("A", 9);
		map.put("B", 3);
		map.put("C", 5);
		map.put("D", 20);
		
		System.out.println("map before sorting::"+map);
		
		
		Map<Object, Object> sortedmap =  map.entrySet().stream()
		.sorted(Map.Entry.comparingByValue())
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2) -> e1, LinkedHashMap::new));
		
		
		sortedmap.forEach((Key,Value) -> System.out.println(Key+" - "+Value));
		
		
		 
	}
	
	
	public void ReverseWordAndCharacters() {
		System.out.println("Inside ReverseWordAndCharacters Method");
		String s = "AGNES HARRIS";
		
		String ss=	"";
		
		ss=	Arrays.stream(s.split(" ")).sorted(Comparator.reverseOrder()).collect(Collectors.joining(" "));
		System.out.println("ss::"+ss);
		
		ss=	Arrays.stream(s.split(" ")).sorted(Comparator.reverseOrder()).map(n -> new StringBuilder(n).reverse().toString())
				.collect(Collectors.joining(" "));
		System.out.println("ss::"+ss);
		
		
	}
	
	public void findDuplicateFromList() {
		System.out.println("Inside findDuplicateFromList Method");
		
		List<Integer> numbers = List.of(1,2,2,3,9,10,3,2);
		
		Set<Integer> countMap =  numbers.stream().collect(Collectors.groupingBy(n ->n, Collectors.counting())).entrySet()
				.stream().filter(e -> e.getValue() > 1).map(n -> n.getKey()).collect(Collectors.toSet());
		
		String countSTR =  numbers.stream().collect(Collectors.groupingBy(n ->n, Collectors.counting())).entrySet()
				.stream().filter(e -> e.getValue() > 1).map(n ->  String.valueOf(n.getKey()) ).collect(Collectors.joining(","));
		
		System.out.println("countMap::"+countMap);
		System.out.println("countSTR::"+countSTR);
		
	}
	
	public void mergeTwoArrays() {
		System.out.println("Inside mergeTwoArrays Method");
		
		Integer [] arr1 = {1,2,3};
		Integer [] arr2 = {4,5};
		
		Integer [] mergeArray = Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).toArray(Integer[]::new);
		List<Integer> mergeArrayInt  = Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).collect(Collectors.toList());

		System.out.println("mergeArray::"+Arrays.toString(mergeArray));
		System.out.println("mergeArrayInt::"+mergeArrayInt);
		
	}
	
	
	public void findFirstRepeatedCharsFormString() {
		System.out.println("Inside findFirstRepeatedCharsFormString Method");
		
		String S = "AI is getting more powerful";
		
		Character Char = S.chars().mapToObj(ch -> (char) ch).filter(ch -> ch != ' ').collect(Collectors.groupingBy(ch -> ch,Collectors.counting())).entrySet().stream()
		.filter(ch -> ch.getValue() > 1).findFirst().get().getKey();
		
		System.out.println("Char::"+Char);
		
		
	}
	
	
	public void findStatrtsWith() {
		System.out.println("Inside findStatrtsWith Method");
		
		String STR = "apple banana mango box been fox auto bike";
		
		
		List <String> words = Arrays.stream(STR.split(" ")).filter(n -> n.startsWith("b")).collect(Collectors.toList());
		System.out.println("Starts with words::"+words);
		
	}
	
	public void primeNumber() {
		System.out.println("Inside primeNumber Method");
		
		IntStream.rangeClosed(1, 100).filter(n -> n > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(n)).noneMatch(i -> n % i == 0))
		.forEach(n -> System.out.print(n+" "));
		
	}
	
	public void findFreqencyOfChar() {
		System.out.println();
		System.out.println("Inside findFreqencyOfChar Method");
		
		String STR = "babca";
		
		Map<Character, Long> countMap =   STR.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(ch -> ch,Collectors.counting()));
		STR.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(ch -> ch,Collectors.counting()))
		.forEach((key,value) -> System.out.print(key+""+value));
		System.out.println();
		System.out.println("countMap::"+countMap);
		char a =   STR.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(ch -> ch,Collectors.counting())).entrySet().stream()
				.filter(n -> n.getValue()>1).findFirst().get().getKey();
		System.out.println("countMap::"+a);
		
	}
	
	
	public void findMaxSubStringWithoutRepeatedChars() {

		System.out.println("Inside findMaxSubStringWithoutRepeatedChars Method");

		String STR = "abcabcd";

		int start = 0;
		int maxLength = 0;

		Map<Character, Integer> map = new HashMap<>();

		for (int end = 0; end < STR.length(); end++) {
			
			char c = STR.charAt(end);
			
			if(map.containsKey(c) && map.get(c) >= start) {
				start = map.get(c) + 1;
			}
			
			map.put(c, end);
			maxLength = Math.max(maxLength, end - start +1);
		}

		System.out.println("maxLength::"+maxLength);
	}
	
	
	//Kadane’s Algorithm.
	public static int maxSubArray(){

		int[] nums={-2,1,-3,4,-1,2,1,-5,4};
		
	    
	    int max = nums[0];
	    int current = nums[0];
	    
	    for(int i=0;i<nums.length;i++) {
	    	
	    	
	    	current = Math.max(nums[i], current + nums[i]);
	    	max = Math.max(max, current);
	    	
	    }
	    
	    System.out.println("max::"+max);

	    return max;
	}
	
}
