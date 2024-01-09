package br.com.fiap.postech.fastfood.pagamento.domain.pagamento;


import br.com.fiap.postech.fastfood.pagamento.domain.enums.PagamentoStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagamento {

  private Long id;
  private String numeroPedido;
  private PagamentoStatus status;
  private MetodoPagamento metodoPagamento;
}
