package br.com.fiap.postech.fastfood.pagamento.ports.pagamento;


import br.com.fiap.postech.fastfood.pagamento.domain.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.pagamento.domain.pagamento.Pagamento;
import br.com.fiap.postech.fastfood.pagamento.infraestructure.clients.TechChallengeOrder;
import br.com.fiap.postech.fastfood.pagamento.infraestructure.clients.dto.TechChallengeOrderDTO;
import br.com.fiap.postech.fastfood.pagamento.repository.entities.PagamentoEntity;
import br.com.fiap.postech.fastfood.pagamento.repository.pagamento.PagamentoJpaRepository;
import br.com.fiap.postech.fastfood.pagamento.services.PedidoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PagamentoPersistencePortImpl implements PagamentoPersistencePort {

  private final PagamentoJpaRepository pagamentoJpaRepository;
  private final ModelMapper modelMapper;

  @Override
    public Pagamento save(Pagamento pagamento) {


    PagamentoEntity pagamentoEntity = modelMapper.map(pagamento, PagamentoEntity.class);
    //pagamentoEntity.setNumeroPedido(pedidoResponse.getNumeroPedido());
    pagamentoEntity = pagamentoJpaRepository.save(pagamentoEntity);

   // pedidoEntity.setPagamentoStatus(pagamentoEntity.getStatus());
    //pedidoJpaRepository.saveAndFlush(pedidoEntity);
    pagamentoJpaRepository.saveAndFlush(pagamentoEntity);

    return modelMapper.map(pagamentoEntity, Pagamento.class);
    }

    @Override
    public List<Pagamento> findAll() {
      return pagamentoJpaRepository.findAll().stream().map(entity -> modelMapper.map(entity, Pagamento.class)).toList();
    }

    @Override
    public Pagamento findById(Long id) {
      return pagamentoJpaRepository.findById(id).map(entity -> modelMapper.map(entity, Pagamento.class)).orElse(null);
    }

  @Override
  public Pagamento updateStatusPagamento(Pagamento pagamento) {
    PagamentoEntity pagamentoEntity = pagamentoJpaRepository.saveAndFlush(modelMapper.map(pagamento, PagamentoEntity.class));
    return modelMapper.map(pagamentoEntity, Pagamento.class);
  }

  @Override
    public List<Pagamento> findAllByStatus(PagamentoStatus status) {
      return pagamentoJpaRepository.findAllByStatus(status).stream().map(entity -> modelMapper.map(entity,
                                                                                                   Pagamento.class)).toList();
    }


  @Override
  public PagamentoStatus getStatusPagamento(String numeroPedido) {
    PagamentoEntity pagamentoEntity = pagamentoJpaRepository.findByNumeroPedido(numeroPedido);
    return pagamentoEntity.getStatus();
  }



}
