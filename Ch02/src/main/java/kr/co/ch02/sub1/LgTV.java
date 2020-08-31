package kr.co.ch02.sub1;

public class LgTV implements TV{

	@Override
	public void power() {
		System.out.println("LgTV power...");
	}

	@Override
	public void chUp() {
		System.out.println("LgTV chUp...");
	}

	@Override
	public void soundUp() {
		System.out.println("LgTV soundUP...");
	}

}
