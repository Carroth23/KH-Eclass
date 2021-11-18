package temp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Quiz03 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		// 셀레니움 인스턴스
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		// 셀레니움 대기제어 인스턴스(10초를 넘기면 에러를 냄). Thread.sleep는 쓰면 안됨. 시간이 고정적.
		// 얘는 한 단계마다 주는게 좋음
		
		JavascriptExecutor script = (JavascriptExecutor) driver;
		driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com");
		
		script.executeScript("document.getElementById('id').value=arguments[0]", "ghdwlsrb321");
		script.executeScript("document.getElementById('pw').value=arguments[0]", "wkdfmshd9922");
		
		WebElement logBtn = driver.findElement(By.id("log.login"));
		logBtn.click();
		
		
		driver.get("https://mail.naver.com");
		// 내게쓰기 클릭하는 방법
		List<WebElement> list = driver.findElements(By.className("btn_import"));
		WebElement writeToMe1 = list.get(0);
		
		WebElement writeToMe2 = driver.findElement(By.className("btn_import"));
		
		WebElement writeToMe3 = driver.findElement(By.cssSelector("div.btn_workset>a:nth-child(2)"));
		
		WebElement writeToMe4 = driver.findElement(By.linkText("내게쓰기"));
		
		WebElement writeToMe5 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[1]/a[2]"));
		// 찾고싶은 태그 우클릭해서 copy에서 fullxpath해온 값 (비추하는 방법, 속도 느림)
		writeToMe1.click();
		
//		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("subject")));
		// id가 subject인 요소가 화면에 존재하는 시점까지 기다려라.
//		id가 존재하는 순간 wait이 풀리고 밑으로 내려감
		
		WebElement title1 = driver.findElement(By.id("subject"));
		title1.sendKeys("웹 자동화 연습 중 입니다..");
		
		// 내용작성이 iframe이라서 iframe으로 한칸 들어감
		driver.switchTo().frame("se2_iframe");
		WebElement write = driver.findElement(By.tagName("p"));
		write.sendKeys("내용입니다");
		
		driver.findElement(By.name("subject")).sendKeys("제목"+Keys.TAB+"내용");
		driver.switchTo().parentFrame(); // 위에서 들어간 frame을 한칸 밖으로 벗어남(Tab눌러서 안쪽Body로 이동도 가능)
		WebElement sendBtn = driver.findElement(By.id("sendBtn"));
		sendBtn.click();
		
		
		Thread.sleep(10000);
		driver.close();
		
	}
}
