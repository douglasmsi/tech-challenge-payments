package br.com.fiap.postech.fastfood.pagamento.usecases.impl;

import br.com.fiap.postech.fastfood.pagamento.pagamento.Pagamento;
import br.com.fiap.postech.fastfood.pagamento.ports.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.usecases.AtualizarStatusPagamentoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AtualizarStatusPagamentoUseCaseImpl implements AtualizarStatusPagamentoUseCase {

  private final PagamentoPersistencePort pagamentoPersistencePort;

  @Override
  public Pagamento updateStatusPagamento(Pagamento pagamento) {
    return pagamentoPersistencePort.updateStatusPagamento(pagamento);
  }
}
