package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.beans.Utilisateur;
import com.sdzee.forms.ConnexionForm;

@WebServlet("/connexion")
public class Connexion extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final String ATT_USER = "utilisateur";
	public static final String ATT_FORM = "form";
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	public static final String VUE = "/WEB-INF/connexion.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'inscription */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ConnexionForm form = new ConnexionForm();

        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
		Utilisateur utilisateur = form.connecterUtilisateur(request);
		
        /* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();
		

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
		/* Transmission de la paire d'objets request/response à notre JSP */
		if (form.getErreurs().isEmpty()) {
			session.setAttribute(ATT_SESSION_USER, utilisateur);
		} else {
			session.setAttribute(ATT_SESSION_USER, null);		
		}

		/* Stockage du résultat et des messages d'erreur dans l'objet request */
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_USER, utilisateur);

		/* Transmission de la paire d'objets request/response à notre JSP */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

}
