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
    
    RadioButton serieFilm = new RadioButton("Serie oder Spielfilm", "Serie");
    RadioButton serieFilm2 = new RadioButton("Serie oder Spielfilm", "Spielfilm");
    RadioButton artDVD1 = new RadioButton("Art der DVD", "Extended Edition");
    RadioButton artDVD2 = new RadioButton("Art der DVD", "Blu-Ray");
    RadioButton artDVD3 = new RadioButton("Art der DVD", "Standard Version");
    RadioButton artDVD4 = new RadioButton("Art der DVD", "Limited Edition");
    RadioButton artDVD5 = new RadioButton("Art der DVD", "Special Edition");
    RadioButton artDVD6 = new RadioButton("Art der DVD", "UK Import");
    RadioButton artDVD7 = new RadioButton("Art der DVD", "USA Import");
    RadioButton artDVD8 = new RadioButton("Art der DVD", "HD DVD");
    RadioButton artDVD9 = new RadioButton("Art der DVD", "Steelbook");
    RadioButton artDVD10 = new RadioButton("Art der DVD", "FR Import");
    
    
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
			createDVD();
			
		}
	}

	private void createDVD() {
		String titel = this.titel.getText();
		String filmSerie = "tbd";
		String artDVD = "tbd";
		
		int fsk = -1;
		
		if (!titel.isEmpty()) {
			dvdVerwaltung.createDVD(this.titel.getText(), fsk, 
					Integer.parseInt(this.prodjahr.getText()),
					Integer.parseInt(this.erschjahr.getText()), 
					this.beschreibung.getText(), 
					Integer.parseInt(this.laenge.getText()), 
					this.stichwort.getText(), 
					Integer.parseInt(this.anzahlDisc.getText()), 
					artDVD, filmSerie, new CreateDVDCallback());
		}
		
	}
	
	class CreateDVDCallback implements AsyncCallback<DVD> {

		@Override
		public void onFailure(Throwable caught) {
			ClientsideSettings.getLogger().severe("DVD konnte nicht hinzugefügt werden.");
		}

		@Override
		public void onSuccess(DVD result) {
			ClientsideSettings.getLogger().severe("DVD wurde hinzugefügt.");
			
			DVDAnzeigen anzeigen = new DVDAnzeigen();
			Navbar nb = new Navbar();
			RootPanel.get("Details").clear();
			RootPanel.get("Navigator").add(nb);
			RootPanel.get("Details").add(anzeigen);
		}
		
	}

}
