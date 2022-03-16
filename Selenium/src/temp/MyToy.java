package temp;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyToy {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.naver.com/");
		driver.findElement(By.id("query")).sendKeys("운세"+Keys.ENTER);
		
		Thread.sleep(1000);
		
		// 여성이면 아래 주석을 해제.
//		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div[1]/section[1]/div/div[2]/div[2]/div[1]/fieldset/div[1]/label[2]")).click();
		
		
		driver.findElement(By.id("srch_txt")).sendKeys("19930206");
		
		
		driver.findElement(By.className("img_btn")).click();
		WebElement b = driver.findElement(By.className("_luckText"));
		
		System.out.println(b.getText());
		driver.close();
	}
}
