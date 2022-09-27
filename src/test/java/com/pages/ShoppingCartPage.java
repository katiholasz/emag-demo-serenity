package com.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ShoppingCartPage extends PageObject {

	@FindBy(css = "h1.cart")
	private WebElementFacade shoopingCartHeading;

	@FindBy(id = "cartProductsPage")
	private WebElementFacade cartProductsPage;

	@FindBy(css = "a.emg-button.emg-btn-large")
	private WebElementFacade nextStepButton;

	@FindBy(css = "a.main-product-title")
	private WebElementFacade productLink;

	@FindBy(className = "main-product-title-container")
	private WebElementFacade productsNameContainer;

	@FindBy(css = ".remove-product.btn-remove-product")
	private WebElementFacade removeProductCartButton;

	public void click_next_step() {
		nextStepButton.waitUntilClickable().click();
	}

	public String get_shopping_cart_heading() {
		return shoopingCartHeading.waitUntilVisible().getText();
	}

	public Boolean is_shopphing_cart_page() {
		return cartProductsPage.isVisible();
	}

	public String get_product_name() {
		return productLink.waitUntilVisible().getText();
	}

	public List<String> getShoppingCartProductsName() {
		WebElementFacade productsList = productsNameContainer;
		return productsList.findElements(By.cssSelector("a")).stream().map(element -> element.getText().toLowerCase())
				.collect(Collectors.toList());
	}

	public void remove_product_from_shopping_cart() {
		removeProductCartButton.waitUntilVisible().click();
	}
	
	public Boolean is_remove_product_from_cart_present() {
		return removeProductCartButton.isPresent();
	}
}
