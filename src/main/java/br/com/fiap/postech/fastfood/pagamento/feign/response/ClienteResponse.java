package br.com.fiap.postech.fastfood.pagamento.feign.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

  private Long id;

  private String cpf;

  private String nome;

  private String telefone;

  private String endereco;

  private String email;
}
