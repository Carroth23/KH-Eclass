package temp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Exam05 {
	
	public static void main(String[] args) throws Exception {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless"); // 시각적으로 보이는것 없이 실행
		options.addArguments("--window-size=1920,1080"); // 풀스크린으로 띄우는 옵션
		// driver에 넣어서 실행
		
		WebDriver driver = new ChromeDriver(); // 여기에 options를 추가하면 옵션 적용
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("http://175.123.204.32:5500/14_Temp/temp2.html");

		String parentWindow = driver.getWindowHandle(); // 처음 오픈된 크롬창의 주소값
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn1"))).click();
		// waituntil은 0.5초마다 검사함. 그래서 많이쓰면 조금 시간텀있을수 있지만 안전을 위해 쓰는게 나음
		
		for(String handle : driver.getWindowHandles()) {
			if(!handle.equals(parentWindow)) { // 처음창이 아니라 팝업창이라면
				System.out.println("팝업윈도우 검색 성공 : " + handle);
				driver.switchTo().window(handle); // 그 팝업창을 봐라
				break;
			}
		}
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("close"))).click();
		
		driver.switchTo().window(parentWindow); // 다시 원래창으로
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn2"))).click();

		Thread.sleep(5000);
		driver.close();
	}
}
