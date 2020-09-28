package kr.co.ch11;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("kr.co.ch11.dao")
public class Ch11Application {

	public static void main(String[] args) {
		SpringApplication.run(Ch11Application.class, args);
	}

}
