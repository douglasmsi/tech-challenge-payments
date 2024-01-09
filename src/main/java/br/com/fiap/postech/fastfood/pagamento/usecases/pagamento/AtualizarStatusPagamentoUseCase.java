package br.com.fiap.postech.fastfood.pagamento.usecases.pagamento;


import br.com.fiap.postech.fastfood.pagamento.domain.pagamento.Pagamento;

public interface AtualizarStatusPagamentoUseCase {
  Pagamento updateStatusPagamento(Pagamento pagamento);
}
