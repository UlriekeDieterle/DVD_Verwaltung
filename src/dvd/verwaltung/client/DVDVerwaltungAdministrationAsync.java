package dvd.verwaltung.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import dvd.verwaltung.shared.bo.DVD;

public interface DVDVerwaltungAdministrationAsync {

	void createDVD(String titel, int fsk, int prodjahr, int erschjahr, String beschreibung, int filmlaenge,
			String stichwort, int anzahlDisc, String artDVD, String filmSerie, AsyncCallback<DVD> callback);

	void deleteDVD (DVD dvd, AsyncCallback<Void> callback);

}
