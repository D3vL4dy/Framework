package com.java.ot;

public class Process {
	public String process(String input) {
		String str = null;
		if(input == null) return null;
		try {
			Integer.parseInt(input);
			// 숫자
			str += "숫자 : ";
		} catch (Exception e) {
			str += "문자 : ";
		}
		str += input;
		
		return str;
	}
}