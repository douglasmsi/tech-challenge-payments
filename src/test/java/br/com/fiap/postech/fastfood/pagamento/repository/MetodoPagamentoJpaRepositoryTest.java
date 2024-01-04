package br.com.fiap.postech.fastfood.pagamento.repository;

import static org.junit.jupiter.api.Assertions.*;

import br.com.fiap.postech.fastfood.pagamento.mocks.MetodoPagamentoEntityMock;
import br.com.fiap.postech.fastfood.pagamento.repository.entity.MetodoPagamentoEntity;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
class MetodoPagamentoJpaRepositoryTest {

  @Autowired
  private MetodoPagamentoJpaRepository metodoPagamentoJpaRepository;

  @BeforeEach
  void setUp() {
    deletaMetodoPagamentoEntity();
    salvaMetodoPagamentoEntity();
  }

  @Test
  void when_existsCpf_should_returnMetodoPagamento() {
    // Arrange
    final var cpf = "123456789";

    // Act
    final var metodosPagamentos = metodoPagamentoJpaRepository.findByCpf(cpf);

    // Assert
    assertEquals(1, metodosPagamentos.size());
    assertEquals(cpf, metodosPagamentos.get(0).getCpf());
  }

  @Test
  void when_nonExistsCpf_should_returnEmptyList() {
    // Arrange
    final var cpf = "1234567890";

    // Act
    final var metodosPagamentos = metodoPagamentoJpaRepository.findByCpf(cpf);

    // Assert
    assertTrue(metodosPagamentos.isEmpty());
  }

  @Test
  void when_notFoundIdAndCpf_should_returnEmptyOptional() {
    // Arrange
    final var id = 1L;
    final var cpf = "123456789";

    // Act
    Optional<MetodoPagamentoEntity> result = metodoPagamentoJpaRepository.findByIdAndCpf(id, cpf);

    // Assert
    assertFalse(result.isPresent());
  }

  @Test
  @Disabled
  void when_foundIdAndCpf_should_returnMetodoPagamento() {
    // Arrange
    final var id = 2L;
    final var cpf = "123456789";

    // Act
    Optional<MetodoPagamentoEntity> result = metodoPagamentoJpaRepository.findByIdAndCpf(id, cpf);

    // Assert
    assertTrue(result.isPresent());
  }

  private void deletaMetodoPagamentoEntity() {
    metodoPagamentoJpaRepository.deleteAll();
  }
  private void salvaMetodoPagamentoEntity() {
    metodoPagamentoJpaRepository.save(MetodoPagamentoEntityMock.criaMetodoPagamentoEntity());
  }
}