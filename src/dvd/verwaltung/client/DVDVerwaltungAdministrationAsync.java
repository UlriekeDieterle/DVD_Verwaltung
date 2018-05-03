package dvd.verwaltung.client;

import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;

import dvd.verwaltung.shared.bo.DVD;
import dvd.verwaltung.shared.bo.Genre;
import dvd.verwaltung.shared.bo.Regisseur;
import dvd.verwaltung.shared.bo.Schauspieler;
import dvd.verwaltung.shared.bo.Sprache;
import dvd.verwaltung.shared.bo.Studio;

public interface DVDVerwaltungAdministrationAsync {

	void createDVD(String titel, int fsk, int prodjahr, int erschjahr, String beschreibung, int filmlaenge,
			String stichwort, int anzahlDisc, String artDVD, String filmSerie, AsyncCallback<DVD> callback);

	void deleteDVD (DVD dvd, AsyncCallback<Void> callback);

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

	void delete(DVD dvd, AsyncCallback<Void> callback);

	void getAllDVDs(AsyncCallback<Vector<DVD>> callback);

}
