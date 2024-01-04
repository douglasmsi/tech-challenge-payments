package br.com.fiap.postech.fastfood.pagamento.mocks;

import static br.com.fiap.postech.fastfood.pagamento.enums.PagamentoStatus.PENDENTE;

import br.com.fiap.postech.fastfood.pagamento.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.pagamento.repository.entity.PagamentoEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class PagamentoEntityMock {

  public PagamentoEntity criaPagamentoEntity() {

    return PagamentoEntity.builder()
        .numeroPedido("ABC123")
        .status(PENDENTE)
        .build();
  }
}
