package br.com.fiap.postech.fastfood.pagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TechChallengePagamentoApplication {

  public static void main(String[] args) {
    SpringApplication.run(TechChallengePagamentoApplication.class, args);
  }

}
