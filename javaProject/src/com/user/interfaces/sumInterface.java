package com.user.interfaces;

@FunctionalInterface
public interface sumInterface {

	public int addNumbers(int a,int b);
	
	
	default void operationType(String logger) {
		
		System.out.println(logger);
	};
	
	
}
