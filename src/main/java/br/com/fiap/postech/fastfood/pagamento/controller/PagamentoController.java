package br.com.fiap.postech.fastfood.pagamento.controller;

import static java.util.Objects.isNull;

import br.com.fiap.postech.fastfood.pagamento.controller.dto.CriarCheckoutRequest;
import br.com.fiap.postech.fastfood.pagamento.controller.dto.ErrorResponse;
import br.com.fiap.postech.fastfood.pagamento.enums.ErrorMessages;
import br.com.fiap.postech.fastfood.pagamento.enums.PagamentoStatus;
import br.com.fiap.postech.fastfood.pagamento.enums.PedidoStatus;
import br.com.fiap.postech.fastfood.pagamento.pagamento.Pagamento;
import br.com.fiap.postech.fastfood.pagamento.usecases.AtualizarStatusPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.BuscarMetodoPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.BuscarPagamentoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.BuscarPedidoUseCase;
import br.com.fiap.postech.fastfood.pagamento.usecases.CriarPagamentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class PagamentoController implements PagamentoControllerSwagger {

  private final CriarPagamentoUseCase criarPagamentoUseCase;
  private final BuscarPagamentoUseCase buscarPagamentoUseCase;
  private final AtualizarStatusPagamentoUseCase atualizarStatusPagamentoUseCase;
  private final BuscarMetodoPagamentoUseCase buscarMetodoPagamentoUseCase;
  private final BuscarPedidoUseCase buscarPedidoUseCase;

  @GetMapping
  public ResponseEntity<Object> getAllPagamentos() {
    var pagamentos = buscarPagamentoUseCase.findAll();
    return pagamentos.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        : ResponseEntity.ok(pagamentos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getPagamentoById(@PathVariable(value = "id") Long id) {
    var pagamento = buscarPagamentoUseCase.findById(id);
    return isNull(pagamento) ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        : ResponseEntity.ok(pagamento);
  }

  @PostMapping("/pedidos/checkout/{numeroPedido}")
  public ResponseEntity<Object> createPagamento(
      @PathVariable(name = "numeroPedido") String numeroPedido,
      @RequestBody CriarCheckoutRequest request) {
    try {
      var pedido = buscarPedidoUseCase.findByNumeroPedido(numeroPedido);

      // Validar se o pedido já foi pago.
      if (pedido.getStatusPagamento() != PagamentoStatus.PENDENTE) {
        var errorResponse = new ErrorResponse(ErrorMessages.PAGAMENTO_INVALID_STATUS.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
      }

      //Validar se o pedido já foi cancelado.
      if (PedidoStatus.CANCELADO.equals(pedido.getStatusPedido())) {
        var errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_CANCELADO.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
      }

      // Validar se o pedido já foi entregue.
      if (PedidoStatus.ENTREGA.equals(pedido.getStatusPedido())) {
        var errorResponse = new ErrorResponse(ErrorMessages.PEDIDO_ENTREGUE.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
      }

      var metodoPagamento = buscarMetodoPagamentoUseCase.findByIdAndCPF(
          request.metodoPagamentoId(), request.cpf());
      if (isNull(metodoPagamento)) {
        ErrorResponse errorResponse = new ErrorResponse(
            ErrorMessages.METODO_PAGAMENTO_NOT_FOUND.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
      }

      //TO-DO: Executar pagamento externamente e com o retorno, atualizar o pagamento.
      var pagamento = Pagamento.builder()
          .pedidoId(pedido.getNumeroPedido())
          .metodoPagamento(metodoPagamento)
          .status(PagamentoStatus.APROVADO)
          .build();

      var createdPagamento = criarPagamentoUseCase.save(pagamento);
      return ResponseEntity.status(HttpStatus.CREATED).body(createdPagamento);
    } catch (DataIntegrityViolationException ex) {
      var errorResponse = new ErrorResponse(
          ErrorMessages.PAGAMENTO_ALREADY_EXISTS.getMessage());
      return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    } catch (Exception ex) {
      var errorResponse = new ErrorResponse(
          ErrorMessages.PAGAMENTO_PAYLOAD_INVALID.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateStatusPagamento(@PathVariable(value = "id") Long id,
      @RequestBody Pagamento pagamento) {
    var existingPagamento = buscarPagamentoUseCase.findById(id);
    if (isNull(existingPagamento)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    pagamento.setId(existingPagamento.getId()); // Mantém o ID original do pagamento
    var updatedPagamento = atualizarStatusPagamentoUseCase.updateStatusPagamento(pagamento);
    return ResponseEntity.ok(updatedPagamento);
  }

  @GetMapping("/status/{status}")
  public ResponseEntity<Object> getPagamentosByStatus(
      @PathVariable(value = "status") PagamentoStatus status) {
    var pagamentos = buscarPagamentoUseCase.findAllByStatus(status);
    return pagamentos.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        : ResponseEntity.ok(pagamentos);
  }

  @GetMapping("/status/{numeroPedido}")
  public ResponseEntity<Object> getPagamentosByStatus(
      @PathVariable(value = "numeroPedido") String numeroPedido) {
    var pagamentos = buscarPagamentoUseCase.getStatusPagamento(numeroPedido);
    return pagamentos.getValue().isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        : ResponseEntity.ok(pagamentos);
  }
}
