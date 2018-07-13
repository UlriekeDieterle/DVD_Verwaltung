package dvd.verwaltung.client;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.FlowPanel;

public abstract class BasicFrame extends FlowPanel {

	@Override
	public void onLoad() {
		super.onLoad();
		this.add(createHeadline(getHeadlineText(), getSubHeadlineText()));
		this.run();
	}

	private void add(HTML createHeadline) {
		
	}

	protected HTML createHeadline(String header, String subHeader) {
		HTML content = new HTML();
		content.setStylePrimaryName("header");
		content.setHTML("<h1>" + header + "</h1><h2>" + subHeader + "</h2>");
		return content;
	}
	
	protected void append(String text) {
		HTML content = new HTML(text);
		content.setStylePrimaryName("simpletext");
		this.add(content);
	}

	protected abstract void run();

	protected abstract String getSubHeadlineText();

	protected abstract String getHeadlineText();
}
