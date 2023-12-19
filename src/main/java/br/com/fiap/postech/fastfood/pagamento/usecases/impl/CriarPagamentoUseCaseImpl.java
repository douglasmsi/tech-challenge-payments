package br.com.fiap.postech.fastfood.pagamento.usecases.impl;

import br.com.fiap.postech.fastfood.pagamento.pagamento.Pagamento;
import br.com.fiap.postech.fastfood.pagamento.ports.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.usecases.CriarPagamentoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarPagamentoUseCaseImpl implements CriarPagamentoUseCase {

  private final PagamentoPersistencePort pagamentoPersistencePort;

  @Override
  public Pagamento save(Pagamento pagamento) {
    return pagamentoPersistencePort.save(pagamento);
  }
}
