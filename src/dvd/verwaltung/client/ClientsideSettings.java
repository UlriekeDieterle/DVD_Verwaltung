package dvd.verwaltung.client;

import com.google.gwt.core.client.GWT;
import com.sun.istack.internal.logging.Logger;

import dvd.verwaltung.shared.CommonSettings;
import dvd.verwaltung.shared.DVDVerwaltungAdministration;
import dvd.verwaltung.shared.DVDVerwaltungAdministrationAsync;

public class ClientsideSettings extends CommonSettings {

	private static DVDVerwaltungAdministrationAsync dvdVerwaltung = null;
	
	// private static ReportGeneratorAsync reportGenerator = null;
	
	private static final String LOGGER_NAME = "DVD Verwaltung";
	
	private static final Logger log = Logger.getLogger(LOGGER_NAME);
	
	public static Logger getLogger() {
		return log;
	}
	
	public static DVDVerwaltungAdministrationAsync getDVDVerwaltung() {
		if(dvdVerwaltung == null) {
			dvdVerwaltung = GWT.create(DVDVerwaltungAdministration.class);
		}
		
		return dvdVerwaltung;
	}
}
