package br.com.fiap.postech.fastfood.pagamento.mocks;

import br.com.fiap.postech.fastfood.pagamento.repository.entity.MetodoPagamentoEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class MetodoPagamentoEntityMock {

  public MetodoPagamentoEntity criaMetodoPagamentoEntity() {
    return new MetodoPagamentoEntity(1L, "123", "123456789", "12/12", "123456789");
  }
}
