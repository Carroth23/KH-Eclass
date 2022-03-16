package temp;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class asd {
   public static void main(String []args) throws Exception {
      WebDriver driver = new ChromeDriver();
      driver.get("https://www.cgv.co.kr/");
      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
      JavascriptExecutor script = (JavascriptExecutor)driver;
      
      wait.until(ExpectedConditions.presenceOfElementLocated(By.className("login"))).click();
      //driver.findElement(By.linkText("로그인")).click();
      WebElement id = driver.findElement(By.id("txtUserId"));
      id.sendKeys("qudwndb94");
      WebElement pw = driver.findElement(By.id("txtPassword"));
      pw.sendKeys("ybj0823!");
      
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submit"))).click();
      
      driver.findElement(By.linkText("예매")).click();
      
      driver.switchTo().frame("ticket_iframe");
      //WebElement title = driver.findElement(By.cssSelector("a"));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"movie_list\"]/ul/li[3]/a"))).click();
      //driver.findElement(By.xpath("//*[@id=\"movie_list\"]/ul/li[3]/a")).click();
      wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("전체"))).click();
      
      Thread.sleep(1000);
      
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"theater_area_list\"]/ul/li[1]/div/ul/li[1]/a"))).click();
      
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"date_list\"]/ul/div/li[4]/a"))).click();
      
      Thread.sleep(1000);
      
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"movie_list\"]/ul/li[3]/a"))).click();
      
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"ticket\"]/div[2]/div[1]/div[4]/div[2]/div[3]/div[1]/div[1]/ul/li[2]/a"))).click();
      
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tnb_step_btn_right"))).click();
      
      Thread.sleep(1000);
      
      
      
      wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("닫기"))).click();
   
      //driver.switchTo().frame("rsvDataframe");
   
      wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("닫기"))).click();
      
      Thread.sleep(1000);
      
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nop_group_adult\"]/ul/li[3]/a"))).click();
      
      Thread.sleep(500);
      //wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("1"))).click();
      driver.findElement(By.xpath("//*[@id=\"seats_list\"]/div[1]/div[10]/div[2]/div/div[1]/a/span[1]")).click();
      
      Thread.sleep(500);
      
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tnb_step_btn_right"))).click();
      
      //Select card = new Select(driver.findElement(By.id("lp_card_type")));
//      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lp_card_type"))).click();
//      
//      //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lp_card_type"))).click();
      //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#lp_card_type > option:nth-child(6)"))).click();
//      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lp_card_type"))).click();
//      driver.findElement(By.cssSelector("#lp_card_type > option:nth-child(6)")).click();
//      card.selectByVisibleText("신한카드");
      
//      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"last_pay_radio3\"]"))).sendKeys(Keys.ENTER);
//      Thread.sleep(1000);
//      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"payKakao_btn\"]"))).sendKeys(Keys.ENTER);
//      Thread.sleep(1000);
//      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tnb_step_btn_right"))).click();
      driver.findElement(By.id("toss_btn")).sendKeys(Keys.ENTER);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tnb_step_btn_right"))).click();
   }
   
}