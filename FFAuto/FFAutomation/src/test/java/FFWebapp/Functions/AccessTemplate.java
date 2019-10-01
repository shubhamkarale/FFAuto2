package FFWebapp.Functions;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccessTemplate extends Setup{
	
	String Name = RandomStringUtils.randomAlphabetic(6).toLowerCase();
	 
 


	
	@Test
	public void Access_tem_page() throws InterruptedException, IOException {
		
		Assert.assertTrue(wd.findElement(By.linkText("New Access Template")).isDisplayed());
		wd.findElement(By.linkText("New Access Template")).click();
		// Name
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtTemplateName")).isDisplayed());
		WebElement username = wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtTemplateName"));
		username.sendKeys(Name);
		System.out.println("Username : "+username.getAttribute("value"));
		// Description
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtDescription")).isDisplayed());
		wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtDescription")).sendKeys(Name);
		// creating a user at center level
		new Select(wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlShowInUserTenantPage")))
				.selectByVisibleText("Yes");
		Thread.sleep(2000);
		WebElement element = wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlShowInUserTenantPage"));
		((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
		// Click on Select Module
		Thread.sleep(3000);
		wd.findElement(By.linkText("Select Module & Page Access")).click();
		Thread.sleep(2000);
		// Select outside div
		JavascriptExecutor js = (JavascriptExecutor) wd;
		String checkedBox = "$('#chkModule').each(function() {$('input:checkbox').prop('checked','checked').change();});";
		js.executeScript(checkedBox);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pagemodulelist\"]/div[1]/table[2]/tbody/tr/td"))).isDisplayed();
		// Select inside div
		JavascriptExecutor js1 =(JavascriptExecutor) wd;
		String script = "$('#pagemodulelist').each(function() {$('input:checkbox').prop('checked','checked').change();});";
		js1.executeScript(script);
		// click on continue
		JavascriptExecutor jse2=(JavascriptExecutor) wd;
		jse2.executeScript("SetModulePage();");
		// % discount
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserDiscount")).isDisplayed());
		wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserDiscount")).sendKeys("10");
		// Select Yes
		List<WebElement> rows1 = wd.findElements(By.xpath(
				"/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[2]/div[8]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[3]/td[1]/table[1]/tbody[1]/tr"));
		int rowcount1 = rows1.size();

		String beforexpath1 = "/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[2]/div[8]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[3]/td[1]/table[1]/tbody[1]/tr[";
		String afterxpath1 = "]/td[2]/select[1]";

		for (int i = 7; i <= rowcount1; i++) {

			String actualxpath = beforexpath1 + i + afterxpath1;

			if (wd.findElements(By.xpath(actualxpath)).size() != 0) {

				if (wd.findElement(By.xpath(actualxpath)).isDisplayed()) {

					new Select(wd.findElement(By.xpath(actualxpath))).selectByIndex(1);

				} else {
					System.out.println("field is disabled " + i);
				}
			} else {
				System.out.println("Element not found " + i);

			}
				
		}
		
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).isDisplayed());
		wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnSubmit")).click();
		
		String verifyacctem = wd.findElement(By.id("ctl00_ContentPlaceHolder1_lblMsg")).getText();
		System.out.println("Data of "+ verifyacctem);
		
	}

}
