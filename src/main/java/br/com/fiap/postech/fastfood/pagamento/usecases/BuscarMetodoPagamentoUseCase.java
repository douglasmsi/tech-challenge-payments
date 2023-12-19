package br.com.fiap.postech.fastfood.pagamento.usecases;

import br.com.fiap.postech.fastfood.pagamento.pagamento.MetodoPagamento;
import java.util.List;

public interface BuscarMetodoPagamentoUseCase {

  MetodoPagamento findByIdAndCPF(Long id, String cpf);

  List<MetodoPagamento> findByCpf(String cpf);
}
