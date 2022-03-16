package temp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exam04 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("http://175.123.204.32:5500/14_Temp/temp.html");
		
//		driver.findElement(By.id("btn1")).click();
//		driver.findElement(By.id("btn2")).click();
//		// alert예외가 발생
//		driver.switchTo().alert().accept();
//		// 포커스를 alert창으로 맞추고 확인버튼 눌러라
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn1"))).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn2"))).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		Thread.sleep(5000);
		driver.close();
	}
}
