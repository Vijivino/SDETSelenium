package com.testNG;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.testNG.Testlistener.class) //we can mention listener in  
                                    //annotation itself rather than adding that in XML file
public class Basictest {

	@Test
	public void positiveTc() {
		Assert.assertTrue(true);
		System.out.println("positive");
	}
	
	@Test(enabled=false)
    public void negativeTC() {
		Assert.assertTrue(false);;
		System.out.println("positive");
	}
	
}
