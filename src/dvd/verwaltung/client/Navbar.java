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
		//UnorderedListWidget menuList = new UnorderedListWidget();
		
		//menuList.setStyleName("menuList");
		menu.setStyleName("menuList");
		
		final Button dvdAnzeigen = new Button ("Alle DVDs anzeigen");
		final Button dvdHinzufuegen = new Button("Neue DVD hinzufügen");
		final Button dvdSuchen = new Button("DVD suchen");
		
		dvdAnzeigen.setStyleName("menubutton");
		menu.add(dvdAnzeigen);
		
		dvdHinzufuegen.setStyleName("menubutton");
		menu.add(dvdHinzufuegen);
		
		dvdSuchen.setStyleName("menubutton");
		menu.add(dvdSuchen);
		
		//menu.add(menuList);
		
		RootPanel.get("Navigator").add(menu);
		
		dvdHinzufuegen.addClickHandler(new DVDHinzufuegenClickHandler());
		dvdSuchen.addClickHandler(new DVDSuchenClickHandler());
		dvdAnzeigen.addClickHandler(new DVDAnzeigenClickHandler());
		
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
	
	private class DVDAnzeigenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			DVDAnzeigen anzeige = new DVDAnzeigen();
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(anzeige);
		}
	}
}
