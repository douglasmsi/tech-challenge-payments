package br.com.fiap.postech.fastfood.pagamento.usecases;

import br.com.fiap.postech.fastfood.pagamento.pagamento.MetodoPagamento;

public interface DeletarMetodoPagamentoUseCase {

  MetodoPagamento deleteById(Long id);
}
