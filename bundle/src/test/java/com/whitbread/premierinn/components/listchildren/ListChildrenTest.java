package com.whitbread.premierinn.components.listchildren;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.ValueMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@RunWith(PowerMockRunner.class)
public class ListChildrenTest {

	private static final String SPECIFIED_PATH = "/content/premierinn/home";

	private static final String PROPERTY = "path";

	private static final String EMPTY_STRING = "";

	private ListChildren listChildren;

	@Mock
	private Page childPage1;

	@Mock
	private Page childPage2;

	@Mock
	private PageManager pageManager;

	@Mock
	private Page parentPage;

	@Mock
	private Page currentPage;

	@Mock
	private ValueMap properties;

	public ListChildrenTest() {
		// Create a mock of the WCMUse class.
		listChildren = mock(ListChildren.class);

		// Set to call the real methods in the class being tested. For methods that return something.
		when(listChildren.getChildPages()).thenCallRealMethod();

		// Set to call the real activate method in the class being tested. For void return types.
		doCallRealMethod().when(listChildren).activate();
	}

	// Write tests
	@Test
	public void testChildPagesWithSetPath() {
		Iterator<Page> testChildren = getChildList();
		when(listChildren.getProperties()).thenReturn(properties);
		when(properties.get(PROPERTY, EMPTY_STRING)).thenReturn(SPECIFIED_PATH);
		when(listChildren.getPageManager()).thenReturn(pageManager);
		when(pageManager.getPage(SPECIFIED_PATH)).thenReturn(parentPage);
		when(parentPage.listChildren()).thenReturn(testChildren);
		listChildren.activate();
		Iterator<Page> childPages = listChildren.getChildPages();
		assertEquals(testChildren, childPages);
	}

	@Test
	public void testChildPagesWithNoSetPath() {
		Iterator<Page> testChildren = getChildList();
		when(listChildren.getProperties()).thenReturn(properties);
		when(properties.get(PROPERTY, EMPTY_STRING)).thenReturn(StringUtils.EMPTY);
		when(listChildren.getCurrentPage()).thenReturn(currentPage);
		when(currentPage.listChildren()).thenReturn(testChildren);
		listChildren.activate();
		Iterator<Page> childPages = listChildren.getChildPages();
		assertEquals(testChildren, childPages);
	}

	private Iterator<Page> getChildList() {
		List<Page> childList = new ArrayList<>();
		childList.add(childPage1);
		childList.add(childPage2);
		return childList.iterator();
	}
}
