package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		//======alert accept
		WebElement elem = driver.findElement(By.xpath("//*[@id='alertButton']"));
		elem.click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		//======alert cancel
		
		WebElement elem1 = driver.findElement(By.xpath("//*[@id='confirmButton']"));
		elem1.click();
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.dismiss();
				
		//============= Alert Message
				
		WebElement elem2 = driver.findElement(By.xpath("//*[@id='promtButton']"));
		JavascriptExecutor obj = (JavascriptExecutor) driver;
		//js.executeScript("scroll(0,500)"); //gives x&y coordinates
		obj.executeScript("arguments[0].scrollIntoView();", elem2);
		elem2.click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.sendKeys("Some text");
		alert2.accept();			

	}

}
