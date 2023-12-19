package br.com.fiap.postech.fastfood.pagamento.usecases.impl;

import br.com.fiap.postech.fastfood.pagamento.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.pagamento.pagamento.Pagamento;
import br.com.fiap.postech.fastfood.pagamento.ports.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.usecases.BuscarPagamentoUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscarPagamentoUseCaseImpl implements BuscarPagamentoUseCase {

  private final PagamentoPersistencePort pagamentoPersistencePort;

  @Override
  public Pagamento findById(Long id) {
    return pagamentoPersistencePort.findById(id);
  }

  @Override
  public List<Pagamento> findAll() {
    return pagamentoPersistencePort.findAll();
  }

  @Override
  public List<Pagamento> findAllByStatus(PagamentoStatus status) {
    return pagamentoPersistencePort.findAllByStatus(status);
  }

  @Override
  public PagamentoStatus getStatusPagamento(String numeroPedido) {
    return pagamentoPersistencePort.getStatusPagamento(numeroPedido);
  }
}
