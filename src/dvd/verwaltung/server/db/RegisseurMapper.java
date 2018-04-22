package dvd.verwaltung.server.db;

import java.sql.*;
import java.util.Vector;

import dvd.verwaltung.shared.bo.DVD;
import dvd.verwaltung.shared.bo.Genre;
import dvd.verwaltung.shared.bo.Regisseur;

public class RegisseurMapper {
	
	public static RegisseurMapper regisseurMapper = null;
	
	protected RegisseurMapper() {
	}
	
	public static RegisseurMapper regisseurMapper() {
		if(regisseurMapper == null) {
			regisseurMapper = new RegisseurMapper();
		}
		return regisseurMapper;
	}
	
	/*				Methoden für verschiedene Abfragezwecke				*/
	
	public Regisseur findByKey (int id) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Regisseur_ID, Name FROM regisseur WHERE Regisseur_ID = " + id);
			
			if(rs.next()) {
				Regisseur r = new Regisseur();
				r.setId(rs.getInt("Regisseur_ID"));
				r.setRegisseur(rs.getString("Name"));
				
				return r;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return null;
	}
	
	public Vector<Regisseur> findAll() {
		Connection con = DBConnection.connection();
		Vector<Regisseur> result = new Vector<Regisseur>();
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Regisseur_ID, Name FROM regisseur ORDER BY Name");
			
			while (rs.next()) {
				Regisseur r = new Regisseur();
				r.setId(rs.getInt("Regisseur_ID"));
				r.setRegisseur(rs.getString("Name"));
				
				result.addElement(r);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Vector<Regisseur> findByName(String name) {
		Connection con = DBConnection.connection();
		Vector<Regisseur> result = new Vector<Regisseur>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Regisseur_ID, Name FROM regisseur WHERE Name = '" + name + "' ORDER BY Name");
			
			while (rs.next()) {
				Regisseur r = new Regisseur();
				r.setId(rs.getInt("Regisseur_ID"));
				r.setRegisseur(rs.getString("Name"));
				
				result.addElement(r); 
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/*			Methoden für insert, update, delete 				*/
	
	public Regisseur insert (Regisseur regisseur) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(Regisseur_ID) AS maxid FROM regisseur");
			
			if(rs.next()){
				regisseur.setId(rs.getInt("maxid") + 1);
				stmt = con.createStatement();
				stmt.executeUpdate("INSERT INTO regisseur (Regisseur_ID, Name) VALUES ("
						+ regisseur.getId() + ", '"
						+ regisseur.getRegisseur() + "')");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return regisseur;
	}
	
	public Regisseur update (Regisseur regisseur) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE regisseur SET " + "Name = '" + regisseur.getRegisseur() + 
					"' WHERE Regisseur_ID = " + regisseur.getId());
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return regisseur;
	}
	
	public void delete (Regisseur regisseur) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM regisseur WHERE Regisseur_ID = " + regisseur.getId());
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public Vector<Regisseur> findByDVDid(DVD dvd) {
		return findByDVD(dvd.getId());
	}
	
	private Vector<Regisseur> findByDVD(int id) {
		Connection con = DBConnection.connection();
		Vector<Regisseur> result = new Vector<Regisseur>();
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT regisseur.Regisseur_ID, regisseur.Name FROM regisseur JOIN regisseur_belegung "
					+ "ON regisseur.Regisseur_ID = regisseur_belegung.Regisseur_ID WHERE regisseur_belegung.DVD_ID = " + id);
			
			while(rs.next()) {
				Regisseur r = new Regisseur();
				r.setId(rs.getInt("Regisseur_ID"));
				r.setRegisseur(rs.getString("Name"));
				
				result.addElement(r);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}
}
