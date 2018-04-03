package dvd.verwaltung.shared.bo;

public class DVD {

	private int id = 0;
	private String titel = null;
	private int fsk = 0;
	private int prodjahr;
	private int erschjahr;
	private String beschreibung;
	private int filmlaenge;
	private String stichwort;
	private int anzahlDisc;
	private String artDVD;
	private String serieFilm;

	public void setId(int id) {
		this.id = id;
	}

	public void setTitel(String titel) {
		this.titel = titel;		
	}

	public void setFSK(int fsk) {
		this.fsk = fsk;
	}

	public void setProduktionsjahr(int jahr) {
		this.prodjahr = jahr;
	}

	public void setErscheinungsjahr(int jahr) {
		this.erschjahr = jahr;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public void setFilmlaenge(int laenge) {
		this.filmlaenge = laenge;
	}

	public void setStichwort(String wort) {
		this.stichwort = wort;
	}

	public void setAnzahlDisc(int disc) {
		this.anzahlDisc = disc;
	}

	public void setArtDVD(String art) {
		this.artDVD = art;
	}

	public void setSerieFilm(String sf) {
		this.serieFilm = sf;
	}
	
	
	
	
	

}
