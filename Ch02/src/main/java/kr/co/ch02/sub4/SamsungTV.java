package kr.co.ch02.sub4;

public class SamsungTV implements TV{
	
	private Speaker spk;
	
	public SamsungTV(Speaker spk) {
		this.spk = spk;
	}

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
		spk.soundUp();
	}

}
