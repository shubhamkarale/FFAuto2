package FFWebapp.Functions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Payment extends Setup {

	@Test
	public void FullPay() throws InterruptedException {

		WebElement element = wd.findElement(By.xpath("//td[@class='padleft5 wht20font ng-binding']"));
		((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);

		String Amount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//*[@id=\"fullscreen\"]/div[1]/div[3]/table/tbody/tr[1]/td[3]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[6]/td[3]")))
				.getText().substring(1);

		System.out.println("Amount to be payable :" + Amount);

		wd.findElement(By.id("PayTypeCash")).click();
		wd.findElement(By.id("input_002")).sendKeys(Amount);
		Thread.sleep(2000);
		wd.findElement(By.id("Pay_Now")).click();

	}

	@Test
	public void Half_Pay() {

		String Amount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//*[@id=\"fullscreen\"]/div[1]/div[3]/table/tbody/tr[1]/td[3]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td/table/tbody/tr[6]/td[3]")))
				.getText().substring(1);

		System.out.println("Amount to be paid :" + Amount);

		int Amt = Integer.parseInt(Amount);

		int half_amt = Amt / 2;

		System.out.println("Amount paid " +half_amt);

		String Amount_half = Integer.toString(half_amt);

		wd.findElement(By.id("PayTypeCash")).click();

		wd.findElement(By.id("input_002")).sendKeys(Amount_half);
		
		WebElement element = wd.findElement(By.id("Pay_Now"));
		((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);

		
		wd.findElement(By.id("Pay_Now")).click();

		wd.findElement(By.id("Show_followUp")).click();

		Select Follow_up_type = new Select(wd.findElement(By.xpath(
				"//*[@id=\"fullscreen\"]/div[1]/div[3]/table/tbody/tr[1]/td[4]/table/tbody/tr[2]/td/div[2]/div[10]/div[2]/table/tbody/tr[1]/td[1]/div[2]/select")));
		Follow_up_type.selectByVisibleText("Balance");
		Select Response = new Select(wd.findElement(By.xpath(
				"//*[@id=\"fullscreen\"]/div[1]/div[3]/table/tbody/tr[1]/td[4]/table/tbody/tr[2]/td/div[2]/div[10]/div[2]/table/tbody/tr[2]/td[1]/div[2]/select")));
		Response.selectByVisibleText("Follow Up Again");
		Select Convertibility = new Select(wd.findElement(By.xpath(
				"//*[@id=\"fullscreen\"]/div[1]/div[3]/table/tbody/tr[1]/td[4]/table/tbody/tr[2]/td/div[2]/div[10]/div[2]/table/tbody/tr[2]/td[2]/div[2]/select")));
		Convertibility.selectByVisibleText("Hot");
		Select Contact_type = new Select(wd.findElement(By.xpath(
				"//*[@id=\"fullscreen\"]/div[1]/div[3]/table/tbody/tr[1]/td[4]/table/tbody/tr[2]/td/div[2]/div[10]/div[2]/table/tbody/tr[3]/td/div[2]/select")));
		Contact_type.selectByVisibleText("Phone");
		wd.findElement(By.xpath(
				"//*[@id=\"fullscreen\"]/div[1]/div[3]/table/tbody/tr[1]/td[4]/table/tbody/tr[2]/td/div[2]/div[10]/div[2]/table/tbody/tr[6]/td/div/textarea"))
				.sendKeys("test");
		wd.findElement(By.xpath(
				"//*[@id=\"fullscreen\"]/div[1]/div[3]/table/tbody/tr[1]/td[4]/table/tbody/tr[2]/td/div[2]/div[10]/div[3]/div[2]/div"))
				.click();
		

	}

	@Test
	public void Multi_Pay() {
		
		
		String Amount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[3]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[3]")))
				.getText().replace("₹", "").replace("/-", "");
		System.out.println("Amount to be payable :" + Amount);
		
		
		double Amt = Integer.parseInt(Amount);
		double qtr_amt = Amt / 2;
		double AmountP = (double) Math.round(qtr_amt*100)/100;
		System.out.println(Math.round(AmountP));
		
		for(int i=1; i<=10;i++) {
			
			if(i==1) {
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("PayTypeDebit Card"))).click();
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input_002"))).sendKeys(Double.toString(AmountP));
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input_004"))).sendKeys(RandomStringUtils.randomNumeric(6));
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input_005"))).click();
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("20"))).click();
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input_006"))).sendKeys(RandomStringUtils.randomNumeric(6));
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"input_007\"]"))).click();
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("20"))).click();
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input_008"))).sendKeys("SBI");
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bankName!"))).sendKeys("Andheri");
				  new Select(wd.findElement(By.id("DDTYPE"))).selectByIndex(2);
				  WebElement element = wd.findElement(By.id("Pay_Now"));
				  ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
				  wd.findElement(By.id("Pay_Now")).click();
				  
					
				  
				
			}else if(i==2) {
				
				String secpayAmount = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[3]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[3]")))
						.getText().replace("₹", "").replace("/-", "");
				System.out.println("Amount to be payable :" + secpayAmount);
				
				
				double secpayAmt = Integer.parseInt(secpayAmount);
				double secpayamt = secpayAmt / 2;
				double secAmountP = (double) Math.round(secpayamt*100)/100;
				System.out.println(Math.round(secAmountP));
				
				 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("PayTypeCredit Card"))).click();
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input_002"))).sendKeys(Double.toString(secAmountP));
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input_004"))).sendKeys(RandomStringUtils.randomNumeric(6));
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input_005"))).click();
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("20"))).click();
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input_006"))).sendKeys(RandomStringUtils.randomNumeric(6));
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input_007"))).click();
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("20"))).click();
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("input_008"))).sendKeys("SBI");
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("bankName!"))).sendKeys("Andheri");
				  new Select(wd.findElement(By.id("cardtype"))).selectByIndex(2);
				  wd.findElement(By.id("Pay_Now")).click();	
				
				
				
			}else {
				
				String balance = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
						"/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[3]/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr[3]/td[3]")))
						.getText().replace("₹", "").replace("/-", "");
				System.out.println("balance to be payable :" + balance);
				
				wd.findElement(By.id("PayTypeCash")).click();
				wd.findElement(By.id("input_002")).sendKeys(balance);
				  wd.findElement(By.id("Pay_Now")).click();	
				break;
			}
			
		}
		
	}

	
	
	
}
