package br.com.fiap.postech.fastfood.pagamento.usecases;

import br.com.fiap.postech.fastfood.pagamento.pagamento.Pagamento;

public interface AtualizarStatusPagamentoUseCase {

  Pagamento updateStatusPagamento(Pagamento pagamento);
}
