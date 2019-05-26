package com.codewars.utility;

public class Handler {

	private int code;
	
	private int repeat;

	public Handler(int code, int repeat) {
		this.code = code;
		this.repeat = repeat;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getRepeat() {
		return repeat;
	}

	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}

}
