package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl(helpers.Constants.url)
public class GlobalNavigationPage extends PageObject {

	@FindBy(className = "navbar-aux-content__departments")
	private WebElementFacade productSeeAllLink;
	
	@FindBy(linkText = "Promotiile saptamanii")
	private WebElementFacade promotiileSaptamaniiLink;

	@FindBy(className = "navbar-aux-help-link")
	private WebElementFacade emagHelpLink;
	
	public Boolean products_link_is_visible() {
		return productSeeAllLink.waitUntilVisible().isVisible();
	}
	
	public Boolean promotions_link_is_visible() {
		return promotiileSaptamaniiLink.waitUntilVisible().isVisible();
	}
	
	public Boolean help_link_is_visible() {
		return emagHelpLink.waitUntilVisible().isVisible();
	}

}
