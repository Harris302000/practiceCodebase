package com.user.streams;

import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class InterviewCodePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String str = "Hello World";
		
		String reversedStr = new StringBuilder(str).reverse().toString();
		System.out.println("reversedStr::"+reversedStr);
		
		str = "MADAM";
		
		if(!str.isEmpty()) {
			
			int i = 0;
			int j = str.length() - 1;
			
			while(i < j) {
			
				if(str.charAt(i) != str.charAt(j)) {
					System.out.println("Not a palindrome");
					break;
				}
				
				i++;
				j--;
				
			}
			
			System.out.println("palindrome");
			
		}
		
		String str1= "silent";
		String str2= "listen";
		
		if(str1.length() == str2.length()) {
			
			
			List<Character> strarr1 =  str1.chars().mapToObj(ch -> (char) ch).sorted().collect(Collectors.toList());
			List<Character> strarr2 =  str2.chars().mapToObj(ch -> (char) ch).sorted().collect(Collectors.toList());
			
			int i=0;
			boolean flag = true;
			while(i != str2.length()) {
				
				
				if(strarr1.get(i) != strarr2.get(i)) {
					flag = false;
					break;
				}
				
				i++;
				
			}
			
			
			if(flag) {
				System.out.println("Anagram");
			} else {
				System.out.println("Not Anagram");
			}
			
			
			
		} else {
			System.out.println("Not Anagram");
		}
		
		
		
		int[] frequency = new int[26];

		for (int i = 0; i < str1.length(); i++) {
		    frequency[str1.charAt(i) - 'a']++;
		    frequency[str2.charAt(i) - 'a']--;
		}

		boolean isAnagram = true;

		for (int count : frequency) {
		    if (count != 0) {
		        isAnagram = false;
		        break;
		    }
		}

		System.out.println(isAnagram ? "Anagram" : "Not Anagram");
		
		
		String a = "programming";
		
//		HashMap <Character,Long> duplicateMap = 
				a.chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(ch -> ch,Collectors.counting())).entrySet()
					.stream().filter(E -> E.getValue() > 1).forEach(e -> System.out.println(e.getKey()));
		
		
		
		
		
	}

}
