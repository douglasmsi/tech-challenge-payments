package br.com.fiap.postech.fastfood.pagamento.infra;

import br.com.fiap.postech.fastfood.pagamento.controller.dto.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FeignMessageErrorDecoder implements ErrorDecoder {

  private final ErrorDecoder errorDecoder = new Default();

  @Override
  public Exception decode(String methodKey, Response response) {
    ErrorResponse message = null;
    try (InputStream bodyIs = response.body().asInputStream()) {
      ObjectMapper mapper = new ObjectMapper();
      message = mapper.readValue(bodyIs, ErrorResponse.class);
    } catch (IOException e) {
      return new Exception(e.getMessage());
    }

    switch (response.status()) {
      case 400:
        return new ResponseStatusException(HttpStatus.BAD_REQUEST,
            message.getMessage() != null ? message.getMessage() : "Bad Request");
      case 404:
        return new ResponseStatusException(HttpStatus.NOT_FOUND,
            message.getMessage() != null ? message.getMessage() : "Not found");
      default:
        return errorDecoder.decode(methodKey, response);
    }
  }
}
