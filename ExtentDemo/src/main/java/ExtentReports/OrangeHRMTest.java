package ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import ExtentReports.base;

public class OrangeHRMTest extends base {

	@Test
	public void loginPageTest() {
		WebElement imgElement = driver.findElement(By.xpath("//*[@id=\"divLogo\"]/img"));
		Assert.assertTrue(imgElement.isDisplayed());
		System.out.println("passed");
	}

	@Test
	public void loginTest() {

		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM1";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
//	 @Test
//	 public void sampleCase() {
//	 test=extent.createTest("sampletest");
// 
//	  test.createNode("Validation1");
//	  Assert.assertTrue(false);
//	  test.createNode("Validation2");
//	  Assert.assertTrue(true);
//	  test.createNode("Validation3");
//	  Assert.assertTrue(true);
//	  test.createNode("Validation4");
//	  Assert.assertTrue(true);
//	 }
}
