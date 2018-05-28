package dvd.verwaltung.client;

import dvd.verwaltung.shared.DVDVerwaltungAdministration;
import dvd.verwaltung.shared.DVDVerwaltungAdministrationAsync;
import dvd.verwaltung.shared.FieldVerifier;
import dvd.verwaltung.shared.bo.DVD;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ParagraphElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class DVD_Projekt implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final DVDVerwaltungAdministrationAsync dvdVerwaltung = ClientsideSettings.getDVDVerwaltung();

	@Override
	public void onModuleLoad() {
		dvdVerwaltung.login(GWT.getHostPageBaseURL() + "DVD_Projekt.html", new LoginCallback());
		
	}
	
	class LoginCallback implements AsyncCallback<DVD> {
		  
		@Override
		public void onFailure(Throwable caught) {
			ClientsideSettings.getLogger().severe("Starten der Anwendung fehlgeschlagen.");
		}
		
		@Override
		public void onSuccess (DVD empty) {
			createStartScreen(empty);
		}

	}
	
	private void createStartScreen(DVD empty) {
		FlowPanel splashContainer = new FlowPanel();
		splashContainer.setStyleName("splash-container");
		
		FlowPanel splash = new FlowPanel();
		splash.setStyleName("splash");
		
		HTML headingElement = new HTML();
		headingElement.setHTML("Willkommen auf der DVD Verwaltung");
		headingElement.setStyleName("splash-head");
		
		FlowPanel splashSubhead = new FlowPanel(ParagraphElement.TAG);
		splashSubhead.setStyleName("splash-subhead");
		HTML splashParagraph = new HTML ("Was möchtest du tun?");
		splashSubhead.add(splashParagraph);
		
		Anchor dvdSuchenAnchor  = new Anchor ("DVD suchen und anzeigen");
		dvdSuchenAnchor.setStyleName("dvdSuchen");
		dvdSuchenAnchor.setHref(empty.getLogin());
		
		Anchor dvdAnlegenAnchor = new Anchor ("neue DVD hinzufügen");
		dvdAnlegenAnchor.setStyleName("dvdAnlegen");
		
		splash.add(headingElement);
		splash.add(splashSubhead);
		splash.add(dvdSuchenAnchor);
		splash.add(dvdAnlegenAnchor);
		
		splashContainer.add(splash);
		RootPanel.get("main").add(splashContainer);
	}
	
	private void dvdSuchen() {
		Navbar nb = new Navbar();
		RootPanel.get("searchmenu").clear();
		RootPanel.get("searchmenu").add(nb);
	}
	
	private void dvdAnlegen() {
		BasicFrame cf = new DVDSuchen();
		RootPanel.get("main").clear();
		RootPanel.get("main").add(cf);
	}
}
