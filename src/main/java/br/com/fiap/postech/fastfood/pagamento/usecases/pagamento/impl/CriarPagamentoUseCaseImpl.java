package br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.impl;


import br.com.fiap.postech.fastfood.pagamento.domain.pagamento.Pagamento;
import br.com.fiap.postech.fastfood.pagamento.ports.pagamento.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.CriarPagamentoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarPagamentoUseCaseImpl implements CriarPagamentoUseCase {
  private final PagamentoPersistencePort pagamentoPersistencePort;

  @Override
  public Pagamento save(Pagamento pagamento) {
    return pagamentoPersistencePort.save(pagamento);
  }
}
