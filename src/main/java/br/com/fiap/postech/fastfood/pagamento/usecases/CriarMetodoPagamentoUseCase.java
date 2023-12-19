package br.com.fiap.postech.fastfood.pagamento.usecases;

import br.com.fiap.postech.fastfood.pagamento.controller.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.pagamento.pagamento.MetodoPagamento;

public interface CriarMetodoPagamentoUseCase {

  MetodoPagamento createMetodoPagamento(MetodoPagamentoRequest metodoPagamento);
}
