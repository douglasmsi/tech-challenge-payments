package br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.impl;


import br.com.fiap.postech.fastfood.pagamento.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.pagamento.domain.pagamento.Pagamento;
import br.com.fiap.postech.fastfood.pagamento.ports.pagamento.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.BuscarPagamentoUseCase;
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
