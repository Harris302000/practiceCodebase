package com.user.interfaces;

import java.util.function.*;

public class defaultInterfaces {
	
	
	public Consumer<Integer> checkAge = (Integer a) -> {

		if (a > 18) {
			System.out.println("Applicant is a major");

		} else {
			System.out.println("Applicant is a minor");
		}
	};

	public Supplier<String> alert = () -> "Everthing works fine";

	public Function<String, String> checkAccountNumber = (String a) -> a.length() == 12 ? "Valide account Number"
			: "Invalide account Number";

	public Predicate<String> namecheck = (String a) -> !a.isEmpty();

	

}
