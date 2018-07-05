package dvd.verwaltung.client;

import java.util.Vector;

import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;
import com.google.gwt.view.client.SelectionChangeEvent;


import dvd.verwaltung.shared.DVDVerwaltungAdministrationAsync;
import dvd.verwaltung.shared.bo.DVD;

public class DVDAnzeigenmitDataGridTest {

	DVDVerwaltungAdministrationAsync dvdVerwaltung = ClientsideSettings.getDVDVerwaltung();
	
	private FlowPanel fPanel = new FlowPanel();
	private Vector<DVD> dvdListe;
	private DVD selected = null;
	DataGrid<DVD> table = new DataGrid<DVD>();

	public DVDAnzeigenmitDataGridTest(Vector<DVD> list) {
		dvdListe = list;
	}
	
	public Vector<DVD> getDVDListe() {
		return dvdListe;
	}
	
	public void setDVDListe(Vector<DVD> dvdListe) {
		this.dvdListe = dvdListe;
	}
	
	public DataGrid<DVD> getTable() {
		return table;
	}
	
	public void setTable(DataGrid<DVD> table) {
		this.table = table;
	}
	
	public FlowPanel start() {
		fPanel.setStyleName("content");
		table.setStyleName("table");
				
		TextColumn<DVD> titel = new TextColumn<DVD>() {

			@Override
			public String getValue(DVD dvd) {
				return dvd.getTitel();
			}
		};
		table.addColumn(titel, "Titel");

		TextColumn<DVD> stichwort = new TextColumn<DVD>() {

			@Override
			public String getValue(DVD dvd) {
				return dvd.getStichwort();
			}
		};
		table.addColumn(stichwort, "Stichwort");
		
		TextColumn<DVD> prodjahr = new TextColumn<DVD>() {

			@Override
			public String getValue(DVD dvd) {
				return Integer.toString(dvd.getProduktionsjahr());
			}
		};
		table.addColumn(prodjahr, "Produktionsjahr");
		
		TextColumn<DVD> erschjahr = new TextColumn<DVD>() {

			@Override
			public String getValue(DVD dvd) {
				return Integer.toString(dvd.getErscheinungsjahr());
			}
		};
		table.addColumn(erschjahr, "Erscheinungsjahr");
		
		TextColumn<DVD> laenge = new TextColumn<DVD>() {

			@Override
			public String getValue(DVD dvd) {
				return Integer.toString(dvd.getFilmlaenge());
			}
		};
		table.addColumn(laenge, "Filmlänge");
		
		TextColumn<DVD> fsk = new TextColumn<DVD>() {

			@Override
			public String getValue(DVD dvd) {
				return Integer.toString(dvd.getFSK());
			}
		};
		table.addColumn(fsk, "FSK");
		
		TextColumn<DVD> serieFilm = new TextColumn<DVD>() {

			@Override
			public String getValue(DVD dvd) {
				return dvd.getSerieFilm();
			}
		};
		table.addColumn(serieFilm, "Serie oder Spielfilm");
		
		TextColumn<DVD> anzahlDisc = new TextColumn<DVD>() {

			@Override
			public String getValue(DVD dvd) {
				return Integer.toString(dvd.getAnzahlDisc());
			}
		};
		table.addColumn(anzahlDisc, "Anzahl der Discs");
		
		TextColumn<DVD> artDVD = new TextColumn<DVD>() {

			@Override
			public String getValue(DVD dvd) {
				return dvd.getArtDVD();
			}
		};
		table.addColumn(artDVD, "Art der DVD");
		
		TextColumn<DVD> beschreibung = new TextColumn<DVD>() {

			@Override
			public String getValue(DVD dvd) {
				return dvd.getBeschreibung();
			}
		};
		table.addColumn(beschreibung, "Beschreibung");
		
		table.setRowCount(dvdListe.size(), false);
		table.setWidth("80%");
		table.setVisibleRange(0, dvdListe.size());
		
		LayoutPanel panel = new LayoutPanel();
		panel.setSize("50em", "40em");
		panel.add(table);
		fPanel.add(panel);
		return fPanel;
	}
	
	
	public void addDetailsClickHandler() {
		final SingleSelectionModel<DVD> selectionModel = new SingleSelectionModel<DVD>();
		table.setSelectionModel(selectionModel);
		
		selectionModel.addSelectionChangeHandler(new SelectionChangeHandler(selectionModel));
		
	}
	
	private class SelectionChangeHandler implements Handler {
		private final SingleSelectionModel<DVD> selectionModel;
		
		private SelectionChangeHandler(SingleSelectionModel<DVD> selectionModel) {
			this.selectionModel = selectionModel;
		}
		
		@Override
		public void onSelectionChange(SelectionChangeEvent event) {
			selected = selectionModel.getSelectedObject();
			
			DVDAnzeigen anzeigen = new DVDAnzeigen(selected);
			RootPanel.get("Details").clear();
			RootPanel.get("Details").add(anzeigen);
		}
	}
}
