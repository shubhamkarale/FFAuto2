package FFWebapp.Functions;

import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Products extends Setup {


	@Test
	public void anyProduct() throws InterruptedException {

		for (int i = 1; i <= 100; i++) {

			if (wd.findElements(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[2]/div[22]/div[1]/div[1]/form[1]/div[3]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/div[2]/table[1]/tbody[1]/tr[" + i + "]/td[1]/div[1]/table[1]")).size() != 0) {

				wd.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[2]/div[22]/div[1]/div[1]/form[1]/div[3]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/div[2]/table[1]/tbody[1]/tr[" + i + "]/td[1]/div[1]/table[1]")).click();

				wd.findElement(By.xpath("/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[2]/div[22]/div[1]/div[1]/form[1]/div[3]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[2]/div[2]/table[1]/tbody[1]/tr[" + i + "]/td[1]/div[1]/table[1]")).click();

				Thread.sleep(5000);

				String ProdList = "/html[1]/body[1]/table[1]/tbody[1]/tr[1]/td[2]/div[22]/div[1]/div[1]/form[1]/div[3]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[2]/td[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[" + i + "]/div[1]/div[1]";

				if (wd.findElements(By.xpath(ProdList)).size() != 0) {

					wd.findElement(By.xpath(ProdList)).click();

					wait.until(ExpectedConditions.presenceOfElementLocated(new ByAll(By.xpath("//*[@id='AddProdBtn']/strong"),By.xpath("/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[3]/div[2]/div[2]/div/div/div[2]/div/strong")))).click();

					break;
				} else {

					System.out.println("No Product Configured");
				}

			} else {

				System.out.println("Product Type Not Configured");
			}
		}
	}
	@Test
	public void SelectPackage() throws InterruptedException 
	{

		for (int i = 1; i <= 100; i++) 
		{

			// Product type selection start
			if (wd.findElements(By.xpath("/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/div[2]/table/tbody/tr[" +(2+ i) + "]/td/div/table")).size() != 0) 
			{

				if (i == 1) {

					wd.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/div[2]/table/tbody/tr["+ (2+ i)+ "]/td/div/table")).click();

					wd.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/div[2]/table/tbody/tr["+ (2+ i) + "]/td/div/table")).click();

				} else {

					wd.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/div[2]/table/tbody/tr["+  (2+ i) + "]/td/div/table")).click();

				}
				// Product type selection End

				for (int j = 1; j <= 100; j++) 
				{

					// Package selection start
					String Package = "/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[3]/div[2]/div[1]/div/table[1]/tbody/tr[1]/td[1]/div/div";

					if (wd.findElements(By.xpath(Package)).size() != 0) 
					{

						wd.findElement(By.xpath(Package)).click();

						if (wd.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[3]/div[2]/div[2]/div/table[1]/tbody/tr/td[2]/div[1]")).isDisplayed()) 
						{

							System.out.println("Package Found");

							wait.until(ExpectedConditions.presenceOfElementLocated(By.id("AddProdBtn"))).click();

							break;

						} else 
						{

							System.out.println("package not found");

						}

					}
					// Package selection End
				}
			}
		}
	}
	@Test
	public void SelectCampaign() throws InterruptedException {

		for (int i = 1; i <= 100; i++) {

			if (wd.findElements(By.xpath("/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/div[2]/table/tbody/tr[" + i + "]/td/div/table")).size() != 0) {

				if (i == 1) {

					wd.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/div[2]/table/tbody/tr[" + i + "]/td/div/table")).click();

					wd.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/div[2]/table/tbody/tr[" + i + "]/td/div/table")).click();

					break;

				} else {

					wd.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/div[2]/table/tbody/tr[" + i + "]/td/div/table")).click();
					break;	
				}
			}
		}

		// Campagin selection Starts
		for (int j = 1; j <= 100; j++) {

			String Campaign = "/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[3]/div[2]/div[1]/div/table[1]/tbody/tr[1]/td[1]/div/div";

			if (wd.findElements(By.xpath(Campaign)).size() != 0) {

				wd.findElement(By.xpath(Campaign)).click();

				if (wd.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[3]/div[2]/div[2]/div/table[1]/tbody/tr/td[2]/div[3]")).isDisplayed()) {

					System.out.println("Campaign Found");

					wait.until(ExpectedConditions.presenceOfElementLocated(By.id("AddProdBtn"))).click();

					break;

				} else {

					wd.findElement(By.id("BackBtn")).click();

					System.out.println("Campaign not found");
				}

			}
//
			// Campagin selection End
		}
	}

	public void SelectProduct() throws InterruptedException {

		for (int i = 1; i <= 100; i++) {

			// Product Type Selection Start

			if (wd.findElements(By.xpath("/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/div[2]/table/tbody/tr[" + i + "]/td/div/table")).size() != 0) {

				if (i == 1) {

					wd.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/div[2]/table/tbody/tr[" + i + "]/td/div/table")).click();

					wd.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/div[2]/table/tbody/tr[" + i + "]/td/div/table")).click();

					Thread.sleep(2000);

					break;

				} else {

					wd.findElement(By.xpath("/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/div[2]/table/tbody/tr[" + i + "]/td/div/table")).click();

					Thread.sleep(2000);

					break;	
				}
			}
		}
		// Product Type Selection End

		// Product Selection Start
		Boolean flag_Productadded = false;

		for (int j = 1; j <= 100; j++) 
		{		   	

			String Package = "/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[3]/div[2]/div[2]/div/table[1]/tbody/tr/td[2]/div[1]";

			String Campaign1 = "/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[3]/div[2]/div[2]/div/table[1]/tbody/tr/td[2]/div[2]";

			String Campaign2 = "/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[3]/div[2]/div[2]/div/table[1]/tbody/tr/td[2]/div[3]";

			String Contract = "/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[3]/div[2]/div[2]/div/table[1]/tbody/tr/td[2]/div[4]";

			for (int k = 1; k <= 2; k++) 
			{	

				String Product = "/html/body/table/tbody/tr/td[2]/div[22]/div/div[1]/form/div[3]/div[1]/div[3]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[3]/div[2]/div[1]/div/table[1]/tbody/tr["+j+"]/td["+k+"]/div/div[1]";

				if (wd.findElements(By.xpath(Product)).size() !=0) {

					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Product))).click(); // Product list click

					Thread.sleep(2000);

					if (wd.findElement(By.xpath(Package)).isDisplayed()|| wd.findElement(By.xpath(Campaign1)).isDisplayed() 
							|| wd.findElement(By.xpath(Campaign2)).isDisplayed() || wd.findElement(By.xpath(Contract)).isDisplayed() ) 
					{

						System.out.println("Product not found");

						wd.findElement(By.id("BackBtn")).click();

						Thread.sleep(2000);

					} 
					else 
					{

						wait.until(ExpectedConditions.presenceOfElementLocated(By.id("AddProdBtn"))).click();

						System.out.println("Product found");

						Thread.sleep(2000);
						flag_Productadded=true;
						break;

					}    	 
				}
				else 
				{
					System.out.println("No More Product Found");
					break;

				}
			}

			if(flag_Productadded) 
			{
				break;
			}
		}

	}

	// Product Selection Start

}



