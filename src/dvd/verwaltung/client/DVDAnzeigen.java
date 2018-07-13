package dvd.verwaltung.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

import dvd.verwaltung.shared.DVDVerwaltungAdministrationAsync;
import dvd.verwaltung.shared.bo.DVD;

public class DVDAnzeigen extends BasicFrame {

	DVDVerwaltungAdministrationAsync dvdVerwaltung = ClientsideSettings.getDVDVerwaltung();

	DVD dvd = null;
	
	public DVDAnzeigen(DVD dvd) {
		this.dvd = dvd;
	}
	
	FlowPanel contentPanel = new FlowPanel();
	FlowPanel buttonPanel = new FlowPanel();
	Button bearbeiten = new Button("bearbeiten");
	Button speichern = new Button("speichern");
	
	@Override
	protected void run() {

		Window.alert("DVD mit der ID " + dvd.getId() + " wurde ausgewählt.");
		bearbeiten.setEnabled(true);
		speichern.setEnabled(false);
		
		bearbeiten.addClickHandler(new BearbeitenClickHandler());
		speichern.addClickHandler(new SpeichernClickHandler());
		
		buttonPanel.add(bearbeiten);
		buttonPanel.add(speichern);
		
		//TODO Callbacks für:
		/*
		 * dvdVerwaltung.getGenreByDVDID(dvd, new GenreByDVDCallback());
			dvdVerwaltung.getRegisseurByDVDID(dvd, new RegisseurByDVDCallback());
			dvdVerwaltung.getSchauspielerByDVDID(dvd, new SchauspielerByDVDCallback());
			dvdVerwaltung.getSpracheByDVDID(dvd, new SpracheByDVDCallback());
			dvdVerwaltung.getUntertitelByDVDID(dvd, new UntertitelByDVDCallback());
			dvdVerwaltung.getStudioByDVDID(dvd, new StudioByDVDCallback());
		 */
		
		//TODO weiter machen (Form mit Inhalten aufbauen) nach jeweiligen Callbacks!
		
	}

	@Override
	protected String getSubHeadlineText() {
		return null;
	}

	@Override
	protected String getHeadlineText() {
		return "Details von DVD ansehen";
	} 
	
	private class BearbeitenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			//TODO gute Frage was hier tun... Änderung der Button-Sicht
		}
		
	}
	
	private class SpeichernClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO hier update/insert Methode aufrufen und in DB schreiben + Callback
			
		}
		
	}
}
