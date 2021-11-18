package temp;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Toy3 {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		JavascriptExecutor script = (JavascriptExecutor) driver;

		driver.get(
				"http://www.kyobobook.co.kr/login/login.laf?Kc=GNHHNOlogin&orderClick=c03&retURL=http%3A//www.kyobobook.co.kr/index.laf%3FNaPm%3Dct%253Dkw4ko9ue%257Cci%253Dcheckout%257Ctr%253Dds%257Ctrx%253D%257Chk%253D395c9ab9a4e09df26537ba2f74daaf8430cf07cb%26OV_REFFER%3Dhttps%3A//search.naver.com/search.naver%253Fwhere%3Dnexearch%2526sm%3Dtop_hty%2526fbm%3D1%2526ie%3Dutf8%2526query%3D%25EA%25B5%2590%25EB%25B3%25B4%25EB%25AC%25B8%25EA%25B3%25A0");

		WebElement id = driver.findElement(By.id("memid"));

		id.sendKeys("ID");

		Thread.sleep(2000);

		WebElement pw = driver.findElement(By.id("pw"));

		pw.sendKeys("PASSWORD");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn_submit"))).click();

		WebElement searchTxt = driver.findElement(By.id("searchKeyword"));

		searchTxt.sendKeys("모던 자바스크립트 Deep Dive");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btn_search"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("#search_list > tr:nth-child(11) > td.detail > div.title > a"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
				"#container > div:nth-child(4) > form > div.box_detail_order > div.box_detail_button > div.button_set > a.btn_xlarge.btn_blue2")))
				.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("#container > div.content_middle.sub > form > div.box_title_area > div > div > a")))
				.click();

		WebElement orderConfirm = driver.findElement(By.id("orderConfirm"));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("delvToName"))).sendKeys("이름");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("delvToCel2"))).sendKeys("전화번호1");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("delvToCel3"))).sendKeys("전화번호2");

		script.executeScript("layerOpen(this, '#address_search')");

		String parentWindow = driver.getWindowHandle();

		for (String handle : driver.getWindowHandles()) {

			if (!handle.equals(parentWindow)) {

				driver.switchTo().window(handle);

				break;

			}

		}

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("addrSearchkeyword"))).sendKeys("한천로55길 9");

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.cssSelector("#step_1 > div.box_detail_address2.bg_blue.margin_top10 > a")))
				.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("#step_2 > div.box_address_scroll > div > table > tbody > tr > td.align_center > a")))
				.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("popDelvToAddress2"))).sendKeys("101-1602");

		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.cssSelector("#step_3 > div.margin_top20.align_center > a"))).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(
				"#orderFrm > div.content_middle.order > div:nth-child(273) > div:nth-child(4) > a.btn_toggle")))
				.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#orderConfirm"))).click();

		// Thread.sleep(5000);

		// driver.close();

	}

}
