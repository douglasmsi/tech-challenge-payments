package br.com.fiap.postech.fastfood.pagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TechChallengePaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechChallengePaymentsApplication.class, args);
	}

}
