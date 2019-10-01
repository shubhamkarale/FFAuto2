package FFWebapp.Functions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FollowUp extends Setup	{ 

	@Test
	public void  SaveFollowUp() {

	if (wd.findElement(By.id("ddlCallResponce")).isDisplayed()) { 

		Select Rep = new Select(wd.findElement(By.id("ddlCallResponce")));
		Rep.selectByIndex(1);
		// Convertibility
		Select Conver = new Select(wd.findElement(By.id("ddlConvertibility")));
		Conver.selectByIndex(3);
		// Next Follow Up
		// wait.until(ExpectedConditions.elementToBeClickable(By.id("//*[@id=\"txtNextFollowupDate\"]"))).click();
		wd.findElement(By.xpath("//*[@id=\"txtNextFollowupDate\"]")).click();
		// DatePicker

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		wd.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/a[2]/span")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wd.findElement(By.linkText("28")).click();
		// ContactType
		Select CT = new Select(wd.findElement(By.id("ddlContacttypefl")));
		CT.selectByIndex(1);
		// Add Comment
		wd.findElement(By.id("textarea")).sendKeys(RandomStringUtils.randomAlphabetic(6));

	} else {

		// System.out.println("Follow Up Not Visible");
	}

	}

	
	
	
}