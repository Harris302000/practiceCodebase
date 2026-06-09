package com.user.builderdesignpattern;

public class myComputer {

	private String HDD;
	private String ram;
	private String GraphsCard;
	private String SSD;
	private boolean bluetooth;

	private myComputer(String HDD, String ram, String GraphsCard, String SSD, boolean bluetooth) {
		System.out.println("Inside myComputer Constructor");
		this.HDD = HDD;
		this.ram = ram;
		this.GraphsCard = GraphsCard;
		this.SSD = SSD;
		this.bluetooth = bluetooth;
	}

	@Override
	public String toString() {
		return "myComputer [HDD=" + HDD + ", ram=" + ram + ", GraphsCard=" + GraphsCard + ", SSD=" + SSD
				+ ", bluetooth=" + bluetooth + "]";
	}

	public static class computerbuilder {

		private String HDD;
		private String ram;
		private String GraphsCard;
		private String SSD;
		private boolean bluetooth;
		
		public computerbuilder(String HDD, String ram) {
			System.out.println("Inside computerbuilder Constructor");
			this.HDD = HDD;
			this.ram = ram;
			
		}
		
		public computerbuilder addGraphics(String val) {
			this.GraphsCard = val;
			return this;
		}
		
		public computerbuilder addSSD(String val) {
			this.SSD = val;
			return this;
		}
		
		public computerbuilder addBluetooth(Boolean val) {
			this.bluetooth = val;
			return this;
		}
		
		public myComputer build() {
			
			return new myComputer(HDD, ram, GraphsCard, SSD, bluetooth);
		}
		

	}

}
