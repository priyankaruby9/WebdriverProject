package test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		String Parentwindow = driver.getWindowHandle();  
		System.out.println("before clicking new window button" + Parentwindow);
		
		WebElement element = driver.findElement(By.xpath("//button[@id='tabButton']"));  ////button[@id='windowButton']
		element.click();
		
		System.out.println("After clicking new window button");
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		
		while(itr.hasNext()) {
			
			String currentVal = itr.next();
			System.out.println(currentVal);
			
			if(!currentVal.equals(Parentwindow)) {
				driver.switchTo().window(currentVal);
			}
		}
		
		WebElement heading = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println(heading.getText());
		
		driver.close();
		
		driver.switchTo().window(Parentwindow); //switch to parent window after closing child window
		System.out.println("back to parent widow");
		driver.close();
		
		

	}

}
