package com.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductsPage extends PageObject {

	@FindBy(className = "js-product-data")
	private WebElementFacade productData;

	@FindBy(css = ".product-page-actions .yeahIWantThisProduct")
	private WebElementFacade addToCartButton;

	@FindBy(css = ".card-toolbox button.add-to-favorites")
	private WebElementFacade addToFavorites;

	@FindBy(className = "product-title-zone")
	private WebElementFacade productsTitles;

	public Boolean is_products_page() {
		return productData.waitUntilVisible().isVisible();
	}

	public void add_to_cart() {
		productData.waitUntilClickable().click();
		addToCartButton.waitUntilVisible().waitUntilClickable().click();
	}

	public void add_to_favorites() {
		addToFavorites.waitUntilClickable().click();
	}

	public List<String> getProductsLinks() {
		WebElementFacade productsList = productsTitles;
		return productsList.findElements(By.cssSelector(".js-product-url")).stream().map(element -> element.getText())
				.collect(Collectors.toList());
	}
}
