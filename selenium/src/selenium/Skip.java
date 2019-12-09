package selenium;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class Skip {
	Boolean DataAvailable = false;

	@Test(enabled=true,invocationCount=10,threadPoolSize=3)
	public void testCaseEnabling(){
			System.out.println("I'm Not Ready, please don't execute me"+Thread.currentThread());
		}
//	@Test
//	public void testCaseSkipException(){
//			System.out.println("Im in skip exception");
//			throw new SkipException("Skipping this exception");
//		}
//
//	@Test
//	public void testCaseConditionalSkipException(){
//		System.out.println("Im in Conditional Skip");
//		if(!DataAvailable)
//		throw new SkipException("Skipping this exception");
//		System.out.println("Executed Successfully");
//	}

}
