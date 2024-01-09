package br.com.fiap.postech.fastfood.pagamento.usecases.pagamento;


import br.com.fiap.postech.fastfood.pagamento.domain.pagamento.Pagamento;

public interface CriarPagamentoUseCase {
  Pagamento save(Pagamento pagamento);
}
