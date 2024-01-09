package br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.impl;


import br.com.fiap.postech.fastfood.pagamento.domain.pagamento.Pagamento;
import br.com.fiap.postech.fastfood.pagamento.ports.pagamento.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.AtualizarStatusPagamentoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AtualizarStatusPagamentoUseCaseImpl implements AtualizarStatusPagamentoUseCase {
  private final PagamentoPersistencePort pagamentoPersistencePort;

  @Override
  public Pagamento updateStatusPagamento(Pagamento pagamento) {
    return pagamentoPersistencePort.updateStatusPagamento(pagamento);
  }
}
