package br.com.fiap.postech.fastfood.pagamento.repository;

import br.com.fiap.postech.fastfood.pagamento.repository.entity.MetodoPagamentoEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagamentoJpaRepository extends JpaRepository<MetodoPagamentoEntity, Long> {

  List<MetodoPagamentoEntity> findByCpf(String cpf);

  Optional<MetodoPagamentoEntity> findByIdAndCpf(Long id, String cpf);
}
