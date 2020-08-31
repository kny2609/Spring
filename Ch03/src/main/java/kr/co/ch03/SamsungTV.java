package kr.co.ch03;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SamsungTV implements TV{
	
	// @Inject
	@Autowired
	private Speaker spk;
	
	@Autowired
	private Internet internet;
	
	@Override
	public void power() {
		System.out.println("SamsungTV power...");
		internet.access();
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
