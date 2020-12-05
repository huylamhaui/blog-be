package lamph11.blogbe.resource;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lamph11.blogbe.common.ApiResponse;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> validateException(MethodArgumentNotValidException e) {
        Map<String, String> errors = e.getFieldErrors().stream()
            .collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));

        ApiResponse response = new ApiResponse()
            .setCode(400)
            .setMessage("VALIDATE")
            .setPayload(errors);
        return ResponseEntity.ok(response);
    }
}
