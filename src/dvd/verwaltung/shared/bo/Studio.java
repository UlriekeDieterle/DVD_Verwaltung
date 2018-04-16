package dvd.verwaltung.shared.bo;

public class Studio {

	private int id = 0;
	private String name = null ;
	private String sitz = null;

	public void setId(int id) {
		this.id  = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSitz(String sitz) {
		this.sitz  = sitz;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSitz() {
		return sitz;
	}
	
	@Override
	public String toString() {
	    return super.toString() + " " + this.id + " " + this.name + " " + this.sitz;
	  }

}
