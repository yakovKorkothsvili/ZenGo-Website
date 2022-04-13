package tools;

import static org.testng.Assert.assertEquals;

public class ZenGoWebsiteFunctions {

	public static void checkingIfTheSiteIsDisplayed(String interCom) {
		String ariaLabel="Open Intercom Messenger";
		assertEquals(interCom, ariaLabel);
		System.out.println("test checking if the site is displayed is passed");

	}
	
	public static void verifyThatItWasRedirectedToRightPage(String url) {
		String urlSite="https://zengo.com/assets/ethereum-wallet/";
		assertEquals(url, urlSite);
		System.out.println("test verify that it was redirected to right page is passed");
	}
	
	public static void checkingIfLogoAndIconAreDisplayed(boolean ImageDisplayed) {
		if (!ImageDisplayed) {
			System.err.println("the logo and icon are not displayed");
		}
		else {
			System.out.println("the logo and icon are displayed");
		}
	}
	
	
}
