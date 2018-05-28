package dvd.verwaltung.client;

import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import dvd.verwaltung.client.gui.DataGridDVD;
import dvd.verwaltung.shared.DVDVerwaltungAdministrationAsync;
import dvd.verwaltung.shared.bo.DVD;

public class DVDAnzeigen extends BasicFrame {

	private Vector<DVD> dvdListe = new Vector<DVD>();
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
	
	final Button schauspielerAnzeigen = new Button("Schauspieler anzeigen");
	final Button regisseurAnzeigen = new Button("Regisseur anzeigen");
	final Button genreAnzeigen = new Button ("Genre anzeigen");
	final Button sprachenAnzeigen = new Button("Sprachen anzeigen");
	final Button untertitelAnzeigen = new Button("Untertitel anzeigen");
	final Button studioAnzeigen = new Button ("Studio anzeigen");
	
	@Override
	protected void run() {

		schauspielerAnzeigen.setStyleName("pure-button");
		regisseurAnzeigen.setStyleName("pure-button");
		genreAnzeigen.setStyleName("pure-button");
		sprachenAnzeigen.setStyleName("pure-button");
		untertitelAnzeigen.setStyleName("pure-button");
		studioAnzeigen.setStyleName("pure-button");
		
		VerticalPanel contentPanel = new VerticalPanel();
		FlexTable table = new FlexTable();
		HorizontalPanel buttonPanel = new HorizontalPanel();
		
		buttonPanel.add(genreAnzeigen);
		buttonPanel.add(schauspielerAnzeigen);
		buttonPanel.add(regisseurAnzeigen);
		buttonPanel.add(sprachenAnzeigen);
		buttonPanel.add(untertitelAnzeigen);
		buttonPanel.add(studioAnzeigen);
		
		contentPanel.add(buttonPanel);
		contentPanel.add(table);
		
		DataGridDVD dg = new DataGridDVD(dvdListe);
		
		RootPanel.get("main").add(contentPanel);
		RootPanel.get("search-table").add(dg.start());
		
		genreAnzeigen.addClickHandler(new GenreAnzeigenClickHandler());
		schauspielerAnzeigen.addClickHandler(new SchauspielerAnzeigenClickHandler());
		regisseurAnzeigen.addClickHandler(new RegisseurAnzeigenClickHandler());
		sprachenAnzeigen.addClickHandler(new SprachenAnzeigenClickHandler());
		untertitelAnzeigen.addClickHandler(new UntertitelAnzeigenClickHandler());
		studioAnzeigen.addClickHandler(new StudioAnzeigenClickHandler());
				
	}

	private class GenreAnzeigenClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			//dvdVerwaltung.getAllGenre(dvd, callback);
			
		}
		
	}
	
	private class SchauspielerAnzeigenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class RegisseurAnzeigenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class SprachenAnzeigenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class UntertitelAnzeigenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class StudioAnzeigenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
