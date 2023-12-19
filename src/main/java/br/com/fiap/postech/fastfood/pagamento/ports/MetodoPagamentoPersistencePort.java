package br.com.fiap.postech.fastfood.pagamento.ports;

import br.com.fiap.postech.fastfood.pagamento.controller.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.pagamento.pagamento.MetodoPagamento;
import java.util.List;

public interface MetodoPagamentoPersistencePort {

  MetodoPagamento createMetodoPagamento(MetodoPagamentoRequest metodoPagamento);

  MetodoPagamento findByIdAndCPF(Long id, String cpf);

  List<MetodoPagamento> findByCpf(String cpf);

  MetodoPagamento deleteById(Long id);
}
