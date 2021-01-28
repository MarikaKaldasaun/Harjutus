package ee.bcs.valiit.tasks;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SolutionErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse>handleError(Exception ex) {
        System.out.println("Not enough money");
        ErrorResponse response = new ErrorResponse();
        response.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(response, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
