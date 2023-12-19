package br.com.fiap.postech.fastfood.pagamento.ports.impl;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import br.com.fiap.postech.fastfood.pagamento.controller.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.pagamento.pagamento.MetodoPagamento;
import br.com.fiap.postech.fastfood.pagamento.ports.MetodoPagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.repository.MetodoPagamentoJpaRepository;
import br.com.fiap.postech.fastfood.pagamento.repository.entity.MetodoPagamentoEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Component
public class MetodoPagamentoPersistencePortImpl implements MetodoPagamentoPersistencePort {

  private final ModelMapper modelMapper;
  private final MetodoPagamentoJpaRepository metodoPagamentoJpaRepository;

  @Override
  public MetodoPagamento createMetodoPagamento(final MetodoPagamentoRequest request) {
    var metodoPagamento = MetodoPagamento.builder()
        .cvv(request.cvv())
        .numeroCartao(request.numeroCartao())
        .dataExpiracao(request.dataExpiracao())
        .cpf(request.cpf())
        .build();

    var metodoPagamentoEntity = modelMapper.map(metodoPagamento,
        MetodoPagamentoEntity.class);
    metodoPagamentoEntity = metodoPagamentoJpaRepository.save(metodoPagamentoEntity);
    return modelMapper.map(metodoPagamentoEntity, MetodoPagamento.class);
  }

  @Override
  public MetodoPagamento findByIdAndCPF(Long id, String cpf) {
    return metodoPagamentoJpaRepository.findByIdAndCpf(id, cpf)
        .map(entity -> modelMapper.map(entity, MetodoPagamento.class)).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
            "Metodo de pagamento não encontrado"));
  }

  @Override
  public List<MetodoPagamento> findByCpf(String cpf) {
    return metodoPagamentoJpaRepository.findByCpf(cpf).stream()
        .map(entity -> modelMapper.map(entity, MetodoPagamento.class)).toList();
  }

  @Override
  public MetodoPagamento deleteById(Long id) {
    return metodoPagamentoJpaRepository.findById(id).map(entity -> {
      metodoPagamentoJpaRepository.deleteById(id);
      return modelMapper.map(entity, MetodoPagamento.class);
    }).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
        "Metodo de pagamento não encontrado"));
  }
}
