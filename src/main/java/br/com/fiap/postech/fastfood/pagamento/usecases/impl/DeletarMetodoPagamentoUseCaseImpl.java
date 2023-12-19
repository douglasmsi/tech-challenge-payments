package br.com.fiap.postech.fastfood.pagamento.usecases.impl;

import br.com.fiap.postech.fastfood.pagamento.pagamento.MetodoPagamento;
import br.com.fiap.postech.fastfood.pagamento.ports.MetodoPagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.usecases.DeletarMetodoPagamentoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeletarMetodoPagamentoUseCaseImpl implements DeletarMetodoPagamentoUseCase {

  private final MetodoPagamentoPersistencePort metodoPagamentoPersistencePort;

  @Override
  public MetodoPagamento deleteById(Long id) {
    return metodoPagamentoPersistencePort.deleteById(id);
  }
}
