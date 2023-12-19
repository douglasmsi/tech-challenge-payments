package br.com.fiap.postech.fastfood.pagamento.usecases;

import br.com.fiap.postech.fastfood.pagamento.pagamento.Pedido;
import java.util.List;

public interface BuscarPedidoUseCase {

  List<Pedido> findAll();

  Pedido findByNumeroPedido(String numeroPedido);
}
