package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.steps.serenity.HeaderSteps;
import com.steps.serenity.NavigationSteps;
import com.steps.serenity.ProductsSteps;
import com.steps.serenity.ShoppingCartSteps;

import helpers.Constants;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class ShoppingCartTest {

	@Managed(uniqueSession = true)
	public WebDriver webdriver;

	@Steps
	public HeaderSteps headerSteps;
	@Steps
	public ProductsSteps productsSteps;
	@Steps
	public ShoppingCartSteps shoppingCartSteps;
	@Steps
	public NavigationSteps navigationSteps;
	
	
	@Test
	public void add_to_cart_searched_product() {
		navigationSteps.navigate_to_homepage();
		headerSteps.search_product(Constants.productName);
		productsSteps.add_first_product_to_cart();
		headerSteps.navigate_to_shopping_cart();
		shoppingCartSteps.should_see_product_in_shopping_cart(Constants.productName);
	}
	
	@Test
	public void remove_product_from_cart() {
		add_to_cart_searched_product();
		shoppingCartSteps.remove_product_from_shopping_cart();
		shoppingCartSteps.should_see_no_removable_product_left();
		}

}
