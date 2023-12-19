package br.com.fiap.postech.fastfood.pagamento.repository;

import br.com.fiap.postech.fastfood.pagamento.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.pagamento.repository.entity.PagamentoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface PagamentoJpaRepository extends JpaRepository<PagamentoEntity, Long> {

  List<PagamentoEntity> findAllByStatus(PagamentoStatus status);

  PagamentoEntity findByNumeroPedido(String numeroPedido);
}
