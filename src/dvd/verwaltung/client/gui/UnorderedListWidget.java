package dvd.verwaltung.client.gui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

public class UnorderedListWidget extends ComplexPanel {

	public UnorderedListWidget() {
		this.setElement(Document.get().createULElement());
	}
	
	public void setId(String id) {
		getElement().setId(id);
	}
	
	public void setDir(String dir) {
		((UListElement) getElement().cast()).setDir(dir);
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public void add(Widget w) {
		super.add(w, getElement());
	}
	
}
