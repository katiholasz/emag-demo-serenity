package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchResultsPage extends PageObject {

	@FindBy(css = ".listing-panel-heading .title-phrasing-xl")
	private WebElementFacade searchTermHeading;
	
	public String get_search_results_page_term() {
		return searchTermHeading.getText();
	}
}
