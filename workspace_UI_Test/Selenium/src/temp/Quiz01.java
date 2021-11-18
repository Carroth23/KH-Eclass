package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Quiz01 {
	public static void main(String[] args) throws Exception {
		
		// 셀레니움 인스턴스
		WebDriver driver = new ChromeDriver();
		
		// 셀레니움이 자바스크립트를 실행할 수 있게 지원하는 클래스
		JavascriptExecutor script = (JavascriptExecutor)driver;
		
		driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com");
		
		
		
		script.executeScript("document.getElementById('id').value=arguments[0]", "Test");
		script.executeScript("document.getElementById('pw').value=arguments[0]", "Test");
		// 자바스크립트 코드 arguments[0]의 값이 Test라는 뜻(얘로하면 캡챠 안뜸)
		
		
		
//		WebElement inputId = driver.findElement(By.id("id")); 페이지에 id값을 가져온것
//		WebElement inputPw = driver.findElement(By.id("pw"));
		

		
		// 아이디 (네이버 키패드보안때문에 한글자씩 사용했음. 원래는 걍 하나에 다씀)
//		inputId.sendKeys("g");
//		Thread.sleep(500);
//		inputId.sendKeys("h");
//		Thread.sleep(400);
//		inputId.sendKeys("d");
//		Thread.sleep(300);
//		inputId.sendKeys("w");
//		Thread.sleep(400);
//		inputId.sendKeys("l");
//		Thread.sleep(300);
//		inputId.sendKeys("s");
//		Thread.sleep(400);
//		inputId.sendKeys("r");
//		Thread.sleep(500);
//		inputId.sendKeys("b");
//		Thread.sleep(300);
//		inputId.sendKeys("3");
//		Thread.sleep(300);
//		inputId.sendKeys("2");
//		Thread.sleep(200);
//		inputId.sendKeys("1");
//		
//		// 비번
//		inputPw.sendKeys("w");
//		Thread.sleep(300);
//		inputPw.sendKeys("k");
//		Thread.sleep(400);
//		inputPw.sendKeys("d");
//		Thread.sleep(200);
//		inputPw.sendKeys("f");
//		Thread.sleep(300);
//		inputPw.sendKeys("m");
//		Thread.sleep(300);
//		inputPw.sendKeys("s");
//		Thread.sleep(300);
//		inputPw.sendKeys("h");
//		Thread.sleep(500);
//		inputPw.sendKeys("d");
//		Thread.sleep(400);
//		inputPw.sendKeys("9");
//		Thread.sleep(300);
//		inputPw.sendKeys("9");
//		Thread.sleep(200);
//		inputPw.sendKeys("2");
//		Thread.sleep(300);
//		inputPw.sendKeys("2");
		
//		WebElement logBtn = driver.findElement(By.id("log.login"));
//		logBtn.click();
		Thread.sleep(10000);
		driver.close();
	}
}
