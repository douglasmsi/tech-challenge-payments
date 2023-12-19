package br.com.fiap.postech.fastfood.pagamento.pagamento;

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
public class MetodoPagamento {

  private String cvv;
  private String dataExpiracao;
  private String numeroCartao;
  private String cpf;

}
