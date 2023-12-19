package br.com.fiap.postech.fastfood.pagamento.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "metodo_pagamentos", uniqueConstraints = {
    @UniqueConstraint(columnNames = "numero_cartao")})
public class MetodoPagamentoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "cvv")
  private String cvv;

  @Column(name = "numero_cartao", unique = true)
  private String numeroCartao;

  @Column(name = "data_expiracao")
  private String dataExpiracao;

  @Column(name = "cpf")
  private String cpf;
}
