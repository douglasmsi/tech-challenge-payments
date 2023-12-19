package br.com.fiap.postech.fastfood.pagamento.usecases.impl;

import br.com.fiap.postech.fastfood.pagamento.feign.PedidoClient;
import br.com.fiap.postech.fastfood.pagamento.pagamento.Pedido;
import br.com.fiap.postech.fastfood.pagamento.usecases.BuscarPedidoUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscarPedidoUseCaseImpl implements BuscarPedidoUseCase {

  private final PedidoClient pedidoClient;

  @Override
  public List<Pedido> findAll() {
    return pedidoClient.findAll();
  }

  @Override
  public Pedido findByNumeroPedido(final String numeroPedido) {
    return pedidoClient.findByNumeroPedido(numeroPedido);
  }
}
