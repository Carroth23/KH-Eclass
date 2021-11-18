package temp;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam03 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor script = (JavascriptExecutor) driver;
		driver.get("http://www.nate.com"); // 네이트에 들어가서

		script.executeScript("onclick_Join();"); // id가 없을때 해당 버튼에 걸려있는 이벤트로 실행시켜버림

		Thread.sleep(5000);
		driver.close();
	}
}
