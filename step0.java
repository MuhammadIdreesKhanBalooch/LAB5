import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.Element;
//import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class step0 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\4073\\Desktop\\chromedr\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//STEP(0)		
		driver.get("https://omayo.blogspot.in/");
//STEP(1)	
		// text field 1
		driver.findElement(By.xpath("(//div[starts-with(@class,'columns-inner')]//child :: textarea)[1]"))
				.sendKeys("Muhammad Idrees Balooch");

		// text field 2
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		WebElement textArea2 = driver
				.findElement(By.xpath("(//div[starts-with(@class,'columns-inner')]//child :: textarea)[2]"));
		Thread.sleep(1);
		textArea2.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(1000);

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		textArea2.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		textArea2.sendKeys("A supreme lover of plants  is automating the browser!");
		Thread.sleep(1000);
//STEP(2)
		// getting the table
		WebElement table = driver.findElement(By.id("table1"));
		List<WebElement> allRows = driver.findElements(By.tagName("tr"));
		for (WebElement row : allRows) {
			// List <WebElement> header = driver.findElements(By.tagName("th"));
			System.out.print(row.getText() + '\n');

		}

//	//first login

		driver.findElement(By.xpath("(//div[contains(@class,'widget-content')]//descendant :: input )[1]"))
				.sendKeys("Muhammad Iddrees");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[contains(@class,'widget-content')]//descendant :: input )[2]"))
				.sendKeys("8932");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[contains(@class,'widget-content')]//descendant :: button )[1]")).click();
		Thread.sleep(1000);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();

//Step (3): 		

		// switchingToFrames xxxxxxxxxxxxxxxxx
		Thread.sleep(2000);
		WebElement frame1 = driver
				.findElement(By.xpath("(//div[contains(@class,'widget-content')]//descendant :: iframe)[1]"));
		driver.switchTo().frame(frame1);
		driver.switchTo().defaultContent();
//		actions.moveToElement(frame1, 30, 30).perform();
//		actions.moveToElement(frame1).build().perform();
		Thread.sleep(2000);
		WebElement frame2 = driver
				.findElement(By.xpath("(//div[contains(@class,'widget-content')]//descendant :: iframe)[2]"));
		driver.switchTo().frame(frame2);
		// actions.moveToElement(frame2).build().perform();
		driver.switchTo().defaultContent();

		// 2nd login
		driver.findElement(By.xpath("(//form[contains(@name,'login')]//descendant :: input )[1]"))
				.sendKeys("Muhammad Iddrees");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//form[contains(@name,'login')]//descendant :: input )[2]")).sendKeys("8932");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//form[contains(@name,'login')]//descendant :: input )[3]")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

//Step (4):
		actions.sendKeys(Keys.PAGE_UP).build().perform();
		actions.sendKeys(Keys.PAGE_UP).build().perform();
		actions.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(1000);
		// select hyundai
		driver.findElement(By.xpath("(//div[contains(@class,'column-left-outer')]//descendant :: option)[3]")).click();
		Thread.sleep(2000);
		// select doc3
		WebElement dropdown = driver
				.findElement(By.xpath("(//div[contains(@class,'widget HTML')]//descendant :: select)[2]"));
		dropdown.click();
		Thread.sleep(1000);
		WebElement doc3 = driver
				.findElement(By.xpath("(//div[contains(@class,'widget-content')]//descendant :: option)[8]"));
		doc3.click();
		// actions.moveToElement(doc3);
//		actions.click().build().perform();
		// doc3.click();
		Thread.sleep(1000);

		// preloaded textbox

		driver.findElement(By.xpath("(//div[contains(@class,'column-left-outer')]//descendant :: option)[8]")).click();
		WebElement preLoadedText = driver
				.findElement(By.xpath("(//div[contains(@class,'sidebar section')]//descendant :: input)[1]"));
		preLoadedText.sendKeys(Keys.CONTROL + "a");
		Thread.sleep(2000);
		preLoadedText.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		preLoadedText.sendKeys("hello world");
		Thread.sleep(1000);
		// enabled button
		WebElement btn2 = driver
				.findElement(By.xpath("(//div[contains(@class,'sidebar section')]//descendant :: button)[1]"));
		btn2.click();
		System.out.println("button 2 is" + btn2.isEnabled());
		Thread.sleep(1000);
		// JavascriptExecutor scroll = (JavascriptExecutor) driver;
		// scroll.executeScript("window.ScrollBy(0,500)","");
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		// submit + login + register
		driver.findElement(By.xpath("(//div[contains(@class,'sidebar section')]//descendant :: button)[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[contains(@class,'sidebar section')]//descendant :: button)[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[contains(@class,'sidebar section')]//descendant :: button)[5]")).click();
		Thread.sleep(1000);
		// clickAfterTextDisapear button
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@id,'delete')]")));

		// Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[contains(@class,'sidebar section')]//descendant :: input)[3]")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
//New Window		
		driver.findElement(By.xpath("(//div[contains(@class,'sidebar section')]//descendant :: a)[4]")).click();
		// gets parent/current window name
		Thread.sleep(10000);
		String parentWindowHandler = driver.getWindowHandle();
		String subWindowHandler = null;

		// get subWindow handles
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}

		driver.switchTo().window(subWindowHandler);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("para1")));
		WebElement para1 = driver.findElement(By.id("para1"));

		WebElement para2 = driver.findElement(By.id("para2"));
//        para1.sendKeys(Keys.CONTROL + "a" );
//        para2.sendKeys(Keys.CONTROL + "a" );
		System.out.println(para1.getText() + "\n" + para2.getText());
		// driver.close();
		driver.switchTo().window(parentWindowHandler);

		// my btn functionality
		WebElement myBtn = driver
				.findElement(By.xpath("(//div[contains(@class,'widget-content')]//descendant :: button)[7]"));
		System.out.println("'My Button' functionality before clicking 'Try It' button" + myBtn.isEnabled());
		// tryIt button
		driver.findElement(By.xpath("(//div[contains(@class,'sidebar section')]//descendant :: button)[7]")).click();
		Thread.sleep(4000);
		System.out.println("'My Button' functionality after clicking 'Try It' button" + myBtn.isEnabled());
		// chekThis buton
		driver.findElement(By.xpath("(//div[contains(@class,'sidebar section')]//descendant :: button)[11]")).click();
		// checkbox wait
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[contains(@class,'sidebar section')]//descendant :: input)[6]")));
		// checkbox click
		driver.findElement(By.xpath("(//div[contains(@class,'sidebar section')]//descendant :: input)[6]")).click();
		Thread.sleep(2000);

//Step (5):
		// gender
		actions.sendKeys(Keys.PAGE_UP).build().perform();
		actions.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[contains(@class,'widget HTML')]//descendant :: input)[13]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[contains(@class,'widget HTML')]//descendant :: input)[15]")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		// colors
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//div[contains(@class,'widget HTML')]//descendant :: input)[17]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[contains(@class,'widget HTML')]//descendant :: input)[16]")).click();
		Thread.sleep(1000);
		WebElement readOnlyTextBox = driver
				.findElement(By.xpath("(//div[contains(@class,'widget HTML')]//descendant :: input)[18]"));
		actions.doubleClick(readOnlyTextBox).perform();
		Thread.sleep(2000);

		// get Prompt for name xxxxxxxxxxxxxxxxxxxxxxxxxx

		WebElement getPrompt = driver
				.findElement(By.xpath("(//div[contains(@class,'widget HTML')]//descendant :: input)[19]"));
		getPrompt.click();
		Alert promptPresent = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(promptPresent.getText());
		Thread.sleep(3000);
		String name = "Muhammad Idrees";
		driver.switchTo().alert().sendKeys(name);
		promptPresent.accept();

//		promptPresent.sendKeys(name);
//		driver.switchTo().alert().sendKeys("midres");
//		Thread.sleep(2000);
		// myNameAlert.accept();

		// Alert getPromptAlert = driver.switchTo().alert();
//		System.out.print(getPromptAlert.getText());
//		getPromptAlert.sendKeys("Muhammad Idrees Balooch");
//		Thread.sleep(2000);
//		getPromptAlert.accept();

		Thread.sleep(1000);

		// filling text boxes and selecting car
		WebElement locateUsingClass1 = driver
				.findElement(By.xpath("(//div[contains(@class,'widget-content') ]//descendant :: input)[26]"));
		locateUsingClass1.click();
		locateUsingClass1.sendKeys("located finally");
		Thread.sleep(1000);
		WebElement locateUsingClass2 = driver
				.findElement(By.xpath("(//div[contains(@class,'widget-content') ]//descendant :: input)[27]"));
		locateUsingClass2.click();
		locateUsingClass2.sendKeys("hope done the question");
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[contains(@class,'widget-content') ]//descendant :: input)[30]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[contains(@class,'widget-content') ]//descendant :: input)[34]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[contains(@class,'widget-content') ]//descendant :: input)[32]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[contains(@class,'widget-content') ]//descendant :: input)[32]")).click();
		Thread.sleep(1000);
		// clicking the dropdown
		driver.findElement(By.xpath("(//div[contains(@class,'widget-content') ]//descendant :: button)[13]")).click();
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[contains(@class,'widget-content') ]//descendant :: a)[20]")));
		// moving to facebook
		driver.findElement(By.xpath("(//div[contains(@class,'widget-content') ]//descendant :: a)[20]")).click();

	}

}
