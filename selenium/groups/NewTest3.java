package groups;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest3 {
  //@Test (groups= {"sanity","regression"},priority=1)
  @BeforeClass(groups= {"sanity","regression"})
  public void Login() {
	  System.out.println("login sucessful");
  }
  
  @Test (groups= {"sanity"},priority=4)
  public void fundTransfer() {
	  System.out.println("fund transfer is sucessful");
  }
  @Test (groups= {"sanity"},priority=2)
  public void search() {
	System.out.println("search is sucessful");  
  }
  @Test (groups= {"regression"},priority=3)
  public void AdvanceSearch() {
	  System.out.println("Advance search is sucessful");
  }
  @Test(groups = {"regression"}, priority =5)
  public void prePaidRecharge(){
  System.out.println("PrePaid Recharge Successful");
  }
  @Test(groups = {"regression"}, priority =6)
  public void billPayments(){
  System.out.println("Bill Payments Successful");
  }
 // @Test(groups = {"sanity", "regression"}, priority =10)
  @AfterClass(groups= {"sanity","regression"})
  public void logout(){
  System.out.println("Logout Successful");
  }
}
