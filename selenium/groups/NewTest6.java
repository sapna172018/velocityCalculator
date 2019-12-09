package groups;

import org.testng.annotations.Test;

public class NewTest6 {
	 @Test
	  public void TestCase4() {
		  long id=Thread.currentThread().getId();
		  System.out.println("TestCase 4 is sucessful thread id is : "+ id);
		  
	  }
	  @Test
	  public void TestCase5() {
		  long id=Thread.currentThread().getId();
		  System.out.println("TestCase 5 is sucessful thread id is : "+ id);
		  
	  }
	  @Test
	  public void TestCase6() {
		  long id=Thread.currentThread().getId();
		  System.out.println("TestCase 6 is sucessful thread id is : "+ id);
		  
	  }

}
