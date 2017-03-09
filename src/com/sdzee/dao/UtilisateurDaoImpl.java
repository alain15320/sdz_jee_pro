package com.sdzee.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.sdzee.beans.Utilisateur;

public class UtilisateurDaoImpl implements UtilisateurDao {

	private DAOFactory daoFactory;

	public static PreparedStatement initialisationRequetePreparee( Connection connexion, String sql, boolean returnGeneratedKeys, Object... objects) throws SQLException {
		PreparedStatement preparedStatement = connexion.clientPrepareStatement(sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
		for (int i=0; i<objects.length; i++) {
			preparedStatement.setObject(i+1, objects[i]);
		}
		return preparedStatement;
	}
	
	public UtilisateurDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void creer(Utilisateur utilisateur) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Utilisateur trouver(String email) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
