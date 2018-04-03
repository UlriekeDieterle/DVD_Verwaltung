package dvd.verwaltung.shared.bo;

public class Regisseur {

	private int id = 0;
	private String regisseur = null;

	public void setId(int id) {
		this.id  = id;
	}
	
	public void setRegisseur(String r) {
		this.regisseur  = r;
	}

	public int getId() {
		return this.id;
	}
	
	public String getRegisseur() {
		return this.regisseur;
	}

}
