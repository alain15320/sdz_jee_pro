package com.sdzee.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {

	private static final String FICHIER_PROPERTIES = "/com/sdzee/dao/dao.properties";
	private static final String PROPERTY_URL = "url";
	private static final String PROPERTY_DRIVERS = "driver";
	private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
	private static final String PROPERTY_MOT_DE_PASSE = "motdepasse";

	private String url;
	private String username;
	private String password;

	DAOFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public static DAOFactory getInstance() {
		Properties properties = new Properties();
		String url;
		String driver;
		String nomUtilisateur;
		String motDePasse;

		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream fichierProperties = classloader.getResourceAsStream(FICHIER_PROPERTIES);

		if (fichierProperties == null) {
			throw new DAOConfigurationException("Le fichier properties " + FICHIER_PROPERTIES + " est introuvable.");
		}

		try {
			properties.load(fichierProperties);
			url = properties.getProperty(PROPERTY_URL);
			driver = properties.getProperty(PROPERTY_DRIVERS);
			nomUtilisateur = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
			motDePasse = properties.getProperty(PROPERTY_MOT_DE_PASSE);
		} catch (IOException e) {
			throw new DAOConfigurationException("Impossible de charger le fichier propreties " + FICHIER_PROPERTIES);
		}

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new DAOConfigurationException("Impossible de charger le fichier prperties " + FICHIER_PROPERTIES, e);
		}

		DAOFactory instance = new DAOFactory(url, nomUtilisateur, motDePasse);
		return instance;
	}

	Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	public UtilisateurDao getUtilisateurDao() {
		return new UtilisateurDaoImpl(this);
	}
}
