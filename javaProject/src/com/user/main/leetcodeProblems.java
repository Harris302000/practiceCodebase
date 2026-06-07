package com.user.main;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class leetcodeProblems {

	public void leetcodemain() {
		// TODO Auto-generated method stub
		String s = "   fly me   to   the moon  ";
		System.out.println("lengthOfLastWord::"+lengthOfLastWord(s));
		
		int [] a = {9,8,7,6,5,4,3,2,1,0};
		int [] b = {1,3,0};
		System.out.println("lengthOfLastWord::"+lengthOfLastWord(s));
		System.out.println("plusOne::"+plusOne(b));
		
		String pattern =
				"abba";
		String 	s1 =
				"dog cat cat dog";
		
		wordPattern(pattern, s1);
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

		for (int i = digits.length - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result; 
	}
	
	public void moveZeroes(int[] nums) {

		
		int insertPos = 0;

	    for (int num : nums) {
	        if (num != 0) {
	            nums[insertPos++] = num;
	        }
	    }

	    while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }

	}
	
	
	public boolean wordPattern(String pattern, String s) {
		HashMap<Character, String> a = new HashMap<Character, String>();
		a.put('a', "dog");
		a.put('b', "cat");

		
		
		System.out.println("Hashmap::"+a.get("a"));
		System.out.println("value at::"+pattern.valueOf(pattern.charAt(0)));
		String[] Sarr = s.split(" ");

		if (pattern.length() != Sarr.length) {
			return false;
		}

		int x = 0;

		while (x != pattern.length()) {
			
			char alphabet = pattern.charAt(x);
			System.out.println("character::"+a.get(alphabet));
			
			if(!a.containsKey(alphabet)) {
				return false;
			}
			
			String val = a.get(alphabet);

			if (!val.equals(Sarr[x])) {
				return false;
			}

			x++;
		}

		return true;

	}

}
