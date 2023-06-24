package pe.ccasani.cinema.trailers.exceptions;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = NOT_FOUND)
public class FileNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public FileNotFoundException(String message) {
    super(message);
  }

  public FileNotFoundException(String message, Throwable throwable) {
    super(message, throwable);
  }
}
