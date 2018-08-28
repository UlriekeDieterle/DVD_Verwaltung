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
import com.google.gwt.user.client.ui.Label;
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
	VerticalPanel contentPanel2 = new VerticalPanel();
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
    RadioButton artDVD11 = new RadioButton("ArtderDVD", "Collector´s Edition");
    RadioButton artDVD12 = new RadioButton("ArtderDVD", "Fan Edition");
    
    Vector<Genre> alleGenre = new Vector<Genre>();
    Vector<Regisseur> alleRegisseure = new Vector<Regisseur>();
    Vector<Schauspieler> alleSchauspieler = new Vector<Schauspieler>();
    Vector<Sprache> alleSprachen = new Vector<Sprache>();
    Vector<Sprache> alleUntertitel = new Vector<Sprache>();
    Vector<Studio> alleStudios = new Vector<Studio>();
    
	ListBox alleGenreOfDVDList = new ListBox();
	ListBox alleRegisseureOfDVDList = new ListBox();
	ListBox alleSchauspielerOfDVDList = new ListBox();
	ListBox alleSprachenOfDVDList = new ListBox();
	ListBox alleUntertitelOfDVDList = new ListBox();
	ListBox alleStudiosOfDVDList = new ListBox();
	
	ListBox alleGenreList = new ListBox();
	ListBox alleRegisseureList = new ListBox();
	ListBox alleSchauspielerList = new ListBox();
	ListBox alleSprachenList = new ListBox();
	ListBox alleUntertitelList = new ListBox();
	ListBox alleStudiosList = new ListBox();
	
	Label beschreibungLabel = new Label("Beschreibung");
	
	@Override
	protected void run() {
		
		titel.setMaxLength(100);
		stichwort.setMaxLength(50);
		anzahlDisc.setMaxLength(2);
		prodjahr.setMaxLength(4);
		erschjahr.setMaxLength(4);
		laenge.setMaxLength(4);
		beschreibung.setCharacterWidth(2000);
		
		bearbeiten.setEnabled(true);
		speichern.setEnabled(false);
		loeschen.setEnabled(true);
		
		bearbeiten.addClickHandler(new BearbeitenClickHandler());
		loeschen.addClickHandler(new LoeschenClickHandler());
		
		buttonPanel.add(bearbeiten);
		buttonPanel.add(speichern);
		buttonPanel.add(loeschen);
		
		 dvdVerwaltung.getGenreByDVDID(dvd, new GenreByDVDCallback());
		
	}
	
	protected void anzeigen(DVD dvd) {
		
		alleGenreOfDVDList.setVisibleItemCount(alleGenreOfDVDList.getItemCount());
		alleRegisseureOfDVDList.setVisibleItemCount(alleRegisseureOfDVDList.getItemCount());
		alleSprachenOfDVDList.setVisibleItemCount(alleSprachenOfDVDList.getItemCount());
		alleUntertitelOfDVDList.setVisibleItemCount(alleUntertitelOfDVDList.getItemCount());
		alleStudiosOfDVDList.setVisibleItemCount(alleStudiosOfDVDList.getItemCount());
		beschreibung.setText(dvd.getBeschreibung());
		beschreibung.setSize("550px", "150px");
				
		if(alleSchauspielerOfDVDList.getItemCount() >= 10) {
			alleSchauspielerOfDVDList.setVisibleItemCount(10);
		} else {
			alleSchauspielerOfDVDList.setVisibleItemCount(alleSchauspielerOfDVDList.getItemCount());
		}
		
		alleGenreOfDVDList.setItemSelected(0, false);
		alleRegisseureOfDVDList.setItemSelected(0, false);
		alleSchauspielerOfDVDList.setItemSelected(0, false);
		alleSprachenOfDVDList.setItemSelected(0, false);
		alleUntertitelOfDVDList.setItemSelected(0, false);
		alleStudiosOfDVDList.setItemSelected(0, false);
		
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
		content.setText(15, 0, "");
		
		content2.setText(0, 4, "Genre");
		content2.setWidget(0, 6, alleGenreOfDVDList);
		content2.setText(1, 4, "Regisseur");
		content2.setWidget(1, 6, alleRegisseureOfDVDList);
		content2.setText(2, 4, "Schauspieler");
		content2.setWidget(2, 6, alleSchauspielerOfDVDList);
		content2.setText(3, 4, "gesprochene Sprachen");
		content2.setWidget(3, 6, alleSprachenOfDVDList);
		content2.setText(4, 4, "Untertitel");
		content2.setWidget(4, 6, alleUntertitelOfDVDList);
		content2.setText(5, 4, "Produktionsstudio");
		content2.setWidget(5, 6, alleStudiosOfDVDList);
		
		layerPanel.add(buttonPanel);
		contentPanel2.add(content);
		contentPanel2.add(beschreibungLabel);
		contentPanel2.add(beschreibung);
		contentPanel.add(contentPanel2);
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
	
	protected void bearbeiten() {
		bearbeiten.setEnabled(false);
		speichern.setEnabled(true);
		loeschen.setEnabled(false);
		
		beschreibung.setSize("550px", "150px");
		
		alleGenreList.setMultipleSelect(true);
		alleGenreList.setVisibleItemCount(5);
		
		alleRegisseureList.setMultipleSelect(true);
		alleRegisseureList.setVisibleItemCount(5);
		
		alleSchauspielerList.setMultipleSelect(true);
		alleSchauspielerList.setVisibleItemCount(5);
		
		alleSprachenList.setMultipleSelect(true);
		alleSprachenList.setVisibleItemCount(5);
		
		alleUntertitelList.setMultipleSelect(true);
		alleUntertitelList.setVisibleItemCount(5);
		
		alleStudiosList.setMultipleSelect(true);
		alleStudiosList.setVisibleItemCount(5);
		
		switch (dvd.getFSK()) {
		case 0:
			fsk0.setChecked(true);
			break;
		case 6:
			fsk6.setChecked(true);
			break;
		case 12:
			fsk12.setChecked(true);
			break;
		case 16:
			fsk16.setChecked(true);
			break;
		case 18:
			fsk18.setChecked(true);
			break;
		}
		
		switch(dvd.getSerieFilm()) {
		case "Serie":
			serieFilm.setChecked(true);
			break;
		case "Spielfilm":
			serieFilm2.setChecked(true);
			break;
		}
		
		switch (dvd.getArtDVD()) {
		case "Extended Edition":
			artDVD1.setChecked(true);
			break;
		case "Blu-Ray":
			artDVD2.setChecked(true);
			break;
		case "Standard Version":
			artDVD3.setChecked(true);
			break;
		case "Limited Edition":
			artDVD4.setChecked(true);
			break;
		case "Special Edition":
			artDVD5.setChecked(true);
			break;
		case "UK Import":
			artDVD6.setChecked(true);
			break;
		case "USA Import":
			artDVD7.setChecked(true);
			break;
		case "HD DVD":
			artDVD8.setChecked(true);
			break;
		case "Steelbook":
			artDVD9.setChecked(true);
			break;
		case "FR Import":
			artDVD10.setChecked(true);
			break;
		case "Collector´s Edition":
			artDVD11.setChecked(true);
			break;			
		case "Fan Edition":
			artDVD12.setChecked(true);
		}
		
		titel.setValue(dvd.getTitel());
		stichwort.setValue(dvd.getStichwort());
		beschreibung.setValue(dvd.getBeschreibung());
		prodjahr.setValue(Integer.toString(dvd.getProduktionsjahr()));
		erschjahr.setValue(Integer.toString(dvd.getErscheinungsjahr()));
		laenge.setValue(Integer.toString(dvd.getFilmlaenge()));
		anzahlDisc.setValue(Integer.toString(dvd.getAnzahlDisc()));
		
		alleGenreList.setItemSelected(0, false);
		for (int i = 0; i < alleGenreList.getItemCount(); i++) {
			for (int j = 0; j < alleGenreOfDVDList.getItemCount(); j++) {
				if(alleGenreOfDVDList.getValue(j) == alleGenreList.getValue(i)) {
					alleGenreList.setItemSelected(i, true);
				}
			}
		}
		
		alleRegisseureList.setItemSelected(0, false);
		for (int i = 0; i < alleRegisseureList.getItemCount(); i++) {
			for(int j = 0; j < alleRegisseureOfDVDList.getItemCount(); j++) {
				if(alleRegisseureOfDVDList.getValue(j) == alleRegisseureList.getValue(i)) {
					alleRegisseureList.setItemSelected(i, true);
				}
			}
		}
		
		alleSchauspielerList.setItemSelected(0, false);
		for (int i = 0; i < alleSchauspielerList.getItemCount(); i++) {
			for(int j = 0; j < alleSchauspielerOfDVDList.getItemCount(); j++) {
				if(alleSchauspielerOfDVDList.getValue(j) == alleSchauspielerList.getValue(i)) {
					alleSchauspielerList.setItemSelected(i, true);
				}
			}
		}
		
		alleSprachenList.setItemSelected(0, false);
		for (int i = 0; i < alleSprachenList.getItemCount(); i++) {
			for(int j = 0; j < alleSprachenOfDVDList.getItemCount(); j++) {
				if(alleSprachenOfDVDList.getValue(j) == alleSprachenList.getValue(i)) {
					alleSprachenList.setItemSelected(i, true);
				}
			}
		}
		
		alleUntertitelList.setItemSelected(0, false);
		for (int i = 0; i < alleUntertitelList.getItemCount(); i++) {
			for(int j = 0; j < alleUntertitelOfDVDList.getItemCount(); j++) {
				if(alleUntertitelOfDVDList.getValue(j) == alleUntertitelList.getValue(i)) {
					alleUntertitelList.setItemSelected(i, true);
				}
			}
		}
		
		alleStudiosList.setItemSelected(0, false);
		for (int i = 0; i < alleStudiosList.getItemCount(); i++) {
			for(int j = 0; j < alleStudiosOfDVDList.getItemCount(); j++) {
				if(alleStudiosOfDVDList.getValue(j) == alleStudiosList.getValue(i)) {
					alleStudiosList.setItemSelected(i, true);
				}
			}
		}
		content.clear();
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
		content.setWidget(9, 2, artDVD7);
		content.setWidget(9, 3, artDVD8);
		content.setWidget(9, 4, artDVD9);
		content.setWidget(9, 5, artDVD10);
		content.setWidget(9, 6, artDVD11);
		content.setWidget(9, 7, artDVD12);
		
		content2.clear();
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
		contentPanel2.add(content);
		contentPanel2.add(beschreibungLabel);
		contentPanel2.add(beschreibung);
		contentPanel.add(contentPanel2);
		contentPanel.add(content2);
		layerPanel.add(contentPanel);
		
		RootPanel.get("Details").clear();
		RootPanel.get("Details").add(layerPanel);
		
		speichern.addClickHandler(new SpeichernClickHandler());
	}
	
	class BearbeitenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			dvdVerwaltung.getAllGenre(new AsyncCallback<Vector<Genre>> (){

				@Override
				public void onFailure(Throwable caught) {}

				@Override
				public void onSuccess(Vector<Genre> result) {
								
				for (int i = 0; i < result.size(); i++) {
					alleGenreList.addItem(result.elementAt(i).getGenre(), Integer.toString(result.elementAt(i).getId()));
				}
					 
				dvdVerwaltung.getAllRegisseur(new AsyncCallback<Vector<Regisseur>> () {

						@Override
						public void onFailure(Throwable caught) {	}

						@Override
						public void onSuccess(Vector<Regisseur> result) {
							for (int i = 0; i < result.size(); i++) {
								alleRegisseureList.addItem(result.elementAt(i).getRegisseur(), Integer.toString(result.elementAt(i).getId()));
							}
							dvdVerwaltung.getAllSchauspieler(new AsyncCallback<Vector<Schauspieler>> () {

								@Override
								public void onFailure(Throwable caught) {	}

								@Override
								public void onSuccess(Vector<Schauspieler> result) {
									String schauspieler = null;
									for (int i = 0; i < result.size(); i++) {
										schauspieler = result.elementAt(i).getVorname() + " " + result.elementAt(i).getNachname();
										alleSchauspielerList.addItem(schauspieler, Integer.toString(result.elementAt(i).getId()));
									}
									dvdVerwaltung.getAllSprachen(new AsyncCallback<Vector<Sprache>> () {

										@Override
										public void onFailure(Throwable caught) {	}

										@Override
										public void onSuccess(Vector<Sprache> result) {
											for (int i = 0; i < result.size(); i++) {
												alleSprachenList.addItem(result.elementAt(i).getSprache(), Integer.toString(result.elementAt(i).getId()));
											}
											
											for (int i = 0; i < result.size(); i++) {
												alleUntertitelList.addItem(result.elementAt(i).getSprache(), Integer.toString(result.elementAt(i).getId()));
											}
											dvdVerwaltung.getAllStudio(new AsyncCallback<Vector<Studio>> () {

												@Override
												public void onFailure(Throwable caught) {}

												@Override
												public void onSuccess(Vector<Studio> result) {
													for (int i = 0; i < result.size(); i++) {
														alleStudiosList.addItem(result.elementAt(i).getName(), Integer.toString(result.elementAt(i).getId()));
													}
													 bearbeiten();
												}
												
											});
										}
										
									});
								}
								
							});
						}
						 
					 });
				
				}
				
			});
		}
		
	}
	
	class SpeichernClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			// TODO hier update/insert Methode aufrufen und in DB schreiben + Callback und wieder diese Seite aufrufen lassen
		
			int prodJahr = Integer.parseInt(prodjahr.getText());
			int erschJahr = Integer.parseInt(erschjahr.getText());
			int filmLaenge = Integer.parseInt(laenge.getText());
			int anzahlDisc2 = Integer.parseInt(anzahlDisc.getText());
			Boolean prodJahrBoolean = false;
			Boolean erschJahrBoolean = false;
			Boolean filmLaengeBoolean = false;
			Boolean anzahlDiscBoolean = false;
			Boolean beschreibungBoolean = false;
			
			if (prodJahr >= 1900 && prodJahr <= 2500) {
				prodJahrBoolean = true;
				dvd.setProduktionsjahr(prodJahr);
			} else {
				Window.alert("Bitte gib ein gültiges Produktionsjahr ein, zwischen 1900 und 2500");
				run();
			}
			
			if(erschJahr >= 1900 && erschJahr <= 2500) {
				erschJahrBoolean = true;
				dvd.setErscheinungsjahr(erschJahr);
			} else {
				Window.alert("Bitte gib ein gültiges Erscheinungsjahr ein, zwischen 1900 und 2500");
				run();
			}
			
			if(filmLaenge >= 50 && filmLaenge <= 2000) {
				filmLaengeBoolean = true;
				dvd.setFilmlaenge(filmLaenge);
			} else {
				Window.alert("Bitte gib eine gültige Länge für den Film an, zwischen 50 und 2000 Minuten");
				run();
			}
			
			if(anzahlDisc2 >= 0 && anzahlDisc2 <= 15) {
				anzahlDiscBoolean = true;
				dvd.setAnzahlDisc(anzahlDisc2);
			} else {
				Window.alert("Bitte gib eine gültige Anzahl von Disc an, mindestens 1 bis maximal 15 Stück");
				run();
			}
			
			if(fsk0.getValue() == true) {
				dvd.setFSK(0);;	
			} else if (fsk6.getValue() == true) {
				dvd.setFSK(6);;
			} else if (fsk12.getValue() == true) {
				dvd.setFSK(12);;
			} else if (fsk16.getValue() == true) {
				dvd.setFSK(16);;
			} else if (fsk18.getValue() == true) {
				dvd.setFSK(18);;
			}
			
			if(serieFilm.getValue() == true) {
				dvd.setSerieFilm("Serie");
			} else if (serieFilm2.getValue() == true) {
				dvd.setSerieFilm("Spielfilm");;
			}
			
			if(artDVD1.getValue() == true) {
				dvd.setArtDVD("Extended Edition");
			} else if (artDVD2.getValue() == true) {
				dvd.setArtDVD("Blu-Ray");
			} else if (artDVD3.getValue() == true) {
				dvd.setArtDVD("Standard Version");
			} else if (artDVD4.getValue() == true) {
				dvd.setArtDVD("Limited Edition");
			} else if (artDVD5.getValue() == true) {
				dvd.setArtDVD("Special Edition");
			} else if (artDVD6.getValue() == true) {
				dvd.setArtDVD("UK Import");
			} else if (artDVD7.getValue() == true) {
				dvd.setArtDVD("USA Import");
			} else if (artDVD8.getValue() == true) {
				dvd.setArtDVD("HD DVD");
			} else if (artDVD9.getValue() == true) {
				dvd.setArtDVD("Steelbook");
			} else if (artDVD10.getValue() == true) {
				dvd.setArtDVD("FR Import");
			} else if (artDVD11.getValue() == true) {
				dvd.setArtDVD("Collector´s Edition");
			} else if (artDVD12.getValue() == true) {
				dvd.setArtDVD("Fan Edition");
			}
			
			if(beschreibung.getText().length() < 2000) {
				beschreibungBoolean = true;
				dvd.setBeschreibung(beschreibung.getText());
			} else {
				Window.alert("Die eingegebene Beschreibung ist zu lang");
				run();
			}
			
			dvd.setTitel(titel.getText());
			dvd.setStichwort(stichwort.getText());
			
			if(!titel.getText().isEmpty() && prodJahrBoolean == true && erschJahrBoolean == true && 
					filmLaengeBoolean == true && beschreibungBoolean == true && anzahlDiscBoolean == true)
			dvdVerwaltung.save(dvd, new AsyncCallback<DVD>() {

				@Override
				public void onFailure(Throwable caught) {					
				}

				@Override
				public void onSuccess(DVD result) {
					Vector<Genre> alleGenre = new Vector<Genre>();
					for(int i = 0; i < alleGenreList.getItemCount(); i++) {
						if(alleGenreList.isItemSelected(i) == true) {
							Genre genre = new Genre();
							genre.setId(Integer.parseInt(alleGenreList.getValue(i)));
							genre.setGenre(alleGenreList.getItemText(i));
							alleGenre.add(genre);
						}
					}
					
					dvdVerwaltung.updateGenreBelegung(alleGenre, result, new AsyncCallback<Vector<Genre>>() {

						@Override
						public void onFailure(Throwable caught) {	}

						@Override
						public void onSuccess(Vector<Genre> result) {
							Vector<Regisseur> alleRegisseure = new Vector<Regisseur>();
							for (int i = 0; i < alleRegisseureList.getItemCount(); i++) {
								if(alleRegisseureList.isItemSelected(i) == true) {
									Regisseur regisseur = new Regisseur();
									regisseur.setId(Integer.parseInt(alleRegisseureList.getValue(i)));
									regisseur.setRegisseur(alleRegisseureList.getItemText(i));
									alleRegisseure.add(regisseur);
								}
							}
							
							dvdVerwaltung.updateRegisseurBelegung(alleRegisseure, dvd, new AsyncCallback<Vector<Regisseur>>() {

								@Override
								public void onFailure(Throwable caught) {}

								@Override
								public void onSuccess(Vector<Regisseur> result) {
									Vector<Schauspieler> alleSchauspieler = new Vector<Schauspieler>();
									for (int i = 0; i < alleSchauspielerList.getItemCount(); i++) {
										if(alleSchauspielerList.isItemSelected(i) == true) {
											Schauspieler schauspieler = new Schauspieler();
											schauspieler.setId(Integer.parseInt(alleSchauspielerList.getValue(i)));
											alleSchauspieler.add(schauspieler);
										}
									}
									
									dvdVerwaltung.updateSchauspielerBelegung(alleSchauspieler, dvd, new AsyncCallback<Vector<Schauspieler>> () {

										@Override
										public void onFailure(Throwable caught) {	}

										@Override
										public void onSuccess(Vector<Schauspieler> result) {
											Vector<Sprache> alleSprachen = new Vector<Sprache>();
											Vector<Sprache> alleUntertitel = new Vector<Sprache>();
											for (int i = 0; i < alleSprachenList.getItemCount(); i++) {
												if(alleSprachenList.isItemSelected(i) == true) {
													Sprache sprache = new Sprache();
													sprache.setId(Integer.parseInt(alleSprachenList.getValue(i)));
													sprache.setSprache(alleSprachenList.getItemText(i));
													alleSprachen.add(sprache);
												}
											}
											
											for (int i = 0; i < alleUntertitelList.getItemCount(); i++) {
												if(alleUntertitelList.isItemSelected(i) == true) {
													Sprache untertitel = new Sprache();
													untertitel.setId(Integer.parseInt(alleUntertitelList.getValue(i)));
													untertitel.setSprache(alleUntertitelList.getItemText(i));
													alleUntertitel.add(untertitel);
												}
											}
											
											dvdVerwaltung.updateSprachenBelegung(alleSprachen, alleUntertitel, dvd, new AsyncCallback<Vector<Sprache>> () {

												@Override
												public void onFailure(Throwable caught) {	}

												@Override
												public void onSuccess(Vector<Sprache> result) {
													Vector<Studio> alleStudios = new Vector<Studio>();
													for (int i = 0; i < alleStudiosList.getItemCount(); i++) {
														if(alleStudiosList.isItemSelected(i) == true) {
															Studio studio = new Studio();
															studio.setId(Integer.parseInt(alleStudiosList.getValue(i)));
															studio.setName(alleStudiosList.getItemText(i));
															alleStudios.add(studio);
														}
													}
													
													dvdVerwaltung.updateStudioBelegung(alleStudios, dvd, new AsyncCallback<Vector<Studio>>() {

														@Override
														public void onFailure(Throwable caught) {	}

														@Override
														public void onSuccess(Vector<Studio> result) {
															BasicFrame weiter = new DVDAnzeigen(dvd);
														      RootPanel.get("Details").clear();
														      RootPanel.get("Details").add(weiter);
														}
														
													});
												}
												
											});
										}
										
									});
								}
								
							});
						}
						
					});
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
				alleGenreOfDVDList.addItem(result.elementAt(i).getGenre(), Integer.toString(result.elementAt(i).getId()));
				
//				Window.alert(result.elementAt(i).getGenre());
			}
			alleGenre = result;
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
				alleRegisseureOfDVDList.addItem(result.elementAt(i).getRegisseur(), Integer.toString(result.elementAt(i).getId()));
			}
			alleRegisseure = result;
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
				alleSchauspielerOfDVDList.addItem(schausp, Integer.toString(result.elementAt(i).getId()));		
			}
			alleSchauspieler = result;
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
				alleSprachenOfDVDList.addItem(result.elementAt(i).getSprache(), Integer.toString(result.elementAt(i).getId()));		
			}
			alleSprachen = result;
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
				alleUntertitelOfDVDList.addItem(result.elementAt(i).getSprache(), Integer.toString(result.elementAt(i).getId()));
			}
			alleUntertitel = result;
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
				alleStudiosOfDVDList.addItem(result.elementAt(i).getName(), Integer.toString(result.elementAt(i).getId()));
			}
			alleStudios = result;
			anzeigen(dvd);
		}
	}
}
