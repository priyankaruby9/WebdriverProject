package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		List<WebElement> tbRows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("Total Rows are " + tbRows.size());
		
		List<WebElement> tbColumns = driver.findElements(By.xpath("//table[@id='customers']//th"));
		System.out.println("Total Columns are " + tbColumns.size());
		
		List<WebElement> tbData = driver.findElements(By.xpath("//table[@id='customers']//tr[4]/td"));
		
		
		for(WebElement elm : tbData) {
			System.out.println(elm.getText());
		}
		
		int column = 1;
		String xpath = "//table[@id='customers']//td[" + column + "]"; //table[@id='customers']//td[1] -->to find the frst column data
		
		////td[text()='Island Trading']/parent::tr/td  used to find the particular row in table
		//table[@id ='customers']//td[2]   to select 2nd colmun all elemnts
		
		
			

	}

}
