package temp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
	public static void main(String[] args) throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=1920,1080");
		WebDriver driver = new ChromeDriver(options);
		JavascriptExecutor script = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		// KH열기
		driver.get("https://www.iei.or.kr/main/main.kh");
		
		// 로그인버튼 뜨면 클릭
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("로그인"))).click();
		
		// 아이디 비번 입력후 로그인함수 실행
		driver.findElement(By.id("id")).sendKeys("아이디를 써주세요");
		driver.findElement(By.id("password")).sendKeys("비밀번호를 써주세요");
		script.executeScript("javascript:fnLogin();");
		
		// 우리반 게시판 뜰때까지 기다렸다가 클릭
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("title")));
		script.executeScript("window.location = '/login/currBoard.kh'");
		
		// 우리반 게시판 될때까지 기다림
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("title")));
//		driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[1]/div[2]/div[2]/ul[2]/li[1]")).click();
		
		// 글쓰기 버튼 클릭
		script.executeScript("javascript:fnWriteForm();");
		
		// 제목 클릭 될때까지 기다림
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("title"))).click();
		
		// 제목 작성
		driver.findElement(By.id("title")).sendKeys("시험문제 답안 작성 중 입니다. 제목 - 홍진규");
		
		// 본문으로 프레임 전환
		driver.switchTo().frame("tx_canvas_wysiwyg");
		driver.findElement(By.className("tx-content-container")).sendKeys("시험문제 답안 작성 중 입니다. 내용 - frame 처리");
		
		// 완료버튼쪽으로 다시 프레임 전환
		driver.switchTo().parentFrame();
		
		// 글쓰기 완료 버튼 클릭
		script.executeScript("javascript:fnRegister();");
		
		// 얼럿뜨면 확인누르기
		wait.until(ExpectedConditions.alertIsPresent()); // ExpectedConditions.찍으면 나오는데 아마 얼럿 대기인듯
		driver.switchTo().alert().accept();
		
		driver.close();
//		Thread.sleep(100000);
		
	}
}
