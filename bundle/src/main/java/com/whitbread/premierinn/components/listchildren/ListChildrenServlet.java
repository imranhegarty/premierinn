package com.whitbread.premierinn.components.listchildren;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUse;
/**
 * Created by hegartyi on 27/05/2016.
 */
public class ListChildrenServlet extends WCMUse{

	Logger logger = LoggerFactory.getLogger(ListChildrenServlet.class);
	protected String detail;

	@Override
	public void activate() {

		ListChildrenServiceInterface service = getSlingScriptHelper().getService(ListChildrenService.class);
		detail = service.getChildren();
	}

	public String getDetail() {
		return this.detail;
	}
}
