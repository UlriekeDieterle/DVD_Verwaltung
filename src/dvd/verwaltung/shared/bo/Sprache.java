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

}
