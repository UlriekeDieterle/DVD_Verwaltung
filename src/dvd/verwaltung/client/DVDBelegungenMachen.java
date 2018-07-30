package dvd.verwaltung.client;

import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import dvd.verwaltung.shared.DVDVerwaltungAdministrationAsync;
import dvd.verwaltung.shared.bo.*;

public class DVDBelegungenMachen extends BasicFrame{

	DVDVerwaltungAdministrationAsync dvdVerwaltung = ClientsideSettings.getDVDVerwaltung();

	 FlexTable belegungen = new FlexTable();
	 ListBox genreLB = new ListBox();
		ListBox regisseurLB = new ListBox();
		ListBox schauspielerLB = new ListBox();
		ListBox spracheLB = new ListBox();
		ListBox untertitelLB = new ListBox();
		ListBox studioLB = new ListBox();
			
		Vector<Sprache> untertitelVec = new Vector<Sprache>();
		TextBox tbReg = new TextBox();
		TextBox tbSpVorname = new TextBox();
		TextBox tbSpNachname = new TextBox();
		TextBox tbSpGeburtsjahr = new TextBox();
		TextBox tbSpNationalitaet = new TextBox();
		TextBox tbStdName = new TextBox();
		TextBox tbStdSitz = new TextBox();
		
		 VerticalPanel neuerContent = new VerticalPanel();
		 HorizontalPanel horPanel = new HorizontalPanel();
		VerticalPanel vpanel = new VerticalPanel();		
		DVD dvd = new DVD();
		
	
	public DVDBelegungenMachen(DVD result) {
		dvd = result;
		}

	@Override
	protected void run() {
//		Window.alert(Integer.toString(dvd.getId()));
		dvdVerwaltung.getAllGenre(new GenreCallback());
	
	}

	@Override
	protected String getSubHeadlineText() {
		return null;
	}

	@Override
	protected String getHeadlineText() {
		return null;
	}


class GenreCallback implements AsyncCallback<Vector<Genre>> {

		@Override
		public void onFailure(Throwable caught) {
		}

		@Override
		public void onSuccess(Vector<Genre> result) {
			RootPanel.get("Details").clear();
			Button weiter = new Button("Weiter");
			genreLB.setVisibleItemCount(10);
			genreLB.setMultipleSelect(true);

			for(int i = 0; i < result.size(); i++ ) {
				genreLB.addItem(result.elementAt(i).getGenre(), Integer.toString(result.elementAt(i).getId()));
			}

			belegungen.setText(0, 0, "Genre");
			belegungen.setWidget(1, 0, genreLB);
			belegungen.setWidget(2, 1, weiter);
			vpanel.add(belegungen);
			RootPanel.get("Details").add(vpanel);
			
			weiter.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					Vector<Genre> genreVec = new Vector<Genre>();

//					Window.alert(Integer.toString(genreLB.getItemCount()));
					for (int i = 0; i < genreLB.getItemCount(); i++) {
//						Window.alert(Integer.toString(genreLB.getItemCount()));

						if(genreLB.isItemSelected(i) == true) {
							Genre genre = new Genre();
							genre.setId(Integer.parseInt(genreLB.getValue(i)));
							genre.setGenre(genreLB.getItemText(i));
//							Window.alert(Integer.toString(genre.getId()) + genre.getGenre());
							genreVec.add(genre);
//							Window.alert("Selektierter Index: " + Integer.toString(i));
//							System.out.println(genreVec);
						}	
//						Window.alert("Jeder einzelne Index: " + Integer.toString(i));						
					}
					
	/*				for(int j = 0; j < genreVec.size(); j++) {
						Window.alert("Element in der Liste: " + Integer.toString(genreVec.elementAt(j).getId()) + " " + genreVec.elementAt(j).getGenre());
					}*/
						//	RootPanel.get("Details").clear();
						
					dvdVerwaltung.createGenreBelegung(genreVec, dvd, new AsyncCallback<Genre>(){
							@Override
							public void onSuccess(Genre result) {
							dvdVerwaltung.getAllRegisseur(new RegisseurCallback());
							}
									
							@Override
							public void onFailure(Throwable caught) {
							}
					});
					}
				});
	}
}
	
	class RegisseurCallback implements AsyncCallback<Vector<Regisseur>> {

		@Override
		public void onFailure(Throwable caught) {
		}

		@Override
		public void onSuccess(Vector<Regisseur> result) {
			RootPanel.get("Details").clear();
			Button weiter = new Button("Weiter");
			Button regisseurNeu = new Button("Neuen Regisseur hinzufügen");
			neuerContent.clear();
			regisseurLB.clear();
			regisseurLB.setVisibleItemCount(5);
			regisseurLB.setMultipleSelect(true);
				
			for(int i = 0; i < result.size(); i++ ) {
				regisseurLB.addItem(result.elementAt(i).getRegisseur(), Integer.toString(result.elementAt(i).getId()));
			}
			
			belegungen.clear();
			belegungen.setText(0, 0, "Regisseur");
			belegungen.setWidget(1, 0, regisseurLB);
			belegungen.setWidget(2, 1, regisseurNeu);
			belegungen.setWidget(4, 1, weiter);
			vpanel.add(belegungen);
			horPanel.add(vpanel);
			
			RootPanel.get("Details").add(horPanel);
			
			regisseurNeu.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					
					Label labReg = new Label("Name des Regisseurs");
					Button hinzufuegen = new Button("Hinzufügen");
					
					neuerContent.add(labReg);
					neuerContent.add(tbReg);
					neuerContent.add(hinzufuegen);
					
					horPanel.add(neuerContent);
					
					hinzufuegen.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
					dvdVerwaltung.createRegisseur(tbReg.getText(), new AsyncCallback<Regisseur>() {

						@Override
						public void onFailure(Throwable caught) {}

						@Override
						public void onSuccess(Regisseur result) {
							
							dvdVerwaltung.getAllRegisseur(new RegisseurCallback());
						}
					});
					}
					});		
				}
			});
		
			weiter.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					Vector<Regisseur> regVec = new Vector<Regisseur>();

//					Window.alert(Integer.toString(genreLB.getItemCount()));
					for (int i = 0; i < regisseurLB.getItemCount(); i++) {
//						Window.alert(Integer.toString(genreLB.getItemCount()));

						if(regisseurLB.isItemSelected(i) == true) {
							Regisseur regisseur = new Regisseur();
							regisseur.setId(Integer.parseInt(regisseurLB.getValue(i)));
							regisseur.setRegisseur(regisseurLB.getItemText(i));
//							Window.alert(Integer.toString(genre.getId()) + genre.getGenre());
							regVec.add(regisseur);
//							Window.alert("Selektierter Index: " + Integer.toString(i));
//							System.out.println(genreVec);
						}	
//						Window.alert("Jeder einzelne Index: " + Integer.toString(i));						
					}
					
	/*				for(int j = 0; j < genreVec.size(); j++) {
						Window.alert("Element in der Liste: " + Integer.toString(genreVec.elementAt(j).getId()) + " " + genreVec.elementAt(j).getGenre());
					}*/
						//	RootPanel.get("Details").clear();
						
					dvdVerwaltung.createRegisseurBelegung(regVec, dvd, new AsyncCallback<Regisseur>(){
							@Override
							public void onSuccess(Regisseur result) {
							dvdVerwaltung.getAllSchauspieler(new SchauspielerCallback());
							}
									
							@Override
							public void onFailure(Throwable caught) {
							}
					});
					}
				});
		}
	}
	
	class SchauspielerCallback implements AsyncCallback<Vector<Schauspieler>> {

		@Override
		public void onFailure(Throwable caught) {
		}

		@Override
		public void onSuccess(Vector<Schauspieler> result) {
			String schausp = null;
			Button weiter = new Button("Weiter");
			Button schauspielerNeu = new Button("neuen Schauspieler hinzufügen");
			neuerContent.clear();
			schauspielerLB.clear();
			schauspielerLB.setVisibleItemCount(15);
			schauspielerLB.setMultipleSelect(true);
			
			for( int i = 0; i < result.size(); i++) {
				
				schausp = result.elementAt(i).getVorname() + " " + result.elementAt(i).getNachname();
				schauspielerLB.addItem(schausp, Integer.toString(result.elementAt(i).getId()));		
			}
			
			belegungen.clear();
			belegungen.setText(0, 0, "Schauspieler");
			belegungen.setWidget(1, 0, schauspielerLB);
			belegungen.setWidget(2, 1, schauspielerNeu);
			belegungen.setWidget(4, 1, weiter);
			RootPanel.get("Details").clear();
			vpanel.add(belegungen);
			horPanel.add(vpanel);
			
			RootPanel.get("Details").add(horPanel);
			
			
			schauspielerNeu.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					
					Label labVorname = new Label("Vorname");
					Label labNachname = new Label("Nachname");
					Label labGebjahr = new Label("Geburtsjahr");
					Label labNational = new Label("Nationalität");
					Button hinzufuegen = new Button("Hinzufügen");
					
					neuerContent.add(labVorname);
					neuerContent.add(tbSpVorname);
					neuerContent.add(labNachname);
					neuerContent.add(tbSpNachname);
					neuerContent.add(labGebjahr);
					neuerContent.add(tbSpGeburtsjahr);
					neuerContent.add(labNational);
					neuerContent.add(tbSpNationalitaet);
					neuerContent.add(hinzufuegen);
					
					horPanel.add(neuerContent);
					
					hinzufuegen.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
					dvdVerwaltung.createSchauspieler(tbSpVorname.getText(), tbSpNachname.getText(), Integer.parseInt(tbSpGeburtsjahr.getText()),tbSpNationalitaet.getText(), new AsyncCallback<Schauspieler>() {

						@Override
						public void onFailure(Throwable caught) {}

						@Override
						public void onSuccess(Schauspieler result) {
							dvdVerwaltung.getAllSchauspieler(new SchauspielerCallback());
						}
					});
					}
					});		
				}
			});
			
			weiter.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					Vector<Schauspieler> schauspVec = new Vector<Schauspieler>();

//					Window.alert(Integer.toString(genreLB.getItemCount()));
					for (int i = 0; i < schauspielerLB.getItemCount(); i++) {
//						Window.alert(Integer.toString(genreLB.getItemCount()));

						if(schauspielerLB.isItemSelected(i) == true) {
							Schauspieler schauspieler = new Schauspieler();
							schauspieler.setId(Integer.parseInt(schauspielerLB.getValue(i)));
//							Window.alert(Integer.toString(genre.getId()) + genre.getGenre());
							schauspVec.add(schauspieler);
//							Window.alert("Selektierter Index: " + Integer.toString(i));
//							System.out.println(genreVec);
						}	
//						Window.alert("Jeder einzelne Index: " + Integer.toString(i));						
					}
					
	/*				for(int j = 0; j < genreVec.size(); j++) {
						Window.alert("Element in der Liste: " + Integer.toString(genreVec.elementAt(j).getId()) + " " + genreVec.elementAt(j).getGenre());
					}*/
						//	RootPanel.get("Details").clear();
						
					dvdVerwaltung.createSchauspielerBelegung(schauspVec, dvd, new AsyncCallback<Schauspieler>(){
							@Override
							public void onSuccess(Schauspieler result) {
							dvdVerwaltung.getAllSprachen(new SpracheCallback());
							}
									
							@Override
							public void onFailure(Throwable caught) {
							}
					});
					}
				});
		}
	}
	
	class SpracheCallback implements AsyncCallback<Vector<Sprache>> {

		@Override
		public void onFailure(Throwable caught) {
			
		}

		@Override
		public void onSuccess(Vector<Sprache> result) {
			Button weiter = new Button("Weiter");
			spracheLB.setVisibleItemCount(10);
			spracheLB.setMultipleSelect(true);
			
			untertitelLB.setVisibleItemCount(10);
			untertitelLB.setMultipleSelect(true);
			
			for( int i = 0; i < result.size(); i++) {
				spracheLB.addItem(result.elementAt(i).getSprache(), Integer.toString(result.elementAt(i).getId()));		
			}
			
			for(int i = 0; i < result.size(); i++) {
				untertitelLB.addItem(result.elementAt(i).getSprache(), Integer.toString(result.elementAt(i).getId()));
			}
			
			belegungen.clear();
			belegungen.setText(0, 0, "gesprochene Sprachen");
			belegungen.setWidget(1, 0, spracheLB);
			belegungen.setText(4, 0, "Untertitel");
			belegungen.setWidget(5, 0, untertitelLB);
			belegungen.setWidget(6, 1, weiter);
			
			
			RootPanel.get("Details").clear();
			vpanel.add(belegungen);
			RootPanel.get("Details").add(vpanel);
			
			weiter.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					Vector<Sprache> spracheVec = new Vector<Sprache>();
					Vector<Sprache> untertitelVec = new Vector<Sprache>();

//					Window.alert(Integer.toString(genreLB.getItemCount()));
					for (int i = 0; i < spracheLB.getItemCount(); i++) {
//						Window.alert(Integer.toString(genreLB.getItemCount()));

						if(spracheLB.isItemSelected(i) == true) {
							Sprache sprache = new Sprache();
							sprache.setId(Integer.parseInt(spracheLB.getValue(i)));
							sprache.setSprache(spracheLB.getItemText(i));
//							Window.alert(Integer.toString(genre.getId()) + genre.getGenre());
							spracheVec.add(sprache);
//							Window.alert("Selektierter Index: " + Integer.toString(i));
//							System.out.println(genreVec);
						}	
//						Window.alert("Jeder einzelne Index: " + Integer.toString(i));						
					}
					
					for (int i = 0; i < untertitelLB.getItemCount(); i++) {
//						Window.alert(Integer.toString(genreLB.getItemCount()));

						if(untertitelLB.isItemSelected(i) == true) {
							Sprache untertitel = new Sprache();
							untertitel.setId(Integer.parseInt(untertitelLB.getValue(i)));
							untertitel.setSprache(untertitelLB.getItemText(i));
//							Window.alert(Integer.toString(genre.getId()) + genre.getGenre());
							untertitelVec.add(untertitel);
//							Window.alert("Selektierter Index: " + Integer.toString(i));
//							System.out.println(genreVec);
						}	
//						Window.alert("Jeder einzelne Index: " + Integer.toString(i));						
					}
					
	/*				for(int j = 0; j < genreVec.size(); j++) {
						Window.alert("Element in der Liste: " + Integer.toString(genreVec.elementAt(j).getId()) + " " + genreVec.elementAt(j).getGenre());
					}*/
						//	RootPanel.get("Details").clear();
						
					dvdVerwaltung.createSpracheBelegung(spracheVec, untertitelVec, dvd, new AsyncCallback<Sprache>(){
							@Override
							public void onSuccess(Sprache result) {
								dvdVerwaltung.getAllStudio(new StudioCallback());
							}
									
							@Override
							public void onFailure(Throwable caught) {
							}
					});
					}
				});
		}
	}
	
	class StudioCallback implements AsyncCallback<Vector<Studio>> {

		@Override
		public void onFailure(Throwable caught) {
		}

		@Override
		public void onSuccess(Vector<Studio> result) {
			Button weiter = new Button("Absenden");
			Button studioNeu = new Button("Produktionsstudio hinzufügen");
			neuerContent.clear();
			studioLB.clear();
			studioLB.setVisibleItemCount(5);
			studioLB.setMultipleSelect(true);
			
				
			for(int i = 0; i < result.size(); i++ ) {
				studioLB.addItem(result.elementAt(i).getName(), Integer.toString(result.elementAt(i).getId()));
			}
			
			belegungen.clear();
			belegungen.setText(0, 0, "Produktionsstudio");
			belegungen.setWidget(1, 0, studioLB);
			belegungen.setWidget(2, 1, studioNeu);
			belegungen.setWidget(4, 1, weiter);
			RootPanel.get("Details").clear();
			vpanel.add(belegungen);
			horPanel.add(vpanel);
			
			RootPanel.get("Details").add(horPanel);
			
			studioNeu.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					
					Label labName = new Label("Name");
					Label labSitz = new Label("Sitz/Land");
					Button hinzufuegen = new Button("Hinzufügen");
					
					neuerContent.add(labName);
					neuerContent.add(tbStdName);
					neuerContent.add(labSitz);
					neuerContent.add(tbStdSitz);
					
					neuerContent.add(hinzufuegen);
					
					horPanel.add(neuerContent);
					
					hinzufuegen.addClickHandler(new ClickHandler() {
					@Override
					public void onClick(ClickEvent event) {
					dvdVerwaltung.createStudio(tbStdName.getText(), tbStdSitz.getText(), new AsyncCallback<Studio>() {

						@Override
						public void onFailure(Throwable caught) {}

						@Override
						public void onSuccess(Studio result) {
							dvdVerwaltung.getAllStudio(new StudioCallback());
						}
					});
					}
					});		
				}
			});
		
			weiter.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
						
					Vector<Studio> studioVec = new Vector<Studio>();

//					Window.alert(Integer.toString(genreLB.getItemCount()));
					for (int i = 0; i < studioLB.getItemCount(); i++) {
//						Window.alert(Integer.toString(genreLB.getItemCount()));

						if(studioLB.isItemSelected(i) == true) {
							Studio studio = new Studio();
							studio.setId(Integer.parseInt(studioLB.getValue(i)));
							studio.setName(studioLB.getItemText(i));
//							Window.alert(Integer.toString(genre.getId()) + genre.getGenre());
							studioVec.add(studio);
//							Window.alert("Selektierter Index: " + Integer.toString(i));
//							System.out.println(genreVec);
						}	
//						Window.alert("Jeder einzelne Index: " + Integer.toString(i));						
					}
					
	/*				for(int j = 0; j < genreVec.size(); j++) {
						Window.alert("Element in der Liste: " + Integer.toString(genreVec.elementAt(j).getId()) + " " + genreVec.elementAt(j).getGenre());
					}*/
						//	RootPanel.get("Details").clear();
						
					dvdVerwaltung.createStudioBelegung(studioVec, dvd, new AsyncCallback<Studio>(){
							@Override
							public void onSuccess(Studio result) {
								BasicFrame dvdsAnzeigen = new AlleDVDAnzeigen();
								RootPanel.get("Details").clear();
								RootPanel.get("Details").add(dvdsAnzeigen);
							}
									
							@Override
							public void onFailure(Throwable caught) {
							}
					});
					}
				});
		}
		}
}
