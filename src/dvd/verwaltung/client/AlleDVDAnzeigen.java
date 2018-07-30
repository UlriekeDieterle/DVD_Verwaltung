package dvd.verwaltung.client;

import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;

import dvd.verwaltung.client.gui.DataGridDVD;
import dvd.verwaltung.shared.DVDVerwaltungAdministrationAsync;
import dvd.verwaltung.shared.bo.DVD;

public class AlleDVDAnzeigen extends BasicFrame {

	private Vector<DVD> dvdListe = new Vector<DVD>();
//	PopupPanel pop = new PopupPanel(false, true);
	DVDVerwaltungAdministrationAsync dvdVerwaltung = ClientsideSettings.getDVDVerwaltung();

	DVD dvd = null;

	public AlleDVDAnzeigen (Vector<DVD> list) {
		dvdListe = list;
	}

	public AlleDVDAnzeigen() {}

	public Vector<DVD> getDVDListe() {
		return dvdListe;
	}
	
	public void setDVDListe (Vector<DVD> dvdListe) {
		this.dvdListe = dvdListe;
	}

	@Override
	protected String getSubHeadlineText() {
		return "Hier werden alle DVDs angezeigt";
	}

	@Override
	protected String getHeadlineText() {
		return "Alle DVDs";
	}
	
	Button alleDVDsAnzeigen = new Button("alle DVDs anzeigen");
	
	FlowPanel contentPanel = new FlowPanel();
	FlowPanel fPanel2 = new FlowPanel();
		FlowPanel buttonPanel = new FlowPanel();
				
	@Override
	protected void run() {

		buttonPanel.add(alleDVDsAnzeigen);
		contentPanel.add(buttonPanel);
		fPanel2.add(contentPanel);
		
		
//		dgdvd.addDetailsClickHandler();
		RootPanel.get("Details").clear();
		RootPanel.get("Details").add(contentPanel);
//		RootPanel.get("Details").add(dgdvd.start());
		
		alleDVDsAnzeigen.addClickHandler(new AlleDVDsAnzeigenClickHandler());
		
	}
	
	private class AlleDVDsAnzeigenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			dvdVerwaltung.getAllDVDs(new AllDVDsCallback());
		}
	}
	
	private class AllDVDsCallback implements AsyncCallback<Vector<DVD>> {

		@Override
		public void onFailure(Throwable caught) {
			
		}

		@Override
		public void onSuccess(Vector<DVD> result) {
			addDVDsToTable(result);
		}	
	}
	
	private void addDVDsToTable(Vector<DVD> result) {
		dvdListe = result;
		DataGridDVD dgd = new DataGridDVD(dvdListe);

//		dgd.addDetailsClickHandler();
		RootPanel.get("Details").clear();
		RootPanel.get("Details").add(dgd.start());
	}
}

