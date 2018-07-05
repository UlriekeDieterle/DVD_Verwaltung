package dvd.verwaltung.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import dvd.verwaltung.shared.DVDVerwaltungAdministrationAsync;

public class Navbar extends VerticalPanel {

	DVDVerwaltungAdministrationAsync dvdVerwaltung = ClientsideSettings.getDVDVerwaltung();
	
	//Panel einfügen; statt Popuppanel?
	
	@Override
	protected void onLoad() {
		RootPanel.get("Details").getElement().getStyle().setBackgroundColor("#BEF781"); /* hellgrün*/
		
		FlowPanel menu = new FlowPanel();
		
		menu.setStyleName("menuList");
		
		final Button alleDVDAnzeigen = new Button ("Alle DVDs anzeigen");
		final Button dvdHinzufuegen = new Button("Neue DVD hinzufügen");
		final Button dvdSuchen = new Button("DVD suchen");
		
		alleDVDAnzeigen.setStyleName("menubutton");
		menu.add(alleDVDAnzeigen);
		
		dvdHinzufuegen.setStyleName("menubutton");
		menu.add(dvdHinzufuegen);
		
		dvdSuchen.setStyleName("menubutton");
		menu.add(dvdSuchen);
		
		//menu.add(menuList);
		
		RootPanel.get("Navigator").add(menu);
		
		dvdHinzufuegen.addClickHandler(new DVDHinzufuegenClickHandler());
		dvdSuchen.addClickHandler(new DVDSuchenClickHandler());
		alleDVDAnzeigen.addClickHandler(new AlleDVDAnzeigenClickHandler());
		
	}
	
	private class DVDHinzufuegenClickHandler implements ClickHandler {
		
		@Override
		public void onClick(ClickEvent event) {			
			DVDHinzufuegen neu = new DVDHinzufuegen();
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(neu);			
		}
	}
	
	private class DVDSuchenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			DVDSuchen suche = new DVDSuchen();
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(suche);
		}
	}
	
	private class AlleDVDAnzeigenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			AlleDVDAnzeigen anzeige = new AlleDVDAnzeigen();
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(anzeige);
		}
	}
}
