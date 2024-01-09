package br.com.fiap.postech.fastfood.pagamento.services;

import br.com.fiap.postech.fastfood.pagamento.infraestructure.clients.TechChallengeClient;
import br.com.fiap.postech.fastfood.pagamento.infraestructure.clients.dto.TechChallengeClientDTO;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

  private final TechChallengeClient techChallengeClient;

  public ClienteService(TechChallengeClient techChallengeClient) {
    this.techChallengeClient = techChallengeClient;
  }

  public TechChallengeClientDTO getClienteByCpf(String cpf) {
    return techChallengeClient.getClienteByCpf(cpf);
  }

}
