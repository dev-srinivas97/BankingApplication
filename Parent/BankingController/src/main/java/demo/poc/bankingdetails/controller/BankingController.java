package demo.poc.bankingdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.poc.bankingdetails.dao.LoginImpl;
import demo.poc.bankingdetails.exception.LoginErrorResponse;
import demo.poc.bankingdetails.exception.LoginExceptionHandler;
import demo.poc.bankingdetails.exception.UserNotFoundException;
import demo.poc.bankingdetails.pojo.Login;
import jakarta.annotation.PostConstruct;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/banking")
public class BankingController {
	List<Login> loginDetails;
	@Autowired
	LoginExceptionHandler loginContr;

	@Autowired
	LoginImpl login;

	@PostConstruct()
	public void getLoginCreds() {

		loginDetails = login.getLogins();
		System.out.println(loginDetails.get(0).getUserName());
	}

	@GetMapping("/details")
	public String getBankingDetails() {
		return "Working";
	}

	@PostMapping("/login")
	public ResponseEntity VerifyLogin(@RequestBody Login login) {
		LoginErrorResponse loginError = new LoginErrorResponse();
		try {
			if (login.getUserName().equals("") || login.getUserName() == null) {
				loginError.setErrorCode("AB2345");
				loginError.setMessage("User should not be empty");
				return loginContr.handleException(loginError);
			} else if (login.getPassword().equals("") || login.getPassword() == null) {
				loginError.setErrorCode("AB1234");
				loginError.setMessage("Password should not be empty");
				return loginContr.handleException(loginError);
			}

			for (int i = 0; i < loginDetails.size();) {
				if (loginDetails.get(i).getUserName().equals(login.getUserName())) {
					if (loginDetails.get(i).getPassword().equals(login.getPassword())) {
						System.out.println("inside user not exist");
						LoginErrorResponse loginSucc = new LoginErrorResponse();

						loginSucc.setMessage("Success");
						return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(loginSucc);
					} else {
						LoginErrorResponse loginErr = new LoginErrorResponse();
						loginErr.setErrorCode("AB0012");
						loginErr.setMessage("Incorrect password. Please enter correct password");
						return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(loginErr);
					}
				}else {
					LoginErrorResponse loginErr = new LoginErrorResponse();
					loginErr.setErrorCode("AB0013");
					loginErr.setMessage("User Does not exist.");
					return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(loginErr);
				}
			}

			System.out.println("inside excep1");
		} catch (Exception ex) {
			System.out.println("inside excep");
			return loginContr.handleExceptions(ex);
		}
		System.out.println("inside excep2");
		LoginErrorResponse loginSucc = new LoginErrorResponse();

		loginSucc.setMessage("Success");
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(loginSucc);

	}
}
