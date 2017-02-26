package com.sdzee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.bdd.TestJDBC;

/**
 * Servlet implementation class GestionTestJDBC
 */
@WebServlet("/testjdbc")
public class GestionTestJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String ATT_MESSAGES = "messages";
	public static final String VUE = "/WEB-INF/test_jdbc.jsp";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TestJDBC test = new TestJDBC();
		List<String> messages = test.executerTest(request);
		
		request.setAttribute(ATT_MESSAGES, messages);
		
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
	}

}
