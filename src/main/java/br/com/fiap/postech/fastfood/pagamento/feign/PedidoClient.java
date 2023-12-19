package br.com.fiap.postech.fastfood.pagamento.feign;

import br.com.fiap.postech.fastfood.pagamento.pagamento.Pedido;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pedido-service", url = "http://localhost:8082")
public interface PedidoClient {

  @GetMapping
  List<Pedido> findAll();

  @GetMapping("/{numeroPedido}")
  Pedido findByNumeroPedido(@PathVariable String numeroPedido);
}
