package com.steps.serenity;

import static org.junit.Assert.assertTrue;

import com.pages.GlobalNavigationPage;
import com.pages.HeaderPage;
import com.pages.SearchResultsPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;

public class HeaderSteps {

	HeaderPage headerPage;
	SearchResultsPage searchResutsPage;
	GlobalNavigationPage globalNavPage;
	
	@Step
	public void navigate_to_shopping_cart() {
		headerPage.go_to_cart();		
	}
	
	@Step
	public void search_product(String productName) {
		headerPage.type_keywords(productName);
		headerPage.search();
		assertTrue(searchResutsPage.get_search_results_page_term().contains(productName));
	}
	
	@Step
	public void global_header_elements_should_be_visible()
	{
		assertTrue(headerPage.my_account_is_visible());
		assertTrue(headerPage.my_cart_is_visible());
		assertTrue(headerPage.my_wishlist_is_visible());
	}
	
	@Step
	public void global_nav_help_link_should_be_visible()
	{
		assertTrue(globalNavPage.help_link_is_visible());
	}
	
	@Step
	public void global_nav_products_link_should_be_visible()
	{
		assertTrue(globalNavPage.products_link_is_visible());
	}
	
	@Step
	public void global_nav_promotions_link_should_be_visible()
	{
		assertTrue(globalNavPage.promotions_link_is_visible());
	}
	
	@StepGroup
	public void global_navigation_elements_should_be_visible() {
		global_nav_help_link_should_be_visible();
		global_nav_products_link_should_be_visible();
		global_nav_promotions_link_should_be_visible();
	}
}
