package cn.ekgc.sms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.ekgc.sms.dao")
@SpringBootApplication
public class ProviderStarter {
	public static void main(String[] args) {
		SpringApplication.run(ProviderStarter.class, args);
	}
}
