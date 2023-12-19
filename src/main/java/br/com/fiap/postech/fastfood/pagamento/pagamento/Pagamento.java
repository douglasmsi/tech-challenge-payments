package br.com.fiap.postech.fastfood.pagamento.pagamento;

import br.com.fiap.postech.fastfood.pagamento.enums.PagamentoStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class Pagamento {

  private Long id;
  private String pedidoId;
  private PagamentoStatus status;
  private MetodoPagamento metodoPagamento;

}
