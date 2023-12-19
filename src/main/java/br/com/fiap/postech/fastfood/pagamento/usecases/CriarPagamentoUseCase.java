package br.com.fiap.postech.fastfood.pagamento.usecases;

import br.com.fiap.postech.fastfood.pagamento.pagamento.Pagamento;

public interface CriarPagamentoUseCase {

  Pagamento save(Pagamento pagamento);
}
