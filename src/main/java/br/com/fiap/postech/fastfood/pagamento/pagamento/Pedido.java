package br.com.fiap.postech.fastfood.pagamento.pagamento;

import br.com.fiap.postech.fastfood.pagamento.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.pagamento.enums.PedidoStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Pedido {

  String numeroPedido;
  PedidoStatus statusPedido;
  PagamentoStatus statusPagamento;
  BigDecimal valorTotal;
  String cpf;
  LocalDateTime dataPedido;
  LocalDateTime dataAtualizacao;
}
