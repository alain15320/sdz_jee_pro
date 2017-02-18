package com.sdzee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Restriction
 */
@WebServlet("/restriction")
public class Restriction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String ACCES_PUBLIC = "/accesPublic";
	public static final String ACCES_RESTREINT = "/WEB-INF/accesRestreint";
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		if (session.getAttribute(ATT_SESSION_USER)==null) {
			response.sendRedirect(request.getContextPath()+ACCES_PUBLIC);
		} else {
			this.getServletContext().getRequestDispatcher(ACCES_RESTREINT).forward(request, response);
		}
	}

}
