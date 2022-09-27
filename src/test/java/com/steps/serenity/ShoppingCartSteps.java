package com.steps.serenity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.pages.ProductsPage;
import com.pages.ShoppingCartPage;

import helpers.Constants;
import net.thucydides.core.annotations.Step;

public class ShoppingCartSteps {
	
	ShoppingCartPage shoppingCartPage;
	ProductsPage productsPage;
	
	@Step
	public void should_see_shopping_cart_page() {
		assertTrue(shoppingCartPage.is_shopphing_cart_page());
		assertTrue(shoppingCartPage.get_shopping_cart_heading().equals(Constants.shoppingCartHeading));
		}

	@Step 
	public void should_see_product_in_shopping_cart(String productName) {
		assertThat(shoppingCartPage.getShoppingCartProductsName(), hasItem(containsString(productName)));
	}

	@Step 
	public void remove_product_from_shopping_cart() {
		shoppingCartPage.remove_product_from_shopping_cart();
	}
	
	@Step 
	public void should_see_no_removable_product_left() {
		assertFalse(shoppingCartPage.is_remove_product_from_cart_present());
	}
	
}
