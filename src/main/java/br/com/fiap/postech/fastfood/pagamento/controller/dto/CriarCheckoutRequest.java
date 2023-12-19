package br.com.fiap.postech.fastfood.pagamento.controller.dto;

import java.math.BigDecimal;

public record CriarCheckoutRequest(String cpf,
                                   Long metodoPagamentoId,
                                   BigDecimal valor) {

}
