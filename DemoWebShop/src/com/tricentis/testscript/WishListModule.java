package com.tricentis.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tricentis.generic.BaseClass;
import com.tricentis.pom.DescriptionPage;
import com.tricentis.pom.HomePage;
import com.tricentis.pom.ProductListPage;
import com.tricentis.pom.WishListPage;

@Listeners(com.tricentis.generic.ListenerImplementation.class)
public class WishListModule extends BaseClass {

	@Test
	public void addAndRemoveProduct() throws InterruptedException, EncryptedDocumentException, IOException {

		HomePage h = new HomePage(driver);
		String data = f.readDataFromExcel("Sheet1", 1, 1);
		h.setSearchBox(data);

		ProductListPage p = new ProductListPage(driver);
		p.setProductIcon();

		DescriptionPage d = new DescriptionPage(driver);
		String qty = d.getProductQuantity().getText();

		int qtyInNum = Integer.parseInt(qty.replace('(', ' ').replace(')', ' ').trim());
		System.out.println("Quantity before adding to wishlist " + qtyInNum);
		d.getAddToWishlistBtn().click();
		Thread.sleep(2000);

		String qtyAfterAdding = d.getProductQuantity().getText();
		int qtyInNumAfterAdding = Integer.parseInt(qtyAfterAdding.replace('(', ' ').replace(')', ' ').trim());
		Assert.assertEquals(qtyInNum + 1, qtyAfterAdding);

		System.out.println("Quantity after adding to wishlist " + qtyInNumAfterAdding);
		boolean res = d.getWishlistMsg().isDisplayed();
		Assert.assertTrue(res, "Popup is not displayed");
		String addedText = d.getWishlistMsg().getText();
		Assert.assertEquals(addedText, "");
		System.out.println(addedText);

		d.getWishlistLink().click();
		WishListPage w = new WishListPage(driver);
		w.removeProduct();

		boolean res2 = w.getEmptyWishlistMsgIsDisplayed();
		Assert.assertTrue(res2, "Item is not removed from wishlist");
		String removedTest = w.getEmptyWishlistMsg();
		Assert.assertEquals(addedText, removedTest);
		System.out.println(removedTest);
	}
}
