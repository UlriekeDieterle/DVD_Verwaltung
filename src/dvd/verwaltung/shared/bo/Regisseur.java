package dvd.verwaltung.shared.bo;

public class Regisseur extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	@Override
	public String toString() {
	    return super.toString() + " " + this.id + " " + this.regisseur;
	  }

}
