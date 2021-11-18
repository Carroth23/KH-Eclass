package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Quiz02 {

	public static void main(String[] args) throws Exception{
		WebDriver driver = new ChromeDriver();

		// 셀레니움이 자바스크립트를 실행할 수 있게 지원하는 클래스
		JavascriptExecutor script = (JavascriptExecutor)driver;

		driver.get("https://www.interpark.com/member/login.do?_method=initial&GNBLogin=Y&&wid1=wgnb&wid2=wel_login&wid3=login&imfsUserPath=http%3A%2F%2Fwww.interpark.com%2Fmalls%2Findex.html%3FgateTp%3D1&historyGoCnt=-1");
		// 인터파크 로그인 연결.
		// 하지만 인터파크는 아이디 비밀번호 입력이 안된다. 이것은 iframe때문.
		
//		driver.get("https://accounts.interpark.com/authorize/shop-pc?origin=http%3A%2F%2Fwww.interpark.com%2Fmalls%2Findex.html%3FgateTp%3D1&amp;postProc=IFRAME");
		// 이게 로그인박스의 iframe주소인데 여기로 접속해도 안되었음. 구글링검색해보니 swichTo 란걸 써야함.
		driver.switchTo().frame("loginIframe"); // 안쪽 프레임으로 들어간다.(대신 이러면 프레임 밖의 콘텐츠를 못건드림)
		
		WebElement inputId = driver.findElement(By.id("userId"));
		WebElement inputPw = driver.findElement(By.id("userPwd"));
		inputId.sendKeys("Test");
		inputPw.sendKeys("Test");
		// 성공. 대신 로그인버튼까지 누르면 캡챠뜨는데 이럴땐 자바스크립트로 뚫을 수 있다.
		
		script.executeScript("document.getElementById('userId').value=arguments[0]", "Test");
		script.executeScript("document.getElementById('userPwd').value=arguments[0]", "Test");
		
		Thread.sleep(5000);
		driver.close();
	}

}
