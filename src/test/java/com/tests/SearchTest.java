package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.serenity.HeaderSteps;
import com.steps.serenity.NavigationSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/searchTerms.csv")
public class SearchTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;
	
	@Steps
	public HeaderSteps headerSteps;
	@Steps
	public NavigationSteps navigationSteps;

	@Test
	public void add_to_cart_searched_product() {
		navigationSteps.navigate_to_homepage();
		headerSteps.search_product(getSearchTerm());
	}

	public String searchTerm;

	@Qualifier 
	public String getQualifier() {
		return searchTerm;
	}
	
	public String getSearchTerm() { 
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
}
