package br.com.fiap.postech.fastfood.pagamento.controller;

import static java.util.Objects.isNull;

import br.com.fiap.postech.fastfood.pagamento.controller.dto.ErrorResponse;
import br.com.fiap.postech.fastfood.pagamento.controller.dto.MetodoPagamentoRequest;
import br.com.fiap.postech.fastfood.pagamento.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.pagamento.pagamento.MetodoPagamento;
import br.com.fiap.postech.fastfood.pagamento.usecases.BuscarMetodoPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.CriarMetodoPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.DeletarMetodoPagamentoUseCase;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/metodo-pagamentos")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MetodoPagamentoController implements MetodoPagamentoControllerSwagger {

  private final CriarMetodoPagamentoUseCase criarMetodoPagamentoUseCase;
  private final BuscarMetodoPagamentoUseCase buscarMetodoPagamentoUseCase;
  private final DeletarMetodoPagamentoUseCase deletarMetodoPagamentoUseCase;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping

  public ResponseEntity<Object> createMetodoPagamento(@RequestBody MetodoPagamentoRequest request) {
    try {
      var createdMetodoPagamento = criarMetodoPagamentoUseCase.createMetodoPagamento(request);
      if (isNull(createdMetodoPagamento)) {
        var errorResponse = new ErrorResponse(ErrorMessages.CLIENTE_CPF_NOT_FOUND.getMessage());
        return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body(errorResponse);
      }
      return ResponseEntity.status(HttpStatus.CREATED).body(createdMetodoPagamento);
    } catch (DataIntegrityViolationException ex) {
      var errorResponse = new ErrorResponse(ErrorMessages.METODO_PAGAMENTO_ALREADY_EXISTS.getMessage());
      return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    } catch (Exception ex) {
      var errorResponse = new ErrorResponse(ErrorMessages.METODO_PAGAMENTO_CREATION_FAILED.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
  }

  @GetMapping("/cpf/{cpf}")
  public ResponseEntity<Object> getAllMetodoPagamento(@PathVariable String cpf) {
    var metodoPagamentos = buscarMetodoPagamentoUseCase.findByCpf(cpf);
    if (metodoPagamentos.isEmpty()) {
      var errorResponse = new ErrorResponse(ErrorMessages.METODO_PAGAMENTO_NOT_FOUND.getMessage());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    return ResponseEntity.ok(metodoPagamentos);
  }

  @GetMapping(value = "/{id}/cpf/{cpf}")
  public ResponseEntity<Object> getMetodoPagamentoById(@PathVariable Long id, @PathVariable String cpf) {
    return ResponseEntity.ok(buscarMetodoPagamentoUseCase.findByIdAndCPF(id, cpf));
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping(value = "/{id}")
  public void deleteMetodoPagamentoById(@PathVariable Long id) {
    deletarMetodoPagamentoUseCase.deleteById(id);
  }
}
