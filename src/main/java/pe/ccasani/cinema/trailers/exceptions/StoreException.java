package pe.ccasani.cinema.trailers.exceptions;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ResponseStatus;

public class StoreException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public StoreException(String message) {
    super(message);
  }

  public StoreException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
