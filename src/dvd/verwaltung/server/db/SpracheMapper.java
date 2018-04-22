package dvd.verwaltung.server.db;

import java.sql.*;
import java.util.Vector;

import dvd.verwaltung.shared.bo.DVD;
import dvd.verwaltung.shared.bo.Genre;
import dvd.verwaltung.shared.bo.Sprache;


public class SpracheMapper {

	public static SpracheMapper spracheMapper = null;
	protected SpracheMapper() {
	}
	
	public static SpracheMapper spracheMapper() {
		if(spracheMapper == null) {
			spracheMapper = new SpracheMapper();
		}
		return spracheMapper;
	}
	
	/*			Methoden für verschiedene Abfragezwecke				*/
	
	public Sprache findByKey(int id) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Sprache_ID, Sprache FROM sprache WHERE Sprache_ID = " + id + " ORDER BY Sprache");
			
			if(rs.next()) {
				Sprache s = new Sprache();
				s.setId(rs.getInt("Sprache_ID"));
				s.setSprache(rs.getString("Sprache"));
				
				return s;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Vector<Sprache> findAll() {
		Connection con = DBConnection.connection();
		Vector<Sprache> result = new Vector<Sprache>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Sprache_ID, Sprache FROM sprache ORDER BY Sprache");
			
			while(rs.next()) {
				Sprache s = new Sprache();
				s.setId(rs.getInt("Sprache_ID"));
				s.setSprache(rs.getString("Sprache"));
				
				result.addElement(s);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Vector<Sprache> findBySprache (String sprache) {
		Connection con = DBConnection.connection();
		Vector<Sprache> result = new Vector<Sprache>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Sprache_ID, Sprache FROM sprache WHERE Sprache = '" + sprache + "' ORDER BY Sprache");
			
			while (rs.next()) {
				Sprache s = new Sprache();
				s.setId(rs.getInt("Sprache_ID"));
				s.setSprache(rs.getString("Sprache"));
				
				result.addElement(s);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/*				Methoden für insert, update und delete			*/
	
	public Sprache insert (Sprache sprache) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(Sprache_ID) AS maxid FROM sprache");
				
			if(rs.next()) {
				sprache.setId(rs.getInt("maxid") + 1);
				stmt = con.createStatement();
				stmt.executeUpdate("INSERT INTO sprache (Sprache_ID, Sprache) VALUES ("
						+ sprache.getId() + ", '"
						+ sprache.getSprache() + "')");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return sprache;
	}
	
	public Sprache update (Sprache sprache) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE sprache SET Sprache = '" + sprache.getSprache() + "' WHERE Sprache_ID = " + sprache.getId());
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return sprache;
	}
	
	public void delete (Sprache sprache) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM sprache WHERE Sprache_ID = " + sprache.getId());
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public Vector<Sprache> findByDVDid(DVD dvd) {
		return findByDVD(dvd.getId());
	}
	
	private Vector<Sprache> findByDVD(int id) {
		Connection con = DBConnection.connection();
		Vector<Sprache> result = new Vector<Sprache>();
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT sprache.Sprache_ID, sprache.Sprache FROM sprache JOIN gesprochene_sprache "
					+ "ON sprache.Sprache_ID = gesprochene_sprache.Sprache_ID WHERE gesprochene_sprache.DVD_ID = " + id);
			
			while(rs.next()) {
				Sprache s = new Sprache();
				s.setId(rs.getInt("Sprache_ID"));
				s.setSprache(rs.getString("Sprache"));
				result.addElement(s);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}

	public Vector<Sprache> findUntertitelByDVDid(DVD dvd) {
		return findUntertitelByDVD(dvd.getId());
	}

	private Vector<Sprache> findUntertitelByDVD (int id) {
		Connection con = DBConnection.connection();
		Vector<Sprache> result = new Vector<Sprache>();
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT sprache.Sprache_ID, sprache.Sprache FROM sprache JOIN untertitel "
					+ "ON sprache.Sprache_ID = untertitel.Sprache_ID WHERE untertitel.DVD_ID = " + id);
			
			while(rs.next()) {
				Sprache s = new Sprache();
				s.setId(rs.getInt("Sprache_ID"));
				s.setSprache(rs.getString("Sprache"));
				
				result.addElement(s);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}
}
