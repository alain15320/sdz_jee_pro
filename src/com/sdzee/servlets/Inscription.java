package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.beans.Utilisateur;
import com.sdzee.dao.DAOFactory;
import com.sdzee.dao.UtilisateurDao;
import com.sdzee.forms.InscriptionForm;

@WebServlet("/inscription")
public class Inscription extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ATT_USER = "utilisateur";
	public static final String ATT_FORM = "form";
	public static final String VUE = "/WEB-INF/inscription.jsp";

	private UtilisateurDao utilisateurDao;

	public void init() throws ServletException {
		this.utilisateurDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getUtilisateurDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Affichage de la page d'inscription */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Préparation de l'objet formulaire */
		InscriptionForm form = new InscriptionForm(utilisateurDao);

		/*
		 * Appel au traitement et à la validation de la requête, et récupération
		 * du bean en résultant
		 */
		Utilisateur utilisateur = form.inscrireUtilisateur(request);

		/* Stockage du résultat et des messages d'erreur dans l'objet request */
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_USER, utilisateur);

		/* Transmission de la paire d'objets request/response à notre JSP */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

}
