package br.com.fiap.postech.fastfood.pagamento.ports;

import br.com.fiap.postech.fastfood.pagamento.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.pagamento.pagamento.Pagamento;
import java.util.List;

public interface PagamentoPersistencePort {

  Pagamento save(Pagamento pagamento);

  Pagamento findById(Long id);

  Pagamento updateStatusPagamento(Pagamento pagamento);

  List<Pagamento> findAll();

  List<Pagamento> findAllByStatus(PagamentoStatus status);

  PagamentoStatus getStatusPagamento(String numeroPedido);
}
