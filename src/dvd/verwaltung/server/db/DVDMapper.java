package dvd.verwaltung.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import dvd.verwaltung.server.db.DBConnection;

import dvd.verwaltung.shared.bo.DVD;
import dvd.verwaltung.client.*;
public class DVDMapper {

	public static DVDMapper dvdMapper = null;
	
	protected DVDMapper() {
	}
	
	public static DVDMapper dvdMapper() {
		if(dvdMapper == null) {
			dvdMapper = new DVDMapper ();
		}
		
		return dvdMapper;
	}
	
	/*		Methoden für verschiedene Abfragezwecke				*/
	
	public DVD findByKey(int id) throws ClassNotFoundException {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr"
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd "
					+ "WHERE DVD_ID = " + id + " ORDER BY Titel");
			
			if (rs.next()) {
	    		DVD dvd = new DVD();
	    		dvd.setId(rs.getInt("DVD_ID"));
	            dvd.setTitel(rs.getString("Titel"));
	            dvd.setFSK(rs.getInt("FSK"));
	            dvd.setProduktionsjahr(rs.getInt("Produktionsjahr"));
	            dvd.setErscheinungsjahr(rs.getInt("Erscheinungsjahr"));
	            dvd.setBeschreibung(rs.getString("Beschreibung"));
	            dvd.setFilmlaenge(rs.getInt("Filmlänge"));
	            dvd.setStichwort(rs.getString("Stichwort"));
	            dvd.setAnzahlDisc(rs.getInt("Anzahl_Disc"));
	            dvd.setArtDVD(rs.getString("Art_DVD"));
	            dvd.setSerieFilm(rs.getString("Serie_Film"));
	            
	            return dvd;	            
		}			
	} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	public Vector<DVD> findAll() throws ClassNotFoundException {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr"
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd ORDER BY Titel");
			
			while (rs.next()) {
				DVD dvd = new DVD();
				dvd.setId(rs.getInt("Matrikelnummer"));
				dvd.setId(rs.getInt("DVD_ID"));
	            dvd.setTitel(rs.getString("Titel"));
	            dvd.setFSK(rs.getInt("FSK"));
	            dvd.setProduktionsjahr(rs.getInt("Produktionsjahr"));
	            dvd.setErscheinungsjahr(rs.getInt("Erscheinungsjahr"));
	            dvd.setBeschreibung(rs.getString("Beschreibung"));
	            dvd.setFilmlaenge(rs.getInt("Filmlänge"));
	            dvd.setStichwort(rs.getString("Stichwort"));
	            dvd.setAnzahlDisc(rs.getInt("Anzahl_Disc"));
	            dvd.setArtDVD(rs.getString("Art_DVD"));
	            dvd.setSerieFilm(rs.getString("Serie_Film"));
				
				result.addElement(dvd);
				
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public Vector<DVD> findByFSK(int fsk) {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			Statement smt = con.createStatement();
			
			ResultSet rs = smt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr"
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE FSK = " + fsk + " ORDER BY Titel");
						
			while (rs.next()){
				DVD dvd = new DVD();
				dvd.setId(rs.getInt("Matrikelnummer"));
				dvd.setId(rs.getInt("DVD_ID"));
	            dvd.setTitel(rs.getString("Titel"));
	            dvd.setFSK(rs.getInt("FSK"));
	            dvd.setProduktionsjahr(rs.getInt("Produktionsjahr"));
	            dvd.setErscheinungsjahr(rs.getInt("Erscheinungsjahr"));
	            dvd.setBeschreibung(rs.getString("Beschreibung"));
	            dvd.setFilmlaenge(rs.getInt("Filmlänge"));
	            dvd.setStichwort(rs.getString("Stichwort"));
	            dvd.setAnzahlDisc(rs.getInt("Anzahl_Disc"));
	            dvd.setArtDVD(rs.getString("Art_DVD"));
	            dvd.setSerieFilm(rs.getString("Serie_Film"));
				
				result.addElement(dvd);
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		return result;
	}
	
	public Vector<DVD> findByTitel(String titel) {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			Statement smt = con.createStatement();
			
			ResultSet rs = smt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr"
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE Titel = " + titel + " ORDER BY Titel");
						
			while (rs.next()){
				DVD dvd = new DVD();
				dvd.setId(rs.getInt("Matrikelnummer"));
				dvd.setId(rs.getInt("DVD_ID"));
	            dvd.setTitel(rs.getString("Titel"));
	            dvd.setFSK(rs.getInt("FSK"));
	            dvd.setProduktionsjahr(rs.getInt("Produktionsjahr"));
	            dvd.setErscheinungsjahr(rs.getInt("Erscheinungsjahr"));
	            dvd.setBeschreibung(rs.getString("Beschreibung"));
	            dvd.setFilmlaenge(rs.getInt("Filmlänge"));
	            dvd.setStichwort(rs.getString("Stichwort"));
	            dvd.setAnzahlDisc(rs.getInt("Anzahl_Disc"));
	            dvd.setArtDVD(rs.getString("Art_DVD"));
	            dvd.setSerieFilm(rs.getString("Serie_Film"));
				
				result.addElement(dvd);
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		return result;
	}
	
	public Vector<DVD> findByLaenge(int laenge) {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			Statement smt = con.createStatement();
			
			ResultSet rs = smt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr"
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE Filmlänge = " + laenge + " ORDER BY Titel");
						
			while (rs.next()){
				DVD dvd = new DVD();
				dvd.setId(rs.getInt("Matrikelnummer"));
				dvd.setId(rs.getInt("DVD_ID"));
	            dvd.setTitel(rs.getString("Titel"));
	            dvd.setFSK(rs.getInt("FSK"));
	            dvd.setProduktionsjahr(rs.getInt("Produktionsjahr"));
	            dvd.setErscheinungsjahr(rs.getInt("Erscheinungsjahr"));
	            dvd.setBeschreibung(rs.getString("Beschreibung"));
	            dvd.setFilmlaenge(rs.getInt("Filmlänge"));
	            dvd.setStichwort(rs.getString("Stichwort"));
	            dvd.setAnzahlDisc(rs.getInt("Anzahl_Disc"));
	            dvd.setArtDVD(rs.getString("Art_DVD"));
	            dvd.setSerieFilm(rs.getString("Serie_Film"));
				
				result.addElement(dvd);
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		return result;
	}
	
	public Vector<DVD> findByStichwort (String stichwort) {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			Statement smt = con.createStatement();
			
			ResultSet rs = smt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr"
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE Stichwort = " + stichwort + " ORDER BY Titel");
						
			while (rs.next()){
				DVD dvd = new DVD();
				dvd.setId(rs.getInt("Matrikelnummer"));
				dvd.setId(rs.getInt("DVD_ID"));
	            dvd.setTitel(rs.getString("Titel"));
	            dvd.setFSK(rs.getInt("FSK"));
	            dvd.setProduktionsjahr(rs.getInt("Produktionsjahr"));
	            dvd.setErscheinungsjahr(rs.getInt("Erscheinungsjahr"));
	            dvd.setBeschreibung(rs.getString("Beschreibung"));
	            dvd.setFilmlaenge(rs.getInt("Filmlänge"));
	            dvd.setStichwort(rs.getString("Stichwort"));
	            dvd.setAnzahlDisc(rs.getInt("Anzahl_Disc"));
	            dvd.setArtDVD(rs.getString("Art_DVD"));
	            dvd.setSerieFilm(rs.getString("Serie_Film"));
				
				result.addElement(dvd);
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		return result;
	}
	
	public Vector<DVD> findByArtDVD (String art) {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			Statement smt = con.createStatement();
			
			ResultSet rs = smt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr"
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE Art_DVD = " + art + " ORDER BY Titel");
						
			while (rs.next()){
				DVD dvd = new DVD();
				dvd.setId(rs.getInt("Matrikelnummer"));
				dvd.setId(rs.getInt("DVD_ID"));
	            dvd.setTitel(rs.getString("Titel"));
	            dvd.setFSK(rs.getInt("FSK"));
	            dvd.setProduktionsjahr(rs.getInt("Produktionsjahr"));
	            dvd.setErscheinungsjahr(rs.getInt("Erscheinungsjahr"));
	            dvd.setBeschreibung(rs.getString("Beschreibung"));
	            dvd.setFilmlaenge(rs.getInt("Filmlänge"));
	            dvd.setStichwort(rs.getString("Stichwort"));
	            dvd.setAnzahlDisc(rs.getInt("Anzahl_Disc"));
	            dvd.setArtDVD(rs.getString("Art_DVD"));
	            dvd.setSerieFilm(rs.getString("Serie_Film"));
				
				result.addElement(dvd);
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		return result;
	}
	
	public Vector<DVD> findBySerieFilm (String serieFilm) {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			Statement smt = con.createStatement();
			
			ResultSet rs = smt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr"
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE Serie_Film = " + serieFilm + " ORDER BY Titel");
						
			while (rs.next()){
				DVD dvd = new DVD();
				dvd.setId(rs.getInt("Matrikelnummer"));
				dvd.setId(rs.getInt("DVD_ID"));
	            dvd.setTitel(rs.getString("Titel"));
	            dvd.setFSK(rs.getInt("FSK"));
	            dvd.setProduktionsjahr(rs.getInt("Produktionsjahr"));
	            dvd.setErscheinungsjahr(rs.getInt("Erscheinungsjahr"));
	            dvd.setBeschreibung(rs.getString("Beschreibung"));
	            dvd.setFilmlaenge(rs.getInt("Filmlänge"));
	            dvd.setStichwort(rs.getString("Stichwort"));
	            dvd.setAnzahlDisc(rs.getInt("Anzahl_Disc"));
	            dvd.setArtDVD(rs.getString("Art_DVD"));
	            dvd.setSerieFilm(rs.getString("Serie_Film"));
				
				result.addElement(dvd);
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		return result;
	}
	
	public Vector<DVD> findByErschjahr(String jahr) {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			Statement smt = con.createStatement();
			
			ResultSet rs = smt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr"
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE Erscheinungsjahr = " + jahr + " ORDER BY Titel");
						
			while (rs.next()){
				DVD dvd = new DVD();
				dvd.setId(rs.getInt("Matrikelnummer"));
				dvd.setId(rs.getInt("DVD_ID"));
	            dvd.setTitel(rs.getString("Titel"));
	            dvd.setFSK(rs.getInt("FSK"));
	            dvd.setProduktionsjahr(rs.getInt("Produktionsjahr"));
	            dvd.setErscheinungsjahr(rs.getInt("Erscheinungsjahr"));
	            dvd.setBeschreibung(rs.getString("Beschreibung"));
	            dvd.setFilmlaenge(rs.getInt("Filmlänge"));
	            dvd.setStichwort(rs.getString("Stichwort"));
	            dvd.setAnzahlDisc(rs.getInt("Anzahl_Disc"));
	            dvd.setArtDVD(rs.getString("Art_DVD"));
	            dvd.setSerieFilm(rs.getString("Serie_Film"));
				
				result.addElement(dvd);
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		return result;
	}
	
	public Vector<DVD> findByProdjahr (String jahr) {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			Statement smt = con.createStatement();
			
			ResultSet rs = smt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr"
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE Produktionsjahr = " + jahr + " ORDER BY Titel");
						
			while (rs.next()){
				DVD dvd = new DVD();
				dvd.setId(rs.getInt("Matrikelnummer"));
				dvd.setId(rs.getInt("DVD_ID"));
	            dvd.setTitel(rs.getString("Titel"));
	            dvd.setFSK(rs.getInt("FSK"));
	            dvd.setProduktionsjahr(rs.getInt("Produktionsjahr"));
	            dvd.setErscheinungsjahr(rs.getInt("Erscheinungsjahr"));
	            dvd.setBeschreibung(rs.getString("Beschreibung"));
	            dvd.setFilmlaenge(rs.getInt("Filmlänge"));
	            dvd.setStichwort(rs.getString("Stichwort"));
	            dvd.setAnzahlDisc(rs.getInt("Anzahl_Disc"));
	            dvd.setArtDVD(rs.getString("Art_DVD"));
	            dvd.setSerieFilm(rs.getString("Serie_Film"));
				
				result.addElement(dvd);
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		return result;
	}
	
	
	/*		Methoden für insert, update und delete						*/
	
	
	public DVD insert (DVD dvd){
		Connection con = DBConnection.connection();
		
		try{
			Statement smt = con.createStatement();
								
				// nur Strings mit '' einfügen, Rest ohne!
				//System.out.println(test);
				smt.executeUpdate("INSERT INTO dvd (DVD_ID, Vorname, Nachname, EMail, Geburtsdatum, HdM_Kuerzel, Studiengang) "
						+ "VALUES (" 
						+ s.getId() + ",'" 
						+ s.getFirstName() + "', '" 
						+ s.getLastName() + "', '" 
						+ s.getEmail() + "', "
						+ s.getBirthday() + ", '" 
						+ s.getKuerzel() + "', '" 
						+ s.getStudies() + "')");
				
				dvd.verwaltung.client.ClientsideSettings.getLogger().info("DVD wurde in DB geschrieben");
		}
		catch (SQLException e) {
		      e.printStackTrace();
	}
		
		return s;
	}
	
}
