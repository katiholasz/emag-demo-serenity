package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl(helpers.Constants.url)
public class AddedToCartModal extends PageObject {

	@FindBy(css = ".modal-content")
	private WebElementFacade modal;

	@FindBy(css = ".modal-lg button.close")
	private WebElementFacade closeModal;

	@FindBy(css = ".modal-content a[href*='go-to-cart']")
	private WebElementFacade seeShoppingCartDetailsButton;

	public void close_add_to_cart_modal() {
		modal.waitUntilPresent();
		closeModal.waitUntilClickable().click();
	}

	public void see_shopping_cart_details_from_modal() {
		modal.waitUntilPresent();
		seeShoppingCartDetailsButton.waitUntilClickable().click();
	}
}
