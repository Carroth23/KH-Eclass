package temp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam02 {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.nate.com"); // 네이트에 들어가서
		
		List<WebElement> ankers = driver.findElements(By.tagName("a")); // a태그들을 ankers에 담고
		System.out.println(ankers.size()); // a태그들이 몇개인가 알아보고

		
//		for(WebElement w : ankers) {
//			System.out.println(w.getText()); // a태그들의 text내용들을 가져온다
//			System.out.println(w.getText() + " : " + w.getAttribute("href")); // a태그에 걸려있는 주소를 가져옴
//		}
		
		for (int i = 0; i < ankers.size(); i++) {
			ankers.get(3+i).click(); // StaleElementReferenceException 에러. 이미 한번 클릭으로 페이지가 전환되어
		}							 // 셀레니움이 그 페이지를 제어할수 없어졌기때문.
		
		Thread.sleep(5000);
		driver.close();
	}

}
