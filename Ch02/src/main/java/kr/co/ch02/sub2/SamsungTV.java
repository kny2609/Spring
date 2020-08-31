package kr.co.ch02.sub2;

public class SamsungTV implements TV{

	@Override
	public void power() {
		System.out.println("SamsungTV power...");
	}

	@Override
	public void chUp() {
		System.out.println("SamsungTV chUp...");
	}

	@Override
	public void soundUp() {
		System.out.println("SamsungTV soundUP...");
	}

}
