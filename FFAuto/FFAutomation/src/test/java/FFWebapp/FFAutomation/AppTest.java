package FFWebapp.FFAutomation;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;
 
public class AppTest  extends FFWebapp.Functions.Setup {
	
	public FFWebapp.Functions.UrlCall url = new FFWebapp.Functions.UrlCall(); 
	
	public FFWebapp.Functions.Products bc = new FFWebapp.Functions.Products(); 
	
	public FFWebapp.Functions.ClientForm cf = new FFWebapp.Functions.ClientForm(); 
	
	public FFWebapp.Functions.FollowUp fu = new FFWebapp.Functions.FollowUp(); 
	
	public FFWebapp.Functions.FormSubmit fs = new FFWebapp.Functions.FormSubmit(); 
	 
	public FFWebapp.Functions.Payment  p = new FFWebapp.Functions.Payment(); 
	
	public FFWebapp.Functions.Save_Bill  s = new FFWebapp.Functions.Save_Bill(); 
	
	public FFWebapp.Functions.CompanyLevelMenu  menu = new FFWebapp.Functions.CompanyLevelMenu(); 
	
	public FFWebapp.Functions.UserCreationForm  usform = new FFWebapp.Functions.UserCreationForm(); 
	
	public FFWebapp.Functions.AccessTemplate  access = new FFWebapp.Functions.AccessTemplate();
	
//	@Test (priority=1)
//  public void EnquiryCreation() throws IOException, InterruptedException {
//		
//		url.DashboardPage();
//		url.EnquiryPage();
//		cf.formfilling();
//		fu.SaveFollowUp();
//		fs.Enquiry();
//  }
	
	@Test (priority=2)
	  public void MemberCreation() throws IOException, InterruptedException, AWTException {
			
			url.DashboardPage();
			url.MemberPage();
			cf.formfilling();
			fs.Member();
			bc.anyProduct();
			p.Multi_Pay();
			s.SavememBill();
	}
	
//	@Test (priority=3)
//	  public void trialbill() throws IOException, InterruptedException, AWTException {
//		
//			url.DashboardPage();
//			url.TrialPage();
//			cf.formfilling();
//			fu.SaveFollowUp();
//			fs.Trial();
//			s.SaveTrial();  
//	}
//	
//	@Test (priority=4)
//	  public void UserCreation() throws IOException, InterruptedException, AWTException {
//			
//			url.CenterSelectionPage();
//			menu.User_New_Create();
//			usform.createUserForm();
//			usform.Userverify();
//			
//			
//	}
//	
//	@Test (priority=5)
//	  public void Userassigntemplate() throws IOException, InterruptedException, AWTException {
//			
//			menu.user_old_assign_user_access();
//			usform.AssignTemplate();
//			
//	}
//	
//	@Test (priority=6)
//	  public void EditUser() throws IOException, InterruptedException, AWTException {
//			
//			menu.user_old_list();
//			usform.editUserForm();
//			
//	}
//	
//	@Test (priority=7)
//	  public void AccessTEM() throws IOException, InterruptedException, AWTException {
//			
//			menu.user_old_user_access_tem();
//			access.Access_tem_page();
//			
//	}
	
}
