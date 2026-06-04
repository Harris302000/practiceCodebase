package com.user.main;

import java.util.Arrays;
import java.util.Comparator;

public class leetcodeProblems {

	public void leetcodemain() {
		// TODO Auto-generated method stub
		String s = "   fly me   to   the moon  ";
		System.out.println("lengthOfLastWord::"+lengthOfLastWord(s));
		
		int [] a = {9,8,7,6,5,4,3,2,1,0};
		int [] b = {1,3,0};
		System.out.println("lengthOfLastWord::"+lengthOfLastWord(s));
		System.out.println("plusOne::"+plusOne(b));
	}
	
	
	public int lengthOfLastWord(String s) {

		// Approach 1
//		String[] words = s.trim().split("\\s+");
//	    return words[words.length - 1].length();

		// Approach 2 - efficient
//		int length = 0;
//	    int i = s.length() - 1;
//
//	    while (i >= 0 && s.charAt(i) == ' ') {
//	        i--;
//	    }
//
//	    while (i >= 0 && s.charAt(i) != ' ') {
//	        length++;
//	        i--;
//	    }
//	    return length;

		// Approach 3
		return Arrays.stream(s.trim().split("\\s+")).reduce((first, second) -> second).orElse("").length();

	}
	
	

	public int[] plusOne(int[] digits) {

		int result = 0;
		for (int digit : digits) {
			result = result * 10 + digit;
		}

		System.out.println(result);
		result +=1;
		System.out.println(result);
		
		String resultSTR = Integer.toString(result);
		
		int i = resultSTR.length();
		
		int[] resArr = new int [resultSTR.length()];
		
		while (i != 0) {
			int divresult = result % 10;
			result = result / 10;
			i--;
			resArr[i] = divresult;
			
		}
		
		return resArr;
	}

}
