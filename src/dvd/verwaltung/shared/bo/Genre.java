package dvd.verwaltung.shared.bo;

public class Genre extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String genre = null;

	public void setId(int id) {
		this.id  = id;
	}

	public void setGenre(String genre) {
		this.genre  = genre;		
	}

	public int getId() {
		return this.id;
	}

	public String getGenre() {
		return this.genre;
	}
	
	@Override
	public String toString() {
	    return super.toString() + " " + this.id + " " + this.genre;
	  }
	

}
