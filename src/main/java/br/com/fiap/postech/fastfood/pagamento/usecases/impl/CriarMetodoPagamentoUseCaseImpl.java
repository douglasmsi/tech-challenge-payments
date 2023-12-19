package br.com.fiap.postech.fastfood.pagamento.usecases.impl;

import br.com.fiap.postech.fastfood.pagamento.controller.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.pagamento.pagamento.MetodoPagamento;
import br.com.fiap.postech.fastfood.pagamento.ports.MetodoPagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.usecases.CriarMetodoPagamentoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarMetodoPagamentoUseCaseImpl implements CriarMetodoPagamentoUseCase {

  private final MetodoPagamentoPersistencePort metodoPagamentoPersistencePort;

  @Override
  public MetodoPagamento createMetodoPagamento(final MetodoPagamentoRequest metodoPagamento) {
    return metodoPagamentoPersistencePort.createMetodoPagamento(metodoPagamento);
  }
}
