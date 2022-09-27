package com.steps.serenity;

import static org.junit.Assert.assertTrue;

import com.pages.AddedToCartModal;
import com.pages.ProductsPage;
import net.thucydides.core.annotations.Step;

public class ProductsSteps {
	
	ProductsPage products;
	AddedToCartModal modal;
	
	@Step
	public void add_first_product_to_cart() {
		assertTrue(products.is_products_page());
		products.add_to_cart();
		modal.close_add_to_cart_modal();
	}
	
	@Step
	public void add_first_product_to_favorites() {
		assertTrue(products.is_products_page());
		products.add_to_favorites();
	}
	
}
