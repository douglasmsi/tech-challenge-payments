package br.com.fiap.postech.fastfood.pagamento.usecases.pagamento;


import br.com.fiap.postech.fastfood.pagamento.domain.pagamento.MetodoPagamento;

public interface DeletarMetodoPagamentoUseCase {
  MetodoPagamento deleteByIdAndCPF(Long id, String cpf);
}
