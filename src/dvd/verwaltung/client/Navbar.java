package dvd.verwaltung.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import dvd.verwaltung.client.gui.ListItemWidget;
import dvd.verwaltung.client.gui.UnorderedListWidget;
import dvd.verwaltung.shared.DVDVerwaltungAdministrationAsync;

public class Navbar extends VerticalPanel {

	DVDVerwaltungAdministrationAsync dvdVerwaltung = ClientsideSettings.getDVDVerwaltung();
	
	//Panel einfügen; statt Popuppanel?
	
	@Override
	protected void onLoad() {
		RootPanel.get("menu").getElement().getStyle().setBackgroundColor("#58FAF4");
		
		FlowPanel menu = new FlowPanel();
		UnorderedListWidget menuList = new UnorderedListWidget();
		
		menuList.setStyleName("menuList");
		menu.setStyleName("menuList");
		
		Anchor dvdHinzufuegen = new Anchor("DVD hinzufügen");
		Anchor dvdSuchen = new Anchor("DVD suchen");
		
		dvdHinzufuegen.setStyleName("anchor_Style");
		dvdHinzufuegen.add(new ListItemWidget (dvdHinzufuegen));
		
		dvdSuchen.setStyleName("anchor_Style");
		dvdSuchen.add(new ListItemWidget(dvdSuchen));
		
		menu.add(menuList);
		
		RootPanel.get("menu").add(menu);
		
		dvdHinzufuegen.addClickHandler(new DVDHinzufuegenClickHandler());
		dvdSuchen.addClickHandler(new DVDSuchenClickHandler());
		
	}
	
	private class DVDHinzufuegenClickHandler implements ClickHandler {
		
		@Override
		public void onClick(ClickEvent event) {
			DVDHinzufuegen neu = new DVDHinzufuegen();
			RootPanel.get("main").clear();
			RootPanel.get("main").add(neu);			
		}
	}
	
	private class DVDSuchenClickHandler implements ClickHandler {

		@Override
		public void onClick(ClickEvent event) {
			DVDSuchen suche = new DVDSuchen();
			RootPanel.get("main").clear();
			RootPanel.get("main").add(suche);
		}
		
	}
}
