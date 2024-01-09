package br.com.fiap.postech.fastfood.pagamento.infraestructure.clients;

import br.com.fiap.postech.fastfood.pagamento.infraestructure.clients.dto.TechChallengeOrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "tech-challenge-order")
public interface TechChallengeOrder {

  @RequestMapping(method = RequestMethod.GET, value = "/pedidos/{numeroPedido}", produces = MediaType.APPLICATION_JSON_VALUE)
  TechChallengeOrderDTO findByNumeroPedido(@PathVariable String numeroPedido);


}
