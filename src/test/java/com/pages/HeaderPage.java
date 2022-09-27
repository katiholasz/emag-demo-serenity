package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl(helpers.Constants.url)
public class HeaderPage extends PageObject {

	@FindBy(className = "navbar-brand")
	private WebElementFacade logo;

	@FindBy(id = "searchboxTrigger")
	private WebElementFacade searchBox;

	@FindBy(css = ".searchbox-submit-button")
	private WebElementFacade searchIcon;

	@FindBy(id = "my_account")
	private WebElementFacade myAccount;

	@FindBy(id = "my_wishlist")
	private WebElementFacade myWishlist;

	@FindBy(id = "my_cart")
	private WebElementFacade myCart;

	public void type_keywords(String keyword) {
		searchBox.type(keyword);
	}

	public void search() {
		searchIcon.waitUntilClickable();
		searchIcon.click();
	}

	public void go_to_cart() {
		myCart.waitUntilClickable();
		myCart.click();
	}
	
	public Boolean my_account_is_visible() {
		return myAccount.waitUntilVisible().isVisible();
	}
	
	public Boolean my_wishlist_is_visible() {
		return myWishlist.waitUntilVisible().isVisible();
	}
	
	public Boolean my_cart_is_visible() {
		return myCart.waitUntilVisible().isVisible();
	}


}
