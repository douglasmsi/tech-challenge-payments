package br.com.fiap.postech.fastfood.pagamento.usecases.impl;

import br.com.fiap.postech.fastfood.pagamento.pagamento.MetodoPagamento;
import br.com.fiap.postech.fastfood.pagamento.ports.MetodoPagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.usecases.BuscarMetodoPagamentoUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BuscarMetodoPagamentoUseCaseImpl implements BuscarMetodoPagamentoUseCase {

  private final MetodoPagamentoPersistencePort metodoPagamentoPersistencePort;

  @Override
  public MetodoPagamento findByIdAndCPF(Long id, String cpf) {
    return metodoPagamentoPersistencePort.findByIdAndCPF(id, cpf);
  }

  @Override
  public List<MetodoPagamento> findByCpf(String cpf) {
    return metodoPagamentoPersistencePort.findByCpf(cpf);
  }
}
