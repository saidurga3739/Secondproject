package Sample;

import org.testng.annotations.BeforeMethod;

public class Sanity {
	@BeforeMethod(groups= {"Sanity"})
	public void setUp()
	{
		System.out.println("iam sanity");
	}
}
