package br.com.fiap.postech.fastfood.pagamento.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import br.com.fiap.postech.fastfood.pagamento.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.pagamento.mocks.MetodoPagamentoEntityMock;
import br.com.fiap.postech.fastfood.pagamento.mocks.PagamentoEntityMock;
import br.com.fiap.postech.fastfood.pagamento.repository.entity.MetodoPagamentoEntity;
import br.com.fiap.postech.fastfood.pagamento.repository.entity.PagamentoEntity;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
class PagamentoJpaRepositoryTest {

  @Autowired
  private PagamentoJpaRepository pagamentoJpaRepository;

  @Autowired
  private MetodoPagamentoJpaRepository metodoPagamentoJpaRepository;

  @BeforeEach
  void setUp() {
    salvaPagamentoEntity();
  }

  @Test
  void when_findAllByStatus_should_returnAllPagamentoWithStatusPendente() {
    // Arrange
    final var status = PagamentoStatus.PENDENTE;

    // Act
    List<PagamentoEntity> result = pagamentoJpaRepository.findAllByStatus(status);

    // Assert
    assertEquals(1, result.size());
    assertEquals(status, result.get(0).getStatus());
  }

  @Test
  void when_findAllByStatusNonExists_should_returnEmptyList() {
    // Arrange
    final var status = PagamentoStatus.APROVADO;

    // Act
    List<PagamentoEntity> result = pagamentoJpaRepository.findAllByStatus(status);

    // Assert
    assertTrue(result.isEmpty());
  }

  @Test
  void when_findByNumeroPedido_should_returnPagamento() {
    // Arrange
    final var numeroPedido = "ABC123";

    // Act
    final var pagamentoEntity = pagamentoJpaRepository.findByNumeroPedido(numeroPedido);

    // Assert
    assertNotNull(pagamentoEntity);
    assertEquals(numeroPedido, pagamentoEntity.getNumeroPedido());
  }

  @Test
  void when_findByNumeroPedidoNonExists_should_returnNull() {
    // Arrange
    final var numeroPedido = "ABC1234";

    // Act
    final var pagamentoEntity = pagamentoJpaRepository.findByNumeroPedido(numeroPedido);

    // Assert
    assertNull(pagamentoEntity);
  }

  private void salvaPagamentoEntity() {
    final var metodoPagamentoEntity = metodoPagamentoJpaRepository.save(
        MetodoPagamentoEntityMock.criaMetodoPagamentoEntity());
    final var pagamentoEntity = PagamentoEntityMock.criaPagamentoEntity();
    pagamentoEntity.setMetodoPagamento(metodoPagamentoEntity);
    pagamentoJpaRepository.save(pagamentoEntity);
  }
}