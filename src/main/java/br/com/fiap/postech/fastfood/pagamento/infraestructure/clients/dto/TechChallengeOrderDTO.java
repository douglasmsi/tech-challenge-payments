package br.com.fiap.postech.fastfood.pagamento.infraestructure.clients.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class TechChallengeOrderDTO {

  String numeroPedido;
  String statusPedido;
  BigDecimal valorTotal;
  String cpf;
  LocalDateTime dataPedido;
  LocalDateTime dataAtualizacao;

  List<TechChallengeOrderItemsDTO> items;
}
