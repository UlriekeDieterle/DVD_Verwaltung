package dvd.verwaltung.shared.bo;

public class Sprache {
	
	int id = 0;
	private String sprache = null;

	public void setId(int id) {
		this.id = id;
	}
	
	public void setSprache(String sprache) {
		this.sprache  = sprache;
	}
	
	public int getId() {
		return id;
	}
	
	public String getSprache() {
		return sprache;
	}
	
	@Override
	public String toString() {
	    return super.toString() + " " + this.id + " " + this.sprache;
	  }

}
