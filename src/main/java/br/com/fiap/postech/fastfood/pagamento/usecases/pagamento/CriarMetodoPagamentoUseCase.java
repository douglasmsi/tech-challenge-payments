package br.com.fiap.postech.fastfood.pagamento.usecases.pagamento;


import br.com.fiap.postech.fastfood.pagamento.controller.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.pagamento.domain.pagamento.MetodoPagamento;

public interface CriarMetodoPagamentoUseCase {
  MetodoPagamento createMetodoPagamento(MetodoPagamentoRequest metodoPagamento);
}
