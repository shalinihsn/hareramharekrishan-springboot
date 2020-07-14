package harekrishan.all.exception;

import java.util.List;

public class ErrorResponse {
	
	
	private String message;
    private List<String> detail;
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public List<String> getDetail() {
		return detail;
	}

	public void setDetail(List<String> detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", detail=" + detail + "]";
	}
	

}
