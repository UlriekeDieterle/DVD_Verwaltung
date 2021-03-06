package dvd.verwaltung.shared;

import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import dvd.verwaltung.shared.bo.Auswahl;
import dvd.verwaltung.shared.bo.DVD;
import dvd.verwaltung.shared.bo.Genre;
import dvd.verwaltung.shared.bo.Regisseur;
import dvd.verwaltung.shared.bo.Schauspieler;
import dvd.verwaltung.shared.bo.Sprache;
import dvd.verwaltung.shared.bo.Studio;

@RemoteServiceRelativePath("dvd")
public interface DVDVerwaltungAdministration extends RemoteService {
	
	void init() throws IllegalArgumentException;

	DVD createDVD(String titel, int fsk, int prodjahr, int erschjahr, String beschreibung, int filmlaenge,
			String stichwort, int anzahlDisc, String artDVD, String filmSerie);

	void delete (DVD dvd) throws IllegalArgumentException;

	Genre save(Genre genre) throws IllegalArgumentException;

	Regisseur save(Regisseur regisseur) throws IllegalArgumentException;

	Schauspieler save(Schauspieler schauspieler) throws IllegalArgumentException;

	Sprache save(Sprache sprache) throws IllegalArgumentException;

	Studio save(Studio studio) throws IllegalArgumentException;

	void delete(Studio studio) throws IllegalArgumentException;

	void delete(Sprache sprache) throws IllegalArgumentException;

	void delete(Schauspieler schauspieler) throws IllegalArgumentException;

	void delete(Regisseur regisseur) throws IllegalArgumentException;

	void delete(Genre genre) throws IllegalArgumentException;

	Genre createGenre(String name) throws IllegalArgumentException;

	Regisseur createRegisseur(String name) throws IllegalArgumentException;

	Schauspieler createSchauspieler(String vorname, String nachname, int jahr, String nationalitaet)
			throws IllegalArgumentException;

	Sprache createSprache(String name) throws IllegalArgumentException;

	Studio createStudio(String name, String sitz) throws IllegalArgumentException;

	Vector<DVD> getDVDErschjahr(int jahr) throws IllegalArgumentException;

	Vector<DVD> getDVDProdjahr(int jahr) throws IllegalArgumentException;

	DVD getByKey(int id) throws IllegalArgumentException;

	Vector<DVD> getBySerieFilm(String serieFilm) throws IllegalArgumentException;

	Vector<DVD> getByStichwort(String stichwort) throws IllegalArgumentException;

	Vector<DVD> getByTitel(String titel) throws IllegalArgumentException;

	Vector<Genre> getAllGenre() throws IllegalArgumentException;

	Genre getByGenreId(int id) throws IllegalArgumentException;

	Vector<Genre> getByGenre(String name) throws IllegalArgumentException;

	Genre createGenreBelegung(Vector<Genre> genre, DVD dvd) throws IllegalArgumentException;

	Regisseur createRegisseurBelegung(Vector<Regisseur> reg, DVD dvd) throws IllegalArgumentException;

	Schauspieler createSchauspielerBelegung(Vector<Schauspieler> schausp, DVD dvd) throws IllegalArgumentException;

	Sprache createSpracheBelegung(Vector<Sprache> sprache, Vector<Sprache> untertitel, DVD dvd) throws IllegalArgumentException;

	Studio createStudioBelegung(Vector<Studio> studio, DVD dvd) throws IllegalArgumentException;

	Vector<Regisseur> getAllRegisseur() throws IllegalArgumentException;

	Regisseur getByRegisseurId(int id) throws IllegalArgumentException;

	Vector<Regisseur> getByRegisseurName(String name) throws IllegalArgumentException;

	Vector<Schauspieler> getAllSchauspieler() throws IllegalArgumentException;

	Schauspieler getSchauspielerId(int id) throws IllegalArgumentException;

	Vector<Schauspieler> getByNachname(String name) throws IllegalArgumentException;

	Vector<Schauspieler> getByNationalitaet(String nationalitaet) throws IllegalArgumentException;

	Vector<Sprache> getAllSprachen() throws IllegalArgumentException;

	Sprache getSpracheById(int id) throws IllegalArgumentException;

	Vector<Sprache> getSpracheByName(String name) throws IllegalArgumentException;

	Vector<Studio> getAllStudio() throws IllegalArgumentException;

	Studio getStudioById(int id) throws IllegalArgumentException;

	Vector<Studio> getByStudioName(String name) throws IllegalArgumentException;

	Vector<DVD> getByFSK(int fsk, Auswahl auswahl) throws IllegalArgumentException;

	Vector<DVD> getByLaenge(int laenge, Auswahl auswahl) throws IllegalArgumentException;

	DVD save(DVD dvd) throws IllegalArgumentException;

	Vector<DVD> getAllDVDs() throws IllegalArgumentException;
	
	Vector<Genre> getGenreByDVDID(DVD dvd) throws IllegalArgumentException;
	
	Vector<Regisseur> getRegisseurByDVDID (DVD dvd) throws IllegalArgumentException;
	
	Vector<Schauspieler> getSchauspielerByDVDID (DVD dvd) throws IllegalArgumentException;
	
	void setDVD(DVD dvd);
	
	String sayHelloTest (String name);

	Vector<Sprache> getSpracheByDVDID(DVD dvd) throws IllegalArgumentException;

	Vector<Sprache> getUntertitelByDVDID(DVD dvd) throws IllegalArgumentException;

	Vector<Studio> getStudioByDVDID(DVD dvd) throws IllegalArgumentException;

	DVD getDVD() throws IllegalArgumentException;

	Vector<Genre> updateGenreBelegung(Vector<Genre> genre, DVD dvd) throws IllegalArgumentException;

	Vector<Regisseur> updateRegisseurBelegung(Vector<Regisseur> regisseur, DVD dvd) throws IllegalArgumentException;

	Vector<Schauspieler> updateSchauspielerBelegung(Vector<Schauspieler> schauspieler, DVD dvd)
			throws IllegalArgumentException;

	Vector<Sprache> updateSprachenBelegung(Vector<Sprache> sprache, Vector<Sprache> untertitel, DVD dvd)
			throws IllegalArgumentException;

	Vector<Studio> updateStudioBelegung(Vector<Studio> studio, DVD dvd) throws IllegalArgumentException;

}
