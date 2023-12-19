package br.com.fiap.postech.fastfood.pagamento.usecases;

import br.com.fiap.postech.fastfood.pagamento.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.pagamento.pagamento.Pagamento;
import java.util.List;

public interface BuscarPagamentoUseCase {

  Pagamento findById(Long id);

  List<Pagamento> findAll();

  List<Pagamento> findAllByStatus(PagamentoStatus status);

  PagamentoStatus getStatusPagamento(String numeroPedido);
}
