package dvd.verwaltung.client.gui;

import java.util.Vector;

import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent.Handler;

import dvd.verwaltung.client.BasicFrame;
import dvd.verwaltung.client.ClientsideSettings;
import dvd.verwaltung.client.DVDAnzeigen;
import dvd.verwaltung.client.Navbar;
import dvd.verwaltung.shared.DVDVerwaltungAdministrationAsync;
import dvd.verwaltung.shared.bo.DVD;

public class DataGridDVD {

	DVDVerwaltungAdministrationAsync dvdVerwaltung = ClientsideSettings.getDVDVerwaltung();
	
	public DataGrid<DVD> table = new DataGrid<DVD>();
	private Vector<DVD> dvdListe;
	private FlowPanel flowPanel = new FlowPanel();
	private DVD selected = null;

	
	public DataGridDVD (Vector<DVD> list) {
		dvdListe = list;
	}
	
	public Vector<DVD> getDVDListe() {
		return dvdListe;
	}
	
	public void setProfilListe(Vector<DVD> dvdListe) {
		this.dvdListe = dvdListe;
	}
	
	public DataGrid<DVD> getTable() {
		return table;
	}
	
	public void setTable(DataGrid<DVD> table) {
		this.table = table;
	}
	
	public FlowPanel start() {
		flowPanel.setStyleName("content");
		
		TextColumn<DVD> titel = new TextColumn<DVD>() {
			@Override
			public String getValue(DVD dvd) {
				return dvd.getTitel();
			}
		};
		table.addColumn(titel, "Titel");
		
		TextColumn<DVD> pjahr = new TextColumn<DVD>() {
			@Override
			public String getValue(DVD dvd) {
				return String.valueOf(dvd.getProduktionsjahr());
			}
		};
		table.addColumn(pjahr, "Produktionsjahr");
		
		TextColumn<DVD> ejahr = new TextColumn<DVD>() {
			@Override
			public String getValue(DVD dvd) {
				return String.valueOf(dvd.getErscheinungsjahr());
			}
		};
		table.addColumn(ejahr, "Erscheinungsjahr");
		
		TextColumn<DVD> laenge = new TextColumn<DVD>() {
			@Override
			public String getValue (DVD dvd) {
				return String.valueOf(dvd.getFilmlaenge());
			}
		};
		table.addColumn(laenge, "Filmlänge");
		
		TextColumn<DVD> fsk = new TextColumn<DVD>() {
			@Override
			public String getValue(DVD dvd) {
				return String.valueOf(dvd.getFSK());
			}
		};
		table.addColumn(fsk, "FSK-Angabe");
		
		TextColumn<DVD> stichwort = new TextColumn<DVD>() {
			@Override
			public String getValue(DVD dvd) {
				return dvd.getStichwort();
			}
		};
		table.addColumn(stichwort, "Stichwort");
		
		TextColumn<DVD> art = new TextColumn<DVD>() {
			@Override
			public String getValue (DVD dvd) {
				return dvd.getArtDVD();
			}
		};
		table.addColumn(art, "Art der DVD");
		
		TextColumn<DVD> sF = new TextColumn<DVD>() {
			@Override
			public String getValue (DVD dvd) {
				return dvd.getSerieFilm();
			}
		};
		table.addColumn(sF, "Serie oder Film?");
		
		TextColumn<DVD> discs = new TextColumn<DVD>() {
			@Override
			public String getValue(DVD dvd) {
				return String.valueOf(dvd.getAnzahlDisc());
			}
		};
		table.addColumn(discs, "Anzahl der Disc");
		
		table.setRowCount(dvdListe.size(), false);
		table.setWidth("100%");
		table.setVisibleRange(0, dvdListe.size());
		table.setRowData(0, dvdListe);
		
		LayoutPanel panel = new LayoutPanel();
		panel.setSize("1450px", "420px");
		panel.add(table);
		flowPanel.add(panel);
		
		return flowPanel;
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
	      
	      Navbar navbar = new Navbar();
	      BasicFrame anzeigen = new DVDAnzeigen(selected);
	      RootPanel.get("Details").clear();
	      RootPanel.get("Navigator").add(navbar);
	      RootPanel.get("Details").add(anzeigen);
	      
	    }
	}
}
