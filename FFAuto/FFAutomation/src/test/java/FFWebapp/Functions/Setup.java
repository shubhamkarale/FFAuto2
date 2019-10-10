package FFWebapp.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

public class Setup {

public static WebDriver wd;
public static WebDriverWait wait;

String url = "https://demo.fitnessforce.com/";

String username = "automation";

String Password = "grip@123";

String TenantName = "only";

String TenantId ="1006";

String CompanyId = "27";

String centeralize = "yes";


@BeforeSuite
public void startUp(){

  	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
  	
  	wd = new ChromeDriver();  	
  	wd.get(url+"ffDefault.aspx");    
    wd.manage().window().maximize();    
    wd.manage().deleteAllCookies();    
    wait = new WebDriverWait (wd, 60);    
    wd.findElement(By.id("txtUsername")).sendKeys(username);    
    wd.findElement(By.id("txtPassword")).sendKeys(Password);	
	wd.findElement(By.id("SignIn")).click();// click on sign in	
	
}

}
