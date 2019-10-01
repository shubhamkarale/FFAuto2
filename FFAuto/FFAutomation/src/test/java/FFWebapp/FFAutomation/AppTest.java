package FFWebapp.FFAutomation;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;
 
public class AppTest  extends FFWebApp.Functions.Setup {
	
	public FFWebApp.Functions.UrlCall url = new FFWebApp.Functions.UrlCall(); 
	
	public FFWebApp.Functions.Products bc = new FFWebApp.Functions.Products(); 
	
	public FFWebApp.Functions.ClientForm cf = new FFWebApp.Functions.ClientForm(); 
	
	public FFWebApp.Functions.FollowUp fu = new FFWebApp.Functions.FollowUp(); 
	
	public FFWebApp.Functions.FormSubmit fs = new FFWebApp.Functions.FormSubmit(); 
	 
	public FFWebApp.Functions.Payment  p = new FFWebApp.Functions.Payment(); 
	
	public FFWebApp.Functions.Save_Bill  s = new FFWebApp.Functions.Save_Bill(); 
	
	public FFWebApp.Functions.CompanyLevelMenu  menu = new FFWebApp.Functions.CompanyLevelMenu(); 
	
	public FFWebApp.Functions.UserCreationForm  usform = new FFWebApp.Functions.UserCreationForm(); 
	
	public FFWebApp.Functions.AccessTemplate  access = new FFWebApp.Functions.AccessTemplate();
	
	@Test (priority=1)
  public void EnquiryCreation() throws IOException, InterruptedException {
		
		url.DashboardPage();
		url.EnquiryPage();
		cf.formfilling();
		fu.SaveFollowUp();
		fs.Enquiry();
  }
	
	@Test (priority=2)
	  public void MemberCreation() throws IOException, InterruptedException, AWTException {
			
			url.DashboardPage();
			url.MemberPage();
			cf.formfilling();
			fs.Member();
			bc.anyProduct();
			p.Multi_Pay();
			s.SavememBill();
			
			System.out.println("test");
	}
	
	@Test (priority=3)
	  public void trialbill() throws IOException, InterruptedException, AWTException {
		
			url.DashboardPage();
			url.TrialPage();
			cf.formfilling();
			fu.SaveFollowUp();
			fs.Trial();
			s.SaveTrial();  
	}
	
	@Test (priority=4)
	  public void UserCreation() throws IOException, InterruptedException, AWTException {
			
			url.CenterSelectionPage();
			menu.User_New_Create();
			usform.createUserForm();
			usform.Userverify();
			
			
	}
	
	@Test (priority=5)
	  public void Userassigntemplate() throws IOException, InterruptedException, AWTException {
			
			menu.user_old_assign_user_access();
			usform.AssignTemplate();
			
	}
	
	@Test (priority=6)
	  public void EditUser() throws IOException, InterruptedException, AWTException {
			
			menu.user_old_list();
			usform.editUserForm();
			
	}
	
	@Test (priority=7)
	  public void AccessTEM() throws IOException, InterruptedException, AWTException {
			
			menu.user_old_user_access_tem();
			access.Access_tem_page();
			
	}
	
}
