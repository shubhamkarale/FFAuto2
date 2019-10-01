package FFWebapp.Functions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Save_Bill extends Setup {
	
	String MemberId;

	@Test
	public void SavememBill() throws InterruptedException, AWTException {

		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable((By.id("BtnSubmit")))).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("successmessage")));
	
		String MemberID = wd.getCurrentUrl().substring(80, 88);

		ArrayList<String> tabs4 = new ArrayList<String>(wd.getWindowHandles());

		int tabcount = tabs4.size();

		wd.switchTo().window(tabs4.get(tabcount - 1));

		Robot robot = new Robot();
		Thread.sleep(4000);

		
//		Actions action = new Actions(wd);
//		action.sendKeys(Keys.ESCAPE).build().perform();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(5000);
		ArrayList<String> tabs5 = new ArrayList<String>(wd.getWindowHandles());
		int tabcount2 = tabs5.size();

		wd.switchTo().window(tabs5.get(tabcount2 - 1));

		String b = wait
				.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("/html/body/table/tbody/tr[3]/td/table[1]/tbody/tr/td[2]/div[2]")))
				.getText().substring(1);
			
			
		wd.get(url + "clientview.aspx?pagevalue=1&enquiryid=" + MemberID + "&tenantid=" + TenantId);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Purchase_History"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("createNewmembership")));

		String Billid = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"
						+ "/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/div[1]/span[1]/span[1]")))
				.getText();

		String newStr = Billid.substring(0, Billid.indexOf(" | ")).trim();

		if (b.matches(newStr)) {

			System.out.println("Bill Created SuccessFully. Your Bill Id - " + b);

		} else {

			System.out.println("Bill Not Found or Failed for Member ID - " + MemberID);
		}
	}
	
	 public void SaveTrial() throws InterruptedException {
		 
		 // Trial Date Selection 
		 	wd.findElement(By.id("ctl00_ContentPlaceHolder1_imgTrlStart")).click();
			wd.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender4_today")).click();
			
			// Product Select
			wd.findElement(By.cssSelector(
					"#ctl00_ContentPlaceHolder1_grdProducts > tbody > tr:nth-child(2) > td:nth-child(1) > input[type=\"image\"]"))
					.click();
			
			//Session Owner
			Select session = new Select(wd.findElement(By.id("customerOwner")));
			session.selectByIndex(2);
			
			// Submit Button
			wd.findElement(By.id("payment")).click();
			
		String Status =	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customertype"))).getText().toLowerCase();
		
		if(Status.contains("trial")) {
			Thread.sleep(5000);
			System.out.println("Trial Created Successfully "+ MemberId);
			
	  }else {
		  
		  System.out.println("unknown Error ");
	  	}
	  }

}
