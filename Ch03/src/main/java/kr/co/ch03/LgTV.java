package kr.co.ch03;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

@Repository
public class LgTV implements TV{
	
	// @Autowired
	@Inject
	private Speaker spk;
	
	@Inject
	private Internet internet;
	
	@Override
	public void power() {
		System.out.println("LgTV power...");
		internet.access();
	}

	@Override
	public void chUp() {
		System.out.println("LgTV chUp...");
	}

	@Override
	public void soundUp() {
		spk.soundUp();
	}

}
