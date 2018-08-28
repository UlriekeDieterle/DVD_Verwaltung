package dvd.verwaltung.shared;

import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

import dvd.verwaltung.shared.bo.Auswahl;
import dvd.verwaltung.shared.bo.DVD;
import dvd.verwaltung.shared.bo.Genre;
import dvd.verwaltung.shared.bo.Regisseur;
import dvd.verwaltung.shared.bo.Schauspieler;
import dvd.verwaltung.shared.bo.Sprache;
import dvd.verwaltung.shared.bo.Studio;

public interface DVDVerwaltungAdministrationAsync {

	void createDVD(String titel, int fsk, int prodjahr, int erschjahr, String beschreibung, int filmlaenge,
			String stichwort, int anzahlDisc, String artDVD, String filmSerie, AsyncCallback<DVD> callback);
	
	void createGenre(String name, AsyncCallback<Genre> callback);
	
	void createRegisseur(String name, AsyncCallback<Regisseur> callback);

	void createSchauspieler(String vorname, String nachname, int jahr, String nationalitaet,
			AsyncCallback<Schauspieler> callback);

	void createSprache(String name, AsyncCallback<Sprache> callback);

	void createStudio(String name, String sitz, AsyncCallback<Studio> callback);

	void delete (DVD dvd, AsyncCallback<Void> callback);

	void save(DVD dvd, AsyncCallback<DVD> callback);

	void save(Genre genre, AsyncCallback<Genre> callback);

	void save(Regisseur regisseur, AsyncCallback<Regisseur> callback);

	void save(Schauspieler schauspieler, AsyncCallback<Schauspieler> callback);

	void save(Sprache sprache, AsyncCallback<Sprache> callback);

	void save(Studio studio, AsyncCallback<Studio> callback);

	void delete(Studio studio, AsyncCallback<Void> callback);

	void delete(Sprache sprache, AsyncCallback<Void> callback);

	void delete(Schauspieler schauspieler, AsyncCallback<Void> callback);

	void delete(Regisseur regisseur, AsyncCallback<Void> callback);

	void delete(Genre genre, AsyncCallback<Void> callback);

	void getAllDVDs(AsyncCallback<Vector<DVD>> callback);

	void getDVDErschjahr(int jahr, AsyncCallback<Vector<DVD>> callback);

	void getDVDProdjahr(int jahr, AsyncCallback<Vector<DVD>> callback);

	void getByFSK(int fsk, Auswahl auswahl, AsyncCallback<Vector<DVD>> callback);

	void getByLaenge(int laenge, Auswahl auswahl, AsyncCallback<Vector<DVD>> callback);

	void getByKey(int id, AsyncCallback<DVD> callback);

	void getBySerieFilm(String serieFilm, AsyncCallback<Vector<DVD>> callback);

	void getByStichwort(String stichwort, AsyncCallback<Vector<DVD>> callback);

	void getByTitel(String titel, AsyncCallback<Vector<DVD>> callback);

	void getAllGenre(AsyncCallback<Vector<Genre>> callback);

	void getByGenreId(int id, AsyncCallback<Genre> callback);

	void getByGenre(String name, AsyncCallback<Vector<Genre>> callback);

	void createGenreBelegung(Vector<Genre> genre, DVD dvd, AsyncCallback<Genre> callback);

	void createRegisseurBelegung(Vector<Regisseur> reg, DVD dvd, AsyncCallback<Regisseur> callback);

	void createSchauspielerBelegung(Vector<Schauspieler> schausp, DVD dvd, AsyncCallback<Schauspieler> callback);

	void createSpracheBelegung(Vector<Sprache> sprache, Vector<Sprache> untertitel, DVD dvd, AsyncCallback<Sprache> callback);

	void createStudioBelegung(Vector<Studio> studio, DVD dvd, AsyncCallback<Studio> callback);

	void getAllRegisseur(AsyncCallback<Vector<Regisseur>> callback);

	void getByRegisseurId(int id, AsyncCallback<Regisseur> callback);

	void getByRegisseurName(String name, AsyncCallback<Vector<Regisseur>> callback);

	void getAllSchauspieler(AsyncCallback<Vector<Schauspieler>> callback);

	void getSchauspielerId(int id, AsyncCallback<Schauspieler> callback);

	void getByNachname(String name, AsyncCallback<Vector<Schauspieler>> callback);

	void getByNationalitaet(String nationalitaet, AsyncCallback<Vector<Schauspieler>> callback);

	void getAllSprachen(AsyncCallback<Vector<Sprache>> callback);

	void getSpracheById(int id, AsyncCallback<Sprache> callback);

	void getSpracheByName(String name, AsyncCallback<Vector<Sprache>> callback);

	void getAllStudio(AsyncCallback<Vector<Studio>> callback);

	void getStudioById(int id, AsyncCallback<Studio> callback);

	void getByStudioName(String name, AsyncCallback<Vector<Studio>> callback);

	void setDVD(DVD dvd, AsyncCallback<Void> callback);

	void sayHelloTest(String name, AsyncCallback<String> callback);

	void getGenreByDVDID(DVD dvd, AsyncCallback<Vector<Genre>> callback);

	void getRegisseurByDVDID(DVD dvd, AsyncCallback<Vector<Regisseur>> callback);

	void getSchauspielerByDVDID(DVD dvd, AsyncCallback<Vector<Schauspieler>> callback);

	void getSpracheByDVDID(DVD dvd, AsyncCallback<Vector<Sprache>> callback);

	void getUntertitelByDVDID(DVD dvd, AsyncCallback<Vector<Sprache>> callback);

	void getStudioByDVDID(DVD dvd, AsyncCallback<Vector<Studio>> callback);

	void getDVD(AsyncCallback<DVD> callback);

	void init(AsyncCallback<Void> callback);

	void updateGenreBelegung(Vector<Genre> genre, DVD dvd, AsyncCallback<Vector<Genre>> callback);

	void updateRegisseurBelegung(Vector<Regisseur> regisseur, DVD dvd, AsyncCallback<Vector<Regisseur>> callback);

	void updateSchauspielerBelegung(Vector<Schauspieler> schauspieler, DVD dvd,
			AsyncCallback<Vector<Schauspieler>> callback);

	void updateSprachenBelegung(Vector<Sprache> sprache, Vector<Sprache> untertitel, DVD dvd,
			AsyncCallback<Vector<Sprache>> callback);

	void updateStudioBelegung(Vector<Studio> studio, DVD dvd, AsyncCallback<Vector<Studio>> callback);

	

	

}
