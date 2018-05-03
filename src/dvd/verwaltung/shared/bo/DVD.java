package dvd.verwaltung.shared.bo;

public class DVD extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

	public int getId() {
		return this.id;
	}

	public String getTitel() {
		return this.titel;
	}

	public int getFSK() {
		return this.fsk;
	}

	public int getProduktionsjahr() {
		return this.prodjahr;
	}

	public int getErscheinungsjahr() {
		return this.erschjahr;
	}

	public String getBeschreibung() {
		return this.beschreibung;
	}

	public int getFilmlaenge() {
		return this.filmlaenge;
	}

	public String getStichwort() {
		return this.stichwort;
	}

	public int getAnzahlDisc() {
		return this.anzahlDisc;
	}

	public String getArtDVD() {
		return this.artDVD;
	}

	public String getSerieFilm() {
		return this.serieFilm;
	}
	
	@Override
	public String toString() {
	    return super.toString() + " " + this.id + " " + this.titel + " " + this.fsk + " " + this.prodjahr + " " + this.erschjahr
	    		+ " " + this.beschreibung + " " + this.filmlaenge + " " + this.stichwort + " " + this.anzahlDisc + " " 
	    		+ this.artDVD + " " + this.serieFilm;
	  }
}
