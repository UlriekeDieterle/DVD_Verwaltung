package dvd.verwaltung.server;

import java.util.Vector;

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
	public Genre createGenre (String name) throws IllegalArgumentException {
		Genre genre = new Genre();
		genre.setGenre(name);
		
		return genreMapper.insert(genre);
	}
	
	@Override
	public Genre createGenreBelegung (Vector<Genre> genre, DVD dvd) throws IllegalArgumentException {
		for (int i = 0; i < genre.size(); i++) {
			genreMapper.insertGenreBelegung(dvd, genre.elementAt(i));
		}
		return null; 
	}
	
	@Override
	public Regisseur createRegisseur (String name) throws IllegalArgumentException {
		Regisseur regisseur = new Regisseur();
		regisseur.setRegisseur(name);
		
		return regisseurMapper.insert(regisseur);
	}
	
	@Override
	public Regisseur createRegisseurBelegung (Vector<Regisseur> reg, DVD dvd) throws IllegalArgumentException {
		for (int i = 0; i < reg.size(); i++) {
			regisseurMapper.insertRegisseurBelegung(dvd, reg.elementAt(i));
		}
		return null;
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
	public Schauspieler createSchauspielerBelegung (Vector<Schauspieler> schausp, DVD dvd) throws IllegalArgumentException {
		for (int i = 0; i < schausp.size(); i++) {
			schauspielerMapper.insertSchauspielerBelegung(dvd, schausp.elementAt(i));
		}
		return null;
	}
	
	@Override
	public Sprache createSprache (String name) throws IllegalArgumentException {
		Sprache sprache = new Sprache();
		sprache.setSprache(name);
		
		return spracheMapper.insert(sprache);
	}
	
	@Override
	public Sprache createSpracheBelegung (Vector<Sprache> sprache, Vector<Sprache> untertitel, DVD dvd) throws IllegalArgumentException {
		for (int i = 0; i < sprache.size(); i++) {
			spracheMapper.insertSpracheBelegung(dvd, sprache.elementAt(i));
		}
		
		for (int i = 0; i < untertitel.size(); i++) {
			spracheMapper.insertUntertitel(dvd, untertitel.elementAt(i));
		}
		return null;
	}
	
	@Override
	public Studio createStudio (String name, String sitz) throws IllegalArgumentException {
		Studio studio = new Studio();
		studio.setName(name);
		studio.setSitz(sitz);
		
		return studioMapper.insert(studio);
	}
	
	@Override
	public Studio createStudioBelegung (Vector<Studio> studio, DVD dvd) throws IllegalArgumentException {
		for (int i = 0; i < studio.size(); i++) {
			studioMapper.insertStudioBelegung(dvd, studio.elementAt(i));
		}
		return null;
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
	public DVD save(DVD dvd) throws IllegalArgumentException {
		return dvdMapper.update(dvd);
	}
	
	@Override
	public Genre save (Genre genre) throws IllegalArgumentException {
		return genreMapper.update(genre);
	}
	
	@Override
	public Regisseur save (Regisseur regisseur) throws IllegalArgumentException {
		return regisseurMapper.update(regisseur);
	}
	
	@Override
	public Schauspieler save (Schauspieler schauspieler) throws IllegalArgumentException {
		return schauspielerMapper.update(schauspieler);
	}
	
	@Override
	public Sprache save (Sprache sprache) throws IllegalArgumentException {
		return spracheMapper.update(sprache);
	}
	
	@Override
	public Studio save (Studio studio) throws IllegalArgumentException {
		return studioMapper.update(studio);
	}
	
	@Override
	public Vector<Genre> updateGenreBelegung (Vector<Genre> genre, DVD dvd) throws IllegalArgumentException {
		genreMapper.deleteGenreBelegung(dvd);
		createGenreBelegung(genre, dvd);
		return genre;
	}
	
	@Override
	public Vector<Regisseur> updateRegisseurBelegung (Vector<Regisseur> regisseur, DVD dvd) throws IllegalArgumentException {
		regisseurMapper.deleteRegisseurBelegung(dvd);
		createRegisseurBelegung(regisseur, dvd);
		return regisseur;
	}
	
	@Override
	public Vector<Schauspieler> updateSchauspielerBelegung (Vector<Schauspieler> schauspieler, DVD dvd) throws IllegalArgumentException {
		schauspielerMapper.deleteSchauspielerBelegung(dvd);
		createSchauspielerBelegung(schauspieler, dvd);
		return schauspieler;
	}
	
	@Override
	public Vector<Sprache> updateSprachenBelegung (Vector<Sprache> sprache, Vector<Sprache> untertitel, DVD dvd) throws IllegalArgumentException {
		spracheMapper.deleteSprachenBelegung(dvd);
		spracheMapper.deleteUntertitelBelegung(dvd);
		createSpracheBelegung(sprache, untertitel, dvd);
		
		return null;
	}
	
	@Override
	public Vector<Studio> updateStudioBelegung (Vector<Studio> studio, DVD dvd) throws IllegalArgumentException {
		studioMapper.deleteStudioBelegung(dvd);
		createStudioBelegung(studio, dvd);
		
		return studio;
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
	
	@Override
	public DVD getDVD() throws IllegalArgumentException {
		return this.dvd;
	}
	
	@Override
	public void setDVD(DVD dvd) throws IllegalArgumentException {
		this.dvd = dvd;
	}
	
	@Override
	public  Vector<Genre> getGenreByDVDID (DVD dvd) throws IllegalArgumentException {
		return dvdMapper.getDetailsOfDVDGenre(dvd);
	}
	
	@Override
	public Vector<Regisseur> getRegisseurByDVDID (DVD dvd) throws IllegalArgumentException {
		return dvdMapper.getDetailsofDVDRegisseur(dvd);
	}
	
	@Override
	public Vector<Schauspieler> getSchauspielerByDVDID (DVD dvd) throws IllegalArgumentException {
		return dvdMapper.getDetailsofDVDSchauspieler(dvd);
	}
	
	@Override
	public Vector<Sprache> getSpracheByDVDID (DVD dvd) throws IllegalArgumentException {
		return dvdMapper.getDetailsofDVDSprache(dvd);
	}
	
	@Override
	public Vector<Sprache> getUntertitelByDVDID (DVD dvd) throws IllegalArgumentException {
		return dvdMapper.getDetailsofDVDUntertitel(dvd);
	}
	
	@Override
	public Vector<Studio> getStudioByDVDID (DVD dvd) throws IllegalArgumentException {
		return dvdMapper.getDetailsofDVDStudio(dvd);
	}

	@Override
	public String sayHelloTest(String name) {
		String greeting = "Hello " + name;
		return greeting;
	}
	
}
