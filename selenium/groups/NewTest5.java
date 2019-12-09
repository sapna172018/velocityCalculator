package groups;

import org.testng.annotations.Test;

public class NewTest5 {
  @Test
  public void TestCase1() {
	  long id=Thread.currentThread().getId();
	  System.out.println("TestCase 1 is sucessful thread id is : "+ id);
	  
  }
  @Test
  public void TestCase2() {
	  long id=Thread.currentThread().getId();
	  System.out.println("TestCase 2 is sucessful thread id is : "+ id);
	  
  }
  @Test
  public void TestCase3() {
	  long id=Thread.currentThread().getId();
	  System.out.println("TestCase 3 is sucessful thread id is : "+ id);
	  
  }
}
