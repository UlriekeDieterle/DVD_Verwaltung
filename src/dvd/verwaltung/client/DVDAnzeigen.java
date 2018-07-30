package dvd.verwaltung.client;

import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import dvd.verwaltung.shared.DVDVerwaltungAdministrationAsync;
import dvd.verwaltung.shared.bo.*;

public class DVDAnzeigen extends BasicFrame {

	DVDVerwaltungAdministrationAsync dvdVerwaltung = ClientsideSettings.getDVDVerwaltung();

	DVD dvd = null;
	
	public DVDAnzeigen(DVD dvd) {
		this.dvd = dvd;
	}
	
	HorizontalPanel contentPanel = new HorizontalPanel();
	VerticalPanel layerPanel = new VerticalPanel();
	FlowPanel buttonPanel = new FlowPanel();
	FlexTable content = new FlexTable();
	FlexTable content2 = new FlexTable();
	Button bearbeiten = new Button("Bearbeiten");
	Button speichern = new Button("Speichern");
	Button loeschen = new Button("Löschen");
	TextArea beschreibung = new TextArea();
	TextBox titel = new TextBox();
	TextBox stichwort = new TextBox();
	TextBox anzahlDisc = new TextBox();
    TextBox prodjahr = new TextBox();
    TextBox erschjahr = new TextBox();
    TextBox laenge = new TextBox();
	
	RadioButton fsk0 = new RadioButton("FSK", "0");
	RadioButton fsk6 = new RadioButton("FSK", "6");
    RadioButton fsk12 = new RadioButton("FSK", "12");
    RadioButton fsk16 = new RadioButton("FSK", "16");
    RadioButton fsk18 = new RadioButton("FSK", "18");
    
    RadioButton serieFilm = new RadioButton("SerieFilm", "Serie");
    RadioButton serieFilm2 = new RadioButton("SerieFilm", "Spielfilm");
    RadioButton artDVD1 = new RadioButton("ArtderDVD", "Extended Edition");
    RadioButton artDVD2 = new RadioButton("ArtderDVD", "Blu-Ray");
    RadioButton artDVD3 = new RadioButton("ArtderDVD", "Standard Version");
    RadioButton artDVD4 = new RadioButton("ArtderDVD", "Limited Edition");
    RadioButton artDVD5 = new RadioButton("ArtderDVD", "Special Edition");
    RadioButton artDVD6 = new RadioButton("ArtderDVD", "UK Import");
    RadioButton artDVD7 = new RadioButton("ArtderDVD", "USA Import");
    RadioButton artDVD8 = new RadioButton("ArtderDVD", "HD DVD");
    RadioButton artDVD9 = new RadioButton("ArtderDVD", "Steelbook");
    RadioButton artDVD10 = new RadioButton("ArtderDVD", "FR Import");
    
    Vector<Genre> alleGenre = new Vector<Genre>();
    Vector<Regisseur> alleRegisseure = new Vector<Regisseur>();
    Vector<Schauspieler> alleSchauspieler = new Vector<Schauspieler>();
    Vector<Sprache> alleSprachen = new Vector<Sprache>();
    Vector<Sprache> alleUntertitel = new Vector<Sprache>();
    Vector<Studio> alleStudios = new Vector<Studio>();
	
	ListBox alleGenreList = new ListBox();
	ListBox alleRegisseureList = new ListBox();
	ListBox alleSchauspielerList = new ListBox();
	ListBox alleSprachenList = new ListBox();
	ListBox alleUntertitelList = new ListBox();
	ListBox alleStudiosList = new ListBox();
	
	@Override
	protected void run() {
		

//		Window.alert("DVD mit der ID " + dvd.getId() + " wurde ausgewählt.");
		bearbeiten.setEnabled(true);
		speichern.setEnabled(false);
		loeschen.setEnabled(true);
		
		bearbeiten.addClickHandler(new BearbeitenClickHandler());
		loeschen.addClickHandler(new LoeschenClickHandler());
		
		buttonPanel.add(bearbeiten);
		buttonPanel.add(speichern);
		buttonPanel.add(loeschen);
		
		 dvdVerwaltung.getGenreByDVDID(dvd, new GenreByDVDCallback());
		
		//TODO weiter machen (Form mit Inhalten aufbauen) nach jeweiligen Callbacks!
	}
	
	protected void anzeigen(DVD dvd) {
		
		alleGenreList.setVisibleItemCount(alleGenreList.getItemCount());
		alleRegisseureList.setVisibleItemCount(alleRegisseureList.getItemCount());
		alleSchauspielerList.setVisibleItemCount(10);
		alleSprachenList.setVisibleItemCount(alleSprachenList.getItemCount());
		alleUntertitelList.setVisibleItemCount(alleUntertitelList.getItemCount());
		alleStudiosList.setVisibleItemCount(alleStudiosList.getItemCount());
		beschreibung.setText(dvd.getBeschreibung());
		beschreibung.setSize("500px", "150px");
		
		content.setText(0, 0, "Titel");
		content.setText(0, 2, dvd.getTitel());
		content.setText(1, 0, "Stichwort");
		content.setText(1, 2, dvd.getStichwort());
		content.setText(2, 0, "Produktionsjahr");
		content.setText(2, 2, Integer.toString(dvd.getProduktionsjahr()));
		content.setText(3, 0, "Erscheinungsjahr");
		content.setText(3, 2, Integer.toString(dvd.getErscheinungsjahr()));
		content.setText(4, 0, "Filmlänge");
		content.setText(4, 2, Integer.toString(dvd.getFilmlaenge()) + " Minuten");
		content.setText(5, 0, "Freigegeben ab ");
		content.setText(5, 2, Integer.toString(dvd.getFSK()) + " Jahren");
		content.setText(6, 0, "Serie oder Spielfilm");
		content.setText(6, 2, dvd.getSerieFilm());
		content.setText(7, 0, "Anzahl der Disc");
		content.setText(7, 2, Integer.toString(dvd.getAnzahlDisc()));
		content.setText(8, 0, "Art der DVD");
		content.setText(8, 2, dvd.getArtDVD());
		content.setText(9, 0, "Beschreibung");
		content.setWidget(9, 2, beschreibung);
		
		content2.setText(0, 4, "Genre");
		content2.setWidget(0, 6, alleGenreList);
		content2.setText(1, 4, "Regisseur");
		content2.setWidget(1, 6, alleRegisseureList);
		content2.setText(2, 4, "Schauspieler");
		content2.setWidget(2, 6, alleSchauspielerList);
		content2.setText(3, 4, "gesprochene Sprachen");
		content2.setWidget(3, 6, alleSprachenList);
		content2.setText(4, 4, "Untertitel");
		content2.setWidget(4, 6, alleUntertitelList);
		content2.setText(5, 4, "Produktionsstudio");
		content2.setWidget(5, 6, alleStudiosList);
		
		layerPanel.add(buttonPanel);
		contentPanel.add(content);
		contentPanel.add(content2);
		layerPanel.add(contentPanel);
		
		RootPanel.get("Details").clear();
		RootPanel.get("Details").add(layerPanel);
	}

	@Override
	protected String getSubHeadlineText() {
		return null;
	}

	@Override
	protected String getHeadlineText() {
		return "Details von DVD ansehen";
	} 
	
	class BearbeitenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			bearbeiten.setEnabled(false);
			speichern.setEnabled(true);
			loeschen.setEnabled(false);
			
			titel.setValue(dvd.getTitel());
			stichwort.setValue(dvd.getStichwort());
			beschreibung.setValue(dvd.getBeschreibung());
			prodjahr.setValue(Integer.toString(dvd.getProduktionsjahr()));
			erschjahr.setValue(Integer.toString(dvd.getErscheinungsjahr()));
			laenge.setValue(Integer.toString(dvd.getFilmlaenge()));
			anzahlDisc.setValue(Integer.toString(dvd.getAnzahlDisc()));
			if (fsk0.getValue() == true) {
				fsk0.setChecked(true);
			} else if (fsk6.getValue() == true) {
				fsk6.setChecked(true);
			} else if (fsk12.getValue() == true) {
				fsk12.setChecked(true);
			} else if (fsk16.getValue() == true) {
				fsk16.setChecked(true);
			} else if (fsk18.getValue() == true) {
				fsk18.setChecked(true);
			}
			
			
			
			content.setText(0, 0, "Titel");
			content.setWidget(0, 2, titel);
			content.setText(1, 0, "Stichwort");
			content.setWidget(1, 2, stichwort);
			content.setText(2, 0, "Produktionsjahr");
			content.setWidget(2, 2, prodjahr);
			content.setText(3, 0, "Erscheinungsjahr");
			content.setWidget(3, 2, erschjahr);
			content.setText(4, 0, "Filmlänge");
			content.setWidget(4, 2, laenge);
			content.setText(5, 0, "Freigegeben ab ");
			content.setWidget(5, 2, fsk0);
			content.setWidget(5, 3, fsk6);
			content.setWidget(5, 4, fsk12);
			content.setWidget(5, 5, fsk16);
			content.setWidget(5, 6, fsk18);
			content.setText(6, 0, "Serie oder Spielfilm");
			content.setWidget(6, 2, serieFilm);
			content.setWidget(6, 3, serieFilm2);
			content.setText(7, 0, "Anzahl der Disc");
			content.setWidget(7, 2, anzahlDisc);
			content.setText(8, 0, "Art der DVD");
			content.setWidget(8, 2, artDVD1);
			content.setWidget(8, 3, artDVD2);
			content.setWidget(8, 4, artDVD3);
			content.setWidget(8, 5, artDVD4);
			content.setWidget(8, 6, artDVD5);
			content.setWidget(8, 7, artDVD6);
			content.setWidget(8, 8, artDVD7);
			content.setWidget(8, 9, artDVD8);
			content.setWidget(8, 10, artDVD9);
			content.setWidget(8, 11, artDVD10);
			content.setText(9, 0, "Beschreibung");
			content.setWidget(9, 2, beschreibung);
			
/*			content2.setText(0, 4, "Genre");
			content2.setWidget(0, 6, alleGenre);
			content2.setText(1, 4, "Regisseur");
			content2.setWidget(1, 6, alleRegisseure);
			content2.setText(2, 4, "Schauspieler");
			content2.setWidget(2, 6, alleSchauspieler);
			content2.setText(3, 4, "gesprochene Sprachen");
			content2.setWidget(3, 6, alleSprachen);
			content2.setText(4, 4, "Untertitel");
			content2.setWidget(4, 6, alleUntertitel);
			content2.setText(5, 4, "Produktionsstudio");
			content2.setWidget(5, 6, alleStudios);*/
			
			
			layerPanel.add(buttonPanel);
			contentPanel.add(content);
			contentPanel.add(content2);
			layerPanel.add(contentPanel);
			
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(layerPanel);
			
			//TODO flextable ändern in Editiermodus
			speichern.addClickHandler(new SpeichernClickHandler());

		}
		
	}
	
	class SpeichernClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO hier update/insert Methode aufrufen und in DB schreiben + Callback und wieder diese Seite aufrufen lassen
			DVD dvd = new DVD();
			
			
			
			dvdVerwaltung.save(dvd, new AsyncCallback<DVD>() {

				@Override
				public void onFailure(Throwable caught) {					
				}

				@Override
				public void onSuccess(DVD result) {
					BasicFrame anzeigen = new DVDAnzeigen(result);
				      RootPanel.get("Details").clear();
				      RootPanel.get("Details").add(anzeigen);
				}
				
			});
		}
	}
	
	class LoeschenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			dvdVerwaltung.delete(dvd, new AsyncCallback<Void>() {

				@Override
				public void onFailure(Throwable caught) {}

				@Override
				public void onSuccess(Void result) {
					BasicFrame alleDVDAnzeigen = new AlleDVDAnzeigen();
				      RootPanel.get("Details").clear();
				      RootPanel.get("Details").add(alleDVDAnzeigen);
				}
				
			});
		}
		
	}
	
	class GenreByDVDCallback implements AsyncCallback<Vector<Genre>> {

		@Override
		public void onFailure(Throwable caught) {			
		}

		@Override
		public void onSuccess(Vector<Genre> result) {
			for(int i = 0; i < result.size(); i++ ) {
				alleGenreList.addItem(result.elementAt(i).getGenre(), Integer.toString(result.elementAt(i).getId()));
//				Window.alert(result.elementAt(i).getGenre());
			}
			
			dvdVerwaltung.getRegisseurByDVDID(dvd, new RegisseurByDVDCallback());
		}
	}
	
	class RegisseurByDVDCallback implements AsyncCallback<Vector<Regisseur>> {

		@Override
		public void onFailure(Throwable caught) {			
		}

		@Override
		public void onSuccess(Vector<Regisseur> result) {
			for(int i = 0; i < result.size(); i++ ) {
				alleRegisseureList.addItem(result.elementAt(i).getRegisseur(), Integer.toString(result.elementAt(i).getId()));
			}
			dvdVerwaltung.getSchauspielerByDVDID(dvd, new SchauspielerByDVDCallback());
		}
	}
	
	class SchauspielerByDVDCallback implements AsyncCallback<Vector<Schauspieler>> {

		@Override
		public void onFailure(Throwable caught) {			
		}

		@Override
		public void onSuccess(Vector<Schauspieler> result) {
			for( int i = 0; i < result.size(); i++) {
				String schausp = result.elementAt(i).getVorname() + " " + result.elementAt(i).getNachname();
				alleSchauspielerList.addItem(schausp, Integer.toString(result.elementAt(i).getId()));		
			}
			dvdVerwaltung.getSpracheByDVDID(dvd, new SpracheByDVDCallback());
		}	
	}
	
	class SpracheByDVDCallback implements AsyncCallback<Vector<Sprache>> {

		@Override
		public void onFailure(Throwable caught) {			
		}

		@Override
		public void onSuccess(Vector<Sprache> result) {
			for( int i = 0; i < result.size(); i++) {
				alleSprachenList.addItem(result.elementAt(i).getSprache(), Integer.toString(result.elementAt(i).getId()));		
			}
			dvdVerwaltung.getUntertitelByDVDID(dvd, new UntertitelByDVDCallback());
		}	
	}
	
	class UntertitelByDVDCallback implements AsyncCallback<Vector<Sprache>> {

		@Override
		public void onFailure(Throwable caught) {			
		}

		@Override
		public void onSuccess(Vector<Sprache> result) {
			for(int i = 0; i < result.size(); i++) {
				alleUntertitelList.addItem(result.elementAt(i).getSprache(), Integer.toString(result.elementAt(i).getId()));
			}
			dvdVerwaltung.getStudioByDVDID(dvd, new StudioByDVDCallback());
		}
	}
	
	class StudioByDVDCallback implements AsyncCallback<Vector<Studio>> {

		@Override
		public void onFailure(Throwable caught) {			
		}

		@Override
		public void onSuccess(Vector<Studio> result) {
			for(int i = 0; i < result.size(); i++ ) {
				alleStudiosList.addItem(result.elementAt(i).getName(), Integer.toString(result.elementAt(i).getId()));
			}
			anzeigen(dvd);
		}
	}
}
