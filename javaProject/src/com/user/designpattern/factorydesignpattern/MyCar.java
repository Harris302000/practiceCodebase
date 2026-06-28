package com.user.designpattern.factorydesignpattern;

public class MyCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Car car = CarFactory.getCar("BMW");
		
		System.out.println(car.drive());
		
		Car car2 =  CarFactory.getCar("Audi");
		
		System.out.println(car2.drive());
		

	}

}


interface Car {
	String drive();
}


class BMW implements Car {

	@Override
	public String drive() {
		return "Driving BMW";

	}

}

class Audi implements Car {

	@Override
	public String drive() {
		return "Driving Audi";

	}

}


class CarFactory{
	
	public static Car getCar(String car) {

		if (car.equals("BMW")) {
			return new BMW();

		} else if (car.equals("Audi")) {

			return new Audi();
		} else {
			return null;
		}

	}
}
