package com.whitbread.premierinn.components.listchildren;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
/**
 * Created by hegartyi on 27/05/2016.
 */

@Component
@Service(value = ListChildrenService.class)
public class ListChildrenService implements ListChildrenServiceInterface{

	Logger logger = LoggerFactory.getLogger(ListChildrenService.class);

	@Override
	public String getChildren() {
		return "John";
	}

	@Override
	public String getCurrentPage() {
		return "AEM Developer";
	}

}
