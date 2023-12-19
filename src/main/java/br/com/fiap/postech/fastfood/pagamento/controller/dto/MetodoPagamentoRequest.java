package br.com.fiap.postech.fastfood.pagamento.controller.dto;

public record MetodoPagamentoRequest(String cvv,
                                     String dataExpiracao,
                                     String numeroCartao,
                                     String cpf) {

}
