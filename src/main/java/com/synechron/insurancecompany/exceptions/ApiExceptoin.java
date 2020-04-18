package com.synechron.insurancecompany.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiExceptoin {

	private HttpStatus status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp = LocalDateTime.now();;
	private String message;
	private String debugMessage;

	public ApiExceptoin() {
	}
	
	public ApiExceptoin(HttpStatus status, String message, Throwable ex) {
		this.status = status;
		this.message = message;
		this.timestamp = LocalDateTime.now();
		this.debugMessage = ex.getLocalizedMessage();
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}	

}
