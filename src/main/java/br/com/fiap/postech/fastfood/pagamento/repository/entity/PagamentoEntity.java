package br.com.fiap.postech.fastfood.pagamento.repository.entity;

import br.com.fiap.postech.fastfood.pagamento.enums.PagamentoStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pagamentos")
public class PagamentoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "status")
  private PagamentoStatus status;

  @Column(name = "numero_pedido")
  private String numeroPedido;

  @ManyToOne
  @JoinColumn(name = "metodo_pagamento_id")
  private MetodoPagamentoEntity metodoPagamento;

  private Long pedidoId;
}
