package br.com.fiap.postech.fastfood.pagamento.config;

import br.com.fiap.postech.fastfood.pagamento.TechChallengePaymentsApplication;
import br.com.fiap.postech.fastfood.pagamento.feign.PedidoClient;
import br.com.fiap.postech.fastfood.pagamento.ports.MetodoPagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.ports.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.usecases.AtualizarStatusPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.BuscarMetodoPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.BuscarPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.BuscarPedidoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.CriarMetodoPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.CriarPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.DeletarMetodoPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.impl.AtualizarStatusPagamentoUseCaseImpl;
import br.com.fiap.postech.fastfood.pagamento.usecases.impl.BuscarMetodoPagamentoUseCaseImpl;
import br.com.fiap.postech.fastfood.pagamento.usecases.impl.BuscarPagamentoUseCaseImpl;
import br.com.fiap.postech.fastfood.pagamento.usecases.impl.BuscarPedidoUseCaseImpl;
import br.com.fiap.postech.fastfood.pagamento.usecases.impl.CriarMetodoPagamentoUseCaseImpl;
import br.com.fiap.postech.fastfood.pagamento.usecases.impl.CriarPagamentoUseCaseImpl;
import br.com.fiap.postech.fastfood.pagamento.usecases.impl.DeletarMetodoPagamentoUseCaseImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = TechChallengePaymentsApplication.class)
public class BeanConfig {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  public CriarPagamentoUseCase criarPagamentoUseCaseImpl(PagamentoPersistencePort persistence) {
    return new CriarPagamentoUseCaseImpl(persistence);
  }

  @Bean
  public BuscarPagamentoUseCase buscarPagamentoUseCaseImpl(
      PagamentoPersistencePort persistence) {
    return new BuscarPagamentoUseCaseImpl(persistence);
  }

  @Bean
  public AtualizarStatusPagamentoUseCase atualizarStatusPagamentoUseCaseImpl(
      PagamentoPersistencePort persistence) {
    return new AtualizarStatusPagamentoUseCaseImpl(persistence);
  }

  @Bean
  public BuscarMetodoPagamentoUseCase buscarMetodoPagamentoUseCaseImpl(
      MetodoPagamentoPersistencePort persistence) {
    return new BuscarMetodoPagamentoUseCaseImpl(persistence);
  }

  @Bean
  public BuscarPedidoUseCase buscarPedidoUseCaseImpl(PedidoClient pedidoClient) {
    return new BuscarPedidoUseCaseImpl(pedidoClient);
  }

  @Bean
  public CriarMetodoPagamentoUseCase creaMetodoPagamentoUseCaseImpl(
      MetodoPagamentoPersistencePort persistence) {
    return new CriarMetodoPagamentoUseCaseImpl(persistence);
  }

  @Bean
  public DeletarMetodoPagamentoUseCase deletarMetodoPagamentoUseCase(
      MetodoPagamentoPersistencePort persistence) {
    return new DeletarMetodoPagamentoUseCaseImpl(persistence);
  }
}
