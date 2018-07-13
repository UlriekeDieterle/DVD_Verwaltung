package dvd.verwaltung.shared.bo;

import java.io.Serializable;

public abstract class BusinessObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected int id = 0;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return this.getClass().getName() + " #" + this.id;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof BusinessObject) {
			BusinessObject bo = (BusinessObject) o;
			try {
				if (bo.getId() == this.id)
					return true;
			}
			catch(IllegalArgumentException e) {
				return false;
			}
		}
		return false;
	}
	
	public int hashCode() {
		return this.id;
	}
}
