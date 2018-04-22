package dvd.verwaltung.server.db;

import java.sql.*;

import dvd.verwaltung.shared.bo.DVD;
import dvd.verwaltung.shared.bo.Genre;
import notenberechnung.server.db.DBConnection;
import notenberechnung.shared.bo.Modulbelegung;

import java.util.Vector;

public class GenreMapper {
	
	public static GenreMapper genreMapper = null;
	protected GenreMapper() {
	}
	
	public static GenreMapper genreMapper() {
		if(genreMapper == null) {
			genreMapper = new GenreMapper();
		}
		
		return genreMapper;
	}
	
	/*		Methoden für Abfragen				*/
	
	public Genre findByKey (int id) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT Genre_ID, Genre FROM genre WHERE Genre_ID = " + id
					+ " ORDER BY Genre");
			
			if (rs.next()) {
				Genre genre = new Genre();
				genre.setId(rs.getInt("Genre_ID"));
				genre.setGenre(rs.getString("Genre"));
				
				return genre;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return null;
	}
		
	public Vector <Genre> findAll() {
			Connection con = DBConnection.connection();
			Vector<Genre> result = new Vector<Genre>();
			
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT Genre_ID, Genre FROM genre ORDER BY genre");
				
				while (rs.next()) {
					Genre genre = new Genre();
					genre.setId(rs.getInt("Genre_ID"));
					genre.setGenre(rs.getString("Genre"));
					
					result.addElement(genre);
				}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Vector<Genre> findByGenre (String genre) {
		Connection con = DBConnection.connection();
		Vector<Genre> result = new Vector<Genre>();
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT Genre_ID, Genre FROM genre WHERE Genre = '" + genre
					+ "' ORDER BY Genre");
			
			while (rs.next()) {
				Genre g = new Genre();
				g.setId(rs.getInt("Genre_ID"));
				g.setGenre(rs.getString("Genre"));
				
				result.addElement(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return result;
	}
	
	/*				Methoden für insert, update, delete				*/
	
	public Genre insert (Genre genre) {
		Connection con = DBConnection.connection();
		
		try {
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT MAX(Genre_ID) AS maxid FROM genre");
			
			if(rs.next()) {
				genre.setId(rs.getInt("maxid") + 1);
				stmt = con.createStatement();
				stmt.executeUpdate("INSERT INTO genre (Genre_ID, Genre) VALUES ("
						+ genre.getId() + ", '"
						+ genre.getGenre() + "')");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return genre;
	}
	
	public Genre update (Genre genre) {
		Connection con = DBConnection.connection();
		
		try{
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE genre SET " + "Genre = '" + genre.getGenre() + "' WHERE Genre_ID = " + genre.getId());
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return genre;
	}
	
	public void delete (Genre genre) {
		Connection con = DBConnection.connection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM genre WHERE Genre_ID = " + genre.getId());
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteGenreBelegung (Genre g) {
		Connection con = DBConnection.connection();
		
		try {
			Statement smt = con.createStatement();
			smt.executeUpdate("DELETE FROM genre_belegung" + " WHERE Genre_ID = " + g.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Vector<Genre> findByDVDid(DVD dvd) {
		return findByDVD(dvd.getId());
	}

	private Vector<Genre> findByDVD(int id) {
		Connection con = DBConnection.connection();
		Vector<Genre> result = new Vector<Genre>();
		
		try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT genre.Genre_ID, genre.Genre FROM genre JOIN genre_belegung "
					+ "ON genre.Genre_ID = genre_belegung.Genre_ID WHERE genre_belegung.DVD_ID = " + id);
			
			while(rs.next()) {
				Genre g = new Genre();
				g.setId(rs.getInt("Genre_ID"));
				g.setGenre(rs.getString("Genre"));
				
				result.addElement(g);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}		
		return result;
	}
		
}
