package com.whitbread.premierinn.components.listchildren;

import java.util.Iterator;

import com.day.cq.wcm.api.Page;
import org.apache.commons.lang3.StringUtils;

import com.adobe.cq.sightly.WCMUse;

/**
 * A class to retrieve child pages from a given path - fallback option is current page children.
 *
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

	/**
	 * Returns the child pages of a page that depends on whether an override path was set in the component or not
	 * @return Iterator<Page> returns an iterator containing a list of child pages
	 */
	public Iterator<Page> getChildPages() {
		return this.pages;
	}
}
