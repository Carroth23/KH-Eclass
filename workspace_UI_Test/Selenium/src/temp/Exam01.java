package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exam01 {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver(); // 크롬드라이버 올림
		
//		Thread.sleep(5000); 브라우저 렌더링할 시간을 벌어주는것. 좋은코드는 아니다. 이루 wait으로 변경
		
		driver.get("http://www.naver.com"); // selenium아 네이버로 이동해
		
		WebElement inputSearch = driver.findElement(By.id("query")); // 이동 했으면, 검색 창 인스턴스의 주소를 찾아와.
		inputSearch.sendKeys("Selenium"); // 검색창에 "Selenium" 입력
		
		WebElement btnSearch = driver.findElement(By.id("search_btn")); // 검색버튼 인스턴스 주소 추출
		btnSearch.click();
		
		
		Thread.sleep(5000);
		driver.close();
	}
}
