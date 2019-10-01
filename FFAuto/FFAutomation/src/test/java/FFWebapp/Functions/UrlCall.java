package FFWebapp.FFFunctions;

import org.testng.annotations.Test;

public class UrlCall extends Setup{
	
	
  public void DashboardPage() {
		  
	  wd.get(url+"dashboard/started.aspx?feature=show&pagevalue=99&tenantId="+TenantId);  
	  
	  }
	  
  	public void CenterSelectionPage() {
	  
  		
	  wd.get(url+"selectcenter.aspx?pagevalue=7&cid="+CompanyId+"?pagevalue=1&cid="+CompanyId);  
	  
	  }
	
	
	  public void EnquiryPage() {
		  
		  wd.get(url+"Transaction/membercommon_ff.aspx?formname=EnquirySearch&pagetype=createenquiry&mode=enquiry&TenantId="+TenantId+"&BillAtId="+TenantId+"&BillForId="+TenantId+"&searchtext=5480548");  
	  }
	  
	  @Test
	  public void MemberPage() {
		  
		  wd.get(url+"Transaction/membercommon_ff.aspx?formname=EnquirySearch&pagetype=member&mode=enquiry&TenantId="+TenantId+"&BillAtId="+TenantId+"&BillForId="+TenantId+"&searchtext=5480548");
	  }
	  
	  @Test
	  public void TrialPage() {
		  
		  wd.get(url+"Transaction/membercommon_ff.aspx?formname=EnquirySearch&pagetype=trial&mode=enquiry&TenantId="+TenantId+"&BillAtId="+TenantId+"&BillForId="+TenantId+"&searchtext=5480548");
	  }

}


