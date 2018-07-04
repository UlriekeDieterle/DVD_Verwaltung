package dvd.verwaltung.client;

import dvd.verwaltung.shared.DVDVerwaltungAdministrationAsync;
import dvd.verwaltung.shared.bo.DVD;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.HTML;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class DVD_Projekt implements EntryPoint {
		
	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	
	//Konstruktor!
	public DVD_Projekt() {	
	}

	@Override
	public void onModuleLoad() {
		DVD dvd = new DVD();
//		
		DVDVerwaltungAdministrationAsync dvdVerwaltung = ClientsideSettings.getDVDVerwaltung();
//
//		dvdVerwaltung.setDVD(dvd, new SetDVDCallback());
//		
		HorizontalPanel navPanel = new HorizontalPanel();
		//navPanel.setStylePrimaryName("horizontalPanel");
//		
//		Label test = new Label("Test2");
//		navPanel.add(test);
		
		final Button dvdAnzeigen = new Button("Alle DVDs anzeigen");
		dvdAnzeigen.setStylePrimaryName("menubutton");
		navPanel.add(dvdAnzeigen);
		
		dvdAnzeigen.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				BasicFrame bf = new DVDAnzeigen();
				Navbar nb = new Navbar();
				RootPanel.get("Details").clear();
				RootPanel.get("Navigator").add(nb);
				RootPanel.get("Details").add(bf);
			}
		});
		
		final Button dvdHinzufuegen = new Button ("Neue DVD hinzufügen");
		dvdHinzufuegen.setStylePrimaryName("menubutton");
		navPanel.add(dvdHinzufuegen);
		
		dvdHinzufuegen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				BasicFrame bf = new DVDHinzufuegen();
				Navbar nb = new Navbar();
				RootPanel.get("Details").clear();
				RootPanel.get("Navigator").add(nb);
				RootPanel.get("Details").add(bf);
			}
		});
		
		final Button dvdSuchen = new Button("DVD suchen");
		dvdSuchen.setStylePrimaryName("menubutton");
		navPanel.add(dvdSuchen);
		
		dvdSuchen.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Navbar nb = new Navbar();
				RootPanel.get("Details").clear();
				RootPanel.get("Navigator").add(nb);
				
				BasicFrame bf = new DVDSuchen();
				RootPanel.get("Details").add(bf);
			}
		});
		
		RootPanel.get("Details").add(navPanel);
//		HTML test2 = new HTML("<p> irgendwas </p>");
//		RootPanel.get("Navigator").add(test2);
	}
	
	
	class SetDVDCallback implements AsyncCallback<Void> {

		@Override
		public void onFailure(Throwable caught) {
			ClientsideSettings.getLogger().severe("Starten der Anwendung fehlgeschlagen!");
		}

		@Override
		public void onSuccess(Void result) {
		}
		
	}
	
}
