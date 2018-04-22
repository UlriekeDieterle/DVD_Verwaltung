package dvd.verwaltung.server.db;

import java.sql.*;
import java.util.Vector;

import dvd.verwaltung.shared.bo.DVD;
import dvd.verwaltung.shared.bo.Genre;
import dvd.verwaltung.shared.bo.Schauspieler;

public class SchauspielerMapper {

	public static SchauspielerMapper schauspielerMapper = null;
	protected SchauspielerMapper() {
	}
	
	public static SchauspielerMapper schauspielerMapper() {
		if(schauspielerMapper == null) {
			schauspielerMapper = new SchauspielerMapper();
		}
		return schauspielerMapper;
	}
	
	/*				Methoden für verschiedene Abfragezweck				*/
	
	public Schauspieler findByKey(int id) {
		Connection con = DBConnection.connection();
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Darsteller_ID, Vorname, Nachname, Geburtsjahr, Nationalität "
					+ "FROM darsteller WHERE Darsteller_ID = " + id + " ORDER BY Nachname");
			
			if(rs.next()) {
				Schauspieler s = new Schauspieler();
				s.setId(rs.getInt("Darsteller_ID"));
				s.setVorname(rs.getString("Vorname"));
				s.setNachname(rs.getString("Nachname"));
				s.setGeburtsjahr(rs.getInt("Geburtsjahr"));
				s.setNationalitaet(rs.getString("Nationalität"));
				
				return s;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return null;
	}
	
	public Vector<Schauspieler> findAll() {
		Connection con = DBConnection.connection();
		Vector<Schauspieler> result = new Vector<Schauspieler>();
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Darsteller_ID, Vorname, Nachname, Geburtsjahr, Nationalität "
					+ "FROM darsteller ORDER BY Nachname");
			
			while (rs.next()) {
				Schauspieler s = new Schauspieler();
				s.setId(rs.getInt("Darsteller_ID"));
				s.setVorname(rs.getString("Vorname"));
				s.setNachname(rs.getString("Nachname"));
				s.setGeburtsjahr(rs.getInt("Geburtsjahr"));
				s.setNationalitaet(rs.getString("Nationalität"));
				
				result.addElement(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Vector<Schauspieler> findByNachname (String nachname) {
		Connection con = DBConnection.connection();
		Vector<Schauspieler> result = new Vector<Schauspieler>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Darsteller_ID, Vorname, Nachname, Geburtsjahr, Nationalität "
					+ "FROM darsteller WHERE Nachname = '" + nachname + "' ORDER BY Nachname");
			
			while (rs.next()) {
				Schauspieler s = new Schauspieler();
				s.setId(rs.getInt("Darsteller_ID"));
				s.setVorname(rs.getString("Vorname"));
				s.setNachname(rs.getString("Nachname"));
				s.setGeburtsjahr(rs.getInt("Geburtsjahr"));
				s.setNationalitaet(rs.getString("Nationalität"));
				
				result.addElement(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Vector<Schauspieler> findByNationalitaet (String nat) {
		Connection con = DBConnection.connection();
		Vector<Schauspieler> result = new Vector<Schauspieler>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Darsteller_ID, Vorname, Nachname, Geburtsjahr, Nationalität "
					+ "FROM darsteller WHERE Nationalität = '" + nat + "' ORDER BY Nachname");
			
			while (rs.next()) {
				Schauspieler s = new Schauspieler();
				s.setId(rs.getInt("Darsteller_ID"));
				s.setVorname(rs.getString("Vorname"));
				s.setNachname(rs.getString("Nachname"));
				s.setGeburtsjahr(rs.getInt("Geburtsjahr"));
				s.setNationalitaet(rs.getString("Nationalität"));
				
				result.addElement(s);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Schauspieler insert (Schauspieler s) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(Darsteller_ID) AS maxid "
					+ "FROM darsteller");
			
			if(rs.next()) {
				s.setId(rs.getInt("maxid") + 1);
				stmt = con.createStatement();
				stmt.executeUpdate("INSERT INTO darsteller (Darsteller_ID, Vorname, Nachname, Geburtsjahr, Nationalität) "
					+ "VALUES ("
						+ s.getId() + ", '"
						+ s.getVorname() + "', '"
						+ s.getNachname() + "', "
						+ s.getGeburtsjahr() + ", '"
						+ s.getNationalitaet() + "')");
		
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public Schauspieler update (Schauspieler s) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE darsteller SET " + "Vorname = '" + s.getVorname() + "', Nachname = '" + s.getNachname()
			+ "', Geburtsjahr = " + s.getGeburtsjahr() + ", Nationalität = '" + s.getNationalitaet() + "' WHERE Darsteller_ID = " + s.getId());
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	
	public void delete (Schauspieler s) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM darsteller WHERE Darsteller_ID = " + s.getId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Vector<Schauspieler> findByDVDid(DVD dvd) {
		return findByDVD(dvd.getId());
	}
	
	private Vector<Schauspieler> findByDVD(int id) {
		Connection con = DBConnection.connection();
		Vector<Schauspieler> result = new Vector<Schauspieler>();
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT darsteller.Darsteller_ID, darsteller.Vorname, darsteller.Nachname, "
					+ "darsteller.Geburtsjahr, darsteller.Nationalität FROM darsteller JOIN darsteller_belegung "
					+ "ON darsteller.Darsteller_ID = darsteller_belegung.Darsteller_ID WHERE darsteller_belegung.DVD_ID = " + id);
			
			while(rs.next()) {
				Schauspieler s = new Schauspieler();
				s.setId(rs.getInt("Darsteller_ID"));
				s.setVorname(rs.getString("Vorname"));
				s.setNachname(rs.getString("Nachname"));
				s.setGeburtsjahr(rs.getInt("Geburtsjahr"));
				s.setNationalitaet(rs.getString("Nationalität"));
				
				result.addElement(s);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}
}
