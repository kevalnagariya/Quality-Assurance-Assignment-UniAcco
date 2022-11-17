package UniAccoForm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Assessment {
	
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		        
		
        System.setProperty("webdriver.chrome.driver", "/Users/Keval/Downloads/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Open URl
		driver.get("https://unicreds.com/contact-us");
		
		//Get Title
		System.out.println(driver.getTitle());
		
		//Enter Full Name   
		driver.findElement(By.xpath("//input[@id='fullname']")).sendKeys("Keval Nagariya");
		Thread.sleep(2000);
		
		//Enter Email ID   
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("kevalnagariya27@gmail.com");
		Thread.sleep(2000);
		
		//Select Country Code  
		WebElement cc = driver.findElement(By.xpath("//select[@class='p-2 pl-4 pr-4 m-2 mt-2 mb-2 form-control form-control-md']"));
		Select s= new Select(cc);
		s.selectByIndex(2);
		Thread.sleep(2000);
		
		// Enter Phone Number    
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("9920401516");
		Thread.sleep(2000);
		
		//Enter Message   
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("Hello, Hi I am Keval Nagariya. Have completed my assignment. Thank You");
		Thread.sleep(2000);
		
		//Click on Submit Button   
		driver.findElement(By.xpath("//button[@id='contactButton']")).click();
		Thread.sleep(2000);
		
		String txt=  driver.findElement(By.id("formMessage")).getText();
		String expectedmsg= "Message sent successfully!";
		
		System.out.println(txt);
		if(txt.contentEquals(expectedmsg))
		{
			System.out.println("Form has been submitted successfully");
		}
		else
		{
			System.out.println("Form has not been submitted");
		}
		Thread.sleep(1000);
        driver.quit();
	}

}
