package org.serratec.serratec_music.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("status", HttpStatus.BAD_REQUEST.value());
		body.put("erro", "Erro de validação nos campos:");

        Map<String, String> camposComErro = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                camposComErro.put(error.getField(), error.getDefaultMessage())
        );
        
        body.put("detalhes", camposComErro);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
        
	}
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<Object> handleGenericException(Exception ex) {
	        Map<String, Object> body = new HashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
	        body.put("erro", ex.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
	    }
	 
	 @ExceptionHandler(HttpMessageNotReadableException.class)
	 public ResponseEntity<Object> handleInvalidFormat(HttpMessageNotReadableException ex) {
	     Map<String, Object> body = new LinkedHashMap<>();
	     body.put("timestamp", LocalDateTime.now());
	     body.put("status", HttpStatus.BAD_REQUEST.value());
	     body.put("erro", "Erro de formato no corpo da requisição");

	     if (ex.getMessage().contains("java.time.LocalDate")) {
	         body.put("detalhe", "Formato de data inválido. Use o padrão: yyyy-MM-dd (ex: 1998-07-10)");
	     } else {
	         body.put("detalhe", ex.getMostSpecificCause().getMessage());
	     }

	     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	 }
}
