package com.marcio.myapp.exception;

public class StandardError {

	private String status;
	private Long timestamp;
	private String message;

	public StandardError(String i, Long timestamp, String message) {
		super();
		this.status = i;
		this.timestamp = timestamp;
		this.message = message;
	}

	public StandardError() {
		super();
	}

	public StandardError(int value, long currentTimeMillis, String message2) {
	
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
