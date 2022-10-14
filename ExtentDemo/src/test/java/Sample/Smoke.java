package Sample;

import org.testng.annotations.BeforeMethod;

public class Smoke 
{
	@BeforeMethod(groups= {"Smoke"})
	public void setUp()
	{
		System.out.println("iam smoke");
	}
}
