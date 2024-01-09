package br.com.fiap.postech.fastfood.pagamento.ports.pagamento;


import br.com.fiap.postech.fastfood.pagamento.controller.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.pagamento.domain.pagamento.MetodoPagamento;
import br.com.fiap.postech.fastfood.pagamento.infraestructure.clients.TechChallengeClient;
import br.com.fiap.postech.fastfood.pagamento.infraestructure.clients.dto.TechChallengeClientDTO;
import br.com.fiap.postech.fastfood.pagamento.repository.entities.MetodoPagamentoEntity;
import br.com.fiap.postech.fastfood.pagamento.repository.pagamento.MetodoPagamentoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class MetodoPagamentoPersistencePortImpl implements MetodoPagamentoPersistencePort {

  private final ModelMapper modelMapper;
  private final MetodoPagamentoJpaRepository metodoPagamentoJpaRepository;
  private final TechChallengeClient techChallengeClient;

  @Override
  public MetodoPagamento createMetodoPagamento(MetodoPagamentoRequest request) {

    TechChallengeClientDTO cliente = techChallengeClient.getClienteByCpf(request.getMetodoPagamento().getCpf());
    if (cliente == null) {
      return null;
    }


    MetodoPagamento metodoPagamento = MetodoPagamento.builder()
        .cvv(request.getMetodoPagamento().getCvv())
        .numeroCartao(request.getMetodoPagamento().getNumeroCartao())
        .dataExpiracao(request.getMetodoPagamento().getDataExpiracao())
        .cpf(request.getMetodoPagamento().getCpf())
        .build();

    MetodoPagamentoEntity metodoPagamentoEntity = modelMapper.map(metodoPagamento, MetodoPagamentoEntity.class);
    metodoPagamentoEntity.setCpf(cliente.getCpf());
    metodoPagamentoEntity = metodoPagamentoJpaRepository.save(metodoPagamentoEntity);

    //cliente.setMetodosPagamento(metodoPagamentoEntity.getCliente().getMetodosPagamento());
    //clienteJpaRepository.saveAndFlush(cliente);

    return modelMapper.map(metodoPagamentoEntity, MetodoPagamento.class);
  }

  @Override
  public MetodoPagamento findByIdAndCPF(Long id, String cpf) {
    return metodoPagamentoJpaRepository.findById(id).map(entity -> modelMapper.map(entity, MetodoPagamento.class)).orElse(null);
  }

  @Override
  public List<MetodoPagamento> findByCpf(String cpf) {
    return metodoPagamentoJpaRepository.findByCpf(cpf).stream().map(entity -> modelMapper.map(entity, MetodoPagamento.class)).toList();
  }

  @Override
  public MetodoPagamento deleteByIdAndCPF(Long id, String cpf) {
    return metodoPagamentoJpaRepository.findById(id).map(entity -> {
      metodoPagamentoJpaRepository.deleteById(id);
      return modelMapper.map(entity, MetodoPagamento.class);
    }).orElse(null);
  }
}
