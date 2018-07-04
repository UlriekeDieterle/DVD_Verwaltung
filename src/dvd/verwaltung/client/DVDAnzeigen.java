package dvd.verwaltung.client;

import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import dvd.verwaltung.client.gui.DataGridDVD;
import dvd.verwaltung.shared.DVDVerwaltungAdministrationAsync;
import dvd.verwaltung.shared.bo.DVD;
import dvd.verwaltung.shared.bo.Genre;

public class DVDAnzeigen extends BasicFrame {

	private Vector<DVD> dvdListe = new Vector<DVD>();
	private Vector<DVD> genreListe = new Vector<DVD>();
	private Vector<DVD> schauspielerListe = new Vector<DVD>();
	private Vector<DVD> regisseurListe = new Vector<DVD>();
	private Vector<DVD> spracheListe = new Vector<DVD>();
	private Vector<DVD> untertitelListe = new Vector<DVD>();
	private Vector<DVD> studioListe = new Vector<DVD>();
	DVD dvd;

	
	public DVDAnzeigen (Vector<DVD> list) {
		dvdListe = list;
	}
	
	public DVDAnzeigen() {}
	
	public Vector<DVD> getDVDListe() {
		return dvdListe;
	}
	
	public void setDVDListe (Vector<DVD> dvdListe) {
		this.dvdListe = dvdListe;
	}

	@Override
	protected String getSubHeadlineText() {
		return "Alle DVDs";
	}

	@Override
	protected String getHeadlineText() {
		return "Hier werden alle DVDs angezeigt";
	}
	
	DVDVerwaltungAdministrationAsync dvdVerwaltung = ClientsideSettings.getDVDVerwaltung();
	
	@Override
	protected void run() {

		VerticalPanel contentPanel = new VerticalPanel();
		FlexTable table = new FlexTable();
				
		contentPanel.add(table);
		
		DataGridDVD dg = new DataGridDVD(dvdListe);
		
		RootPanel.get("main").add(contentPanel);
		RootPanel.get("search-table").add(dg.start());
		
	}
}

