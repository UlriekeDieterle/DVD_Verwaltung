package dvd.verwaltung.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import dvd.verwaltung.shared.DVDVerwaltungAdministrationAsync;

public class ExampleVonVideo implements EntryPoint{

	VerticalPanel vPanel = new VerticalPanel();	
		Button btn1 = new Button("Submit");	
		Label testLabel = new Label("Please enter your name:");
		TextBox textbox1 = new TextBox();
		
		
	
	@Override
	public void onModuleLoad() {
		
		vPanel.add(testLabel);
		vPanel.add(textbox1);
		vPanel.add(btn1);
		RootPanel.get("Details").add(vPanel);
		
		btn1.addClickHandler(new SayHelloClickHandler());
	
	}
	
	private class SayHelloClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			
//			BasicFrame bFrame = new SayHello();
//			RootPanel.get("Details").clear();
//			RootPanel.get("Details").add(bFrame);
			
			DVDVerwaltungAdministrationAsync dvdVerwaltung = ClientsideSettings.getDVDVerwaltung();
			
			String name = textbox1.getText();
			VerticalPanel vPanel = new VerticalPanel();
			Label test2 = new Label("This is test label of class: SayHello.");
			vPanel.add(test2);
			RootPanel.get("Details").add(vPanel);
			
			dvdVerwaltung.sayHelloTest(name, new DefaultCallback());
		}
	}
	
}

class DefaultCallback implements AsyncCallback<String> {
	
	public DefaultCallback() {
	}
		
	@Override
	public void onFailure(Throwable caught) {
		ClientsideSettings.getLogger().severe("An error occured");
	}

	@Override
	public void onSuccess(String result) {
				
		if(result != null) {
		Label resultLabel = new Label();
		resultLabel.setText(result);
		VerticalPanel vPanel = new VerticalPanel();
		
		vPanel.add(resultLabel);
		RootPanel.get("Details").clear();
		RootPanel.get("Details").add(vPanel);
		}
	}

}
