package br.com.fiap.postech.fastfood.pagamento.services;

import br.com.fiap.postech.fastfood.pagamento.infraestructure.clients.TechChallengeOrder;
import br.com.fiap.postech.fastfood.pagamento.infraestructure.clients.dto.TechChallengeOrderDTO;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

private final TechChallengeOrder techChallengeOrder;

  public PedidoService(TechChallengeOrder techChallengeOrder) {
    this.techChallengeOrder = techChallengeOrder;
  }

  public TechChallengeOrderDTO findByNumeroPedido(String numeroPedido) {
    return techChallengeOrder.findByNumeroPedido(numeroPedido);
  }
}
