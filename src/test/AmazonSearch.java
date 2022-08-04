package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();
		driver.get("https://www.amazon.co.uk/");    
		
		//Maximize window
		driver.manage().window().maximize();
		
		//wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		// To Accept the cookies 
		
		WebElement AcceptCookies = driver.findElement(By.xpath("//*[@id='sp-cc-accept']"));
		AcceptCookies.click();
		
		WebElement Search = driver.findElement(By.xpath("//input[@aria-label='Search']"));
		Search.sendKeys("Iphone 12");
		
		WebElement Submit = driver.findElement(By.xpath("//input[@value='Go']"));
		Submit.click();
		
		List<WebElement> Result = driver.findElements(By.xpath("//*[contains(text(), 'Apple iPhone 12')]"));
		System.out.println("Number of iPhones are " + Result.size());
		
		List<WebElement> Name = driver.findElements(By.xpath("//*[@class='a-size-medium a-color-base a-text-normal']"));
		
		for (int i=0;i<Name.size();i++) {
			
			if(Name.get(i).getText().toUpperCase().contains("APPLE IPHONE 12")) {
				
				List<WebElement> Symbol = driver.findElements(By.xpath("//*[@class='a-price-symbol']"));
				List<WebElement> Price = driver.findElements(By.xpath("//*[@class='a-price-whole']"));
				List<WebElement> PriceFraction = driver.findElements(By.xpath("//*[@class='a-price-fraction']"));
				System.out.println("Name: " + Name.get(i).getText()+ " " + " Price: " + " " + Symbol.get(i).getText()+Price.get(i).getText()
						+"."+PriceFraction.get(i).getText() );
			}
		}
		
		
		driver.close();


	}

}
