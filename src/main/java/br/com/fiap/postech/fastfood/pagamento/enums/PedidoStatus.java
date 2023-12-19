package br.com.fiap.postech.fastfood.pagamento.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PedidoStatus {

  CRIADO("CRIADO"),
  ANDAMENTO("ANDAMENTO"),
  ENTREGA("ENTREGA"),
  CANCELADO("CANCELADO"),
  FINALIZADO("FINALIZADO");

  private String value;
}
