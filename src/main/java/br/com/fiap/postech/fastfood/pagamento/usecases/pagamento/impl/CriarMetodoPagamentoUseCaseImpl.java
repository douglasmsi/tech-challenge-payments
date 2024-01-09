package br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.impl;


import br.com.fiap.postech.fastfood.pagamento.controller.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.pagamento.domain.pagamento.MetodoPagamento;
import br.com.fiap.postech.fastfood.pagamento.ports.pagamento.MetodoPagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.CriarMetodoPagamentoUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarMetodoPagamentoUseCaseImpl implements CriarMetodoPagamentoUseCase {
  private final MetodoPagamentoPersistencePort metodoPagamentoPersistencePort;

  @Override
  public MetodoPagamento createMetodoPagamento(MetodoPagamentoRequest metodoPagamento) {
    return metodoPagamentoPersistencePort.createMetodoPagamento(metodoPagamento);
  }
}
