package FFWebapp.Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CompanyLevelMenu extends Setup {
	
  @Test
  public void User_New_List() throws InterruptedException {

		  // hover on users and click in create link
		  Thread.sleep(2000);
		  Actions action = new Actions(wd);
		  WebElement element = wd.findElement(By.xpath("//*[@id='ctl00_ulmenu']/li[2]/a"));
		  action.moveToElement(element).perform();

		  Assert.assertTrue(wd.findElement(By.linkText("List")).isDisplayed());
		  wd.findElement(By.linkText("List")).click();

  }

  
  @Test
  public void User_New_Create() throws InterruptedException {

	  Thread.sleep(2000);
		Actions action = new Actions(wd);
		WebElement element = wd.findElement(By.xpath("//*[@id='ctl00_ulmenu']/li[2]/a"));
		action.moveToElement(element).perform();
		
		Assert.assertTrue(wd.findElement(By.linkText("Create")).isDisplayed());
		wd.findElement(By.linkText("Create")).click();
  }
  
  
 
  
  @Test
  public void User_New_User_Access_Template() throws InterruptedException  {
		
		// hover on users and click in create link
		Thread.sleep(2000);

		Actions action = new Actions(wd);
		WebElement element = wd.findElement(By.xpath("//*[@id='ctl00_ulmenu']/li[2]/a"));
		action.moveToElement(element).perform();

		Assert.assertTrue(wd.findElement(By.linkText("User Access Template")).isDisplayed());
		wd.findElement(By.linkText("User Access Template")).click();
	
  }
  
  
  @Test
  public void User_New_Assign_User_Access() throws InterruptedException {

	  Thread.sleep(2000);
		Actions action = new Actions(wd);
		WebElement element = wd
				.findElement(By.xpath("//*[@id='ctl00_ulmenu']/li[2]/a"));
		action.moveToElement(element).perform();
		
		Assert.assertTrue(wd.findElement(By.linkText("Assign User Access")).isDisplayed());
		wd.findElement(By.linkText("Assign User Access")).click();
  }
  
  
  
  
  @Test
	public void user_old_list() throws InterruptedException {
	Thread.sleep(2000);
	Actions action = new Actions(wd);
	WebElement element = wd.findElement(By.linkText("Users"));
	action.moveToElement(element).perform();
	Assert.assertTrue(wd.findElement(By.linkText("List")).isDisplayed());
	wd.findElement(By.linkText("List")).click();
	
	}
  
  @Test
	public void user_old_create() throws InterruptedException {
	Thread.sleep(2000);
	Actions action = new Actions(wd);
	WebElement element = wd.findElement(By.linkText("Users"));
	action.moveToElement(element).perform();
	Assert.assertTrue(wd.findElement(By.linkText("Create")).isDisplayed());
	wd.findElement(By.linkText("Create")).click();
	
	}

  @Test
 	public void user_old_user_access_tem() throws InterruptedException {
 	Thread.sleep(2000);
 	Actions action = new Actions(wd);
 	WebElement element = wd.findElement(By.linkText("Users"));
 	action.moveToElement(element).perform();
 	Assert.assertTrue(wd.findElement(By.linkText("User Access Template")).isDisplayed());
 	wd.findElement(By.linkText("User Access Template")).click();
 	
 	}
  
  @Test
 	public void user_old_assign_user_access() throws InterruptedException {
 	Thread.sleep(2000);
 	Actions action = new Actions(wd);
 	WebElement element = wd.findElement(By.linkText("Users"));
 	action.moveToElement(element).perform();
 	Assert.assertTrue(wd.findElement(By.linkText("Assign User Access")).isDisplayed());
 	wd.findElement(By.linkText("Assign User Access")).click();
 	
 	}
  
  
  
  
  
  
  
  
  
}
