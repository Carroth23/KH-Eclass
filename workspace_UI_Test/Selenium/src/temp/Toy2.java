package temp;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Toy2 {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		JavascriptExecutor script = (JavascriptExecutor) driver;

		driver.get("https://www.kobus.co.kr/mrs/rotinf.do");

		String parentWindow = driver.getWindowHandle();

		WebElement depart = driver.findElement(By.id("readDeprInfoList"));

		depart.click();

		script.executeScript("fnDeprArvlViewList('11');");

		script.executeScript("fnDeprChc('010','서울경부');");

		script.executeScript("fnDeprArvlViewList('26');");

		script.executeScript("fnArvlChc('710','창원','N','','','235');");

		Thread.sleep(500);

		driver.findElement(By.className("remodal-close")).click();

		driver.findElement(By.className("btn_confirm")).click();
		
		driver.switchTo().alert().accept();
		
		driver.switchTo().alert().accept();

		script.executeScript(
				"fnSatsChc('20211118','210000','210000','010','710','1','03','0','Y','N','010','710','N','N','N','N');");

		driver.switchTo().alert().accept();

		Thread.sleep(500);

		driver.findElement(By.className("dimm")).click();

		List<WebElement> addBtn = driver.findElements(By.className("btn_add"));

		for (int i = 0; i < addBtn.size(); i++) {

			addBtn.get(4 + i).click();

			break;

		}

		List<WebElement> label = driver.findElements(By.tagName("label"));

		System.out.println(label.size());

		for (int i = 0; i < label.size(); i++) {

			label.get(2 + i).click();

			break;

		}

		script.executeScript("fnSatsChcCfm(event);");

		script.executeScript("javascript:fnNonUsrMrs();");

		Thread.sleep(5000);

		driver.close();

	}

}