package FFWebapp.Functions;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ClientForm extends Setup {

	@Test
	public void formfilling() throws IOException, InterruptedException {
		
		
		
		if (wd.findElements(By.id("meco_IDType")).size()!=0) {
			
			// national ID

			if (wd.findElement(By.id("meco_nationalIn")).isDisplayed()) {

				wd.findElement(By.id("meco_nationalIn")).sendKeys(RandomStringUtils.randomNumeric(10));

			} else {

				// System.out.println("national ID is not compulsory");
			}

		} else {
			// System.out.println("meco_MiddleName is not compulsory");
		}
		

		// FirstNAme
		if (wd.findElement(By.id("meco_Firstname")).isDisplayed()) {
				
			wd.findElement(new ByAll(By.id("meco_Firstname"),By.name("meco_Firstname_Required"), By.xpath("//*[@id=\"meco_Firstname\"]"))).sendKeys(RandomStringUtils.randomAlphabetic(5));

			String FName = wd.findElement(By.id("meco_Firstname")).getAttribute("value").trim();
			
			System.out.println("Firstname : " +FName);
			
			if(FName.matches("")) {
			wd.findElement(By.id("meco_Firstname")).sendKeys(RandomStringUtils.randomAlphabetic(5));
			}else {
				System.out.println("Firstname already Filled");
			}
			
		} else {
			// System.out.println("Field meco_Firstname is not compulsory");
		}

		if (wd.findElement(By.id("meco_MiddleName")).isDisplayed()) {
			wd.findElement(By.id("meco_MiddleName")).sendKeys(RandomStringUtils.randomAlphabetic(5));
		} else {
			// System.out.println("meco_MiddleName is not compulsory");
		}

		// Last Name

		if (wd.findElement(By.id("meco_lastName")).isDisplayed()) {
			wd.findElement(By.id("meco_lastName")).sendKeys(RandomStringUtils.randomAlphabetic(5));
		} else {
			// System.out.println("Field error is not compulsory");
		}

		// Gender

		if (wd.findElement(By.id("meco_Gender")).isDisplayed()) {

			new Select(wd.findElement(By.id("meco_Gender"))).selectByIndex(1);

		} else {
			// System.out.println("meco_Gender is not compulsory");
		}

		if (wd.findElement(By.id("meco_HostuserID")).isDisplayed()) {

			new Select (wd.findElement(By.id("meco_HostuserID"))).selectByIndex(3);
			// Select date = new Select(wd.findElement(By.xpath("ui-datepicker-year")));
			// date.selectByValue("2019");
//			wd.findElement(By.linkText("1")).click();

		} else {
			// System.out.println("meco_DateOfBirth is not compulsory");
		}
		
//		if (wd.findElement(By.id("meco_EnrollmentDate")).isDisplayed()) {
//
//			wd.findElement(By.id("meco_EnrollmentDate")).click();
//			// Select date = new Select(wd.findElement(By.xpath("ui-datepicker-year")));
//			// date.selectByValue("2019");
//			wd.findElement(By.linkText("1")).click();
//
//		} else {
//			// System.out.println("meco_DateOfBirth is not compulsory");
//		}

		// source

		if (wd.findElement(By.id("meco_Source")).isDisplayed()) {

			Select source = new Select(wd.findElement(By.id("meco_Source")));
			source.selectByIndex(2);
			if (wd.findElement(By.id("meco_Source_other")).isDisplayed()) {

				wd.findElement(By.id("meco_Source_other")).sendKeys(RandomStringUtils.randomAlphabetic(5));
			} else {
				// System.out.println("Other as source not Found")
			}

		} else {

			// System.out.println("meco_Source is not compulsory");
		}
		Thread.sleep(2000);

		// Service interested in
		if (wd.findElement(
				By.xpath("//span[@id='ddcl-chklstServicesInterestedIn']//span[@class='ui-dropdownchecklist-text']"))
				.isDisplayed()) {

			wd.findElement(By.xpath(
					"//span[@id='ddcl-chklstServicesInterestedIn']//span[@class='ui-dropdownchecklist-text']"))
			.click();

			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ddcl-chklstServicesInterestedIn-i0")))
			.click();

		} else {
			// System.out.println("Service interested in is not compulsory");
		}

		// Fitness Goal

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("ddcl-meco_FitnessGoal"))).clear();
		if (wd.findElement(By.id("ddcl-meco_FitnessGoal")).isDisplayed()) {

			wd.findElement(By.xpath("//*[@id=\"ddcl-meco_FitnessGoal\"]/span")).click();
			WebElement goal = wd.findElement(By.id("ddcl-meco_FitnessGoal-i0"));

			goal.click();

		} else {
			// System.out.println("meco_FitnessGoal is not compulsory");
		}

		// DOB

		if (wd.findElement(By.id("meco_DateOfBirth")).isDisplayed()) {
			
			wd.findElement(By.id("meco_DateOfBirth")).click();
			
			new Select (wd.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]"))).selectByValue("1986");
			
			wd.findElement(By.linkText("1")).click();
			
			
			
//			JavascriptExecutor jse = (JavascriptExecutor) wd;
//			
//			wd.findElement(By.id("meco_DateOfBirth")).click();
//			
//			wd.findElement(By.linkText("1")).click();
//			
//			if (wd.findElements(By.id("errorlist_divitems")).size() != 0) {
//
//				String ErrorMsg = wd.findElement(By.id("errorlist_divitems")).getText();
//				
//				wd.findElement(By.linkText("Close")).click();
//
//				String no1 = ErrorMsg.substring(21, 23).trim();
//
//				System.out.println("Minimum Age is " +no1);
//
//				int number1 = Integer.parseInt(no1);
//
//				String year = Integer.toString(2018 - number1);
//
//				System.out.println("D.O.B Selected : "+year);

//				Date date = null; // your date
//				// Choose time zone in which you want to interpret your Date
//				Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
//				cal.setTime(date);
//				int year1 = cal.get(Calendar.YEAR);
//				
//				int month = cal.get(Calendar.MONTH);
//				int day = cal.get(Calendar.DAY_OF_MONTH);
//				
//			jse.executeScript("$('#meco_DateOfBirth').val('1-Sep-"+Integer.toString(2018 - number1)+"')");
//
////		wd.findElement(By.xpath("//*[@id=\"modal_error\"]/div/div/div[2]/a")).click();
////
//				wd.findElement(By.id("meco_DateOfBirth")).click();
//				
//				wd.findElement(By.linkText("1")).click();
////
//				wd.findElement(By.linkText("1")).click();
//				Thread.sleep(2000);
//				// wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/select[2]")).click();
//				new Select(wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/select[2]")))
//				.selectByVisibleText(year);
//				wd.findElement(By.linkText("22")).click();
//			
			
			
//			WebElement DOB = wd.findElement(By.id("meco_DateOfBirth"));
//			
//			
//			
//			jse.executeScript("CheckValue_date(this);");
//			jse.executeScript("arguments[0].onblur()", DOB);

//			wd.findElement(By.xpath("/html/body/div[3]/div[2]/button[2]")).click();									

			// wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/select[2]")).click();
//			Select date = new Select(wd.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/select[2]")));
//			date.selectByValue("2016");
//			wd.findElement(By.linkText("22")).click();

//			Thread.sleep(3000);

			} else {
				
			}

//		} else {
//			// System.out.println("meco_DateOfBirth is not compulsory");
//		}

		// Anniversary

		if (wd.findElement(By.id("img_meco_Anniversary")).isDisplayed()) {
			wd.findElement(By.id("img_meco_Anniversary")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("17"))).click();
		} else {

			// System.out.println("Anniversary is not compulsory");
		}

		
				// national ID

					if (wd.findElement(By.id("meco_nationalIn")).isDisplayed()) {

						wd.findElement(By.id("meco_nationalIn")).sendKeys(RandomStringUtils.randomNumeric(10));

					} else {

						// System.out.println("national ID is not compulsory");
					}
		
		
		// spouse name
		if (wd.findElement(By.id("meco_SpouseName")).isDisplayed()) {

			wd.findElement(By.id("meco_SpouseName")).sendKeys(RandomStringUtils.randomAlphabetic(5));

		} else {

			// System.out.println("spouse name is not compulsory");
		}

		// Height

		if (wd.findElement(By.id("meco_Height")).isDisplayed()) {

			wd.findElement(By.id("meco_Height")).sendKeys(RandomStringUtils.randomNumeric(1));

		} else {

			// System.out.println("Height is not compulsory");
		}

		// Weight

		if (wd.findElement(By.id("meco_weight")).isDisplayed()) {

			wd.findElement(By.id("meco_weight")).sendKeys(RandomStringUtils.randomNumeric(2));
		} else {

			// System.out.println("Weight is not compulsory");
		}

		// Medical Alert

		if (wd.findElement(By.id("meco_MedicalAlert")).isDisplayed()) {

			wd.findElement(By.id("meco_MedicalAlert")).sendKeys(RandomStringUtils.randomNumeric(2));
		} else {

			// System.out.println("Medical Alert is not compulsory");
		}

		// personal int

		if (wd.findElement(By.xpath("//*[@id=\"ddcl-chklstPersonalInterest\"]/span")).isDisplayed()) {

			wd.findElement(By.xpath("//*[@id=\"ddcl-chklstPersonalInterest\"]/span")).click();
			WebElement PI = wd.findElement(By.id("ddcl-chklstPersonalInterest-i0"));
			PI.click();

		} else {

			// System.out.println("Medical Alert is not compulsory");
		}

		// Language

		if (wd.findElement(
				By.xpath("//span[@id='ddcl-meco_preferred_language']//span[@class='ui-dropdownchecklist-selector']"))
				.isDisplayed()) {

			wd.findElement(By.xpath(
					"//span[@id='ddcl-meco_preferred_language']//span[@class='ui-dropdownchecklist-selector']"))
			.click();

			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ddcl-meco_preferred_language-i0")))
			.click();

		} else {
			// System.out.println("Service interested in is not compulsory");
		}

		// Referred by

		if (wd.findElement(By.id("meco_ReferredBy")).isDisplayed()) {

			wd.findElement(By.id("chkNoReferedBy")).click();

		} else {

			// System.out.println("Referred by is not compulsory");
		}

		// Cl
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if (wd.findElement(By.id("meco_clientlanguage")).isDisplayed()) {

			Select Cl = new Select(wd.findElement(By.id("meco_clientlanguage")));
			Cl.selectByIndex(0);

		} else {
			// System.out.println("meco_clientlanguage is not compulsory");
		}

		// Nationlity

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (wd.findElement(By.id("meco_Nationality")).isDisplayed()) {

			Select nationality = new Select(wd.findElement(By.id("meco_Nationality")));
			nationality.selectByValue("Indian");

		} else {
			// System.out.println("meco_Nationality is not compulsory");
		}

		// WrkTime

		if (wd.findElement(By.xpath("//*[@id=\"ddcl-meco_PreferredWorkOuttime\"]/span")).isDisplayed()) {

			wd.findElement(By.xpath("//*[@id=\"ddcl-meco_PreferredWorkOuttime\"]/span")).click();

			WebElement WT = wd.findElement(By.id("ddcl-meco_PreferredWorkOuttime-i0"));

			WT.click();
		} else {
			// System.out.println("WrkTime is not compulosry");
		}
		
		// Tax Number
		if (wd.findElement(By.id("meco_taxnumber")).isDisplayed()) {

			wd.findElement(By.id("meco_taxnumber")).sendKeys(RandomStringUtils.randomNumeric(10));;

		} else {
			// System.out.println("WrkTime is not compulosry");
		}

		// mobile no 1

		if (wd.findElement(By.id("meco_MobileNo")).isDisplayed()) {
			
			wd.findElement(By.id("meco_MobileNo")).click();

			wd.findElement(By.id("meco_MobileNo")).sendKeys(RandomStringUtils.randomNumeric(9));
			
			wd.findElement(By.id("meco_SecondMobileNo")).click();
			
			Thread.sleep(3000);

			if (wd.findElement(By.id("errorlist_divitems")).isDisplayed()) {

				String ErrorMsg = wd.findElement(By.id("errorlist_divitems")).getText();

				String no = ErrorMsg.substring(28, 31).trim();

				int number = Integer.parseInt(no);

				wd.findElement(By.xpath("//*[@id=\"modal_error\"]/div/div/div[2]/a")).click();

				System.out.println("Min Mobile Digits : "+no);

					wd.findElement(By.id("meco_MobileNo")).clear();

					wd.findElement(By.xpath("//*[@id=\"modal_error\"]/div/div/div[2]/a")).click();

					wd.findElement(By.id("meco_MobileNo")).sendKeys(RandomStringUtils.randomNumeric(number));
			}else {
			}

				// Email
				wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


				if (wd.findElement(By.id("meco_Emailaddress")).isDisplayed()) {

					WebElement Email = wd.findElement(By.id("meco_Emailaddress"));
					Email.sendKeys("username" + RandomStringUtils.randomNumeric(2) + "@sgrfh.com");
				} else {
					// System.out.println("meco_Emailaddress is not compulsory");
				}

				// emergency Contact person

				if (wd.findElement(By.id("meco_emergencyContactPerson")).isDisplayed()) {

					wd.findElement(By.id("meco_emergencyContactPerson")).click();
					//wd.findElement(By.id("ddcl-meco_preferred_language-i0")).click();
					wd.findElement(By.id("meco_emergencyContactPerson")).sendKeys(RandomStringUtils.randomNumeric(10));

				} else {

					// System.out.println("meco_emergencyContactPerson is not compulsory");
				}
				
				// emergency Contact no
				if (wd.findElement(By.id("meco_emergencyContactNo")).isDisplayed()) {

					wd.findElement(By.id("meco_emergencyContactNo")).sendKeys(RandomStringUtils.randomNumeric(10));

				} else {

					// System.out.println("meco_emergencyContactNo is not compulsory");
				}

				// Access Card issued Date

				if (wd.findElement(By.id("img_meco_accesscardissuedate")).isDisplayed()) {

					wd.findElement(By.id("img_meco_accesscardissuedate")).click();

					wd.findElement(By.linkText("1")).click();

				} else {

					// System.out.println("Access Card issued Date is not compulsory");
				}

				// occupation
				if (wd.findElement(By.id("meco_Occuption")).isDisplayed()) {

					Select occ = new Select(wd.findElement(By.id("meco_Occuption")));
					occ.selectByIndex(5);

				} else {
					// System.out.println("meco_Occuption is not compulosry");
				}

				// Org

				try {
				
				if (wd.findElement(By.id("cb_meco_NameofOrg")).isDisplayed()) {

					wd.findElement(By.id("cb_meco_NameofOrg")).sendKeys("asdas");

				} else {
					// System.out.println("Org is not compulsory");
				}
				}catch(Exception e) {
					System.out.println("catch print "+e);
				}
				// Facebook Id

				if (wd.findElement(By.id("meco_facebookId")).isDisplayed()) {

					wd.findElement(By.id("meco_facebookId")).sendKeys(RandomStringUtils.randomAlphabetic(6));

				} else {

					// System.out.println("meco_facebookId is not compulsory");
				}

				// Orkut Id

				if (wd.findElement(By.id("meco_orkutId")).isDisplayed()) {

					wd.findElement(By.id("meco_orkutId")).sendKeys(RandomStringUtils.randomAlphabetic(6));

				} else {

					// System.out.println("meco_orkutId is not compulsory");
				}

				// Linked In
				if (wd.findElement(By.id("meco_linkedinId")).isDisplayed()) {

					wd.findElement(By.id("meco_linkedinId")).sendKeys(RandomStringUtils.randomAlphabetic(6));

				} else {

					// System.out.println("meco_linkedinId is not compulsory");
				}
				// Twitter Id

				if (wd.findElement(By.id("meco_twitterId")).isDisplayed()) {

					wd.findElement(By.id("meco_twitterId")).sendKeys(RandomStringUtils.randomAlphabetic(6));

				} else {

					// System.out.println("meco_twitterId is not compulsory");
				}

				// Ethnicity

				if (wd.findElement(By.id("meco_ethnicity")).isDisplayed()) {

					Select Cl = new Select(wd.findElement(By.id("meco_ethnicity")));
					Cl.selectByIndex(1);

				} else {
					// System.out.println("meco_clientlanguage is not compulsory");
				}

				// Gen Info

				if (wd.findElement(By.id("meco_generalInfo")).isDisplayed()) {

					wd.findElement(By.id("meco_generalInfo")).sendKeys("non");

				} else {
					// System.out.println("meco_generalInfo is not compulsory");
				}

				// meco_personalizeMessage
				if (wd.findElement(By.id("meco_personalizeMessage")).isDisplayed()) {

					wd.findElement(By.id("meco_personalizeMessage")).sendKeys(RandomStringUtils.randomAlphabetic(6));

				}
				// Blood Group

				if (wd.findElement(By.id("meco_bloodgroup")).isDisplayed()) {

					Select BG = new Select(wd.findElement(By.id("meco_bloodgroup")));
					BG.selectByIndex(1);

				} else {
					// System.out.println("meco_bloodgroup is not compulosry");
				}

				// Enquiry type

				if (wd.findElement(By.id("meco_EnquiryType")).isDisplayed()) {

					Select EQ = new Select(wd.findElement(By.id("meco_EnquiryType")));
					EQ.selectByIndex(6);
				} else {
					// System.out.println("meco_bloodgroup is not compulosry");
				}

				// bldg name
				if (wd.findElements(By.id("meco_bldngName")).size() != 0) {

					wd.findElement(By.id("meco_bldngName")).sendKeys("non");

				} else {
					// System.out.println("meco_bldngName is not compulsory");
				}

				// Street
				if (wd.findElement(By.id("meco_addressline1")).isDisplayed()) {

					wd.findElement(By.id("meco_addressline1")).sendKeys("non");

				} else {
					// System.out.println("meco_addressline1 is not compulsory");
				}

				// pin code
				if (wd.findElement(By.id("meco_addrPinCode")).isDisplayed()) {

					wd.findElement(By.id("meco_addrPinCode")).sendKeys(RandomStringUtils.randomNumeric(6));

				} else {
					// System.out.println("meco_addrPinCode is not compulsory");
				}
				// Location
				if (wd.findElement(By.id("meco_addrLocatoin")).isDisplayed()) {
					Select loc = new Select(wd.findElement(By.id("meco_addrLocatoin")));
					loc.selectByIndex(3);

				} else {
					// System.out.println("meco_addrLocatoin is not compulsory");
				}

			}
		}
	}
