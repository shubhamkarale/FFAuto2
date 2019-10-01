package FFWebapp.Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class FormSubmit extends Setup{ 
	
	String MemberId;
	
	@Test
	public void Enquiry(){
		
		wd.findElement(By.id("btnSaveEnq")).click();
		  
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LabelIDType")));
		  
		  MemberId = wd.findElement(By.id("divMemberId")).getText();
		  
		  System.out.println("Enquiry Created SuccessFully id = " + MemberId);
		
	}
	
	@Test
	public void Member(){
		
		 wd.findElement(By.id("btnSaveEnq")).click();
		  
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("PayTypeCash")));
		  
//		  String Url = wd.getCurrentUrl();
				  
		 // MemberId = wd.findElement(By.xpath("//*[@id=\"fullscreen\"]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div[2]/table/tbody/tr/td/table/tbody/tr[2]/td/div[2]/table/tbody/tr/td/div[2]/div/div[6]/div[2]/div[2]")).getText();
		  
		 // System.out.println("Bill Page load SuccessFully for Member Id = " + MemberId);	
		
	}
	
	
	@Test
	public void Trial(){
		
		 wd.findElement(By.id("btnSaveEnq")).click();
		  
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customerid")));
		  
		  MemberId = wd.findElement(By.id("customerid")).getText(); 
		  
		  System.out.println("Trial Page load for member id = " + MemberId);
		
	}
	
	public void  FollowUp() {

	 String getUrl = wd.getCurrentUrl();

	  if(getUrl.contains("pagetype=createenquiry")) {
		  
		  wd.findElement(By.id("btnSaveEnq")).click();
		  
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LabelIDType")));
		  
		  MemberId = wd.findElement(By.id("divMemberId")).getText();
		  
		  System.out.println("Enquiry Created SuccessFully id = " + MemberId);
		  
	  } else if(getUrl.contains("pagetype=trial")) {
		  
		  wd.findElement(By.id("btnSaveEnq")).click();
		  
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customerid")));
		  
		  MemberId = wd.findElement(By.id("customerid")).getText(); 
		  
		  System.out.println("Trial Page load for member id = " + MemberId);
		  
	  } else if(getUrl.contains("pagetype=member")) {
		  
		  
		  wd.findElement(By.id("btnSaveEnq")).click();
		  
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("PayTypeCash")));
		  
		  MemberId = wd.findElement(By.xpath("//*[@id=\"fullscreen\"]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div[2]/table/tbody/tr/td/table/tbody/tr[2]/td/div[2]/table/tbody/tr/td/div[2]/div/div[6]/div[2]/div[2]")).getText();
		  
		  System.out.println("Bill Page load SuccessFully for Member Id = " + MemberId);	  
		  
	  } else {
		  System.out.println("Page Not found");
	  }

}

}