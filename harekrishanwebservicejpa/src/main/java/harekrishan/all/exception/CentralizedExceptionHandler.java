package harekrishan.all.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CentralizedExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		List<String> errorList= new ArrayList<String>();
		errorList.add(ex.getMessage());
		ErrorResponse errResponse= new ErrorResponse();
		errResponse.setMessage("Server Error");
		errResponse.setDetail(errorList);
		return new  ResponseEntity<Object>(errResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> recordNotFoundException(Exception ex,WebRequest request)throws Exception{
		List<String> errorList= new ArrayList<String>();
		errorList.add(ex.getMessage());
		ErrorResponse errResponse= new ErrorResponse();
		errResponse.setMessage(ex.getMessage());
		errResponse.setDetail(errorList);
		return new  ResponseEntity<Object>(errResponse, HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	
		List<FieldError> er=ex.getBindingResult().getFieldErrors();
		ErrorResponse errResponse= new ErrorResponse();
		errResponse.setMessage("validation error");
		List<String> errDetails= new ArrayList<String>();
		
		for(FieldError e:er)
		{
			errDetails.add(e.getDefaultMessage());
			
		}
	
		errResponse.setDetail(errDetails);
		return new ResponseEntity<Object>(errResponse, status.BAD_REQUEST);
	}
	
	
	
	}
	


