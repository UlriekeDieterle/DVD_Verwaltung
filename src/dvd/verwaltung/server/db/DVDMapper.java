package dvd.verwaltung.server.db;

import java.sql.*;
import java.util.Vector;
import dvd.verwaltung.shared.bo.DVD;
import dvd.verwaltung.shared.bo.Genre;
import dvd.verwaltung.shared.bo.Regisseur;
import dvd.verwaltung.shared.bo.Schauspieler;
import dvd.verwaltung.shared.bo.Sprache;
import dvd.verwaltung.shared.bo.Studio;

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
	
	
	public DVD findByKey(int id) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr, "
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
	
	public Vector<DVD> findAll() {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr, "
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd ORDER BY Titel");
			
			while (rs.next()) {
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
				
				result.addElement(dvd);
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	
	
	public Vector<DVD> findByFSKGleich(int fsk) {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr, "
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE FSK = " + fsk + " ORDER BY Titel");
						
			while (rs.next()){
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
				
				result.addElement(dvd);
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		return result;
	}
	
	public Vector<DVD> findByFSKKleiner(int fsk) {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr, "
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE FSK <= " + fsk + " ORDER BY Titel");
						
			while (rs.next()){
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
				
				result.addElement(dvd);
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		return result;
	}
	
	public Vector<DVD> findByFSKGroesser(int fsk) {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr, "
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE FSK >= " + fsk + " ORDER BY Titel");
						
			while (rs.next()){
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
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr, "
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE Titel = '" + titel + "' ORDER BY Titel");
						
			while (rs.next()){
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
				
				result.addElement(dvd);
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		return result;
	}
	
	public Vector<DVD> findByLaengeKleiner (int laenge) {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr, "
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE Filmlänge <= " + laenge + " ORDER BY Titel");
						
			while (rs.next()){
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
				
				result.addElement(dvd);
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		return result;
	}
	
	public Vector<DVD> findByLaengeGroesser(int laenge) {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr, "
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE Filmlänge >= " + laenge + " ORDER BY Titel");
						
			while (rs.next()){
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
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr, "
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE Stichwort = '" + stichwort + "' ORDER BY Titel");
						
			while (rs.next()){
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
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr, "
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd "
					+ "WHERE Art_DVD = '" + art + "' ORDER BY Titel");
						
			while (rs.next()){
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
			
			ResultSet rs = smt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr, "
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE Serie_Film = '" + serieFilm + "' ORDER BY Titel");
						
			while (rs.next()){
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
				
				result.addElement(dvd);
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		return result;
	}
	
	public Vector<DVD> findByErschjahr(int jahr) {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr, "
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE Erscheinungsjahr = " + jahr + " ORDER BY Titel");
						
			while (rs.next()){
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
				
				result.addElement(dvd);
				
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		
		return result;
	}
	
	public Vector<DVD> findByProdjahr (int jahr) {
		Connection con = DBConnection.connection();
		Vector<DVD> result = new Vector<DVD>();
		
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr, "
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film FROM dvd"
					+ " WHERE Produktionsjahr = " + jahr + " ORDER BY Titel");
						
			while (rs.next()){
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
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT MAX(DVD_ID) AS maxid "
			          + "FROM dvd ");
								
				// nur Strings mit '' einfügen, Rest ohne!
				//System.out.println(test);
			
			if(rs.next()) {
				
				dvd.setId(rs.getInt("maxid") + 1);
				
				stmt = con.createStatement();						
						
				stmt.executeUpdate("INSERT INTO dvd (DVD_ID, Titel, FSK, Produktionsjahr, Erscheinungsjahr,"
					+ "Beschreibung, Filmlänge, Stichwort, Anzahl_Disc, Art_DVD, Serie_Film) "
					+ "VALUES (" 
						+ dvd.getId() + ",'" 
						+ dvd.getTitel() + "', " 
						+ dvd.getFSK() + ", " 
						+ dvd.getProduktionsjahr() + ", "
						+ dvd.getErscheinungsjahr() + ", '" 
						+ dvd.getBeschreibung() + "', " 
						+ dvd.getFilmlaenge() + ", '"
						+ dvd.getStichwort() + "', "
						+ dvd.getAnzahlDisc() + ", '"
						+ dvd.getArtDVD() + "', '"
						+ dvd.getSerieFilm() + "')");
				
								
				//dvd.verwaltung.client.ClientsideSettings.getLogger().info("DVD wurde in DB geschrieben");
				
			}
		}
		catch (SQLException e) {
		      e.printStackTrace();
	}
		
		return dvd;
	}
	
	
	public DVD update (DVD dvd){
		Connection con = DBConnection.connection();
		
		try {
		Statement stmt = con.createStatement();
		stmt.executeUpdate("UPDATE dvd SET " + "Titel = '" + dvd.getTitel() + "', FSK = " + dvd.getFSK() + ", Produktionsjahr = "
				+ dvd.getProduktionsjahr() + ", Erscheinungsjahr = " + dvd.getErscheinungsjahr() + ", Beschreibung = '" 
				+ dvd.getBeschreibung() + "', Filmlänge = " + dvd.getFilmlaenge() + ", Stichwort = '" 
				+ dvd.getStichwort() + "', Anzahl_Disc = " + dvd.getAnzahlDisc() + ", Art_DVD = '" + dvd.getArtDVD() +
				"', Serie_Film = '" + dvd.getSerieFilm()	+ "' WHERE DVD_ID = " + dvd.getId());
		
	}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dvd;
	}
	
	public void delete (DVD dvd){
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM dvd " + "WHERE DVD_ID = " + dvd.getId());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*			Details von DVD anzeigen können; Abfrage der Zwischentabellen			*/
	
	public Vector<Genre> getDetailsOfDVDGenre (DVD dvd) {
		return GenreMapper.genreMapper().findByDVDid(dvd);
	}
	
	public Vector<Regisseur> getDetailsofDVDRegisseur (DVD dvd) {
		return RegisseurMapper.regisseurMapper.findByDVDid(dvd);
	}
	
	public Vector<Schauspieler> getDetailsofDVDSchauspieler (DVD dvd) {
		return SchauspielerMapper.schauspielerMapper.findByDVDid(dvd);
	}
	
	public Vector<Sprache> getDetailsofDVDSprache (DVD dvd) {
		return SpracheMapper.spracheMapper.findByDVDid(dvd);
	}
	
	public Vector<Sprache> getDetailsofDVDUntertitel (DVD dvd) {
		return SpracheMapper.spracheMapper().findUntertitelByDVDid(dvd);
	}
	
	public Vector<Studio> getDetailsofDVDStudio (DVD dvd) {
		return StudioMapper.studioMapper.findByDVDid(dvd);
	}
	
}
