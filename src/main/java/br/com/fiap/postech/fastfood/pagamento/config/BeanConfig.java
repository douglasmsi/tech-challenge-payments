package br.com.fiap.postech.fastfood.pagamento.config;

import br.com.fiap.postech.fastfood.pagamento.TechChallengePaymentApplication;
import br.com.fiap.postech.fastfood.pagamento.ports.pagamento.MetodoPagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.ports.pagamento.PagamentoPersistencePort;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.AtualizarStatusPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.BuscarMetodoPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.BuscarPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.CriarMetodoPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.CriarPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.DeletarMetodoPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.impl.AtualizarStatusPagamentoUseCaseImpl;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.impl.BuscarMetodoPagamentoUseCaseImpl;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.impl.BuscarPagamentoUseCaseImpl;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.impl.CriarMetodoPagamentoUseCaseImpl;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.impl.CriarPagamentoUseCaseImpl;
import br.com.fiap.postech.fastfood.pagamento.usecases.pagamento.impl.DeletarMetodoPagamentoUseCaseImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = TechChallengePaymentApplication.class)
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Bean
    public CriarPagamentoUseCase criarPagamentoUseCase(PagamentoPersistencePort persistence) {
        return new CriarPagamentoUseCaseImpl(persistence);
    }

    @Bean
    public BuscarPagamentoUseCase buscarPagamentoUseCase(PagamentoPersistencePort persistence) {
        return new BuscarPagamentoUseCaseImpl(persistence);
    }

    @Bean
    public AtualizarStatusPagamentoUseCase atualizarStatusPagamentoUseCase(PagamentoPersistencePort persistence) {
        return new AtualizarStatusPagamentoUseCaseImpl(persistence);
    }


    @Bean
    public CriarMetodoPagamentoUseCase criarMetodoPagamentoUseCase(MetodoPagamentoPersistencePort persistence) {
        return new CriarMetodoPagamentoUseCaseImpl(persistence);
    }

    @Bean
    public BuscarMetodoPagamentoUseCase buscarMetodoPagamentoUseCase(MetodoPagamentoPersistencePort persistence) {
        return new BuscarMetodoPagamentoUseCaseImpl(persistence);
    }

    @Bean
    public DeletarMetodoPagamentoUseCase deletarMetodoPagamentoUseCase(MetodoPagamentoPersistencePort persistence) {
        return new DeletarMetodoPagamentoUseCaseImpl(persistence);
    }

}
