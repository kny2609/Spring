package kr.co.kmarket.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultVo {

	private int result;
	
	public ResultVo(int result) {
		this.result = result;
	}
	
}
