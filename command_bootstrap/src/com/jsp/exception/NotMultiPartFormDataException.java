package com.jsp.exception;

public class NotMultiPartFormDataException extends Exception {

	public NotMultiPartFormDataException() {
		super("Multipart 형식이 아닙니다.");
	}
}
