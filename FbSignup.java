package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbSignup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement CreatenewAccount = driver.findElement(By.xpath("//*[text()='Create new account']"));
		CreatenewAccount.click();
		WebElement Firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement Password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		
		Firstname.sendKeys("priya");
		lastname.sendKeys("singh");
		email.sendKeys("priyankaruby9@gmail.com");
		Password.sendKeys("abse@123");
		
		//WebElement gen = driver.findElement(By.xpath("//input[@value='2']"));
		String strGender = "Female";
		//input[@value='1']
        //input[@value='2']
        //input[@value='-1']
		//label[text()='Male']/following-sibling::input  xpath followd by radio button sibling
        //label[text()='Female']/following-sibling::input
        //label[text()='Custom']/following-sibling::input
		//label[text()='Custom']/following-sibling::input
		String genXpath = "//label[text()='" + strGender + "']/following-sibling::input";//dynamic xpath
		
		WebElement gen = driver.findElement(By.xpath(genXpath));
		gen.click();
		//select[@title='Month']/option[@selected="1"]  - selecting default month feb
		List<WebElement> Months = driver.findElements(By.xpath("//select[@title='Month']/option"));
		
		for(WebElement elm : Months) {
			System.out.println(elm.getText());
		}
		
		List<WebElement> Days = driver.findElements(By.xpath("//select[@name='birthday_day']/option"));
		for(WebElement elm1 : Days) {
			System.out.println(elm1.getText());
		}
		
		WebElement CurrMonth = driver.findElement(By.xpath("//select[@title='Month']/option[@selected='1']"));
        
        System.out.println("Current Month " + CurrMonth.getText());
        
       WebElement Month = driver.findElement(By.xpath("//select[@id='month']"));
        
        Select ddMonth = new Select(Month);
        ddMonth.selectByVisibleText("Jul");      
        
        WebElement Day = driver.findElement(By.xpath("//select[@id='day']"));
        
        Select ddDay = new Select(Day);
        ddDay.selectByVisibleText("19");
                     
        WebElement Year = driver.findElement(By.xpath("//select[@id='year']"));
        
        Select ddyear = new Select(Year);
        ddyear.selectByVisibleText("2018");                
	}

}
