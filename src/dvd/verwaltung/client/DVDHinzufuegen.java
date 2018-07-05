package dvd.verwaltung.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import dvd.verwaltung.shared.DVDVerwaltungAdministrationAsync;
import dvd.verwaltung.shared.bo.DVD;

public class DVDHinzufuegen extends BasicFrame{

	DVDVerwaltungAdministrationAsync dvdVerwaltung = ClientsideSettings.getDVDVerwaltung();
	
	VerticalPanel vpanel = new VerticalPanel();
	FlexTable flextable = new FlexTable();
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
    
    
    TextBox beschreibung = new TextBox();
    TextBox anzahlDisc = new TextBox();
    TextBox stichwort = new TextBox();  
    TextBox titel = new TextBox();
    TextBox prodjahr = new TextBox();
    TextBox erschjahr = new TextBox();
    TextBox laenge = new TextBox();
    
    Button confirmBtn = new Button("Weiter");
	
	@SuppressWarnings("deprecation")
	@Override
	protected void run() {
		flextable.setStyleName("table");
		vpanel.setStyleName("panel");
		confirmBtn.setStyleName("button");
		confirmBtn.addClickHandler(new ConfirmClickHandler());
				
	    fsk0.setChecked(true);
	    serieFilm.setChecked(true);
	    
	    flextable.setText(0, 0, "Titel der DVD");
	    flextable.setWidget(0, 1, titel);
	    flextable.setText(1, 0, "Stichwort");
	    flextable.setWidget(1, 1, stichwort);
	    flextable.setText(2, 0, "Produktionsjahr");
	    flextable.setWidget(2, 1, prodjahr);
	    flextable.setText(3, 0, "Erscheinungsjahr");
	    flextable.setWidget(3, 1, erschjahr);
	    flextable.setText(4, 0, "Filmlänge");
	    flextable.setWidget(4, 1, laenge);
	    flextable.setText(5, 0, "Freigegeben ab Jahren");
	    flextable.setWidget(5, 1, fsk0);
	    flextable.setWidget(5, 2, fsk6);
	    flextable.setWidget(5, 3, fsk12);
	    flextable.setWidget(5, 4, fsk16);
	    flextable.setWidget(5, 5, fsk18);
	    flextable.setText(6, 0, "Serie oder Spielfilm");
	    flextable.setWidget(6, 1, serieFilm);
	    flextable.setWidget(6, 2, serieFilm2);
	    flextable.setText(7, 0, "Anzahl der Discs");
	    flextable.setWidget(7, 1, anzahlDisc);
	    flextable.setText(8, 0, "Art der DVD");
	    flextable.setWidget(8, 1, artDVD1);
	    flextable.setWidget(8, 2, artDVD2);
	    flextable.setWidget(8, 3, artDVD3);
	    flextable.setWidget(8, 4, artDVD4);
	    flextable.setWidget(8, 5, artDVD5);
	    flextable.setWidget(8, 6, artDVD6);
	    flextable.setWidget(8, 7, artDVD7);
	    flextable.setWidget(8, 8, artDVD8);
	    flextable.setWidget(8, 9, artDVD9);
	    flextable.setWidget(8, 10, artDVD10);
	    flextable.setText(9, 0, "Beschreibung");
	    flextable.setWidget(9, 1, beschreibung);

	    vpanel.add(flextable);
	    vpanel.add(confirmBtn);
	    RootPanel.get("Details").add(vpanel);

	}

	@Override
	protected String getSubHeadlineText() {
		return "Lege eine neue DVD an";
	}

	@Override
	protected String getHeadlineText() {
		return null;
	}
	
	private class ConfirmClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			RootPanel.get("Header").getElement().setInnerHTML("onClick");
			createDVD();			
		}
	}

	private void createDVD() {
		String titel = this.titel.getText();
		int fsk = 1;
		int prodJahr = Integer.parseInt(this.prodjahr.getText());
		int erschJahr = Integer.parseInt(this.erschjahr.getText());
		String beschreibung = this.beschreibung.getText();
		int filmLaenge = Integer.parseInt(this.laenge.getText());
		String stichwort = this.stichwort.getText();
		int anzahlDisc = Integer.parseInt(this.anzahlDisc.getText());
		String artDvd = null;
		String filmSerie = null;	
		
		if(fsk0.getValue() == true) {
			fsk = 0;	
		} else if (fsk6.getValue() == true) {
			fsk = 6;
		} else if (fsk12.getValue() == true) {
			fsk = 12;
		} else if (fsk16.getValue() == true) {
			fsk = 16;
		} else if (fsk18.getValue() == true) {
			fsk = 18;
		}
		
		if(serieFilm.getValue() == true) {
			filmSerie = "Serie";
		} else if (serieFilm.getValue() == true) {
			filmSerie = "Spielfilm";
		}
		
		if(artDVD1.getValue() == true) {
			artDvd = "Extended Edition";
		} else if (artDVD2.getValue() == true) {
			artDvd = "Blu-Ray";
		} else if (artDVD3.getValue() == true) {
			artDvd = "Standard Version";
		} else if (artDVD4.getValue() == true) {
			artDvd = "Limited Edition";
		} else if (artDVD5.getValue() == true) {
			artDvd = "Special Edition";
		} else if (artDVD6.getValue() == true) {
			artDvd = "UK Import";
		} else if (artDVD7.getValue() == true) {
			artDvd = "USA Import";
		} else if (artDVD8.getValue() == true) {
			artDvd = "HD DVD";
		} else if (artDVD9.getValue() == true) {
			artDvd = "Steelbook";
		} else if (artDVD10.getValue() == true) {
			artDvd = "FR Import";
		}
		
		if (!titel.isEmpty()) {
			dvdVerwaltung.createDVD(titel,
					fsk, 
					prodJahr,
					erschJahr,
					beschreibung,
					filmLaenge,
					stichwort,
					anzahlDisc,
					artDvd,
					filmSerie,
					new CreateDVDCallback());
		}
		
	}
	
	class CreateDVDCallback implements AsyncCallback<DVD> {

		@Override
		public void onFailure(Throwable caught) {
//			ClientsideSettings.getLogger().severe("DVD konnte nicht hinzugefügt werden.");
		}

		@Override
		public void onSuccess(DVD result) {
//			ClientsideSettings.getLogger().severe("DVD wurde hinzugefügt.");
//			
//			AlleDVDAnzeigen anzeigen = new AlleDVDAnzeigen();
//			Navbar nb = new Navbar();
//			RootPanel.get("Details").clear();
//			RootPanel.get("Navigator").add(nb);
//			RootPanel.get("Details").add(anzeigen);
		}
		
	}

}
