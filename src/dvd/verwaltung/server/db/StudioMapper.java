package dvd.verwaltung.server.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import dvd.verwaltung.shared.bo.DVD;
import dvd.verwaltung.shared.bo.Genre;
import dvd.verwaltung.shared.bo.Studio;

public class StudioMapper {

	public static StudioMapper studioMapper = null;
	protected StudioMapper() {
	}
	
	public static StudioMapper studioMapper() {
		if(studioMapper == null) {
			studioMapper = new StudioMapper();
		}
		return studioMapper;
	}
	
	/*			Methoden für verschiedene Abfragezwecke				*/
	
	public Studio findByKey(int id) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Studio_ID, Name, Sitz_Land "
					+ "FROM produktionsstudio WHERE Studio_ID = " + id + " ORDER BY Name");
			
			if(rs.next()) {
				Studio s = new Studio();
				s.setId(rs.getInt("Studio_ID"));
				s.setName(rs.getString("Name"));
				s.setSitz(rs.getString("Sitz_Land"));
				
				return s;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Vector<Studio> findAll() {
		Connection con = DBConnection.connection();
		Vector<Studio> result = new Vector<Studio>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Studio_ID, Name, Sitz_Land FROM produktionsstudio"
					+ " ORDER BY Name");
			
			while (rs.next()) {
				Studio s = new Studio();
				s.setId(rs.getInt("Studio_ID"));
				s.setName(rs.getString("Name"));
				s.setSitz(rs.getString("Sitz_Land"));
				
				result.addElement(s);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Vector<Studio> findByName(String name) {
		Connection con = DBConnection.connection();
		Vector<Studio> result = new Vector<Studio>();
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Studio_ID, Name, Sitz_Land FROM produktionsstudio"
					+ " WHERE Name = '" + name + "' ORDER BY Name" );
			
			while (rs.next()) {
				Studio s = new Studio();
				s.setId(rs.getInt("Studio_ID"));
				s.setName(rs.getString("Name"));
				s.setSitz(rs.getString("Sitz_Land"));
				
				result.addElement(s);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Studio insert (Studio studio) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT MAX(Studio_ID) AS maxid FROM produktionsstudio");
			
			if(rs.next()) {
				studio.setId(rs.getInt("maxid") + 1);
				stmt = con.createStatement();
				stmt.executeUpdate("INSERT INTO produktionsstudio (Studio_ID, Name, Sitz_Land) VALUES ("
						+ studio.getId() + ", '"
						+ studio.getName() + "', '"
						+ studio.getSitz() + "')");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return studio;
	}
	
	public Studio insertStudioBelegung (DVD dvd, Studio s) {
		Connection con = DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate("INSERT INTO studio_belegung (DVD_ID, Studio_ID) SELECT dvd.DVD_ID, produktionsstudio.Studio_ID"
						+ " FROM dvd, produktionsstudio WHERE dvd.DVD_ID = " + dvd.getId() +  " AND produktionsstudio.Studio_ID = " + s.getId());
				
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;		//muss noch geklärt werden, was und wie zurückgeben
	}
	
	public Studio update (Studio studio) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE produktionsstudio SET Name = '" + studio.getName() + "', Sitz_Land = '"
					+ studio.getSitz() + "' WHERE Studio_ID = " + studio.getId());
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return studio;
	}
	
	public void delete (Studio studio) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM produktionsstudio WHERE Studio_ID = " + studio.getId());
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudioBelegung (Studio s, DVD dvd) {
		Connection con = DBConnection.connection();
		
		try {
			Statement smt = con.createStatement();
			smt.executeUpdate("DELETE FROM studio_belegung" + " WHERE Studio_ID = " + s.getId() + " AND DVD_ID = " + dvd.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Vector<Studio> findByDVDid(DVD dvd) {
		return findByDVD(dvd.getId());
	}

	private Vector<Studio> findByDVD(int id) {
		Connection con = DBConnection.connection();
		Vector<Studio> result = new Vector<Studio>();
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT produktionsstudio.Studio_ID, produktionsstudio.Name,"
					+ " produktionsstudio.Sitz_Land FROM produktionsstudio JOIN studio_belegung "
					+ "ON produktionsstudio.Studio_ID = studio_belegung.Studio_ID WHERE studio_belegung.DVD_ID = " + id);
			
			while(rs.next()) {
				Studio s = new Studio();
				s.setId(rs.getInt("Studio_ID"));
				s.setName(rs.getString("Name"));
				s.setSitz(rs.getString("Sitz_Land"));
				
				result.addElement(s);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}
}
