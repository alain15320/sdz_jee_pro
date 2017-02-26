package com.sdzee.bdd;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class TestJDBC {
	
	private List<String> message = new ArrayList<String>();
	
	public List<String> executerTest(HttpServletRequest request) {
		return message;
	}

}
