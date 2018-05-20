package dvd.verwaltung.client;

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

	void save(DVD dvd, AsyncCallback<Void> callback);

	void save(Genre genre, AsyncCallback<Void> callback);

	void save(Regisseur regisseur, AsyncCallback<Void> callback);

	void save(Schauspieler schauspieler, AsyncCallback<Void> callback);

	void save(Sprache sprache, AsyncCallback<Void> callback);

	void save(Studio studio, AsyncCallback<Void> callback);

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

	void createGenreBelegung(Genre genre, DVD dvd, AsyncCallback<Genre> callback);

	void createRegisseurBelegung(Regisseur reg, DVD dvd, AsyncCallback<Regisseur> callback);

	void createSchauspielerBelegung(Schauspieler schausp, DVD dvd, AsyncCallback<Schauspieler> callback);

	void createSpracheBelegung(Sprache sprache, DVD dvd, AsyncCallback<Sprache> callback);

	void createUntertitelBelegung(Sprache sprache, DVD dvd, AsyncCallback<Sprache> callback);

	void createStudioBelegung(Studio studio, DVD dvd, AsyncCallback<Studio> callback);

	void insertDVD(DVD dvd, Genre genre, Regisseur regisseur, Sprache sprache, Schauspieler schauspieler, Studio studio,
			AsyncCallback<Void> callback);

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

	void getGenreByDVD(DVD dvd, AsyncCallback<Vector<Genre>> callback);

	void getSchauspielerByDVD(DVD dvd, AsyncCallback<Vector<Schauspieler>> callback);

	void getRegisseurByDVD(DVD dvd, AsyncCallback<Vector<Regisseur>> callback);

	void getSpracheByDVD(DVD dvd, AsyncCallback<Vector<Sprache>> callback);

	void getUntertitelByDVD(DVD dvd, AsyncCallback<Vector<Sprache>> callback);

	void getStudioByDVD(DVD dvd, AsyncCallback<Vector<Studio>> callback);

	

	

}
