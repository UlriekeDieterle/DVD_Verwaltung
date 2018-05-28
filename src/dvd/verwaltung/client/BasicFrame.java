package dvd.verwaltung.client;

import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public abstract class BasicFrame extends Widget {

	@Override
	public void onLoad() {
		super.onLoad();
		this.addAttachHandler(createHeadline(getHeadlineText(), getSubHeadlineText()));
		RootPanel.get("search-table").clear();
		run();
	}

	protected HTML createHeadline(String header, String subHeader) {
		HTML content = new HTML();
		content.setStylePrimaryName("header");
		content.setHTML("<h1>" + header + "</h1><h2>" + subHeader + "</h2>");
		return content;
	}

	protected abstract void run();

	protected abstract String getSubHeadlineText();

	protected abstract String getHeadlineText();
}
