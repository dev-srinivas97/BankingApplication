package demo.poc.bankingdetails.exception;

public class LoginErrorResponse {
	private String errorCode;
	private String message;
	
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String i) {
		this.errorCode = i;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
