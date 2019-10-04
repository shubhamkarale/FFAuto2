package FFWebapp.Functions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserCreationForm extends Setup{
	
	String Name = RandomStringUtils.randomAlphabetic(6).toLowerCase();
	
	WebElement username;

  @Test
  public void createUserForm() throws InterruptedException {  

		// username
		Thread.sleep(2000);
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).isDisplayed());
		username = wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName"));
		username.sendKeys(Name);
		System.out.println("Username : "+username.getAttribute("value"));
		
		
		// userid = username.getAttribute("value");
		// password
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_lblSetPwd")).isDisplayed());
		wd.findElement(By.id("ctl00_ContentPlaceHolder1_lblSetPwd")).click();
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword")).isDisplayed());
		WebElement password = wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword"));
		password.sendKeys(RandomStringUtils.randomAlphabetic(7)+"1");
		System.out.println("Password : "+password.getAttribute("value"));
		// firstname
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).isDisplayed());
		wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).sendKeys(RandomStringUtils.randomAlphabetic(5));
		// lastname
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName")).isDisplayed());
		wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName")).sendKeys("Lastname");
		// gender
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlgender")).isDisplayed());
		new Select(wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlgender"))).selectByVisibleText("Male");
		// department
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtDepartment")).isDisplayed());
		wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtDepartment"))
		.sendKeys(RandomStringUtils.randomAlphabetic(8));
		// designation
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDesignatin")).isDisplayed());
		new Select(wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDesignatin")))
		.selectByIndex(2);
		// role
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlRole")).isDisplayed());
		new Select(wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlRole")))
		.selectByVisibleText("Administrator");
		// appointment rights
		Assert.assertTrue(
		wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlAppointmentsRights")).isDisplayed());
		new Select(wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlAppointmentsRights")))
		.selectByVisibleText("Edit Own");
		// Scheduled rights
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlScheduleRights")).isDisplayed());
		new Select(wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlScheduleRights")))
		.selectByVisibleText("Edit Own");
		// Language
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlLanguage")).isDisplayed());
		new Select(wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlLanguage")))
		.selectByVisibleText("English");
		// submit
		Assert.assertTrue(wd.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']")).isDisplayed());
		wd.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btnSubmit']")).click();
		//takeScreenshotpass("tenant_selection");
		
  }
  
  @Test
  public void Userverify() throws InterruptedException {

	  wait.until(ExpectedConditions.urlContains("Default"));

	  Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).isDisplayed());
	     wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Name);
	  Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnSerSubmit")).isDisplayed());
	  wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnSerSubmit")).click();
//	  System.out.println("User Created Successful");
	  //takeScreenshotpass("Createuser_page");
	  
	  wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ctl00_ContentPlaceHolder1_grdUsers_ctl03_lblUserName")));
	
	  if(wd.findElements(By.id("ctl00_ContentPlaceHolder1_grdUsers_ctl02_lblUserName")).size()!=0) {
		  
		  String usrnm = wd.findElement(By.id("ctl00_ContentPlaceHolder1_grdUsers_ctl02_lblUserName")).getText();
		  
		  System.out.println(usrnm);
		  
		//  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ctl00_ContentPlaceHolder1_grdUsers_ctl02_lblUserName"), usrnm));
		  
		  if(wd.findElement(By.id("ctl00_ContentPlaceHolder1_grdUsers_ctl02_lblUserName")).getText().matches(Name)) {
			  System.out.println("User Created SuccessFully");
		  }else {
			  System.out.println("User Not Created SuccessFully");
		  }
		  
	  } else {
		  
	  }

}
  @Test
  public void AssignTemplate() throws InterruptedException, AWTException {

	  Assert.assertTrue(wd.findElement(By.id("select2-customerOwner-container")).isDisplayed());
		wd.findElement(By.id("select2-customerOwner-container")).click();
		
		
		Assert.assertTrue(wd.findElement(By.xpath("//*[@id='ctl00_combodymaster']/span/span/span[1]/input"))
				.isDisplayed());
		wd.findElement(By.xpath("//*[@id='ctl00_combodymaster']/span/span/span[1]/input")).sendKeys(Name);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
//		Assert.assertTrue(wd.findElement(By.id(TenantId)).isDisplayed());
		Thread.sleep(8000);
		
		wait.until(ExpectedConditions.presenceOfElementLocated((By.id(TenantId)))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				(By.id("select2-ctl00_ContentPlaceHolder1_ddlAccessTemplate-container")))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='ctl00_combodymaster']/span/span/span[1]/input")))
				.sendKeys("Administrator");
		
		Thread.sleep(1000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnAdd")).isDisplayed());
		wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnAdd")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("ctl00_ContentPlaceHolder1_btnSave"))))
				.click();
		Thread.sleep(2000);
		String actual = wd.findElement(By.id("ctl00_ContentPlaceHolder1_lblMsg")).getText();
		String expected = ("Data saved successfully.");
		Assert.assertEquals(actual, expected, "Data Is Not Saved");
		System.out.println(actual);
	  
  }
  
  @Test
  public void editUserForm() throws InterruptedException {  

		// username
	  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("ctl00_ContentPlaceHolder1_grdUsers_ctl02_hplnkEdit")));
		
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_ContentPlaceHolder1_txtserlName"))).sendKeys("Lastname");
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_ContentPlaceHolder1_btnSerSubmit"))).click();
	  
	  wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ctl00_ContentPlaceHolder1_grdUsers_ctl02_lblLastname"), "Lastname"));
			
	  wd.findElement(By.id("ctl00_ContentPlaceHolder1_grdUsers_ctl02_hplnkEdit")).click();
		Thread.sleep(2000);
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlgender")).isDisplayed());
		new Select(wd.findElement(By.id("ctl00_ContentPlaceHolder1_ddlgender"))).selectByVisibleText("Female");
		
		WebElement element = wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnUpdate"));
		((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
		
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnUpdate")).isDisplayed());
		wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnUpdate")).click();
		
		Thread.sleep(2000);
		
		
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).isDisplayed());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ctl00_ContentPlaceHolder1_txtUserName"))).sendKeys(Name);
		//wd.findElement(By.id("ctl00_ContentPlaceHolder1_txtUserName")).sendKeys(Name);
		Thread.sleep(2000);
		
		Assert.assertTrue(wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnSerSubmit")).isDisplayed());
		wd.findElement(By.id("ctl00_ContentPlaceHolder1_btnSerSubmit")).click();
		
		Thread.sleep(2000);
		System.out.println("User Updated Successfully");
		//takeScreenshotpass("tenant_selection");
		
  }
  
}

