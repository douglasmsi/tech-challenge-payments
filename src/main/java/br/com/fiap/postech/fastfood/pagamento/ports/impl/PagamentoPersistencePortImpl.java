package br.com.fiap.postech.fastfood.pagamento.ports.impl;

import static java.util.Objects.isNull;

import br.com.fiap.postech.fastfood.pagamento.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.pagamento.pagamento.Pagamento;
import br.com.fiap.postech.fastfood.pagamento.ports.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.repository.PagamentoJpaRepository;
import br.com.fiap.postech.fastfood.pagamento.repository.entity.PagamentoEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@RequiredArgsConstructor
public class PagamentoPersistencePortImpl implements PagamentoPersistencePort {

  private final PagamentoJpaRepository pagamentoJpaRepository;
  //private final PedidoJpaRepository pedidoJpaRepository;
  private final ModelMapper modelMapper;

  @Override
  public Pagamento save(Pagamento pagamento) {
    //PedidoEntity pedidoEntity = pedidoJpaRepository.findByNumeroPedido(pagamento.getPedido().getNumeroPedido());

    if (isNull(pagamento.getPedidoId())) {
      throw new RuntimeException("Pedido não encontrado");
    }

    PagamentoEntity pagamentoEntity = modelMapper.map(pagamento, PagamentoEntity.class);
    //pagamentoEntity.setPedido(pedidoEntity);
    //pedidoEntity.setPagamentoEntity(pagamentoEntity);
    pagamentoEntity = pagamentoJpaRepository.save(pagamentoEntity);

    //pedidoEntity.setPagamentoStatus(pagamentoEntity.getStatus());

   // pedidoJpaRepository.saveAndFlush(pedidoEntity);
    pagamentoJpaRepository.saveAndFlush(pagamentoEntity);

    return modelMapper.map(pagamentoEntity, Pagamento.class);
  }

  @Override
  public List<Pagamento> findAll() {
    return pagamentoJpaRepository.findAll().stream()
        .map(entity -> modelMapper.map(entity, Pagamento.class)).toList();
  }

  @Override
  public Pagamento findById(final Long id) {
    return pagamentoJpaRepository.findById(id)
        .map(entity -> modelMapper.map(entity, Pagamento.class))
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "Pagamento não encontrado"));
  }

  @Override
  public Pagamento updateStatusPagamento(final Pagamento pagamento) {
    var pagamentoEntity = pagamentoJpaRepository.saveAndFlush(
        modelMapper.map(pagamento, PagamentoEntity.class));
    return modelMapper.map(pagamentoEntity, Pagamento.class);
  }

  @Override
  public List<Pagamento> findAllByStatus(final PagamentoStatus status) {
    return pagamentoJpaRepository.findAllByStatus(status).stream()
        .map(entity -> modelMapper.map(entity,
            Pagamento.class)).toList();
  }


  @Override
  public PagamentoStatus getStatusPagamento(final String numeroPedido) {
    var pagamentoEntity = pagamentoJpaRepository.findByNumeroPedido(numeroPedido);
    return pagamentoEntity.getStatus();
  }
}
