package FFWebapp.FFAutomation;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;
 
public class AppTest  extends FFWebapp.FFFunctions.Setup {
	
	public FFWebapp.FFFunctions.UrlCall url = new FFWebapp.FFFunctions.UrlCall(); 
	
	public FFWebapp.FFFunctions.Products bc = new FFWebapp.FFFunctions.Products(); 
	
	public FFWebapp.FFFunctions.ClientForm cf = new FFWebapp.FFFunctions.ClientForm(); 
	
	public FFWebapp.FFFunctions.FollowUp fu = new FFWebapp.FFFunctions.FollowUp(); 
	
	public FFWebapp.FFFunctions.FormSubmit fs = new FFWebapp.FFFunctions.FormSubmit(); 
	 
	public FFWebapp.FFFunctions.Payment  p = new FFWebapp.FFFunctions.Payment(); 
	
	public FFWebapp.FFFunctions.Save_Bill  s = new FFWebapp.FFFunctions.Save_Bill(); 
	
	public FFWebapp.FFFunctions.CompanyLevelMenu  menu = new FFWebapp.FFFunctions.CompanyLevelMenu(); 
	
	public FFWebapp.FFFunctions.UserCreationForm  usform = new FFWebapp.FFFunctions.UserCreationForm(); 
	
	public FFWebapp.FFFunctions.AccessTemplate  access = new FFWebapp.FFFunctions.AccessTemplate();
	
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
