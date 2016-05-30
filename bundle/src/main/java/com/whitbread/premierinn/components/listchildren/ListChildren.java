package com.whitbread.premierinn.components.listchildren;

import java.util.Iterator;

import com.day.cq.wcm.api.Page;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUse;

/**
 * Created by hegartyi on 29/05/2016.
 */

public class ListChildren extends WCMUse {

	protected Page parentPage;
	private Iterator<Page> pages;
	private String pathfield;
	private String value;

	@Override
	public void activate() {

		pathfield = StringUtils.EMPTY;

		pathfield = getProperties().get("path", "");

		if (pathfield == null || pathfield.isEmpty()) {
			this.parentPage = getCurrentPage();
		} else {
			this.parentPage = getPageManager().getPage(pathfield);
		}

		this.pages = this.parentPage.listChildren();

	}

	public Iterator<Page> getChildPages() {
		return this.pages;
	}
}


