package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver = new ChromeDriver();//webdriver is class
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		//WebDriverWait wait = new WebDriverWait(driver, 50);
	//	WebElement LoginLink = driver.findElement(By.className("login"));
	//	wait.until(ExpectedConditions.elementToBeClickable(LoginLink));
	//	LoginLink.click();
		
		
		WebElement LoginLink = driver.findElement(By.linkText("Log in")); //Linktext is locator
		LoginLink.click();
		
		WebElement UserName = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		WebElement Rememberme = driver.findElement(By.className("rememberMe"));
		
		UserName.sendKeys("Xyz@abc.com");
		Password.sendKeys("Abc@12345");
		Rememberme.click();
		LoginBtn.click();
		
		WebElement ErrorMsg = driver.findElement(By.id("msg_box"));
		String ActualMsg = ErrorMsg.getText();//used to store the txt on screen
		String ExpMsg = "The email or password you have entered is invalid.";
		if(ActualMsg.equals(ExpMsg)) {
			System.out.println("TC passed");
		}else {
			System.out.println("TC Failed");
		}
		
		List<WebElement> links = driver.findElements(By.tagName("a"));//findelemnts will find multiple hyperlinks having tag called "a". so we need list for multiple hyperlinks
		System.out.println("Total Links are" + links.size());
		
		for(WebElement elm : links) {
			System.out.println(elm.getAttribute("href")); // shows all hyperlinks address
		}
		
		driver.close();
	}

}
