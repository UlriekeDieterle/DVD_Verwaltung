package dvd.verwaltung.client;

import com.google.gwt.user.client.rpc.RemoteService;

import dvd.verwaltung.shared.bo.DVD;

public interface DVDVerwaltungAdministration extends RemoteService {

	DVD createDVD(String titel, int fsk, int prodjahr, int erschjahr, String beschreibung, int filmlaenge,
			String stichwort, int anzahlDisc, String artDVD, String filmSerie);

	void deleteDVD (DVD dvd) throws IllegalArgumentException;

}
