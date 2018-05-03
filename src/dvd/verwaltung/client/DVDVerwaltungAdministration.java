package dvd.verwaltung.client;

import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;

import dvd.verwaltung.shared.bo.DVD;
import dvd.verwaltung.shared.bo.Genre;
import dvd.verwaltung.shared.bo.Regisseur;
import dvd.verwaltung.shared.bo.Schauspieler;
import dvd.verwaltung.shared.bo.Sprache;
import dvd.verwaltung.shared.bo.Studio;

public interface DVDVerwaltungAdministration extends RemoteService {

	DVD createDVD(String titel, int fsk, int prodjahr, int erschjahr, String beschreibung, int filmlaenge,
			String stichwort, int anzahlDisc, String artDVD, String filmSerie);

	void deleteDVD (DVD dvd) throws IllegalArgumentException;

	void save(DVD dvd) throws IllegalArgumentException;

	void save(Genre genre) throws IllegalArgumentException;

	void save(Regisseur regisseur) throws IllegalArgumentException;

	void save(Schauspieler schauspieler) throws IllegalArgumentException;

	void save(Sprache sprache) throws IllegalArgumentException;

	void save(Studio studio) throws IllegalArgumentException;

	void delete(Studio studio) throws IllegalArgumentException;

	void delete(Sprache sprache) throws IllegalArgumentException;

	void delete(Schauspieler schauspieler) throws IllegalArgumentException;

	void delete(Regisseur regisseur) throws IllegalArgumentException;

	void delete(Genre genre) throws IllegalArgumentException;

	void delete(DVD dvd) throws IllegalArgumentException;

	Vector<DVD> getAllDVDs() throws IllegalArgumentException;

}
