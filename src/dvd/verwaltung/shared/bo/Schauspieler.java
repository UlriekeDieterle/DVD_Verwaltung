package dvd.verwaltung.shared.bo;

public class Schauspieler extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String vorname = null;
	private String nachname = null;
	private int jahr = 0;
	private String nationalitaet = null;

	public void setId(int id) {
		this.id = id;		
	}
	
	public void setVorname(String v) {
		this.vorname = v;
	}
	
	public void setNachname(String n) {
		this.nachname  = n;
	}
	
	public void setGeburtsjahr(int jahr) {
		this.jahr  = jahr;
	}
	
	public void setNationalitaet(String n) {
		this.nationalitaet  = n;
	}

	public int getId() {
		return id;
	}
	
	public String getVorname() {
		return vorname;
	}
	
	public String getNachname() {
		return nachname;
	}
	
	public int getGeburtsjahr() {
		return jahr;
	}
	
	public String getNationalitaet() {
		return nationalitaet;
	}
	
	@Override
	public String toString() {
	    return super.toString() + " " + this.id + " " + this.vorname + " " + this.nachname + " " + this.jahr + " " + this.nationalitaet;
	  }

}
