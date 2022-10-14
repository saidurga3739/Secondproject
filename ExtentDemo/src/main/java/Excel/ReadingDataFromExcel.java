package Excel;

import java.io.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class ReadingDataFromExcel {

	public WebDriver driver;

	@DataProvider(name = "loginTest")

	public String[][] getMyData() throws IOException {
//		String loginData[][] = {
//
//				{ "admin", "admin123" }, // 0
//
////                   {"sidama" ,   "World@03"},  // 1
////                   
////                   {"rissac" ,   "World@04" },  // 2
//		};

	     String path="C:\\Users\\003KT8744\\Desktop\\sai.xlsx";
	     NewExcelLibrary rv1= new NewExcelLibrary(path);
	     int rows=rv1.getRowCount("Sheet1");// 2
	     int cols=rv1.getCellCount("Sheet1",rows); // 2
	     String loginData[][]=new String[rows][cols];
	     for(int i=1;i<=rows;i++)
	     {
	    	 for(int j=0;j<cols;j++)
	    	 {
	    		 loginData[i-1][j]=rv1.getCellData("Sheet1", i, j);
	    	 }
	     }
	     
	    
	

		return loginData;

	}

	@Test(dataProvider = "loginTest")
	public void loginTest(String uname, String pwd) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\003KT8744\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.id("btnLogin")).click();
	}

}
