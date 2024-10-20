package demo.poc.bankingdetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class LoginExceptionHandler {
	
	
	public ResponseEntity<LoginErrorResponse> handleException(LoginErrorResponse ex) {
		
		LoginErrorResponse login=new LoginErrorResponse();
		login.setErrorCode(ex.getErrorCode());
		login.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(login);
	}
	
	
	public ResponseEntity handleExceptions(Exception ex) {
		
		LoginErrorResponse login=new LoginErrorResponse();
		login.setErrorCode("");
		login.setMessage(ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(login);
	}
}
