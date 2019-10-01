package FFWebapp.Functions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class BackdatedEntries extends Setup{
	
	@Test
	public void BackDateEnquiry() throws IOException, InterruptedException {
	
	if (wd.findElement(By.id("meco_EnrollmentDate")).isDisplayed()) {

		wd.findElement(By.id("meco_EnrollmentDate")).click();
		// Select date = new Select(wd.findElement(By.xpath("ui-datepicker-year")));
		// date.selectByValue("2019");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[1]/a[1]/span"))).click();
		
		wd.findElement(By.linkText("10")).click();

	} else {
		// System.out.println("meco_DateOfBirth is not compulsory");
	}
	
	}
	
	public void BackDatePurchase() throws IOException, InterruptedException {
		
		if (wd.findElement(By.id("purchasedate")).isDisplayed()) {
			
			wd.findElement(By.id("purchasedate")).click();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[14]/div/a[1]/span"))).click();

			// Select date = new Select(wd.findElement(By.xpath("ui-datepicker-year")));
			// date.selectByValue("2019");
			wd.findElement(By.linkText("10")).click();

		} else {
			// System.out.println("meco_DateOfBirth is not compulsory");
		}
	}
}