package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/upload/");
		//Maximize window
		driver.manage().window().maximize();
				
		//wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement FileUpload = driver.findElement(By.xpath("//input[@name='uploadfile_0']"));
		
		FileUpload.sendKeys("C:/testing.txt");
		
		WebElement TnC = driver.findElement(By.id("terms"));
		TnC.click();
		
		WebElement Submit = driver.findElement(By.id("submitbutton"));
		Submit.click();

		
	}

}
