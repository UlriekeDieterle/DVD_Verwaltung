package dvd.verwaltung.server;

import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import dvd.verwaltung.server.db.*;
import dvd.verwaltung.shared.DVDVerwaltungAdministration;
import dvd.verwaltung.shared.bo.*;

public class DVDVerwaltungAdministrationImpl extends RemoteServiceServlet implements DVDVerwaltungAdministration {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DVDMapper dvdMapper = null;
	private GenreMapper genreMapper = null;
	private RegisseurMapper regisseurMapper = null;
	private SchauspielerMapper schauspielerMapper = null;
	private SpracheMapper spracheMapper = null;
	private StudioMapper studioMapper = null;

	private DVD dvd;
	
	//Konstruktor
	public DVDVerwaltungAdministrationImpl() throws IllegalArgumentException {}
	
	@Override
	public void init() throws IllegalArgumentException {
		dvdMapper = DVDMapper.dvdMapper();
		genreMapper = GenreMapper.genreMapper();
		regisseurMapper = RegisseurMapper.regisseurMapper();
		schauspielerMapper = SchauspielerMapper.schauspielerMapper();
		spracheMapper = SpracheMapper.spracheMapper();
		studioMapper = StudioMapper.studioMapper();
	}
	
	@Override
	public DVD createDVD (String titel, int fsk, int prodjahr, int erschjahr, String beschreibung, 
			int filmlaenge, String stichwort, int anzahlDisc, String artDVD, String filmSerie) throws IllegalArgumentException{
		
		DVD dvd = new DVD();
		dvd.setTitel(titel);
		dvd.setAnzahlDisc(anzahlDisc);
		dvd.setArtDVD(artDVD);
		dvd.setBeschreibung(beschreibung);
		dvd.setErscheinungsjahr(erschjahr);
		dvd.setFilmlaenge(filmlaenge);
		dvd.setFSK(fsk);
		dvd.setProduktionsjahr(prodjahr);
		dvd.setSerieFilm(filmSerie);
		dvd.setStichwort(stichwort);
		
		
		return dvdMapper.insert(dvd);
	}
	
	@Override
	public void insertDVD (DVD dvd, Genre genre, Regisseur regisseur, Sprache sprache, Schauspieler schauspieler, Studio studio)
		throws IllegalArgumentException {
		createGenreBelegung (genre, dvd);
		createRegisseurBelegung (regisseur, dvd);
		createSchauspielerBelegung (schauspieler, dvd);
		createSpracheBelegung (sprache, dvd);
		createUntertitelBelegung (sprache, dvd);
		createStudioBelegung (studio, dvd);
	}
	
	@Override
	public Genre createGenre (String name) throws IllegalArgumentException {
		Genre genre = new Genre();
		genre.setGenre(name);
		
		return genreMapper.insert(genre);
	}
	
	@Override
	public Genre createGenreBelegung (Genre genre, DVD dvd) throws IllegalArgumentException {
		return genreMapper.insertGenreBelegung(dvd, genre);
	}
	
	@Override
	public Regisseur createRegisseur (String name) throws IllegalArgumentException {
		Regisseur regisseur = new Regisseur();
		regisseur.setRegisseur(name);
		
		return regisseurMapper.insert(regisseur);
	}
	
	@Override
	public Regisseur createRegisseurBelegung (Regisseur reg, DVD dvd) throws IllegalArgumentException {
		return regisseurMapper.insertRegisseurBelegung(dvd, reg);
	}
	
	@Override
	public Schauspieler createSchauspieler (String vorname, String nachname, int jahr, String nationalitaet) throws IllegalArgumentException {
		Schauspieler schauspieler = new Schauspieler();
		schauspieler.setVorname(vorname);
		schauspieler.setNachname(nachname);
		schauspieler.setGeburtsjahr(jahr);
		schauspieler.setNationalitaet(nationalitaet);
		
		return schauspielerMapper.insert(schauspieler);
	}
	
	@Override
	public Schauspieler createSchauspielerBelegung (Schauspieler schausp, DVD dvd) throws IllegalArgumentException {
		return schauspielerMapper.insertSchauspielerBelegung(dvd, schausp);
	}
	
	@Override
	public Sprache createSprache (String name) throws IllegalArgumentException {
		Sprache sprache = new Sprache();
		sprache.setSprache(name);
		
		return spracheMapper.insert(sprache);
	}
	
	@Override
	public Sprache createSpracheBelegung (Sprache sprache, DVD dvd) throws IllegalArgumentException {
		return spracheMapper.insertSpracheBelegung(dvd, sprache);
	}
	
	@Override
	public Sprache createUntertitelBelegung (Sprache sprache, DVD dvd) throws IllegalArgumentException {
		return spracheMapper.insertUntertitel(dvd, sprache);
	}
	
	@Override
	public Studio createStudio (String name, String sitz) throws IllegalArgumentException {
		Studio studio = new Studio();
		studio.setName(name);
		studio.setSitz(sitz);
		
		return studioMapper.insert(studio);
	}
	
	@Override
	public Studio createStudioBelegung (Studio studio, DVD dvd) throws IllegalArgumentException {
		return studioMapper.insertStudioBelegung(dvd, studio);
	}
	
	/*------------------------------------------------------------------------------------*/
	
	@Override
	public void delete (DVD dvd) throws IllegalArgumentException {		
		dvdMapper.delete(dvd);
	}

	@Override
	public void delete (Genre genre)throws IllegalArgumentException {
		genreMapper.delete(genre);
	}
	
	@Override
	public void delete (Regisseur regisseur) throws IllegalArgumentException {
		regisseurMapper.delete(regisseur);
	}
	
	@Override
	public void delete (Schauspieler schauspieler) throws IllegalArgumentException {
		schauspielerMapper.delete(schauspieler);
	}
	
	@Override
	public void delete (Sprache sprache) throws IllegalArgumentException {
		spracheMapper.delete(sprache);
	}
	
	@Override
	public void delete (Studio studio) throws IllegalArgumentException {
		studioMapper.delete(studio);
	}
	
	/*------------------------------------------------------------------------------------*/
	
	@Override
	public void save(DVD dvd) throws IllegalArgumentException {
		dvdMapper.update(dvd);
	}
	
	@Override
	public void save (Genre genre) throws IllegalArgumentException {
		genreMapper.update(genre);
	}
	
	@Override
	public void save (Regisseur regisseur) throws IllegalArgumentException {
		regisseurMapper.update(regisseur);
	}
	
	@Override
	public void save (Schauspieler schauspieler) throws IllegalArgumentException {
		schauspielerMapper.update(schauspieler);
	}
	
	@Override
	public void save (Sprache sprache) throws IllegalArgumentException {
		spracheMapper.update(sprache);
	}
	
	@Override
	public void save (Studio studio) throws IllegalArgumentException {
		studioMapper.update(studio);
	}
	
	/*------------------------------------------------------------------------------------*/
	
	@Override
	public Vector<DVD> getAllDVDs() throws IllegalArgumentException {
		return dvdMapper.findAll();
	}
	
	@Override
	public Vector<DVD> getDVDErschjahr(int jahr) throws IllegalArgumentException {
		return dvdMapper.findByErschjahr(jahr);
	}
	
	@Override
	public Vector<DVD> getDVDProdjahr(int jahr) throws IllegalArgumentException {
		return dvdMapper.findByProdjahr(jahr);
	}
	
	@Override
	public Vector<DVD> getByFSK(int fsk, Auswahl auswahl) throws IllegalArgumentException {
		
		switch (auswahl) {
		case kleiner: return dvdMapper.findByFSKKleiner(fsk); 
		case groesser: return dvdMapper.findByFSKGroesser(fsk); 
		case gleich: return dvdMapper.findByFSKGleich(fsk);
		}
		
		return null;
	}
	
	@Override
	public Vector<DVD> getByLaenge(int laenge, Auswahl auswahl) throws IllegalArgumentException {
		
		switch (auswahl) {
		case kleiner: return dvdMapper.findByLaengeKleiner(laenge); 
		case groesser: return dvdMapper.findByLaengeGroesser(laenge); 
		default:
			break;
		}
		
		return null;
	}
	
	@Override
	public DVD getByKey (int id) throws IllegalArgumentException {
		return dvdMapper.findByKey(id);
	}
	
	@Override
	public Vector<DVD> getBySerieFilm (String serieFilm) throws IllegalArgumentException {
		return dvdMapper.findBySerieFilm(serieFilm);
	}
	
	@Override
	public Vector<DVD> getByStichwort (String stichwort) throws IllegalArgumentException {
		return dvdMapper.findByStichwort(stichwort);
	}
	
	@Override
	public Vector<DVD> getByTitel (String titel) throws IllegalArgumentException {
		return dvdMapper.findByTitel(titel);
	}
	
	/*------------------------------------------------------------------------------------*/
	
	@Override
	public Vector<Genre> getAllGenre() throws IllegalArgumentException {
		return genreMapper.findAll();
	}
	
	@Override
	public Genre getByGenreId(int id) throws IllegalArgumentException {
		return genreMapper.findByKey(id);
	}
	
	@Override
	public Vector<Genre> getByGenre (String name) throws IllegalArgumentException {
		return genreMapper.findByGenre(name);
	}
	
	/*------------------------------------------------------------------------------------*/

	@Override
	public Vector<Regisseur> getAllRegisseur() throws IllegalArgumentException {
		return regisseurMapper.findAll();
	}
	
	@Override
	public Regisseur getByRegisseurId (int id) throws IllegalArgumentException {
	return regisseurMapper.findByKey(id);
	}
	
	@Override
	public Vector<Regisseur> getByRegisseurName (String name) throws IllegalArgumentException {
		return regisseurMapper.findByName(name);
	}
	
	/*------------------------------------------------------------------------------------*/

	@Override
	public Vector<Schauspieler> getAllSchauspieler() throws IllegalArgumentException {
		return schauspielerMapper.findAll();
	}
	
	@Override
	public Schauspieler getSchauspielerId (int id) throws IllegalArgumentException {
		return schauspielerMapper.findByKey(id);
	}
	
	@Override
	public Vector<Schauspieler> getByNachname (String name) throws IllegalArgumentException {
		return schauspielerMapper.findByNachname(name);
	}
	
	@Override
	public Vector<Schauspieler> getByNationalitaet (String nationalitaet) throws IllegalArgumentException {
		return schauspielerMapper.findByNationalitaet(nationalitaet);
	}
	
	/*------------------------------------------------------------------------------------*/

	@Override
	public Vector<Sprache> getAllSprachen () throws IllegalArgumentException {
		return spracheMapper.findAll();
	}
	
	@Override
	public Sprache getSpracheById (int id) throws IllegalArgumentException {
		return spracheMapper.findByKey(id);
	}
	
	@Override
	public Vector<Sprache> getSpracheByName (String name) throws IllegalArgumentException {
		return spracheMapper.findBySprache(name);
	}
	
	/*------------------------------------------------------------------------------------*/

	@Override
	public Vector<Studio> getAllStudio () throws IllegalArgumentException {
		return studioMapper.findAll();
	}
	
	@Override
	public Studio getStudioById (int id) throws IllegalArgumentException {
		return studioMapper.findByKey(id);
	}
	
	@Override
	public Vector<Studio> getByStudioName (String name) throws IllegalArgumentException {
		return studioMapper.findByName(name);
	}
	
	/*------------------------------------------------------------------------------------*/
	
	public DVD getDVD() throws IllegalArgumentException {
		return this.dvd;
	}
	
	public void setDVD(DVD dvd) throws IllegalArgumentException {
		this.dvd = dvd;
	}

	@Override
	public String sayHelloTest(String name) {
		String greeting = "Hello " + name;
		return greeting;
	}
	
}
